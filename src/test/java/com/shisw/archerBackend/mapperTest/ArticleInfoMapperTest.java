package com.shisw.archerBackend.mapperTest;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.shisw.archerBackend.dto.ArticleData;
import com.shisw.archerBackend.entity.ArticleInfo;
import com.shisw.archerBackend.mapper.ArticleInfoMapper;
import com.shisw.archerBackend.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: shisw
 * @date 2022年08月21日 21:20
 */
@SpringBootTest
public class ArticleInfoMapperTest {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Autowired
    private ArticleService articleService;

    @Test
    void testInsert(){
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setContent("test");
        int count = articleInfoMapper.insert(articleInfo);
        System.out.println(count);
    }

    @Test
    void testService(){
        ArticleData articleData = articleService.getArticleById(1);
        System.out.println(articleData);
    }
}
