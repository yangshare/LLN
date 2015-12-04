package com.jkx.yang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkx.yang.bean.MovieInfo;
import com.jkx.yang.dao.MovieDao;

public class Movie_Info extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		MovieDao movieDao=new MovieDao();
		ArrayList<MovieInfo> STW_list=new ArrayList<MovieInfo>();
		//获取电影类型
		String movie_types=null;
		try{
			
		    movie_types=request.getParameter("movie_types");
			movie_types=new String(movie_types.getBytes("iso-8859-1"),"utf-8");
		}catch(Exception e){
			System.out.println("movie_types="+movie_types);
			System.out.println("********************************************************");
		}
			
		
		if(movie_types!=null&&!movie_types.equals("")){
			STW_list=movieDao.QureyAllMovieByType(movie_types);
		}else{
			STW_list=movieDao.QureyAllMovie();//查询并获取所有电影列表
		}	
		try{
			//获取action的name
			String actions=request.getParameter("actions");
			actions=new String(actions.getBytes("iso-8859-1"),"utf-8");
			//增加电影条数
			if(actions.equals("addMovie")){
				String titles=request.getParameter("titles");
				String img_src=request.getParameter("img_src");
				String movie_src=request.getParameter("movie_src");
				String movie_descrip=request.getParameter("movie_descrip");
				String movie_type=request.getParameter("movie_type");
				if(!titles.equals("")&&titles!=null){
					movieDao.InsertMovie(titles, img_src, movie_src, movie_descrip, movie_type);
				}
				
			}
		}catch(Exception e){
			System.out.println("获取actions无值");
		}
		
		session.setAttribute("STW_list", STW_list);
		request.getRequestDispatcher("Y_STW/STW.jsp").forward(request, response);
		out.flush();
		out.close();
	}

}
