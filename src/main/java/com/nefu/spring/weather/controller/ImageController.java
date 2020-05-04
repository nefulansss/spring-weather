package com.nefu.spring.weather.controller;

import com.nefu.spring.weather.service.ImageService;
import com.nefu.spring.weather.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: spring-weather-2
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 23:33
 **/
//@RestController
public class ImageController {
//    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);
//
//    @Autowired
//    ImageService imageService;
//
//
//    @PostMapping("upload")
//    public JsonResult uploadImage(MultipartFile[] img){
//        if (img==null){
//            return null;
//        }
//        List<String> strings = imageService.uploadImage(img);
//        LOGGER.info("上传的文件路径 {}",strings);
//        if (strings!=null){
//            return new JsonResult(strings.get(0),"操作成功",200);
//        }else{
//            return new JsonResult(null,"操作失败",500);
//        }
//    }


}
