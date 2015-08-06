package com.util;

import java.text.SimpleDateFormat;

public class Shenfenzheng {

	/**
	 * 校验身份证正确
	 */
	public static void main(String[] args) {

		System.out.println(checkID("142225198710230511"));
		System.out.println("******************");
		System.out.println(checkID("142225198710230512"));
		System.out.println("******************");
		System.out.println(checkID("142225198710231111"));
	}

	// 验证身份证号的有效性,必须是15 位或 18位
	public static String checkID(String aNewID) {
		String id = aNewID;
		if (id.length() == 15)
			id = OldIDTransferToNew(id);
		String result = "";
		String[] aCity = new String[] { null, null, null, null, null, null, null, null, null, null, null, "北京", "天津", "河北", "山西", "内蒙古", null, null, null,
				null, null, "辽宁", "吉林", "黑龙江", null, null, null, null, null, null, null, "上海", "江苏", "浙江", "安微", "福建", "江西", "山东", null, null, null, "河南",
				"湖北", "湖南", "广东", "广西", "海南", null, null, null, "重庆", "四川", "贵州", "云南", "西藏", null, null, null, null, null, null, "陕西", "甘肃", "青海", "宁夏", "新疆",
				null, null, null, null, null, "台湾", null, null, null, null, null, null, null, null, null, "香港", "澳门", null, null, null, null, null, null, null,
				null, "国外" };
		try {

			if (aCity[Integer.parseInt(id.substring(0, 2))] == null) {
				result = "身份证号的地区不合法，请重新输入！";
				return result;
			}
			String strBirth = id.substring(6, 10) + "-" + id.substring(10, 12) + "-" + id.substring(12, 14);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateBirthFromID = null;
			java.util.Date specialDate = null;
			try {
				dateBirthFromID = sdf.parse(strBirth);
				specialDate = sdf.parse("1900-01-01");
			} catch (Exception e) {
				e.printStackTrace();

			}
			if (dateBirthFromID.getTime() > System.currentTimeMillis() || dateBirthFromID.getTime() < specialDate.getTime()) {
				result = "身份证号的出生日期不合要求，请重输！";
				return result;
			}
			int intYear = Integer.parseInt(id.substring(6, 10));
			int intMonth = Integer.parseInt(id.substring(10, 12));
			int intDay = Integer.parseInt(id.substring(12, 14));
			if (intMonth > 12) {
				result = "身份证号的出生日期的月份不合要求，请重输！";
				return result;
			}
			if (getMonthDays(intYear, intMonth) < intDay) {
				result = "身份证号的出生日期的天数不合要求，请重输！";
				return result;
			}
			String lastCode = id.substring(17);
			if (lastCode.equals("x")) {
				lastCode = lastCode.toUpperCase();
			}
			if (!lastCode.equals(getValidateCode(id))) {
				result = "身份证号的验证码不合要求，请重输！";
				return result;
			}
		} catch (Exception ex) {
			result = "身份证号较验不通过！";
		}
		return result;
	}

	private static String getValidateCode(String OldID) {
		int total = 0;
		int[] factor = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		String InvalidateCode = "10X98765432";
		for (int i = 0; i < 17; i++) {
			total += Integer.parseInt(OldID.substring(i, i + 1)) * factor[i];
		}

		int M = total % 11;

		String lastCode = InvalidateCode.substring(M, M + 1);
		return lastCode;
	}
	private static int getMonthDays(int iYear, int iMonth) {
		switch (iMonth) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			return isLeapYear(iYear) ? 29 : 28;
		}
		return 0;
	}
	
	private static boolean isLeapYear(int iYear) {
		if ((iYear % 400 == 0) || (iYear % 100 != 0) && (iYear % 4 == 0)) {
			return true;
		}
		return false;
	}
	
	private static String OldIDTransferToNew(String OldID) {
		int total = 0;
		int[] factor = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		String InvalidateCode = "10X98765432";
		String NewID;
		NewID = OldID.substring(0, 6);
		NewID += "19";
		NewID += OldID.substring(6, 15);
		for (int i = 0; i < 17; i++) {
			total += Integer.parseInt(NewID.substring(i, i + 1)) * factor[i];
		}
		int M = total % 11;
		NewID += InvalidateCode.substring(M, M + 1);
		return NewID;
	}
	
}
