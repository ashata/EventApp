package org.hoboventures.wedding.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Asha on 4/29/2017.
 */
@Document(collection = "faq")
@Data
@NoArgsConstructor
public class FAQ extends BaseDTO {

    private String question;
    private String answer;
    private String link;
    private String type;

    public FAQ(String question, String answer, String link) {
        this.question = question;
        this.answer = answer;
        this.link = link;
        this.type = "faq";
    }

    public FAQ(String question, String answer, String link, String type) {
        this.question = question;
        this.answer = answer;
        this.link = link;
        this.type = type;
    }
}
