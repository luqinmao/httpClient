package com.imooc.http;

import com.imooc.OkHttpRequest;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import okhttp3.OkHttpClient;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);

        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpRequest request = new OkHttpRequest(okHttpClient,HttpMethod.GET,"http://www.imooc.com/");

//        request.getBody().write("username=nate&userage=21".getBytes());

        HttpResponse response = request.execute();

        String content =null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()));
        while ((content = reader.readLine()) != null){
            System.out.println(content);
        }
        response.close();
    }
}