package com.jkx.yang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;

import com.jkx.yang.bean.XunleiInfo;
import com.jkx.yang.dao.XunleiDao;

public class Xunlei_Info extends HttpServlet {

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
		//HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		XunleiDao xunleiDao=new XunleiDao();
		ArrayList<XunleiInfo> list=new  ArrayList<XunleiInfo>();//迅雷资源列表
		JSONArray jsonArray;//ArrayList转换json
		//获取action
		try{
			String actions_add=request.getParameter("actions_add");
			try{
				String actions_js=request.getParameter("action");
				actions_js=new String(actions_js.getBytes("iso-8859-1"),"utf-8");
				System.out.println("actions_js="+actions_js);
				System.out.println("*************************************************************");
				if(actions_js.equals("getall")){
					 list=xunleiDao.QureyAllXunlei();
				}else if(actions_js.equals("lookClick")){
					String titles_js=request.getParameter("titles_js");
					titles_js=new String(titles_js.getBytes("iso-8859-1"),"utf-8");
					System.out.println("titles_js="+titles_js);
					System.out.println("*************************************************************");
					 list=xunleiDao.QureyXunleiByName(titles_js);
				}
				
			}catch(Exception e){
				System.out.println("js获取的actions获取为空");
			}
			if(actions_add.equals("addXunlei")){//判断action
				String titles=request.getParameter("titles");
				String contents=request.getParameter("contents");
				xunleiDao.InsertXunlei(titles, contents);
				response.sendRedirect("Y_ZYW/ZYW.jsp");//从服务器跳转，使变量只有一次活性
			}
		}catch(Exception e){
			System.out.println("actions获取为空");
		}
		
		//从数据库获取资源放到json
		
		
		
		 jsonArray=JSONArray.fromObject(list);//list转换为json
		 //将获取列表放到json输出给js
		 out.print(jsonArray);
		
		 
		out.flush();
		out.close();
	}

}
