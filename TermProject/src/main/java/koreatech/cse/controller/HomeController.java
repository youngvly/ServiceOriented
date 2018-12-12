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
    public String conditionSearched(Model model,
                                    @ModelAttribute WorkNetSearchable workNetSearchable ,
                                    @RequestParam Map<String,String> pramMap)
    {
//        //폼 입력받은거 처리
//        if (pramMap.get("startdate").length() >0 ) {
//            int sdate = Integer.parseInt(pramMap.get("startdate").replace("-",""));
//            workNetSearchable.setSdate(sdate);
//        }
//        if(pramMap.get("enddate").length() >0){
//            int edate = Integer.parseInt(pramMap.get("enddate").replace("-",""));
//            workNetSearchable.setEdate(edate);
//        }
//        System.out.println(workNetSearchable.toString());

        //api이용해서 찾아오기
        ClientPOJO clientPOJO = getApiService.getApi(pramMap);
        int num = 1;
        for (Result r: clientPOJO.getResult()) {
            model.addAttribute("ResultNews" + num,r.getNewsList());
            model.addAttribute("ResultEmploy" + num++,r.getEmployList());
        }

        return "redirect:/search/condition";
    }


    @RequestMapping("/search/jobname")
    public String jobnameSearch() {return "searchJobname";}
}

