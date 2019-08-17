package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value="results")
    public String search(Model model, HttpServletRequest request) {

        model.addAttribute("columns", ListController.columnChoices);

        //will change to @requestparam after solving other issues
        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");

        //just to check that I'm actually pulling the information from the user
        System.out.println(searchTerm);
        System.out.println(searchType);
        System.out.println(JobData.findByValue(searchTerm));

        if (searchType == "all"){
            model.addAttribute("jobs",JobData.findByValue(searchTerm));
            System.out.println("made it here");
        } else {
            model.addAttribute("jobs",JobData.findByColumnAndValue(searchType,searchTerm));
            System.out.println("made it hereee");
        }




        return "search";
    }
}
