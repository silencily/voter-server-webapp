/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.core.AbstractControllerSupport;
import org.silencer.voter.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gejb
 * @since 2015-06-21
 */

@Controller
public class SettingsController extends AbstractControllerSupport {
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
}
