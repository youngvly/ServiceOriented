package koreatech.cse.controller;

import koreatech.cse.domain.worknet.WorkNetSearchable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String conditionSearch(Model model) {
        WorkNetSearchable workNetSearchable = new WorkNetSearchable();
        model.addAttribute("jobSearch",workNetSearchable);
        return "searchCondition";
    }

    @RequestMapping(value = "/search/condition" ,method = RequestMethod.POST)
    public String conditionSearched(Model model,@ModelAttribute WorkNetSearchable workNetSearchable){
//        model.addAttribute();
        return "redirect:/search/condition";
    }


    @RequestMapping("/search/jobname")
    public String jobnameSearch() {return "searchJobname";}
}

