package com.palvair;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by widdy on 28/11/2015.
 */
@Data
public class View  implements Serializable {

    private String page;

    private Status status;
}
