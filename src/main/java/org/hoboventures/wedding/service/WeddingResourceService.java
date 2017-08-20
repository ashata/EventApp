package org.hoboventures.wedding.service;

import org.hoboventures.wedding.dto.WeddingResource;

/**
 * Created by Asha on 4/22/2017.
 */
public interface WeddingResourceService {

    Long weddingResource(WeddingResource resource);
    Long delete(WeddingResource resource);
}
