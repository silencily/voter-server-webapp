/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.repository;

import org.silencer.voter.entity.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author gejb
 * @since 14-8-26
 */
public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {
}
