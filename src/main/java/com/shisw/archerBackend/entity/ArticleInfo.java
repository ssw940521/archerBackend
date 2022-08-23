package com.shisw.archerBackend.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shisw.archerBackend.dto.ArticleData;
import lombok.Data;

import java.util.Date;
@Data
@TableName("article_info")
public class ArticleInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String author;

    private String tag;

    private String content;

    private String isOriginal;

    private Date created;

    private Date lastUpdate;

    public ArticleInfo(){}

    public ArticleInfo(ArticleData articleData){
        this.title = articleData.getTitle();
        this.author = articleData.getTitle();
        this.tag = articleData.getTag();
        this.content = articleData.getContent();
        this.isOriginal = articleData.getIsOriginal();
    }


}
