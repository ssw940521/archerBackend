package com.shisw.archerBackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: shisw
 * @date 2022年10月03日 14:36
 */
@Data
@TableName("article_class")
public class ArticleClass {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String primaryClass;

    private String secondaryClass;

    private String thirdClass;
}
