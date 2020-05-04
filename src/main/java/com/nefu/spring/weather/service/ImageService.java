package com.nefu.spring.weather.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: spring-weather-2
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 23:39
 **/

public interface ImageService {
    List<String> uploadImage(MultipartFile[] multipartFiles);
}
