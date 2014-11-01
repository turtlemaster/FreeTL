package freetl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")

public class StartUpController {



    @RequestMapping("/splash")
    public String splashPage (Model model){

        model.addAttribute("contentTemplate", "layout/splashpage");
        model.addAttribute("contentFragment", "splashpage");
        return WebUtil.MAIN_LAYOUT;

    }
}
