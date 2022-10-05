package com.shisw.archerBackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shisw.archerBackend.entity.ArticleInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {

    @Select("select id,tag,title from article_info")
    List<ArticleInfo> getArticleTagInfo();
}
