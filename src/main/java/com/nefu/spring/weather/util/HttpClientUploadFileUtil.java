package com.nefu.spring.weather.util;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.net.www.http.HttpClient;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

/**
 * @Author: zhanglan61
 * @Date: 2020/3/31 9:01
 * @Version: 1.0
 */
public class HttpClientUploadFileUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUploadFileUtil.class);

    private static final String url = "htpp://101.121.168.168/upload";

    public static void uploadImage(String url, String fileName,String filePath){

        CloseableHttpClient httpClient = HttpClients.createDefault();

        File img = new File(filePath);
        if (!img.exists()){
            LOGGER.error("文件不存在");
        }


    }

    public static String uploadImage(File file) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        FileBody uploadimage = new FileBody(file);

        MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create().setCharset(Charset.forName("UTF-8")).setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        multipartEntity.addPart("img", uploadimage);

        HttpEntity build = multipartEntity.build();
        httpPost.setEntity(build);

        CloseableHttpResponse response = httpClient.execute(httpPost);

        int code = response.getStatusLine().getStatusCode();
        LOGGER.info("上传图片状态码 {}",code);

        HttpEntity entity = response.getEntity();
        String data = null;
        if (entity!=null){
            data = EntityUtils.toString(entity,Charset.forName("UTF-8"));
            LOGGER.info("上传图片输出数据：：{}",data);
        }
        EntityUtils.consume(entity);

        return data;

    }

}
