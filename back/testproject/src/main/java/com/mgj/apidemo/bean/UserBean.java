package com.mgj.apidemo.bean;

import com.mgj.apidemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserBean {

    private static Map<String, User> userMap=new HashMap<String, User>();

    static {
        userMap.put("1",new User("1","张三","武汉技术开发部"));
        userMap.put("2",new User("2","李四 ","华南技术开发部"));
        userMap.put("3",new User("3","王五 ","华东技术开发部"));
        userMap.put("4",new User("4","赵六 ","西南技术开发部"));
    }

    public User selectByusercode(String usercode){
        return userMap.get(usercode);
    }
}
