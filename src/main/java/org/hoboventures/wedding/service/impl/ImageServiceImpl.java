package org.hoboventures.wedding.service.impl;

import org.hoboventures.wedding.dao.ImageRepository;
import org.hoboventures.wedding.dto.GiftRegistryLite;
import org.hoboventures.wedding.dto.Image;
import org.hoboventures.wedding.service.GiftRegistryService;
import org.hoboventures.wedding.service.ImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource private ImageRepository imageRepository;

    @Override
    public List<Image> images() {
        return imageRepository.findAll();
    }
}
