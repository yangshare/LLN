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
		HttpSession session=request.getSession();//实例化session，来获取session装的作者
		MessageDao msDao=new MessageDao();
		//UserInfoDao userDao=new UserInfoDao();
//①获取jsp页面的发帖信息（为空，说明没发帖）
		
		GetSystemNowTime date=new GetSystemNowTime();
		//获取游标值，判断是从论坛跳转还是评论页
		int cursors=Integer.parseInt(request.getParameter("cursors"));
		String titless;//帖名
		String autherss;//帖主
		String timess;//发帖时间
		String contentss;//发帖内容
		String contents;//评论内容
		String authers=(String)session.getAttribute("username");//登陆人（也就是评论人）
		Timestamp timestamp = new Timestamp(date.getSysTime().getTime());//评论的时间
		if(cursors==1){
			 titless=new String(request.getParameter("titless").getBytes("iso-8859-1"),"utf-8");
			 autherss=new String(request.getParameter("autherss").getBytes("iso-8859-1"),"utf-8");
			 timess=request.getParameter("timess");
			 MessageInfo messageinfo=new MessageInfo();
			 messageinfo=msDao.QureyMessageByThree(autherss,timess,titless);
			 contentss=messageinfo.getContents();
			 session.setAttribute("contentss", contentss);
			System.out.println("帖子内容="+contentss);
		}else{
			 titless=request.getParameter("titless");//帖名
			 autherss=request.getParameter("autherss");//帖主
			 timess=request.getParameter("timess");//发帖时间
			 contents=request.getParameter("BBS_Content");
			 System.out.println("评论内容="+contents);
			//通过判断来插入信息
				if(authers!=null&&contents!=null&&autherss!=null&&titless!=null&&!authers.equals("")&&!contents.equals("")&&!autherss.equals("")&&!titless.equals("")){
					msDao.InsertComment(authers,contents,autherss,timestamp,titless);
					
				}else{
					System.out.println("不发评论");
				}
		}
		
		
		 
	
		
		//测试语句
		System.out.println("authers="+authers);
	
		System.out.println("times="+timestamp);
		System.out.println("titless="+titless);
		System.out.println("autherss="+autherss);
		System.out.println("timess="+timess);
		System.out.println("**********************************************************");
		
				
//②将数据库的帖子提出来发送给jsp页面（包括查询帖子）
		//从帖子页获取的作者和帖名和时间
		session.setAttribute("titless", titless);
		session.setAttribute("autherss", autherss);
		session.setAttribute("timess", timess);
		
		//获取数据库帖子
		ArrayList<MessageInfo> list=new ArrayList<MessageInfo>();
		list=msDao.QureyCommentsByTitle(titless);
	    session.setAttribute("list", list);
			
		
		
//③通过上面两步的逻辑处理后跳转到BBS.jsp
		//response.sendRedirect("./Y_BBS/BBS.jsp");
		request.getRequestDispatcher("Y_BBS/BBS_second.jsp").forward(request, response);
		out.flush();
		out.close();
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
