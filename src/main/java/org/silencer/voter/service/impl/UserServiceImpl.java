/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service.impl;

import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.repository.UserRepository;
import org.silencer.voter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gejb
 * @since 14-8-26
 */
@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity registerUser(String fullname, String email, String password) {
        return null;
    }
}
