package com.codingdojo.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class SurveyController {
    @RequestMapping("")
    public String form(){
        return "form.jsp";
    }
    @RequestMapping("/submit")
public String submit(@RequestParam(value="name") String name,@RequestParam(value="dojo") String dojo,@RequestParam(value="lang") String lang,@RequestParam(value="comment") String comment, HttpSession session , RedirectAttributes redirectAttributes){
        if (name==""){
         redirectAttributes.addFlashAttribute("warning", "The name shouldn't  be empty");
         return "redirect:/";
        }
        else{
            session.setAttribute("name", name);
            session.setAttribute("dojo", dojo);
            session.setAttribute("lang", lang);
            session.setAttribute("comment", comment);
            return "redirect:/result";
        }

    }
    @RequestMapping("/result")
    public String result(){
        return "formInfo.jsp";
    }



}
