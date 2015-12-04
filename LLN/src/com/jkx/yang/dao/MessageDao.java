package com.jkx.yang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.jkx.yang.bean.MessageInfo;
import com.jkx.yang.connection.ConDB;

public class MessageDao {
	//引入连接
	ConDB condb=new ConDB();
	//创建一个连接对象
	Connection con=null;
	/**
	 * ①添加帖子
	 * ②修改帖子
	 * ③通过用户,帖名，时间查询帖子（commentName为空的为帖子）
	 * ④通过帖名查询评论
	 * ⑤查询所有帖子（取前10显示在jsp）
	 * ⑥查询所有帖子数目
	 * ⑦查询所有帖子评论数目
	 * ⑧添加评论
	 * ⑨通过帖名查询帖子（commentName为空的为帖子）
	 */
	
	
	/**
	 * ①添加帖子
	 */
	
	public boolean InsertMessage(String username,String contents,String titles,Timestamp times){
		boolean flag=false;
		String sql="insert into MessageInfo(username,contents,times,titles) values(?,?,?,?)";
		con=condb.getConDB();
		try {
			PreparedStatement Pstate=con.prepareStatement(sql);
			
			Pstate.setString(1, username);
			Pstate.setString(2, contents);
			Pstate.setTimestamp(3, times);
			Pstate.setString(4, titles);
			
			Pstate.executeUpdate();
//			int rows=Pstate.executeUpdate();
//			System.out.println("修改了"+rows+"行");
			
			flag=true;
			con.close();//关闭数据库连接
			
			System.out.println("添加帖子成功！");
			System.out.println("*******************************************");
		} catch (SQLException e) {
			System.out.println("添加帖子方法出问题！");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * ②修改帖子
	 * @param stu
	 * @return
	 */
	public boolean UpdateMessage(String username,String contents,Timestamp times,String titles){
		boolean flag=false;
		String sql="update User_Info set contents=? times=? titles=? where username=?";
		con=condb.getConDB();
		try {
			PreparedStatement Pstate=con.prepareStatement(sql);
			
			Pstate.setString(1, contents);
			Pstate.setTimestamp(2, times);
			Pstate.setString(3,titles);
			Pstate.setString(4,username);
			
			Pstate.executeUpdate();
//			int rows=Pstate.executeUpdate();
//			System.out.println("修改了"+rows+"行");
			
			flag=true;
			con.close();//关闭数据库连接
			
			
		} catch (SQLException e) {
			System.out.println("修改帖子方法出问题！");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * ③通过用户,帖名，时间查询帖子（commentName为空的为帖子）
	 * @param stu_nums
	 * @return
	 */	
 	public MessageInfo QureyMessageByThree(String username,String times,String titles){
 		MessageInfo messages=new MessageInfo();
		String sql="select * from MessageInfo where username=? and times=? and titles=? and commentName is null";
		con=condb.getConDB();//连接数据库
		
		try {
			
			PreparedStatement Pstate=con.prepareStatement(sql);
			Pstate.setString(1,username);
			Pstate.setString(2,times);
			Pstate.setString(3,titles);
			
			ResultSet rs=Pstate.executeQuery();
			
			if(rs.next()){
				
				messages.setUsername(rs.getString(2));
				messages.setContents(rs.getString(3));
				messages.setTimes(rs.getTimestamp(4));
				messages.setTitles(rs.getString(6));
				
				
				
				
			}else{
			System.out.println("QureyMessageByName()结果集为空！");
			}
			con.close();//关闭数据库连接	
		} catch (SQLException e) {
			System.out.println("通过用户查询帖子方法出错！");
			e.printStackTrace();
		}
		
		
		return messages;
	}
	
 	/**
	 * ④通过帖名查询评论（commentName不为空的为评论）
	 * @param stu_nums
	 * @return
	 */	
 	public ArrayList<MessageInfo> QureyCommentsByTitle(String titles){
 		ArrayList<MessageInfo> Mlist=new ArrayList<MessageInfo>();
 		
 		MessageInfo messages;
		String sql="select * from MessageInfo where  titles=? and commentName is not null";
		con=condb.getConDB();//连接数据库
		
		try {
			
			PreparedStatement Pstate=con.prepareStatement(sql);
			Pstate.setString(1,titles);
			ResultSet rs=Pstate.executeQuery();
			if(rs.next()){
				
				do{
					messages=new MessageInfo();
					messages.setUsername(rs.getString(2));
					messages.setContents(rs.getString(3));
					messages.setTimes(rs.getTimestamp(4));
					Mlist.add(messages);
				}while(rs.next());
				
			}else{
				Mlist=null;
				System.out.println("查询评论为空！Mlist="+Mlist);
				
			}
			con.close();//关闭数据库连接	
		} catch (SQLException e) {
			System.out.println("通过用户查询评论方法出错！");
			e.printStackTrace();
		}
		
		
		return Mlist;
	}
	/**
	 * ⑤查询所有帖子（commentName为空的为帖子）
	 * @return
	 */
	public ArrayList<MessageInfo> QureyAllMessage(){
		ArrayList<MessageInfo> Mlist=new ArrayList<MessageInfo>();
		
		MessageInfo messages;
		String sql="select * from MessageInfo where  commentName is null";
		con=condb.getConDB();//连接数据库
	
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				ResultSet rs=Pstate.executeQuery();
			if(rs.next()){
				do{	
					messages=new MessageInfo();
					messages.setUsername(rs.getString(2));
					messages.setContents(rs.getString(3));
					messages.setTimes(rs.getTimestamp(4));
					messages.setTitles(rs.getString(6));
					Mlist.add(messages);
					
				}while(rs.next());
			}else{
				System.out.println("查询所有帖子为空！");
			}	
			
			
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("查询所有帖子方法出问题！");
				e.printStackTrace();
			}
			

		
		
		return Mlist;
	}
	
	/**
	 * ⑥查询所有帖子数目（commentName为空的为帖子）
	 * @return
	 */
	public int QureyAllMessageNum(){
		
		String sql="select count(*) from MessageInfo where  commentName is null";
		con=condb.getConDB();//连接数据库
		int nums=0;
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				ResultSet rs=Pstate.executeQuery();
				
			if(rs.next()){			
				nums=rs.getInt(1);
				
			}else{
				System.out.println("帖子数为："+nums);
				nums=0;
			}
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("查询所有帖子数目方法出问题！");
				e.printStackTrace();
			}
			

		
		
		return nums;
	}
	
	/**
	 * ⑦查询对应作者帖子评论数目（commentName不为空的为评论）
	 * @return
	 */
	public int QureyAllCommentNum(String commentName){
		
		String sql="select count(*) from MessageInfo where  commentName=?";
		con=condb.getConDB();//连接数据库
		int nums=0;
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				Pstate.setString(1,commentName);
				ResultSet rs=Pstate.executeQuery();
				
			if(rs.next()){			
				nums=rs.getInt(1);
				
			}else{
				System.out.println("评论数为："+nums);
			}
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("查询所有帖子评论数目方法出问题！");
				e.printStackTrace();
			}
			

		
		
		return nums;
	}
	
	/**
	 * ⑧添加评论
	 */
	
	public boolean InsertComment(String username,String contents,String commentName,Timestamp times,String titles){
		boolean flag=false;
		String sql="insert into MessageInfo(username,contents,times,commentName,titles) values(?,?,?,?,?)";
		con=condb.getConDB();
		try {
			PreparedStatement Pstate=con.prepareStatement(sql);
			
			Pstate.setString(1, username);
			Pstate.setString(2, contents);
			Pstate.setTimestamp(3, times);
			Pstate.setString(4, commentName);
			Pstate.setString(5, titles);
			
			Pstate.executeUpdate();
//			int rows=Pstate.executeUpdate();
//			System.out.println("修改了"+rows+"行");
			
			flag=true;
			con.close();//关闭数据库连接
			
			System.out.println("添加评论成功！");
			System.out.println("*******************************************");
		} catch (SQLException e) {
			System.out.println("添加评论方法出问题！");
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * ⑨通过帖名查询帖子（commentName为空的为帖子）
	 * @param stu_nums
	 * @return
	 */	
 	public ArrayList<MessageInfo> QureyMessageByTitle(String titles){
 		ArrayList<MessageInfo> list=new ArrayList<MessageInfo>();
 		MessageInfo messages;
		String sql="select * from MessageInfo where titles=? and commentName is null";
		con=condb.getConDB();//连接数据库
		
		try {
			
			PreparedStatement Pstate=con.prepareStatement(sql);
			
			Pstate.setString(1,titles);
			
			ResultSet rs=Pstate.executeQuery();
			
			if(rs.next()){
				do{	
					messages=new MessageInfo();
					messages.setUsername(rs.getString(2));
					messages.setContents(rs.getString(3));
					messages.setTimes(rs.getTimestamp(4));
					messages.setTitles(rs.getString(6));
					list.add(messages);
					
				}while(rs.next());
			}else{
				System.out.println("查询帖子为空！");
			}	
			con.close();//关闭数据库连接	
		} catch (SQLException e) {
			System.out.println("通过帖名查询帖子方法出错！");
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
