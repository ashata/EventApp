package org.hoboventures.wedding.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Asha on 4/29/2017.
 */
@Document(collection = "program")
@Data
@NoArgsConstructor
public class Program extends BaseDTO {

    @Field("intro")
    private String question;
    @Field("description")
    private String answer;
}
