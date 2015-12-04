package com.jkx.yang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkx.yang.bean.UserInfo;
import com.jkx.yang.dao.UserInfoDao;

public class User_Info extends HttpServlet {

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

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//实例化session对象
		HttpSession session=request.getSession();
		
		/**
		 * 获取用户信息
		 * 1、判断用户是否存在
		 * 	存在：直接调用,放到session；不存在：添加到数据库后调用。
		 */
		//获取用户学号、昵称、密码
		String stuid=request.getParameter("stuid").trim();
		System.out.println("stuid"+stuid);
		String stuName=request.getParameter("stuname").trim();
		String stuPassword=request.getParameter("stupassword").trim();
		//判断数据库是否有该学号
		UserInfoDao userdao=new UserInfoDao();
		UserInfo user=new UserInfo();
		int returnNum=userdao.CheckUserById(stuid);
		//判断的反馈信息
		String messages="请认真填写";
		//如果存在该学号
		if(returnNum==1){
			user=userdao.QureyUserById(stuid);
			if((user.getName().trim()).equals(stuName)){
				if((user.getPassword().trim()).equals(stuPassword)){
					messages="登陆成功！";
					session.setAttribute("username", user.getName());
					session.setAttribute("messages", messages);
					System.out.println(messages);
					//response.sendRedirect("./index.jsp");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else{
					messages="用户密码有误！";
					session.setAttribute("messages", messages);
					request.getRequestDispatcher("index.jsp").forward(request, response);
					System.out.println(messages);
				}
			}else{
				messages="用户名有误！";
				session.setAttribute("messages", messages);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println(messages);
			}
		}else if(returnNum==0){//如果不存在该学号
			boolean flag=userdao.InsertUser(stuid, stuName, stuPassword);
			if(flag){
				messages="用户注册成功！";
				System.out.println(messages);
				session.setAttribute("messages", messages);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				messages="用户注册失败！";
				System.out.println(messages);
				session.setAttribute("messages", messages);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
