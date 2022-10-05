package com.shisw.archerBackend.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: shisw
 * @date 2022年10月04日 22:22
 */
@Data
public class ArticleIndexTree {

    private String indexName;

    private List<ArticleIndexTree> subIndex;

    private List<Integer> articleIds;
}
