package com.shisw.archerBackend.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shisw
 * @date 2022年10月20日 21:53
 */
@Data
public class UploadResponse {

    private Integer errno;

    private String message;

    private Map<String,String> data;

    public static UploadResponse error(String errorMsg){
        UploadResponse response = new UploadResponse();
        response.setErrno(1);
        response.setMessage(errorMsg);
        return response;
    }

    public UploadResponse(){}

    public UploadResponse(String url,String alt, String href){
        Map<String,String> data = new HashMap<>();
        data.put("url",url);
        data.put("alt",alt);
        data.put("href",href);
        this.data = data;
        this.errno = 0;
    }
}
