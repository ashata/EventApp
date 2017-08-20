package org.hoboventures.wedding.constants;

import lombok.Getter;

/**
 * Created by Asha on 4/21/2017.
 */
@Getter
public enum RSVPCodeEnum {

        ACCEPT(202, "I(We) would love to"),
        NEED_MORE_TIME(408, "I need more time to think"),
        WATCH_ONLINE(418, "I'll just watch it online"),
        THANKS_BUT_DECLINE(409, "Congrats!! but I have other plans"),

        //CURSE_AND_DECLINE(502, "F******B**@##"),
        ;

        RSVPCodeEnum(int code, String text) {
            this.code = new Integer(code);
            this.text = text;
        }

        private Integer code;
        private String text;
}
