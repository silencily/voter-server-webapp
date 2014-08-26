/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service.impl;

import org.silencer.voter.repository.NotificationRepository;
import org.silencer.voter.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gejb
 * @since 14-8-26
 */
@Service
public class NotificationServiceImpl implements NotificationService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private NotificationRepository notificationRepository;
}
