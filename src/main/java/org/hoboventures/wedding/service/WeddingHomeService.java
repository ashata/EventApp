package org.hoboventures.wedding.service;

import org.hoboventures.wedding.dto.Program;
import org.hoboventures.wedding.dto.WeddingHome;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
public interface WeddingHomeService {

    List<WeddingHome> findAll();

    List<Program> getProgram();

    @CacheEvict(cacheNames = "programCache", allEntries = true)
    void programCacheEvict();
}
