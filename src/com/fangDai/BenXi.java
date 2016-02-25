package com.fangDai;

public class BenXi {
	/**
	 *计算房贷 等额本息
	 *每月还款金额= [贷款本金×月利率×（1+月利率）^还款月数]÷[（1+月利率）^（还款月数－1）]
	 */
	public static void main(String[] args) {
		float yearLilv=5.65F/100;//年利率
		float monthLilv=yearLilv/12;//月利率
		int daiKuanNum=30*10000;//贷款总额
		int huanKuanMonths=20*12;//贷款月份数
		double perMonthBenJinLiXi=daiKuanNum*monthLilv*Math.pow((1+monthLilv),huanKuanMonths)/
			(Math.pow((1+monthLilv),huanKuanMonths)-1);//每月固定本金利息数
		double returnMoney=0F;//已归还本金数
		int j=1;
		
		for(int i=1;i<=huanKuanMonths;i++){
			double perMonthLiXi=(daiKuanNum-returnMoney)*monthLilv;//每月付利息
			System.out.println("第"+j+"年，"+"第"+i+"月，本金:"+(perMonthBenJinLiXi-perMonthLiXi)+"，利息"+perMonthLiXi+"，还款金为："+perMonthBenJinLiXi);
			returnMoney=perMonthBenJinLiXi*i;
			if(i%12==0){
				j++;
			}
		}
	}
}
