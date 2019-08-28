package com.mgj.apidemo.controller;

import com.mgj.apidemo.bean.UserBean;
import com.mgj.apidemo.entity.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApiController {

    @Autowired
    private UserBean userBean;

    @PostMapping("/api")
    public User post(@RequestBody JSONObject jsonobject){
        String usercode = jsonobject.getString("usercode");
        return userBean.selectByusercode(usercode);
    }

}
