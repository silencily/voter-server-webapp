/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.repository.UserRepository;
import org.silencer.voter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author gejb
 * @since 14-8-26
 */
@Service
public class UserServiceImpl implements UserService {
    private final Log log = LogFactory.getLog(this.getClass());

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserRepository userRepository;

    @Value("${security.password.encoder.salt}")
    private String passwordSalt;


    @Override
    public UserEntity registerUser(String fullname, String email, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setFullname(fullname);

        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String encodedPassword = encoder.encodePassword(password, passwordSalt);
        log.debug("username [" + email + "] encoded password:[" + encodedPassword + "],salt:[" + passwordSalt + "]");
        userEntity.setPassword(encodedPassword);
        userEntity.setUsername(email);
        userEntity.setEnabled(true);
        userEntity.setVoteCounter(new UserEntity.VoteCounter());
        userEntity.setPhone("");
        userEntity.setLgPhoto("");
        userEntity.setSmPhoto("");
        userEntity.setLocation("CN");
        UserEntity savedUser = userRepository.save(userEntity);
        return savedUser;
    }

    @Override
    public UserEntity findUserById(String id) {
        return userRepository.findOne(id);
    }


}
