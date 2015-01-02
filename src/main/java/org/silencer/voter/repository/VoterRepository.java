/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.repository;

import org.silencer.voter.entity.VoterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author gejb
 * @since 2015-01-02
 */
public interface VoterRepository extends MongoRepository<VoterEntity, String> {
}
