package com.nefu.spring.weather.service.impl;

import com.nefu.spring.weather.controller.ImageController;
import com.nefu.spring.weather.service.ImageService;
import com.nefu.spring.weather.util.UicodeBackslashU;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: spring-weather-2
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 23:39
 **/
@Service
public class ImageServiceImpl implements ImageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);
    private static final String toUrl = "http://121.40.169.169:5000/upload_img";
    @Value("${web.image.upload}")
    private String uploadPath; //上传路径

    @Override
    public List<String> uploadImage(MultipartFile[] multipartFiles) {
        List<String> urlList = new ArrayList<String>();
        List<String> ansString = new ArrayList<>();
        LOGGER.info("uploadPath：{}",uploadPath);
        String realpath = uploadPath;
        CreatFileDir(realpath);
        String filename = null;
        for (MultipartFile multipartFile : multipartFiles) {
            try {
                filename = UUID.randomUUID().toString().replaceAll("-", "")+multipartFile.getOriginalFilename();
                multipartFile.transferTo(new File(realpath,filename));
                String fileU = realpath+"/"+filename;
                LOGGER.info(fileU);

                LOGGER.info("保存路径：{}",fileU);
                String ans = fileUpload(toUrl, fileU);
                ansString.add(ans);
                return ansString;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return urlList;

    }





    /**
     * 判断目录是否存在
     * @param filepath
     */
    private void CreatFileDir(String filepath) {
        File dir = new File(filepath);
        if (!dir.exists())
            dir.mkdirs();
    }

        public  String fileUpload(String url, String filePath){
            CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                HttpPost httppost = new HttpPost(url);

                RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000).build();
                httppost.setConfig(requestConfig);

                FileBody bin = new FileBody(new File(filePath));
                StringBody comment = new StringBody("This is comment", ContentType.TEXT_PLAIN);

                HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("img", bin).addPart("comment", comment).build();

                httppost.setEntity(reqEntity);

                System.out.println("executing request " + httppost.getRequestLine());
                CloseableHttpResponse response = httpclient.execute(httppost);
                try {
                    System.out.println(response.getStatusLine());
                    HttpEntity resEntity = response.getEntity();
                    if (resEntity != null) {
                        String responseEntityStr = EntityUtils.toString(response.getEntity());
                        //打印数据信息
                        LOGGER.info("返回信息：：");
                        String ans = UicodeBackslashU.unicodeToCn(responseEntityStr);
                        System.out.println(ans);
                        String[] split = ans.split("'");
                        String[] s = split[1].split("'");
                        return s[0];
                        //System.out.println("Response content length: " + resEntity.getContentLength());
                    }
                    EntityUtils.consume(resEntity);
                } finally {
                    response.close();
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }







}
