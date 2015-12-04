package com.jkx.yang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

public class message_comment extends HttpServlet {

	
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
		HttpSession session=request.getSession();//ʵ����session������ȡsessionװ������
		MessageDao msDao=new MessageDao();
		//UserInfoDao userDao=new UserInfoDao();
//�ٻ�ȡjspҳ��ķ�����Ϣ��Ϊ�գ�˵��û������
		
		GetSystemNowTime date=new GetSystemNowTime();
		//��ȡ�α�ֵ���ж��Ǵ���̳��ת��������ҳ
		int cursors=Integer.parseInt(request.getParameter("cursors"));
		String titless;//����
		String autherss;//����
		String timess;//����ʱ��
		String contentss;//��������
		String contents;//��������
		String authers=(String)session.getAttribute("username");//��½�ˣ�Ҳ���������ˣ�
		Timestamp timestamp = new Timestamp(date.getSysTime().getTime());//���۵�ʱ��
		if(cursors==1){
			 titless=new String(request.getParameter("titless").getBytes("iso-8859-1"),"utf-8");
			 autherss=new String(request.getParameter("autherss").getBytes("iso-8859-1"),"utf-8");
			 timess=request.getParameter("timess");
			 MessageInfo messageinfo=new MessageInfo();
			 messageinfo=msDao.QureyMessageByThree(autherss,timess,titless);
			 contentss=messageinfo.getContents();
			 session.setAttribute("contentss", contentss);
			System.out.println("��������="+contentss);
		}else{
			 titless=request.getParameter("titless");//����
			 autherss=request.getParameter("autherss");//����
			 timess=request.getParameter("timess");//����ʱ��
			 contents=request.getParameter("BBS_Content");
			 System.out.println("��������="+contents);
			//ͨ���ж���������Ϣ
				if(authers!=null&&contents!=null&&autherss!=null&&titless!=null&&!authers.equals("")&&!contents.equals("")&&!autherss.equals("")&&!titless.equals("")){
					msDao.InsertComment(authers,contents,autherss,timestamp,titless);
					
				}else{
					System.out.println("��������");
				}
		}
		
		
		 
	
		
		//�������
		System.out.println("authers="+authers);
	
		System.out.println("times="+timestamp);
		System.out.println("titless="+titless);
		System.out.println("autherss="+autherss);
		System.out.println("timess="+timess);
		System.out.println("**********************************************************");
		
				
//�ڽ����ݿ��������������͸�jspҳ�棨������ѯ���ӣ�
		//������ҳ��ȡ�����ߺ�������ʱ��
		session.setAttribute("titless", titless);
		session.setAttribute("autherss", autherss);
		session.setAttribute("timess", timess);
		
		//��ȡ���ݿ�����
		ArrayList<MessageInfo> list=new ArrayList<MessageInfo>();
		list=msDao.QureyCommentsByTitle(titless);
	    session.setAttribute("list", list);
			
		
		
//��ͨ�������������߼��������ת��BBS.jsp
		//response.sendRedirect("./Y_BBS/BBS.jsp");
		request.getRequestDispatcher("Y_BBS/BBS_second.jsp").forward(request, response);
		out.flush();
		out.close();
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
