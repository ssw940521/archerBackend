package com.shisw.archerBackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shisw.archerBackend.dto.ClassTag;
import com.shisw.archerBackend.entity.ArticleClass;

import java.util.List;

public interface ArticleClassService extends IService<ArticleClass> {

    List<ClassTag> getAllArticleClass();
}
