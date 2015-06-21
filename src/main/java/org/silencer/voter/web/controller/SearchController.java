/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.core.AbstractControllerSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gejb
 * @since 2015-06-21
 */
@Controller
public class SearchController extends AbstractControllerSupport {
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model) {
        return "search";
    }
}
