package freetl.web;

import freetl.bo.TransformBO;
import freetl.vo.TransformVO;
import freetl.vo.step.operation.input.CSVInputStepVO;
import freetl.vo.step.StepVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/transform/{transformId}/step")
@SessionAttributes({"step","transform"})

public class StepController {
    @RequestMapping(value = "/{stepId}/confirm", method = RequestMethod.POST)
    public ModelAndView confirm(@PathVariable(value = "transformId") int transformId,
                                @PathVariable(value="stepId") int stepId,
                                @ModelAttribute("step") StepVO step,
                                BindingResult bindingResult) throws IOException {

        TransformBO transformBO = new TransformBO();
        TransformVO transform = transformBO.loadTransform(transformId);

        ModelAndView mav = new ModelAndView();
        mav.getModel().put("step", step);
        mav.getModel().put("transform", transform);
        mav.setViewName("page.step.confirmEdit");

        return mav;
    }

        @RequestMapping("/confirm")
        public ModelAndView newStepConfirm(@PathVariable(value = "transformId") int transformId,
                                           @PathVariable(value="stepId") int stepId ) throws IOException {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("redirect:0/confirm");
            return mav;
        }


    @RequestMapping(value = "/{stepId}/commit")
    public ModelAndView commit(@PathVariable(value = "transformId") int transformId,
                               @PathVariable(value="stepId") int stepId,
                               @ModelAttribute("step") StepVO step,
                               @ModelAttribute("transform") TransformVO transform) throws IOException {


        if(stepId == 0){
            transform.addStepVO(step);
        }


        TransformBO transformBO = new TransformBO();
        transformBO.saveTransform(transform);
        ModelAndView mav = new ModelAndView();


      /*  StepCollection stepCollection = transform.getStepCollection();
        Step step = stepCollection.getStepWithId(stepId);


        if (step instanceof CSVInput) {
            CSVInput csvInput = (CSVInput) step;


            if (!removedIds.isEmpty()) {
                List<Integer> indeces = new ArrayList<Integer>();

                String[] rawFieldTypes = removedIds.split(",");
                for (String type : rawFieldTypes) {
                    String fieldType = type.substring("fieldtype_".length(), type.length());
                    indeces.add(Integer.valueOf(fieldType));
                }
                Collections.sort(indeces, Collections.reverseOrder());

                for (Integer i : indeces) {
                    csvInput.removeFieldType(i);
                }
            }
        }



        ModelAndView model = new ModelAndView();

        model.getModel().put("descriptor", descriptor);
        model.getModel().put("transformName", transformName);*/
        mav.setViewName("redirect:/controller/transform/list");
        return  mav;
    }



    @RequestMapping("/{stepId}/edit")
    public ModelAndView edit(@PathVariable(value = "transformId") int transformId,
                             @PathVariable(value="stepId") int stepId) throws IOException {

        TransformBO transformBO = new TransformBO();
        TransformVO transform = transformBO.loadTransform(transformId);
       //change later
        StepVO stepVO = new CSVInputStepVO();

        if(stepId > 0){

            stepVO = transform.getStepVO(stepId);
        }

        ModelAndView mav = new ModelAndView();
        mav.getModel().put("step", stepVO);
        mav.getModel().put("transform", transform);

        mav.setViewName("page.step.CSVInput");

        return mav;
    }

    @RequestMapping("/0/new")
    public ModelAndView newStepWithId(@PathVariable(value = "transformId") int transformId) throws IOException {
        return edit(transformId, 0);
    }

    @RequestMapping("/new")
    public ModelAndView newStep(@PathVariable(value = "transformId") int transformId) throws IOException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:0/new");
        return mav;
    }
}

