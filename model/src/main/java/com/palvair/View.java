package com.palvair;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by widdy on 28/11/2015.
 */
@Data
@Document
@EqualsAndHashCode
public class View  implements Serializable {

    @Id
    private String id;

    private String page;

    @Setter
    private Status status;
}
