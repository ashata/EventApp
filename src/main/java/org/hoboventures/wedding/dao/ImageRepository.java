package org.hoboventures.wedding.dao;

import org.hoboventures.wedding.dto.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Asha on 7/29/2017.
 */
@Repository
public interface ImageRepository extends MongoRepository<Image, String> {
}

