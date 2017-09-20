package org.hoboventures.wedding.service;

import org.hoboventures.wedding.dto.RSVP;
import org.hoboventures.wedding.dto.RSVPReport;

/**
 * Created by Asha on 4/22/2017.
 */
public interface RSVPService {

    Long rsvp(RSVP rsvp);

    RSVPReport printReport();
}
