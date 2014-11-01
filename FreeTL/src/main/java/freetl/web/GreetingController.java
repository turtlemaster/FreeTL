package freetl.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/bye")
    public String bye(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", "Jerk - You suck");
        return "foo/bar2";
    }

    @RequestMapping("/poo")
    public String poo(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", ":(");
        return "greeting";
    }

    @RequestMapping("/basic")
    public String basictutorial (Model model){


        return "basic";

    }


}