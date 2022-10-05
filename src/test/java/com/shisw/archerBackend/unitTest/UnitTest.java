package com.shisw.archerBackend.unitTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: shisw
 * @date 2022年10月05日 1:03
 */
public class UnitTest {

    @Test
    public void testTagSplit(){
        String tags = "游戏|2d|";
        String[] tagSplit = tags.split("\\|");
        System.out.println(Arrays.toString(tagSplit));
    }
}
