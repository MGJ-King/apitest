package com.mgj.translatordemo.service;

import com.mgj.translatordemo.webxml.TranslatorWebService;
import com.mgj.translatordemo.webxml.TranslatorWebServiceSoap;

public class TranslatorService {

    public String translat(String word){

        //创建服务视图
        TranslatorWebService service = new TranslatorWebService();
        //根据服务视图创建实现类对象
        TranslatorWebServiceSoap port = service.getPort(TranslatorWebServiceSoap.class);
        //调用翻译的方法
        String str = port.getEnCnTwoWayTranslator(word).getString().get(1);

        return str;
    }

}
