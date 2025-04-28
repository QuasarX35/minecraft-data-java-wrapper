package com.quasarx35.mcdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private Long id;
    private String name;
    private String displayName;
    private int stackSize;

}
