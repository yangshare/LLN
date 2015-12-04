package com.jkx.yang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jkx.yang.bean.XunleiInfo;
import com.jkx.yang.connection.ConDB;

public class XunleiDao {
	//引入连接
	ConDB condb=new ConDB();
	//创建一个连接对象
	Connection con=null;
	/**
	 * ①添加迅雷账号
	 * ②读出迅雷账号
	 * ③通过资源名查询资源
	 */
	
	
	/**
	 * ①添加迅雷账号
	 */
	
	public boolean InsertXunlei(String titles,String contents){
		boolean flag=false;
		String sql="insert into Xunlei(titles,contents) values(?,?)";
		con=condb.getConDB();
		try {
			PreparedStatement Pstate=con.prepareStatement(sql);
			
			Pstate.setString(1, titles);
			Pstate.setString(2, contents);
			
		
			
			Pstate.executeUpdate();
//			int rows=Pstate.executeUpdate();
//			System.out.println("修改了"+rows+"行");
			
			flag=true;
			con.close();//关闭数据库连接
			
			System.out.println("添加迅雷账号成功！");
			System.out.println("*******************************************");
		} catch (SQLException e) {
			System.out.println("添加迅雷账号方法出问题！");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * ②读出迅雷账号
	 * @return
	 */
	public ArrayList<XunleiInfo> QureyAllXunlei(){
		ArrayList<XunleiInfo> Mlist=new ArrayList<XunleiInfo>();
		
		XunleiInfo xunlei;
		String sql="select * from Xunlei";
		con=condb.getConDB();//连接数据库
	
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				ResultSet rs=Pstate.executeQuery();
			if(rs.next()){
				do{	
					xunlei=new XunleiInfo();
					xunlei.setTitles(rs.getString(2));
					xunlei.setContents(rs.getString(3));
					
					Mlist.add(xunlei);
					
				}while(rs.next());
			}else{
				System.out.println("读出迅雷账号为空！");
			}	
			
			
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("读出迅雷账号方法出问题！");
				e.printStackTrace();
			}
			

		
		
		return Mlist;
	}
	
	/**
	 * ③通过资源名查询资源
	 * @return
	 */
	public ArrayList<XunleiInfo> QureyXunleiByName(String titles){
		ArrayList<XunleiInfo> list=new ArrayList<XunleiInfo>();
		
		XunleiInfo xunlei=new XunleiInfo();
		String sql="select * from Xunlei where titles=?";
		con=condb.getConDB();//连接数据库
	
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				Pstate.setString(1, titles);
				ResultSet rs=Pstate.executeQuery();
			if(rs.next()){
				do{	
					
					xunlei.setTitles(rs.getString(2));
					xunlei.setContents(rs.getString(3));
					list.add(xunlei);
					
				}while(rs.next());
			}else{
				System.out.println("通过资源名查询资源为空！");
			}	
			
			
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("通过资源名查询资源方法出问题！");
				e.printStackTrace();
			}

		return list;
	}
	
}
