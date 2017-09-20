package org.hoboventures.wedding.dao;

import org.hoboventures.wedding.dto.RSVP;
import org.hoboventures.wedding.dto.RSVPLite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

/**
 * Created by Asha on 4/22/2017.
 */
@Repository
public interface RSVPRepository extends MongoRepository<RSVP, String> {

    @Query("{'$or':[ {'email':?0}, {'lastName':?1} ] }")
    RSVP findByEmailOrLastName(String email, String lastName);
}
