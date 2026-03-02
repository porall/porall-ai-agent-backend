package com.porall.poaiagent.demo.invoke;// 建议dashscope SDK的版本 >= 2.12.0

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONArray;
import com.porall.poaiagent.demo.invoke.TestApiKey;

/**
 * 阿里云灵机AI_HTTP调用
 */
public class HttpAiInvoke {
    
    public static String callWithHttp() {
        // 构建请求体
        JSONObject requestBody = new JSONObject();
        requestBody.set("model", "qwen-plus");
        
        JSONObject input = new JSONObject();
        JSONArray messages = new JSONArray();
        
        JSONObject systemMsg = new JSONObject();
        systemMsg.set("role", "system");
        systemMsg.set("content", "You are a helpful assistant.");
        messages.add(systemMsg);
        
        JSONObject userMsg = new JSONObject();
        userMsg.set("role", "user");
        userMsg.set("content", "你好,我是朱雨剑,我是个前端开发帅哥");
        messages.add(userMsg);
        
        input.set("messages", messages);
        requestBody.set("input", input);
        
        JSONObject parameters = new JSONObject();
        parameters.set("result_format", "message");
        requestBody.set("parameters", parameters);
        
        // 发送HTTP请求
        HttpResponse response = HttpRequest.post("https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation")
                .header("Authorization", "Bearer " + TestApiKey.API_KEY)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .execute();
        
        return response.body();
    }
    
    public static void main(String[] args) {
        try {
            String result = callWithHttp();
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("An error occurred while calling the generation service: " + e.getMessage());
            e.printStackTrace();
        }
        System.exit(0);
    }
}