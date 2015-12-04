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
		HttpSession session=request.getSession();//实例化session，来获取session装的作者
		MessageDao msDao=new MessageDao();
		UserInfoDao userDao=new UserInfoDao();
//①获取jsp页面的发帖信息（为空，说明没发帖）
		
		GetSystemNowTime date=new GetSystemNowTime();
		String authers=(String)session.getAttribute("username");
		String title=request.getParameter("BBS_Title");//帖子标题
		String contents=request.getParameter("BBS_Content");//帖子内容
		//Date times=new Date(date.getSysTime().getTime());//java的Date转换为sql的Date,只留日期
		Timestamp timestamp = new Timestamp(date.getSysTime().getTime());//获取当前时间
		String sousuo=null;//获取搜索帖名
		try{
			sousuo=request.getParameter("sousuo");
			System.out.println("搜帖为:"+sousuo);
		}catch(Exception e){
			System.out.println("搜帖为空！"+sousuo);
		}
		//测试语句
		System.out.println("authers="+authers+",title"+title);
		System.out.println("contents="+contents);
		System.out.println("times="+timestamp);
		System.out.println("**********************************************************");
		//通过判断来插入信息
		if(authers!=null&&title!=null&&contents!=null&&!authers.equals("")&&!title.equals("")&&!contents.equals("")){
			msDao.InsertMessage(authers, contents, title, timestamp);
		}else{
			System.out.println("不发布帖子");
		}
				
//②将数据库的帖子提出来发送给jsp页面（包括查询帖子）
		//获取数据库用户数目
		session.setAttribute("userNum", userDao.QureyUserNum());
		//获取数据库帖子数目
		session.setAttribute("messageNum", msDao.QureyAllMessageNum());
		//获取数据库帖子
		ArrayList<MessageInfo> BBS_list=new ArrayList<MessageInfo>();
		if(sousuo!=null){
			BBS_list=msDao.QureyMessageByTitle(sousuo);
		}else{
			BBS_list=msDao.QureyAllMessage();
		}
		session.setAttribute("BBS_list", BBS_list);
		
		
//③通过上面两步的逻辑处理后跳转到BBS.jsp
		//response.sendRedirect("./Y_BBS/BBS.jsp");
		request.getRequestDispatcher("Y_BBS/BBS.jsp").forward(request, response);
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
