package org.hoboventures.wedding.service;

import org.hoboventures.wedding.dto.GiftRegistryLite;

import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
public interface GiftRegistryService {

    Long saveItem(GiftRegistryLite registryItem);
    List<GiftRegistryLite> findAll();
    Long deleteItem(GiftRegistryLite registryItem);
}
