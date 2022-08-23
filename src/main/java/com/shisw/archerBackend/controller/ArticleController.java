package com.shisw.archerBackend.controller;

import com.shisw.archerBackend.dto.ArticleData;
import com.shisw.archerBackend.entity.ArticleInfo;
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
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/getArticleById/{id}")
    public ArticleData getArticleById(@PathVariable("id") Integer id){
          return articleService.getArticleById(id);
    }

    @GetMapping(value = "/getArticleList")
    public  List<ArticleData> getArticleList(@RequestBody ArticleSearchVo vo){
         return articleService.getArticleList(vo.getCurrentPage(),vo.getTotalPage());
    }

    @PostMapping(value = "/addArticle")
    public String addArticle(@RequestBody ArticleData articleData){
       return articleService.addArticle(articleData);
    }
}
