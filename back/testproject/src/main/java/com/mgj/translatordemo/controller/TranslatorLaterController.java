package com.mgj.translatordemo.controller;

import com.mgj.translatordemo.service.TranslatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class TranslatorLaterController extends HttpServlet {

    @RequestMapping("translatorLater")
    public String TranslatorLater(HttpServletRequest request){

        TranslatorService ts = new TranslatorService();
        String word = request.getParameter("word");
        String str = ts.translat(word);
        request.setAttribute("infor",str);

        return "translatorBefor";
    }

}
