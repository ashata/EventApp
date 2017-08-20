package org.hoboventures.wedding.dao;

import org.hoboventures.wedding.dto.FAQ;
import org.hoboventures.wedding.dto.RSVP;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@Repository
public interface FAQRepository extends MongoRepository<FAQ, String> {

    @Query("{'type':'aboutUs'}")
    List<FAQ> brideAndGroom();

    @Query("{ 'type': { $not: { $eq: 'aboutUs' }}})")
    List<FAQ> findAll();

}
