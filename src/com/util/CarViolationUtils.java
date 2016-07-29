package com.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * title：车首页违章查询接口
 * 
 * 
 */
public class CarViolationUtils {


 public static String URL ="http://www.cheshouye.com";
	 
	/**  
	 * title:测试方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
//			String carInfo = "{hphm=粤B12345&classno=123456&engineno=1234&city_id=152&car_type=02}";
			String carInfo = "{hphm=苏E536v6&classno=KTV3A24F1B3039629&engineno=111112&city_id=59&car_type=02}";
			String appId="1803";    //联系车首页获取
			String appKey="208021dcbaf464d3a36445065d88bb53";//联系车首页获取
			
			String sb = getWeizhangInfoPost(carInfo, appId, appKey);
			System.out.println("返回违章结果：" + sb);
			
			
			//获取省份城市字典配置
//			System.out.println("附录一   获取省份城市参数接口参数="+getConfig());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * title:获取违章信息
	 * 
	 * @param carInfo
	 * @return
	 */
	public static String getWeizhangInfoPost(String carInfo, String appId, String appKey) {
		long timestamp = System.currentTimeMillis();

		String line = null;
		String signStr = appId + carInfo + timestamp + appKey;
		String sign = md5(signStr);
		try {
			URL postUrl = new URL(URL + "/api/weizhang/query_task?");
			String content = "car_info=" + URLEncoder.encode(carInfo, "utf-8") + "&sign=" + sign + "&timestamp=" + timestamp + "&app_id=" + appId;
		
//			System.out.println("请求URL="+postUrl+content);
			
			line = post(postUrl, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	/**
	 * title:获取省份城市对应ID配置
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String getConfig() throws IOException {
		String line = null;
		try {
			URL postUrl = new URL(URL + "/api/weizhang/get_all_config?");
			String content = "";
			line = post(postUrl, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;

	}

	/**
	 * title:post请求
	 * 
	 * @param postUrl
	 * @param content
	 * @return
	 */
	private static String post(URL postUrl, String content) {
		String line = null;
		try {
			HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.writeBytes(content);
			out.flush();
			out.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

			while ((line = reader.readLine()) != null) {
				return line;
			}
			reader.close();
			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;

	}

	/**
	 * title:md5加密,应与 (http://tool.chinaz.com/Tools/MD5.aspx) 上32加密结果一致
	 * 
	 * @param password
	 * @return
	 */
	private static String md5(String msg) {
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");
			instance.update(msg.getBytes("UTF-8"));
			byte[] md = instance.digest();
			return byteArrayToHex(md);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String byteArrayToHex(byte[] a) {
		StringBuilder sb = new StringBuilder();
		for (byte b : a) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
}