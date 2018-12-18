package koreatech.cse.controller;

import koreatech.cse.domain.Client.ClientPOJO;
import koreatech.cse.domain.Client.Result;
import koreatech.cse.domain.User;
import koreatech.cse.domain.worknet.WorkNetSearchable;
import koreatech.cse.service.client.GetApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Map;



@Controller
@RequestMapping("/")
public class HomeController {

    @Inject
    private GetApiService getApiService;


    @RequestMapping
    public String home(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    @RequestMapping("/main")
    public String main(Model model) {
        return "index";
    }

    @RequestMapping(value="/search/condition", method = RequestMethod.GET)
    public String conditionSearch(Model model) {
        return "searchCondition";
    }

    @RequestMapping(value="/api/about", method = RequestMethod.GET)
    public String apiSearch(Model model) {
        return "apiAbout";
    }

    @RequestMapping(value = "/search/condition" ,method = RequestMethod.POST)
    public String conditionSearched(Model model,
                                    @RequestParam Map<String,String> pramMap)
    {
        ClientPOJO clientPOJO = getApiService.getApi(pramMap);
        model.addAttribute("Result" , clientPOJO.getResult());
        return "searchCondition";
    }
}

