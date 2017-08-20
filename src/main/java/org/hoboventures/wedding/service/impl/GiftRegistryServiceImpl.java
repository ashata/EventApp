package org.hoboventures.wedding.service.impl;

import org.hoboventures.wedding.dao.GiftRegistryRepository;
import org.hoboventures.wedding.service.GiftRegistryService;
import org.hoboventures.wedding.dto.GiftRegistryLite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@Service
public class GiftRegistryServiceImpl implements GiftRegistryService {

    @Resource private GiftRegistryRepository registryRepository;

    @Override
    public Long saveItem(GiftRegistryLite registryItem) {
        Long returnVal;
        try {
            //elastic logs
            if (registryItem.getId() == null) {
                //saving
            } else {
                //editing
            }
            registryItem = registryRepository.save(registryItem);
            returnVal = 0L;
        }
        catch (Exception ex){
            returnVal = -1L;
        }
        return returnVal;
    }

    @Override
    public List<GiftRegistryLite> findAll() {
        return registryRepository.findAll();
    }

    @Override
    public Long deleteItem(GiftRegistryLite registryItem) {
        Long returnVal = -2L;
        try {
            if (registryItem.getId() != null) {
                registryRepository.delete(registryItem);
                returnVal = 0L;
            }
        }
        catch (Exception ex){
            returnVal = -1L;
        }
        return returnVal;
    }

}
