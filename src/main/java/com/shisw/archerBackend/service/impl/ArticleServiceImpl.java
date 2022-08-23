package com.shisw.archerBackend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shisw.archerBackend.constdata.ResponseConst;
import com.shisw.archerBackend.dto.ArticleData;
import com.shisw.archerBackend.entity.ArticleInfo;
import com.shisw.archerBackend.mapper.ArticleInfoMapper;
import com.shisw.archerBackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shisw
 * @date 2022年08月21日 23:29
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleInfoMapper,ArticleInfo> implements ArticleService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public ArticleData getArticleById(Integer id){
        ArticleInfo articleInfo = articleInfoMapper.selectById(id);
        return new ArticleData(articleInfo);
    }

    @Override
    public List<ArticleData> getArticleList(int currentPage,int totalPage){
        List<ArticleData> articleDataList = new ArrayList<>();
        Page<ArticleInfo> articleDataPage = new Page<>(currentPage,totalPage);
        IPage<ArticleInfo> result = articleInfoMapper.selectPage(articleDataPage,null);
        result.getRecords().forEach(articleInfo -> {
            ArticleData articleData = new ArticleData(articleInfo);
            articleDataList.add(articleData);
        });
        return articleDataList;
    }

    @Override
    public String addArticle(ArticleData articleData){
        if(articleData == null){
            return ResponseConst.REQ_ERROR;
        }
        ArticleInfo articleInfo = new ArticleInfo(articleData);
        int result = articleInfoMapper.insert(articleInfo);
        if(result > 0){
          return ResponseConst.SUCCESS;
        } else {
            return ResponseConst.SYS_ERROR;
        }
    }

}
