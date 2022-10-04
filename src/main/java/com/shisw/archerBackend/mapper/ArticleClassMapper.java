package com.shisw.archerBackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shisw.archerBackend.entity.ArticleClass;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleClassMapper extends BaseMapper<ArticleClass> {

    @Select("select distinct primary_class from article_class")
    List<String> selectPrimaryClass();

    @Select("select distinct secondary_class from article_class where primary_class = #{primary} and secondary_class <> ''")
    List<String> selectSecondaryClassByPrimary(@Param("primary") String primary);

    @Select("select distinct third_class from article_class where secondary_class = #{second} and third_class <> ''")
    List<String> selectThirdClassBySecond(@Param("second") String second);
}
