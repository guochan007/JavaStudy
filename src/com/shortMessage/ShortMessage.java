package com.shortMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ShortMessage {

	private static final String addr = "http://api.sms.cn/mt/";
	private static final String userId = "mjgcj";
	private static final String pwd = MD5Util.encode2hex("yipusoft1234mjgcj");  
	private static final String encode = "utf8";

	public static void send(String msgContent, String mobile) throws Exception {
		String content = URLEncoder.encode(msgContent,"utf8");
		//组建请求
		String strAddress = addr + 
						"?uid="+userId+
						"&pwd="+pwd+
						"&encode="+encode+
						"&mobile="+mobile+
						"&content=" + content;
		
		StringBuffer stringBuffer = new StringBuffer(strAddress);
		System.out.println("URL:"+stringBuffer);
		
		//发送请求
		URL url = new URL(stringBuffer.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		BufferedReader resultStream = new BufferedReader(new InputStreamReader(
				url.openStream(),"gbk"));
		
		//返回结果
		String resultStr = resultStream.readLine();
		System.out.println("Response:"+resultStr);
		
	}
	
	
	public static void main(String[] args) {
		try {
			send("今天回家吃饭！！！", "18636841011");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
