package org.hoboventures.wedding.service.impl;

import org.hoboventures.wedding.dao.ProgramRepository;
import org.hoboventures.wedding.dao.WeddingHomeRepository;
import org.hoboventures.wedding.dto.Program;
import org.hoboventures.wedding.dto.WeddingHome;
import org.hoboventures.wedding.service.WeddingHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@Service
public class WeddingHomeServiceImpl implements WeddingHomeService {

    private Logger logger = LoggerFactory.getLogger(WeddingHomeService.class);

    @Resource private WeddingHomeRepository weddingHomeRepository;
    @Resource private ProgramRepository programRepository;

    @Override
    public List<WeddingHome> findAll() {
        return weddingHomeRepository.findAll();
    }

    @Override
    @Cacheable(value = "programCache", unless = "#result != null")
    public List<Program> getProgram(){
        List<Program> list = programRepository.findAll();
        return list;
    }

    @Override
    @CacheEvict(cacheNames = "programCache", allEntries = true)
    public void programCacheEvict(){

    }
}
