package org.hoboventures.wedding.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Asha on 4/22/2017.
 */
@Component
public class JsonUtil {

    public static <T> T fromJson(String rsvpStr, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            obj = mapper.readValue(rsvpStr, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
