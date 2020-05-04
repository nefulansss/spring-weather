package com.nefu.spring.weather.controller;

import com.google.common.collect.Maps;
import com.nefu.spring.weather.service.ImageService;
import com.nefu.spring.weather.util.HttpClientUploadFileUtil;
import com.nefu.spring.weather.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhanglan61
 * @Date: 2020/3/27 14:44
 * @Version: 1.0
 */
@RestController
public class ImgeController {

    @Autowired
    ImageService imageService;


    @PostMapping("upload")
    public JsonResult upload(@RequestParam("img") MultipartFile img, @RequestParam("city")String city) throws IOException {
        if (img.isEmpty()) {
            return new JsonResult(null,"上传图片为空",500);

        }
        Map<String,String> map  = Maps.newHashMap();
        MultipartFile [] imgs = {img};
        List<String> strings = imageService.uploadImage(imgs);
        map.put("result",strings.get(0));
        if (strings != null) {
            return new JsonResult(map, "操作成功", 200);
        } else {
            return new JsonResult(null, "操作失败", 500);
        }


    }

}
