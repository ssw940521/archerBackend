package com.shisw.archerBackend.dto;

import com.shisw.archerBackend.entity.ArticleInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: shisw
 * @date 2022年08月21日 23:21
 */
@Data
public class ArticleData implements Serializable {

    private String id;
    private String title;

    private String author;

    private String tag;

    private String content;

    private String isOriginal;

    private Date created;

    public ArticleData(ArticleInfo articleInfo) {
        if (articleInfo != null) {
            this.title = articleInfo.getTitle();
            this.author = articleInfo.getAuthor();
            this.tag = articleInfo.getTag();
            this.content = articleInfo.getContent();
            this.isOriginal = articleInfo.getIsOriginal();
            this.created = articleInfo.getCreated();
            this.id = String.valueOf(articleInfo.getId());
        }
    }
    @SuppressWarnings("unused")
    public ArticleData(){}
}
