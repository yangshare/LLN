package com.jkx.yang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jkx.yang.bean.MovieInfo;
import com.jkx.yang.connection.ConDB;

public class MovieDao {
	//引入连接
	ConDB condb=new ConDB();
	//创建一个连接对象
	Connection con=null;
	/**
	 * ①添加电影
	 * ②读出电影
	 */
	
	
	/**
	 * ①添加帖子
	 */
	
	public boolean InsertMovie(String titles,String img_src,String movie_src,String movie_description,String movie_type){
		boolean flag=false;
		String sql="insert into movieInfo(titles,img_src,movie_src,movie_description,movie_type) values(?,?,?,?,?)";
		con=condb.getConDB();
		try {
			PreparedStatement Pstate=con.prepareStatement(sql);
			
			Pstate.setString(1, titles);
			Pstate.setString(2, img_src);
			Pstate.setString(3, movie_src);
			Pstate.setString(4, movie_description);
			Pstate.setString(5, movie_type);
		
			
			Pstate.executeUpdate();
//			int rows=Pstate.executeUpdate();
//			System.out.println("修改了"+rows+"行");
			
			flag=true;
			con.close();//关闭数据库连接
			
			System.out.println("添加电影成功！");
			System.out.println("*******************************************");
		} catch (SQLException e) {
			System.out.println("添加帖子方法出问题！");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * ⑤查询所有电影
	 * @return
	 */
	public ArrayList<MovieInfo> QureyAllMovie(){
		ArrayList<MovieInfo> Mlist=new ArrayList<MovieInfo>();
		
		MovieInfo movies;
		String sql="select * from movieInfo";
		con=condb.getConDB();//连接数据库
	
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				ResultSet rs=Pstate.executeQuery();
			if(rs.next()){
				do{	
					movies=new MovieInfo();
					movies.setTitles(rs.getString(2));
					movies.setImg_src(rs.getString(3));
					movies.setMovie_src(rs.getString(4));
					movies.setMovie_description(rs.getString(5));
					movies.setMovie_type(rs.getString(6));
					Mlist.add(movies);
					
				}while(rs.next());
			}else{
				System.out.println("查询所有电影为空！");
			}	
			
			
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("查询所有电影方法出问题！");
				e.printStackTrace();
			}
			

		
		
		return Mlist;
	}
	
	/**
	 * ③通过电影名查询电影
	 * @return
	 */
	public MovieInfo QureyMovieByName(String titles){
	
		
		MovieInfo movies=new MovieInfo();
		String sql="select * from movieInfo where titles=?";
		con=condb.getConDB();//连接数据库
	
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				Pstate.setString(1, titles);
				ResultSet rs=Pstate.executeQuery();
			if(rs.next()){
				do{	
					
					movies.setTitles(rs.getString(2));
					movies.setImg_src(rs.getString(3));
					movies.setMovie_src(rs.getString(4));
					movies.setMovie_description(rs.getString(5));
					movies.setMovie_type(rs.getString(6));
				
					
				}while(rs.next());
			}else{
				System.out.println("通过电影名查询查询电影为空！");
			}	
			
			
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("通过电影名查询电影方法出问题！");
				e.printStackTrace();
			}
			

		
		
		return movies;
	}
	/**
	 * ④通过电影类型查询电影
	 * @return
	 */
	public ArrayList<MovieInfo> QureyAllMovieByType(String movie_type){
	
		ArrayList<MovieInfo> list=new ArrayList<MovieInfo>();
		MovieInfo movies;
		String sql="select * from movieInfo where movie_type=?";
		con=condb.getConDB();//连接数据库
	
			PreparedStatement Pstate;
		try {
				Pstate = con.prepareStatement(sql);
				Pstate.setString(1, movie_type);
				ResultSet rs=Pstate.executeQuery();
			if(rs.next()){
				do{	
					movies=new MovieInfo();
					movies.setTitles(rs.getString(2));
					movies.setImg_src(rs.getString(3));
					movies.setMovie_src(rs.getString(4));
					movies.setMovie_description(rs.getString(5));
					movies.setMovie_type(rs.getString(6));
					list.add(movies);
					
				}while(rs.next());
			}else{
				System.out.println("通过电影类型查询电影为空！");
			}	
			
			
			con.close();//关闭数据库连接
		} catch (SQLException e) {
				System.out.println("通过电影类型查询电影方法出问题！");
				e.printStackTrace();
			}
			

		
		
		return list;
	}
}
