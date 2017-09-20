package org.hoboventures.wedding.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hoboventures.wedding.constants.ActivityCodeEnum;
import org.hoboventures.wedding.constants.RSVPCodeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ReflectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Asha on 4/21/2017.
 */
@Data
@NoArgsConstructor
public class RSVPLite {

    private String firstName;
    private String lastName;
    private Long guests;
    private String email;
    private String rsvpText;

    @JsonIgnore
    private RSVPCodeEnum rsvpCode;

    private List<ActivityCodeEnum> activitiesOfInterest;

    public RSVPLite(RSVP rsvp) {
        activitiesOfInterest = new ArrayList<>();
        rsvp.getRsvpText();
        BeanUtils.copyProperties(rsvp, this);
        /*setActivitiesOfInterest(rsvp.getActivitiesOfInterest());
        setEmail(rsvp.getEmail());
        setFirstName(rsvp.getFirstName());
        setLastName(rsvp.getLastName());
        setRsvpText(rsvp.getRsvpText());
        setGuests(rsvp.getGuests());*/
    }
}
