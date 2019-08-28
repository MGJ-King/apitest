package com.mgj.translatordemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TranslatorBeforeController {

    @RequestMapping("translatorBefor")
    public String translatorBefor(){
        return "translatorBefor";
    }
}
