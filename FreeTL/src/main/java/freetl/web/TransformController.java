package freetl.web;

import freetl.bo.TransformBO;
import freetl.exceptions.StepException;
import freetl.operation.Route;
import freetl.operation.Transform;
import freetl.util.RouteCollection;
import freetl.vo.TransformVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/transform")
@SessionAttributes("transform")


public class TransformController {

    @RequestMapping("/list")
    public ModelAndView list() {

        ModelAndView model = new ModelAndView();

        TransformBO transformBO = new TransformBO();
        List<TransformVO> transformVOs = transformBO.loadTransforms();

        model.getModel().put("transforms", transformVOs);
        model.setViewName("page.transform.list");

        return model;
    }

    @RequestMapping("/{transformId}")
    public ModelAndView viewTransform(@PathVariable(value = "transformId") int transformId) throws IOException {


        TransformBO transformBO = new TransformBO();
        TransformVO transformVO = transformBO.loadTransform(transformId);

        ModelAndView mva = new ModelAndView();
        mva.getModel().put("transform", transformVO);
        mva.setViewName("page.transform.view");

        return mva;
    }


    @RequestMapping("/new")
    public ModelAndView newTransform() throws IOException {

        ModelAndView mva = new ModelAndView();
        TransformBO transformBO = new TransformBO();
        mva.getModel().put("transform", transformBO.newTransformVO());
        mva.setViewName("page.transform.new");
        return mva;
    }



    @RequestMapping(value = "/{transformId}/edit")
    public ModelAndView edit(@PathVariable(value = "transformId") int transformId) throws IOException {

       ModelAndView mav = new ModelAndView();

       TransformBO transformBO = new TransformBO();
       TransformVO transformVO = transformBO.loadTransform(transformId);
       mav.getModel().put("transform", transformVO);
       mav.setViewName("page.transform.edit");

        return mav;
    }

   @RequestMapping(value = "/{transformId}/confirm")
    public ModelAndView confirm(@ModelAttribute("transform") TransformVO transform,
                                            BindingResult bindingResult) throws IOException {


        ModelAndView mav = new ModelAndView();
        mav.getModel().put("transform", transform);
        mav.setViewName("page.transform.edit.confirm");

        return mav;

    }

    @RequestMapping(value = "/{transformId}/commit")
    public ModelAndView commit(@ModelAttribute("transform") TransformVO transform,
                                             BindingResult bindingResult) throws IOException {

        TransformBO transformBO = new TransformBO();
        transformBO.saveTransform(transform);


        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/controller/transform/list");
        return mav;

    }

    @RequestMapping("/{transformId}/run")
    public ModelAndView run(@PathVariable(value = "transformId") int transformId) throws IOException {


        ModelAndView mav = new ModelAndView();
        TransformBO transformBO = new TransformBO();
        TransformVO transformVO = transformBO.loadTransform(transformId);

        Route route0 = new Route(1,2);
        RouteCollection routes = new RouteCollection();
        routes.addRoute(route0);

        Transform transform = new Transform(transformVO, routes);

        try {
            transform.run();
        } catch (StepException e) {
            e.printStackTrace();
        }


        mav.setViewName("redirect:/controller/transform/list");
        return mav;

    }
}


