/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gejb
 * @since 2015-03-22
 */
@Controller
public class DiscoverController {
    @RequestMapping(value = "discover")
    public String discover() {
        return "discover";
    }
}
