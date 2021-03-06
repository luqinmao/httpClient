package com.imooc.http.lib;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author nate
 */
public class AsyncHttp {

    //发送同步请求
    public static void sendRequest(String url) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //发送异步请求
    public static void sendAsyncRequest(String url) {
        System.out.println(Thread.currentThread().getId());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println(Thread.currentThread().getId());
//                    System.out.println(response.body().string());
                }

            }
        });
    }

    public static void main(String args[]) {
        System.out.println(0/100.0);

        sendAsyncRequest("http://www.imooc.com");
    }
}
