package com.shisw.archerBackend.controller;

import com.shisw.archerBackend.vo.UploadResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: shisw
 * @date 2022年10月19日 1:37
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Value("${prop.uploadFolder}")
    private String UPLOAD_FOLDER;

    @PostMapping(value = "/getPicture",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public UploadResponse getPicture(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        if (file == null) {
            return UploadResponse.error("请选择要上传的图片");
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            return UploadResponse.error( "文件大小不能大于10M");
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            return UploadResponse.error( "请选择jpg,jpeg,gif,png格式的图片");
        }
        String savePath = UPLOAD_FOLDER;
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        try {
            //将文件保存指定目录
            file.transferTo(new File(savePath + filename));
        } catch (Exception e) {
            e.printStackTrace();
            return UploadResponse.error( "保存文件异常");
        }
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/img/"+filename;
        return new UploadResponse(url,null,null);
    }
}
