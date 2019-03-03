package com.wj.demo.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class BaseController {

    @Autowired
    private HttpSession session;

    public UserInfo getUserInfo() {
        return (UserInfo) session.getAttribute("userInfo");
    }
}
