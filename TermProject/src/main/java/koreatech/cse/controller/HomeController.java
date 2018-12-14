package koreatech.cse.controller;

import koreatech.cse.domain.Client.ClientPOJO;
import koreatech.cse.domain.Client.Result;
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
    public String home() {
        return "index";
    }

    @RequestMapping(value="/search/condition", method = RequestMethod.GET)
    public String conditionSearch(Model model) {
        return "searchCondition";
    }

    @RequestMapping(value = "/search/condition" ,method = RequestMethod.POST)
    public String conditionSearched(Model model,
                                    @RequestParam Map<String,String> pramMap)
    {

        //api이용해서 찾아오기
        ClientPOJO clientPOJO = getApiService.getApi(pramMap);
//        if (clientPOJO != null){
//            int num = 1;
            model.addAttribute("Result" , clientPOJO.getResult());
//        }
        return "searchCondition";
    }


    @RequestMapping("/search/jobname")
    public String jobnameSearch() {return "searchJobname";}
}

