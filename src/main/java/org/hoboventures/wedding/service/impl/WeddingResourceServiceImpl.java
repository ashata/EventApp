package org.hoboventures.wedding.service.impl;

import org.hoboventures.wedding.constants.ResourceType;
import org.hoboventures.wedding.dao.WeddingResourceRepository;
import org.hoboventures.wedding.dto.WeddingResource;
import org.hoboventures.wedding.service.WeddingResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Asha on 4/22/2017.
 */
@Service
public class WeddingResourceServiceImpl implements WeddingResourceService {

    @Resource private WeddingResourceRepository weddingResourceRepository;

    @Override
    public Long weddingResource(WeddingResource resource) {
        Long returnVal;
        try {
            //elastic logs
            if (resource.getId() == null) {
                //saving
            } else {
                //editing
            }
            if(resource.getResource().equals(ResourceType.AUDIO) || resource.getResource().equals(ResourceType.VIDEO)){
                //any special logs??
            }
            resource = weddingResourceRepository.save(resource);
            returnVal = 0L;
        }
        catch (Exception ex){
            returnVal = -1L;
        }
        return returnVal;
    }

    @Override
    public Long delete(WeddingResource resource) {
        Long returnVal = -2L;
        try {
            if (resource.getId() != null) {
                weddingResourceRepository.delete(resource);
                returnVal = 0L;
            }
            else{
                //log??
            }
        }
        catch (Exception ex){
            returnVal = -1L;
        }
        return returnVal;
    }
}
