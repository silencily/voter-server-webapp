/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.core.AbstractControllerSupport;
import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gejb
 * @since 2015-06-21
 */

@Controller
public class SettingsController extends AbstractControllerSupport {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model) {
        UserEntity userEntity = obtainCurrentUser();
        model.addAttribute("currentUser", userEntity);
        return "profile";
    }

    @RequestMapping(value = "password", method = RequestMethod.GET)
    public String password(Model model) {
        UserEntity userEntity = obtainCurrentUser();
        model.addAttribute("currentUser", userEntity);
        return "password";
    }

    @ResponseBody
    @RequestMapping(value = "password", method = RequestMethod.POST)
    public String password(String oldPassword, String newPassword) {
        //验证旧密码
        UserEntity userEntity = obtainCurrentUser();
        if (userService.validatePassword(userEntity.getId(), oldPassword)) {
            userService.changePassword(userEntity.getId(), newPassword);
        }else {
            return "0";
        }
        return "1";
    }
}
