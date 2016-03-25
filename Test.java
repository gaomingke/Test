package com.kaishengit;

import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.util.UUID;

public class Test {
    public static void main(String[] args) throws Exception {

        //1. 准备好AK和SK
        final String AK = "G3jWeQ4OOxUwAQJumftrS_jcAej9uBQLn1-oCoHD";
        final String SK = "fmiPh7SZ_UvRWRsntAihdOS67Pin9jeeNYR3aRBv";
        //2. 指定上传的空间名称
        final String bucketName = "demo20";

        //3. 创建Auth对象
        Auth auth = Auth.create(AK,SK);

        //4. 获取上传Token
        String token = auth.uploadToken(bucketName);

        //5. 创建上传对象
        UploadManager uploadManager = new UploadManager();

        String key = UUID.randomUUID().toString();
        Response response = uploadManager.put("D:/2.jpg",key,token);

        if(response.isOK()) {
            System.out.println("文件上传成功:"+ key);
        }

        /*System.out.println(response.bodyString());
        StringMap map = response.jsonToMap();
        String value = (String) map.get("key");
        System.out.println(value);*/


    }
}
