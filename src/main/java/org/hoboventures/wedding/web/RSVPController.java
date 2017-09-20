package org.hoboventures.wedding.web;

import org.hoboventures.wedding.dto.RSVP;
import org.hoboventures.wedding.dto.RSVPReport;
import org.hoboventures.wedding.dto.WeddingHome;
import org.hoboventures.wedding.util.JsonUtil;
import org.hoboventures.wedding.service.RSVPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Asha on 4/22/2017.
 */
@RestController
public class RSVPController {
    private static final Logger logger = LoggerFactory.getLogger(RSVPController.class);

    @Resource private RSVPService rsvpService;

    @PostMapping(value = "rsvp")
    public String rsvp(@RequestBody String rsvpStr){
        logger.info("RSVP: "+ rsvpStr);
        RSVP rsvp = JsonUtil.fromJson(rsvpStr, RSVP.class);
        Long returnVal = rsvpService.rsvp(rsvp);
        return returnVal+"";
    }

    @GetMapping(value = "rsvpView")
    public ModelAndView rsvpView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("scripts/rsvp/rsvp");
        return mav;
    }

    @GetMapping(value = "admin/rsvpReport")
    public RSVPReport rsvpReport(){
        return rsvpService.printReport();
    }
}
