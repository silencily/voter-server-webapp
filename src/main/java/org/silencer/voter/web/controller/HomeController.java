/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gejb
 * @since 14-8-26
 */
@Controller
public class HomeController {
    @RequestMapping(value = "home")
    public String home() {

        return "home";
    }
}
