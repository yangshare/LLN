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
		//ʵ����session����
		HttpSession session=request.getSession();
		
		/**
		 * ��ȡ�û���Ϣ
		 * 1���ж��û��Ƿ����
		 * 	���ڣ�ֱ�ӵ���,�ŵ�session�������ڣ���ӵ����ݿ����á�
		 */
		//��ȡ�û�ѧ�š��ǳơ�����
		String stuid=request.getParameter("stuid").trim();
		System.out.println("stuid"+stuid);
		String stuName=request.getParameter("stuname").trim();
		String stuPassword=request.getParameter("stupassword").trim();
		//�ж����ݿ��Ƿ��и�ѧ��
		UserInfoDao userdao=new UserInfoDao();
		UserInfo user=new UserInfo();
		int returnNum=userdao.CheckUserById(stuid);
		//�жϵķ�����Ϣ
		String messages="��������д";
		//������ڸ�ѧ��
		if(returnNum==1){
			user=userdao.QureyUserById(stuid);
			if((user.getName().trim()).equals(stuName)){
				if((user.getPassword().trim()).equals(stuPassword)){
					messages="��½�ɹ���";
					session.setAttribute("username", user.getName());
					session.setAttribute("messages", messages);
					System.out.println(messages);
					//response.sendRedirect("./index.jsp");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else{
					messages="�û���������";
					session.setAttribute("messages", messages);
					request.getRequestDispatcher("index.jsp").forward(request, response);
					System.out.println(messages);
				}
			}else{
				messages="�û�������";
				session.setAttribute("messages", messages);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println(messages);
			}
		}else if(returnNum==0){//��������ڸ�ѧ��
			boolean flag=userdao.InsertUser(stuid, stuName, stuPassword);
			if(flag){
				messages="�û�ע��ɹ���";
				System.out.println(messages);
				session.setAttribute("messages", messages);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				messages="�û�ע��ʧ�ܣ�";
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
