package com.shisw.archerBackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shisw.archerBackend.dto.ClassTag;
import com.shisw.archerBackend.entity.ArticleClass;
import com.shisw.archerBackend.mapper.ArticleClassMapper;
import com.shisw.archerBackend.service.ArticleClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shisw
 * @date 2022年10月04日 14:05
 */
@Service
@SuppressWarnings("unused")
public class ArticleClassServiceImpl extends ServiceImpl<ArticleClassMapper, ArticleClass> implements ArticleClassService {

    @Autowired
    ArticleClassMapper articleClassMapper;

    @Override
    public List<ClassTag> getAllArticleClass() {
        List<String> primaryClass = articleClassMapper.selectPrimaryClass();
        List<ClassTag> classTags = new ArrayList<>();
        for (String primary : primaryClass) {
            ClassTag tag = new ClassTag();
            tag.setName(primary);
            List<String> secondaryClass = articleClassMapper.selectSecondaryClassByPrimary(primary);
            if (!secondaryClass.isEmpty()) {
                tag.setSubTags(new ArrayList<>());
                for (String second : secondaryClass) {
                    ClassTag secondTag = new ClassTag();
                    secondTag.setName(second);
                    List<String> thirdClass = articleClassMapper.selectThirdClassBySecond(second);
                    if (!thirdClass.isEmpty()) {
                        secondTag.setSubTags(new ArrayList<>());
                        for (String third : thirdClass) {
                            ClassTag thirdTag = new ClassTag();
                            thirdTag.setName(third);
                            secondTag.getSubTags().add(thirdTag);
                        }
                    }
                    tag.getSubTags().add(secondTag);
                }
            }
            classTags.add(tag);
        }
        return classTags;
    }
}
