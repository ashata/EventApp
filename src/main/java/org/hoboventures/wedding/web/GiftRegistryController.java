package org.hoboventures.wedding.web;

import org.hoboventures.wedding.dto.GiftRegistryLite;
import org.hoboventures.wedding.service.GiftRegistryService;
import org.hoboventures.wedding.util.JsonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@RestController
public class GiftRegistryController {

    @Resource private GiftRegistryService registryService;

    @GetMapping(value = "fetchRegistry")
    public List<GiftRegistryLite> findAll(){
        return registryService.findAll();
    }

     /*@PostMapping(value = "register")
    public String saveComment(@RequestBody String itemStr){
        GiftRegistryLite item = JsonUtil.fromJson(itemStr, GiftRegistryLite.class);
        Long returnVal = registryService.saveItem(item);
        return "";
    }

    @GetMapping(value = "deleteItem")
    public void deleteComment(@RequestBody String itemStr){
        GiftRegistryLite item = JsonUtil.fromJson(itemStr, GiftRegistryLite.class);
        Long returnVal = registryService.deleteItem(item);
    }*/

    @GetMapping(value = "initCollection")
    public List<GiftRegistryLite> save(){
        List<GiftRegistryLite> registries = new ArrayList<>();

        GiftRegistryLite registryLite = new GiftRegistryLite();
        registryLite.setStoreName("Amazon");
        registryLite.setUrl("https://www.amazon.com/wedding/share/CharlieAsha");
        registryService.saveItem(registryLite);
        registries.add(registryLite);

        GiftRegistryLite registryLite0 = new GiftRegistryLite();
        registryLite0.setStoreName("Knot");
        registryLite0.setUrl("https://www.amazon.com/wedding/share/CharlieAsha");
        registryService.saveItem(registryLite0);
        registries.add(registryLite0);

        GiftRegistryLite registryLite1 = new GiftRegistryLite();
        registryLite1.setStoreName("WayFair");
        registryLite1.setUrl("");
        registryService.saveItem(registryLite1);
        registries.add(registryLite1);

        GiftRegistryLite registryLite2 = new GiftRegistryLite();
        registryLite2.setStoreName("NFM");
        registryLite2.setUrl("https://www.amazon.com/wedding/share/CharlieAsha");
        registryService.saveItem(registryLite2);
        registries.add(registryLite2);

        GiftRegistryLite registryLite3 = new GiftRegistryLite();
        registryLite3.setStoreName("HomeDepot");
        registryLite3.setUrl("");
        registryService.saveItem(registryLite3);
        registries.add(registryLite3);

        GiftRegistryLite registryLite4 = new GiftRegistryLite();
        registryLite4.setStoreName("Bed Bath and Beyond");
        registryLite4.setUrl("");
        registryService.saveItem(registryLite4);
        registries.add(registryLite4);

        GiftRegistryLite registryLite5 = new GiftRegistryLite();
        registryLite5.setStoreName("KC Pet Project");
        registryLite5.setUrl("");
        registryService.saveItem(registryLite5);
        registries.add(registryLite5);

        GiftRegistryLite registryLite6 = new GiftRegistryLite();
        registryLite6.setStoreName("Gift cards");
        registryLite6.setUrl("You can also buy us Gift cards for any of the stores listed above. There is no minimum amount for the gift card");
        registryService.saveItem(registryLite6);
        registries.add(registryLite6);

        return registries;
    }

}
