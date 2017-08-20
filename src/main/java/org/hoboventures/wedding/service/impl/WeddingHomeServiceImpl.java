package org.hoboventures.wedding.service.impl;

import org.hoboventures.wedding.dao.WeddingHomeRepository;
import org.hoboventures.wedding.dto.WeddingHome;
import org.hoboventures.wedding.service.WeddingHomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@Service
public class WeddingHomeServiceImpl implements WeddingHomeService {

    @Resource private WeddingHomeRepository weddingHomeRepository;

    @Override
    public List<WeddingHome> findAll() {
        return weddingHomeRepository.findAll();
    }
}
