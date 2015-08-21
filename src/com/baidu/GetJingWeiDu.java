package com.baidu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//通过百度获取经纬度
public class GetJingWeiDu {

	public static void main(String[] args) {
//		String address = "太原市小店区迎泽西大街下元公交站";//112.512354   37.86002
//		String address = "太原市小店区迎泽区迎泽宾馆";//112.569677   37.866943
		String address = "太原市小店区迎泽区太原火车站";//112.593301   37.866536

//		String address = "美国加利福尼亚州斯坦福大学";// 报错
		
		try {
			Object[] array = getCoordinate(address);
			System.out.println(array[0] + "   " + array[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object[] getCoordinate(String addr) throws Exception {
		String lng = null;// 经度
		String lat = null;// 纬度
		String address = null;
		address = java.net.URLEncoder.encode(addr, "UTF-8");
		String key = "f247cdb592eb43ebac6ccd27f796e2d2";
		String url = String.format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key);
		URL myURL = null;
		URLConnection httpsConn = null;
		myURL = new URL(url);
		InputStreamReader insr = null;
		BufferedReader br = null;
		try {
			httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
			if (httpsConn != null) {
				insr = new InputStreamReader(httpsConn.getInputStream(), "UTF-8");
				br = new BufferedReader(insr);
				String data = null;
				int count = 1;
				while ((data = br.readLine()) != null) {
					if (count == 5) {
						lng = (String) data.subSequence(data.indexOf(":") + 1, data.indexOf(","));// 经度
						count++;
					} else if (count == 6) {
						lat = data.substring(data.indexOf(":") + 1);// 纬度
						count++;
					} else {
						count++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (insr != null) {
				insr.close();
			}
			if (br != null) {
				br.close();
			}
		}
		return new Object[] { lng, lat };
	}
}
