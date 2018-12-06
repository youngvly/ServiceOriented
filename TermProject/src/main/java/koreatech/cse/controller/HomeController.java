package koreatech.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {
    @ModelAttribute("name")
    private String getName() {
        return "IamHomeControllerModelAttribute";
    }

    @RequestMapping
    public String home() {
        return "index";
    }

    @RequestMapping("/search/condition")
    public String conditionSearch() {return "searchCondition";}
    @RequestMapping("/search/jobname")
    public String jobnameSearch() {return "searchJobname";}
}

