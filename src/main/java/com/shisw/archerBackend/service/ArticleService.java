package com.shisw.archerBackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shisw.archerBackend.dto.ArticleData;
import com.shisw.archerBackend.entity.ArticleInfo;

import java.util.List;
import java.util.Map;

public interface ArticleService extends IService<ArticleInfo> {

    ArticleData getArticleById(Integer id);

    List<ArticleData> getArticleList(int currentPage,int totalPage);

    String addArticle(ArticleData articleData);

    Map<String, List<ArticleInfo>> getArticleIndexTree();
}
