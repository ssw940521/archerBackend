package com.shisw.archerBackend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: shisw
 * @date 2022年10月03日 14:26
 */
@Data
public class ClassTag implements Serializable {

    private String name;

    private List<ClassTag> subTags;

    public ClassTag(){
        this.name = null;
        this.subTags = null;
    }
}
