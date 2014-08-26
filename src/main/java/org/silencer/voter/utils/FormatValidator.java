/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gejb
 * @since 14-8-26
 */
public class FormatValidator {
    /**
     * 验证是否为email格式
     *
     * @param validated 被验证的email
     * @return true:符合;false:不符合
     */
    public static boolean validateEmail(String validated) {
        String regex = "^(\\w+((-\\w+)|(\\.\\w+))*)\\+\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(validated);
        return matcher.matches();
    }

    /**
     * 验证是否为phone格式
     *
     * @param validated 被验证的phone
     * @return true:符合;false:不符合
     */
    public static boolean validatePhone(String validated) {
        String regex = "^1(\\d{10})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(validated);
        return matcher.matches();
    }
}
