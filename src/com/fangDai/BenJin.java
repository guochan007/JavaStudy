package com.fangDai;

public class BenJin {
	/**
	 *计算房贷 等额本金
	 *每月还款金额= （贷款本金 / 还款月数）+（贷款本金 — 已归还本金累计额）×每月利率
	 */
	public static void main(String[] args) {
		float yearLilv=5.65F/100;//年利率
		float monthLilv=yearLilv/12;//月利率
		int daiKuanNum=30*10000;//贷款总额
		int huanKuanMonths=20*12;//贷款月份数
		float PerMonthBenJin=daiKuanNum/huanKuanMonths;//每月固定本金数
		float returnBenJin=0F;//已归还本金数
		int j=1;
		
//		float duoHuan=2756.67F-2662.5F;
//		float duoDay=duoHuan/(daiKuanNum*monthLilv/30);//多出来的天数
//		System.out.println("多出来的天数:"+duoDay);
		float duoChuLixi=daiKuanNum*monthLilv/30*(21-19);//21为每月还贷日，19号为银行放款日
		System.out.println("多出来的利息："+duoChuLixi+",第一个月还:"+(daiKuanNum/huanKuanMonths+daiKuanNum*monthLilv+duoChuLixi));
		
		for(int i=1;i<=huanKuanMonths;i++){
			float PerMonthHuanKuanJin=daiKuanNum/huanKuanMonths+(daiKuanNum-returnBenJin)*monthLilv;
			System.out.println("第"+j+"年，"+"第"+i+"月，本金:"+PerMonthBenJin+"，利息"+(daiKuanNum-returnBenJin)*monthLilv+"，还款金为："+PerMonthHuanKuanJin);
			returnBenJin=PerMonthBenJin*i;
			if(i%12==0){
				j++;
			}
		}
	}
}
