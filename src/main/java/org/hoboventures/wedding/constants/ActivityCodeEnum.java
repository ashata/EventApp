package org.hoboventures.wedding.constants;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Asha on 4/21/2017.
 */
@Getter
public enum ActivityCodeEnum {
    BRIDAL_SHOWER(202, "Bridal Shower TBD"),
    HENNA_TATTOO(408, "Henna Tattoo 2 days before the wedding"),
    Hotel_Block(418, "I(We) will need hotel block reservation"),
    DANCE_PARTY(409, "I'd love to be a part of wedding dance party"),

    //CURSE_AND_DECLINE(502, "F******B**@##"),
    ;


    ActivityCodeEnum(int code, String text) {
        this.code = new Integer(code);
        this.text = text;
    }

    private Integer code;
    private String text;



    public static ActivityCodeEnum getActivityCodeEnum(String text) {
        for (ActivityCodeEnum activityCodeEnum : ActivityCodeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(activityCodeEnum.getText(), text)) {
                return activityCodeEnum;
            }
        }
        return null;
    }
}
