package org.hoboventures.wedding.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Asha on 4/22/2017.
 */
@Data
@NoArgsConstructor
@Document
public class Comment extends BaseDTO {

    private String fName;
    private String lName;
    private String comment;
    private String attachmentUrl;

}
