package com.shisw.archerBackend.controller;

import com.shisw.archerBackend.dto.ArticleData;
import com.shisw.archerBackend.dto.ClassTag;
import com.shisw.archerBackend.service.ArticleClassService;
import com.shisw.archerBackend.service.ArticleService;
import com.shisw.archerBackend.vo.ArticleSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: shisw
 * @date 2022年08月21日 23:14
 */
@RequestMapping("/article")
@RestController
@SuppressWarnings("unused")
public class ArticleController {

    @Autowired
    @SuppressWarnings(value = "unused")
    private ArticleService articleService;

    @Autowired
    @SuppressWarnings(value = "unused")
    private ArticleClassService articleClassService;

    @GetMapping(value = "/getArticleById/{id}")
    @SuppressWarnings("unused")
    public ArticleData getArticleById(@PathVariable("id") Integer id){
          return articleService.getArticleById(id);
    }

    @PostMapping(value = "/getArticleList",consumes = "application/json;charset=utf-8")
    @SuppressWarnings("unused")
    public List<ArticleData> getArticleList(@RequestBody ArticleSearchVo vo){
         return articleService.getArticleList(vo.getCurrentPage(),vo.getTotalPage());
    }

    @PostMapping(value = "/addArticle")
    @SuppressWarnings("unused")
    public String addArticle(@RequestBody ArticleData articleData){
       return articleService.addArticle(articleData);
    }

    @GetMapping(value = "/getArticleClass")
    public List<ClassTag> getArticleClassTag(){
       return articleClassService.getAllArticleClass();
    }
}
