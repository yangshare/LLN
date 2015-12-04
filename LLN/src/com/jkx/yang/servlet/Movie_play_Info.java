package com.jkx.yang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkx.yang.bean.MovieInfo;
import com.jkx.yang.dao.MovieDao;

public class Movie_play_Info extends HttpServlet {

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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		MovieDao mDao=new MovieDao();
		MovieInfo movies=new MovieInfo();
		//获取电影名
		String titles=request.getParameter("titles");
		titles=new String(titles.getBytes("iso-8859-1"),"utf-8");
		System.out.println("获取电影名为:"+titles);
		if(!titles.equals("")&&titles!=null){
			movies=mDao.QureyMovieByName(titles);
			session.setAttribute("movies", movies);
		}else{
			System.out.println("获取电影名为空！");
			System.out.println("************************************");
		}
		request.getRequestDispatcher("Y_STW/Jplayer.jsp").forward(request, response);
		out.flush();
		out.close();
	}

}
