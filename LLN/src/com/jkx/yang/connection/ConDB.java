package com.jkx.yang.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConDB {
	Connection con=null;//连接数据库变量
	


	/**
	 * 连接数据库
	 * @return
	 */
	public Connection getConDB(){
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//跟踪可用驱动
		con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataName=BBW","sa","123456");
//		System.out.println("连接数据库成功！");
		
		}
		catch(Exception e){
			System.out.println("连接数据库方法出错！");
			
		}
		return con;
	}
	
	

	
	
//	/**
//	 * 修改票数
//	 * @param stu
//	 * @return
//	 */
//	public boolean UpdateVote(int voteNum,int id){
//		boolean flag=false;
//		String sql="update VoteTable set votes=? where id=?";
//		con=getConDB();
//		try {
//			PreparedStatement Pstate=con.prepareStatement(sql);
//			Pstate.setInt(1, voteNum);
//			
//			Pstate.setInt(2, id);
//			Pstate.executeUpdate();
////			int rows=Pstate.executeUpdate();
////			System.out.println("修改了"+rows+"行");
//			
//			flag=true;
//			con.close();//关闭数据库连接
//			
//			
//		} catch (SQLException e) {
//			System.out.println("修改票数方法出问题！");
//			e.printStackTrace();
//		}
//		return flag;
//	}
//	
//	
//	/**
//	 * 通过编号查询票数
//	 * @param stu_nums
//	 * @return
//	 */	
// 	public VotejavaBean QureyVotesById(int id){
// 		VotejavaBean vote=new VotejavaBean();
//		String sql="select * from VoteTable where id=?";
//		con=getConDB();//连接数据库
//		
//		try {
//			
//			PreparedStatement Pstate=con.prepareStatement(sql);
//			Pstate.setInt(1,id);
//			ResultSet rs=Pstate.executeQuery();
//			
//			if(rs.next()){
//				
//				vote.setId(rs.getInt(1));
//				vote.setTeachers(rs.getString(2));
//				vote.setLesson(rs.getString(3));
//				
//				vote.setVotes(rs.getInt(4)); 
//				
//				
//			}else{
//			System.out.println("结果集为空！");
//			}
//			con.close();//关闭数据库连接	
//		} catch (SQLException e) {
//			System.out.println("通过编号查询票数方法出错！");
//			e.printStackTrace();
//		}
//		
//		
//		return vote;
//	}
//	
//	
//	/**
//	 * 查询所有票数情况
//	 * @return
//	 */
//	public ArrayList<VotejavaBean> QureyAllVotes(){
//		ArrayList<VotejavaBean> Vlist=new ArrayList<VotejavaBean>();
//		VotejavaBean vote=new VotejavaBean();
//		String sql="select * from VoteTable";
//		con=getConDB();//连接数据库
//	
//			PreparedStatement Pstate;
//		try {
//				Pstate = con.prepareStatement(sql);
//				ResultSet rs=Pstate.executeQuery();
//				
//			while(rs.next()){				
//				vote=QureyVotesById(rs.getInt(1));
//				Vlist.add(vote);
//				
//			}
//			con.close();//关闭数据库连接
//		} catch (SQLException e) {
//				System.out.println("查询所有票数方法出问题！");
//				e.printStackTrace();
//			}
//			
//
//		
//		
//		return Vlist;
//	}

	
	

	
	
}
