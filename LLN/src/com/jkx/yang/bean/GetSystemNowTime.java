package com.jkx.yang.bean;

import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetSystemNowTime {

	/**
	 * @获取系统当前时间（最好是获取网络时间）
	 */
//	public static void main(String[] args){
//		getSysTime();
//	}
	public  Date getSysTime(){
		
		 //取得资源对象
		  URL url;
		  long time = 0;
		  Date date;
		try {
			url = new URL("http://www.bjtime.cn");
			//生成连接对象
		  URLConnection uc = url.openConnection();
		  //发出连接
		  uc.connect();
		  time = uc.getDate();
		  System.out.println("long time:"+time);
		} catch (Exception e) {
			 System.out.println("获取网络时间方法异常");
			e.printStackTrace();
		}if(time!=0){
		 date = new Date(time);
		 System.out.println("联网：获取网络时间");
		}else{
			date=new Date();
			System.out.println("无网络：获取系统时间");
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(date));// new Date()为获取当前系统时间
		System.out.println(date);// new Date()为获取当前系统时间
		return date;
		
		}

}
