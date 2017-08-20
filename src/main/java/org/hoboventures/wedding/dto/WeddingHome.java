package org.hoboventures.wedding.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by Asha on 4/23/2017.
 */
@Document(collection = "dashboard")
@Data
@NoArgsConstructor
public class WeddingHome implements Serializable {

    private String name;
    private String iconCode;
    private String buttonText;
    private String buttonLink;
    private String buttonHover;

    @Field(value = "shortDescription")
    private String description;

    @Field(value = "additionalInfo")
    private String info;
}
