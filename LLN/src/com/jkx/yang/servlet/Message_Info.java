package com.jkx.yang.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jkx.yang.bean.GetSystemNowTime;
import com.jkx.yang.bean.MessageInfo;
import com.jkx.yang.dao.MessageDao;
import com.jkx.yang.dao.UserInfoDao;

public class Message_Info extends HttpServlet {

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
		//PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();//ʵ����session������ȡsessionװ������
		MessageDao msDao=new MessageDao();
		UserInfoDao userDao=new UserInfoDao();
//�ٻ�ȡjspҳ��ķ�����Ϣ��Ϊ�գ�˵��û������
		
		GetSystemNowTime date=new GetSystemNowTime();
		String authers=(String)session.getAttribute("username");
		String title=request.getParameter("BBS_Title");//���ӱ���
		String contents=request.getParameter("BBS_Content");//��������
		//Date times=new Date(date.getSysTime().getTime());//java��Dateת��Ϊsql��Date,ֻ������
		Timestamp timestamp = new Timestamp(date.getSysTime().getTime());//��ȡ��ǰʱ��
		String sousuo=null;//��ȡ��������
		try{
			sousuo=request.getParameter("sousuo");
			System.out.println("����Ϊ:"+sousuo);
		}catch(Exception e){
			System.out.println("����Ϊ�գ�"+sousuo);
		}
		//�������
		System.out.println("authers="+authers+",title"+title);
		System.out.println("contents="+contents);
		System.out.println("times="+timestamp);
		System.out.println("**********************************************************");
		//ͨ���ж���������Ϣ
		if(authers!=null&&title!=null&&contents!=null&&!authers.equals("")&&!title.equals("")&&!contents.equals("")){
			msDao.InsertMessage(authers, contents, title, timestamp);
		}else{
			System.out.println("����������");
		}
				
//�ڽ����ݿ��������������͸�jspҳ�棨������ѯ���ӣ�
		//��ȡ���ݿ��û���Ŀ
		session.setAttribute("userNum", userDao.QureyUserNum());
		//��ȡ���ݿ�������Ŀ
		session.setAttribute("messageNum", msDao.QureyAllMessageNum());
		//��ȡ���ݿ�����
		ArrayList<MessageInfo> BBS_list=new ArrayList<MessageInfo>();
		if(sousuo!=null){
			BBS_list=msDao.QureyMessageByTitle(sousuo);
		}else{
			BBS_list=msDao.QureyAllMessage();
		}
		session.setAttribute("BBS_list", BBS_list);
		
		
//��ͨ�������������߼��������ת��BBS.jsp
		//response.sendRedirect("./Y_BBS/BBS.jsp");
		request.getRequestDispatcher("Y_BBS/BBS.jsp").forward(request, response);
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
