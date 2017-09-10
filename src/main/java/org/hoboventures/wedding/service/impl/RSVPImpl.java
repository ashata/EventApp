package org.hoboventures.wedding.service.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hoboventures.wedding.dao.RSVPRepository;
import org.hoboventures.wedding.dto.RSVP;
import org.hoboventures.wedding.service.RSVPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Asha on 4/22/2017.
 */
@Service
public class RSVPImpl implements RSVPService {
    private final Logger logger = LoggerFactory.getLogger(RSVPService.class);
    @Resource private RSVPRepository rsvpRepository;

    @Override
    public Long rsvp(RSVP rsvp) {
        Long returnVal = -1L;
        logger.info("RSVP to save: " + rsvp.toString());
        if(rsvp != null) {
            try {
                RSVP savedRSVP = rsvpRepository.findByEmailOrLastName(rsvp.getEmail(), rsvp.getLastName());
                logger.info("saved rsvp matching this: " + ObjectUtils.toString(savedRSVP));
                //elastic logs
                if(rsvp.equals(savedRSVP)) {
                    //editing
                    rsvp.setId(savedRSVP.getId());
                }
                rsvp.initActivitiesOfInterest();
                rsvp.initRSVPCode();
                rsvp = rsvpRepository.save(rsvp);
                returnVal = 0L;
            } catch (Exception ex) {
                //returnVal = -1L;
                ex.printStackTrace();
                logger.error("exception saving rsvp: ", ex);
            }
        }
        return returnVal;
    }

    private Long delete(RSVP rsvp) {
        Long returnVal = -2L;
        try {
            if (rsvp.getId() != null) {
                rsvpRepository.delete(rsvp);
                returnVal = 0L;
            }
            else{
                //guest declined invitation log
            }
        }
        catch (Exception ex){
            returnVal = -1L;
        }
        return returnVal;
    }
}
