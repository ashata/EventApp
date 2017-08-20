package org.hoboventures.wedding.web;

import org.hoboventures.wedding.dto.WeddingResource;
import org.hoboventures.wedding.service.WeddingResourceService;
import org.hoboventures.wedding.util.JsonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Asha on 4/22/2017.
 */
@RestController
public class WeddingResourceController {

    @Resource
    private WeddingResourceService resourceService;

    @PostMapping(value = "saveResource")
    public String weddingResource(@RequestBody String resourceStr){
        WeddingResource resource = JsonUtil.fromJson(resourceStr, WeddingResource.class);
        Long returnVal = resourceService.weddingResource(resource);
        return "";
    }

    @GetMapping(value = "deleteResource")
    public void delete(@RequestBody String resourceStr){
        WeddingResource resource = JsonUtil.fromJson(resourceStr, WeddingResource.class);
        Long returnVal = resourceService.delete(resource);
    }
}
