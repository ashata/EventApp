package org.hoboventures.wedding.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.hoboventures.wedding.constants.ActivityCodeEnum;
import org.hoboventures.wedding.constants.RSVPCodeEnum;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Asha on 4/21/2017.
 */
@Data
@NoArgsConstructor
@Document(collection = "RSVP")
public class RSVP extends BaseDTO {

    private String firstName;
    private String lastName;
    private Long guests;
    private String email;

    @Transient
    private Map<String, Boolean> activCodeMap;
    @Transient
    private String rsvpText;

    private RSVPCodeEnum rsvpCode;

    private List<ActivityCodeEnum> activitiesOfInterest;

    public void initActivitiesOfInterest(){
        if(activitiesOfInterest == null && getActivCodeMap() != null){
            activitiesOfInterest = new ArrayList<>();
            for (Map.Entry<String, Boolean> entry : activCodeMap.entrySet()) {
                if(BooleanUtils.isTrue(entry.getValue())){
                    getActivitiesOfInterest().add(ActivityCodeEnum.getActivityCodeEnum(entry.getKey()));
                }
            }
        }
    }

    public void initRSVPCode(){
        for (RSVPCodeEnum rsvp : RSVPCodeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(rsvp.getText(), rsvpText)) {
                this.rsvpCode = rsvp;
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RSVP rsvp = (RSVP) o;
        return (Objects.equals(firstName, rsvp.firstName) && Objects.equals(lastName, rsvp.lastName)) ||
                Objects.equals(email, rsvp.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, email);
    }
}
