/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.service.UserService;
import org.silencer.voter.core.security.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gejb
 * @since 14-8-26
 */
@Controller
public class EntryPointController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup")
    public String signup(String fullname,String email,String password,HttpServletRequest request){

        //TODO:check the user

        UserEntity userEntity= userService.registerUser(fullname, email, password);

        SecurityContextHelper.authenticate(userEntity,request);
        return "redirect:home";
    }
}
