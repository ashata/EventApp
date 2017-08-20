package org.hoboventures.wedding.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;

/**
 * Created by Asha on 4/23/2017.
 */
@Getter @Setter
public class BaseDTO implements Serializable {

    private String id;

    @LastModifiedDate
    private String lastModifiedTime;

    @LastModifiedBy
    private String lastModifiedBy;

    private String iconCode;
    private String templateName;
}
