package org.hoboventures.wedding.dao;

import org.hoboventures.wedding.dto.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Asha on 4/22/2017.
 */
@Repository
public interface ProgramRepository extends MongoRepository<Program, String> {

}
