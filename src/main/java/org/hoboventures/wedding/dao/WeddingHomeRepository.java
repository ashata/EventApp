package org.hoboventures.wedding.dao;

import org.hoboventures.wedding.dto.WeddingHome;
import org.hoboventures.wedding.dto.WeddingResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Asha on 4/22/2017.
 */
@Repository
public interface WeddingHomeRepository extends MongoRepository<WeddingHome, String> {
}
