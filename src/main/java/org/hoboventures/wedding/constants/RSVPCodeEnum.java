package org.hoboventures.wedding.constants;

import lombok.Getter;

/**
 * Created by Asha on 4/21/2017.
 */
@Getter
public enum RSVPCodeEnum {

        ACCEPT(202, "I(We) would love to", 0),
        NEED_MORE_TIME(408, "I need more time to think", 2),
        WATCH_ONLINE(418, "I'll just watch it online", 1),
        THANKS_BUT_DECLINE(409, "Congrats!! but I have other plans", 3),

        //CURSE_AND_DECLINE(502, "F******B**@##"),
        ;

        RSVPCodeEnum(int code, String text, int sortOrder) {
            this.code = new Integer(code);
            this.text = text;
            this.sortOrder = sortOrder;
        }

        private Integer code;
        private String text;
        private int sortOrder;
}
