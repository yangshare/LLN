package com.jkx.yang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jkx.yang.bean.UserInfo;
import com.jkx.yang.connection.ConDB;

public class UserInfoDao {
	//引入连接
	ConDB condb=new ConDB();
	//创建一个连接对象
	Connection con=null;
	
	/**
	 * ①添加用户
	 */
	public boolean InsertUser(String id,String name,String password){
		boolean flag=false;
		String sql="insert into User_Info(id,name,password) values(?,?,?)";
		con=condb.getConDB();
		try {
			PreparedStatement Pstate=con.prepareStatement(sql);
			
			Pstate.setString(1, id);
			Pstate.setString(2, name);
			Pstate.setString(3, password);
			
			Pstate.executeUpdate();
//			int rows=Pstate.executeUpdate();
//			System.out.println("修改了"+rows+"行");
			
			flag=true;
			con.close();//关闭数据库连接
			
			
		} catch (SQLException e) {
			System.out.println("添加用户方法出问题！");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * ②修改用户信息
	 * @param stu
	 * @return
	 */
	public boolean UpdateUser(int id,String name,String password){
		boolean flag=false;
		String sql="update User_Info set name=? password=? where id=?";
		con=condb.getConDB();
		try {
			PreparedStatement Pstate=con.prepareStatement(sql);
			
			Pstate.setString(1, name);
			Pstate.setString(2, password);
			
			Pstate.executeUpdate();
//			int rows=Pstate.executeUpdate();
//			System.out.println("修改了"+rows+"行");
			
			flag=true;
			con.close();//关闭数据库连接
			
			
		} catch (SQLException e) {
			System.out.println("修改用户信息方法出问题！");
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * ③通过学号检测用户是否存在
	 * @param stu_nums
	 * @return
	 */	
 	public int CheckUserById(String id){
 		int checkNum=0;
 		String sql="select * from User_Info where id=?";
		con=condb.getConDB();//连接数据库
		
		try {
			
			PreparedStatement Pstate=con.prepareStatement(sql);
			Pstate.setString(1,id);
			ResultSet rs=Pstate.executeQuery();
			
			if(rs.next()){
				
				checkNum=1;
				
				
				
				
			}else{
				checkNum=0;
			}
			con.close();//关闭数据库连接	
		} catch (SQLException e) {
			System.out.println("学号检测用户方法出错！");
			e.printStackTrace();
		}
		
		
		return checkNum;
	}
	
	
	
	/**
	 * ④通过学号查询用户
	 * @param stu_nums
	 * @return
	 */	
 	public UserInfo QureyUserById(String id){
 		UserInfo user=new UserInfo();
 		
		String sql="select * from User_Info where id=?";
		con=condb.getConDB();//连接数据库
		
		try {
			
			PreparedStatement Pstate=con.prepareStatement(sql);
			Pstate.setString(1,id);
			ResultSet rs=Pstate.executeQuery();
			
			if(rs.next()){
				
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				
				
				
				
			}else{
			System.out.println("结果集为空！");
			}
			con.close();//关闭数据库连接	
		} catch (SQLException e) {
			System.out.println("通过学号查询用户方法出错！");
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	
	/**
	 * ⑤查询所有用户
	 * @return
	 */
	public ArrayList<UserInfo> QureyAllVotes(){
		ArrayList<UserInfo> Ulist=new ArrayList<UserInfo>();
		UserInfo user=new UserInfo();
		String sql="select * from User_Info";
		con=condb.getConDB();//连接数据库
	
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				ResultSet rs=Pstate.executeQuery();
				
			while(rs.next()){				
				user=QureyUserById(rs.getString(1));
				Ulist.add(user);
				
			}
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("查询所有票数方法出问题！");
				e.printStackTrace();
			}
			

		
		
		return Ulist;
	}
	/**
	 * ⑥查询用户总数
	 */
	
	public int QureyUserNum(){
		int userNum=0;
		String sql="select count(*) from User_Info";
		con=condb.getConDB();//连接数据库
	
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				ResultSet rs=Pstate.executeQuery();
				
				if(rs.next()){			
					userNum=rs.getInt(1);
					
				}else{
					userNum=0;
					System.out.println("用户数数为："+userNum);
					
				}
				con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("查询所有票数方法出问题！");
				e.printStackTrace();
			}
			
		return userNum;
	}
}
