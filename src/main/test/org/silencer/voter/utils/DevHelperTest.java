/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.utils;

import org.junit.Test;

/**
 * @author gejb
 * @since 14-8-27
 */
public class DevHelperTest {

    @Test
    public void testEncodePassword() {
        String password = "seven";
        String encodePassword = DevHelper.encodePassword(password);
        System.out.println("encoded password : " + encodePassword);
    }
}
