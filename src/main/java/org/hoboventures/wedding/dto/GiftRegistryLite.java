package org.hoboventures.wedding.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Asha on 4/22/2017.
 */
@Data
@NoArgsConstructor
@Document(collection = "GiftRegistry")
public class GiftRegistryLite extends BaseDTO {

    private String url;
    private String storeName;
}
