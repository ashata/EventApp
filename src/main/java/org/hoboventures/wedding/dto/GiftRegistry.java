package org.hoboventures.wedding.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Asha on 4/22/2017.
 */
@Data
@NoArgsConstructor
//TODO: unused for future purposes where I can have my own registry view
public class GiftRegistry extends BaseDTO {

    private String name;
    private String desc;
    private String url;
    private String storeName;

    private Long maxQty;
    private Long pendingQty;

    private boolean purchased;

    private String bestPrice;
    private String bestPriceStore;
}
