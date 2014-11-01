package freetl.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/world")
    public ModelAndView world() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("page.index");

        return mav;
    }
}
