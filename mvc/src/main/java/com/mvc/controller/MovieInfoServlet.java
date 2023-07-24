package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.MovieInfoRepository;


public class MovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieInfoRepository miRepo = new MovieInfoRepository();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/";
		if("list".equals(uri)) {
			path += "movie-info/list.jsp";
			request.setAttribute("movieInfoList", miRepo.selectMovieInfoList());			
		}else if("view".equals(uri)) {
			path+= "movie-info/view.jsp";
			String miNum = request.getParameter("miNum");
			Map<String,String> movieInfo = miRepo.selectMovieInfo(miNum);
			request.setAttribute("movieInfo", movieInfo);
		}else if("insert".equals(uri)) {
			path += "movie-info/insert.jsp";
		}else if("update".equals(uri)) {
			path += "movie-info/update.jsp";
			String miNum = request.getParameter("miNum");
			Map<String,String> movieInfo = miRepo.selectMovieInfo(miNum);
			request.setAttribute("movieInfo", movieInfo);
		}else if("delete".equals(uri)) {
			path += "movie-info/delete.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String encoding = request.getCharacterEncoding();
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/common/msg.jsp";
		if("insert".equals(uri)) {
			Map<String,String> param = new HashMap<>();
			param.put("miTitle", request.getParameter("miTitle"));
			param.put("miDesc", request.getParameter("miDesc"));
			param.put("miGenre", request.getParameter("miGenre"));
			param.put("miCredat", request.getParameter("miCredat"));
			param.put("miCnt", request.getParameter("miCnt"));
			int result = miRepo.InsertMovieInfo(param);
			request.setAttribute("msg", "실패하였습니다.");
			request.setAttribute("uri", "/movie-info/insert");
			if(result == 1) {
				request.setAttribute("msg", "성공하였습니다.");
				request.setAttribute("uri", "/movie-info/list");
				
			}
			}else if ("update".equals(uri)) {
		        Map<String, String> param = new HashMap<>();
		        param.put("miTitle", request.getParameter("miTitle"));
		        param.put("miDesc", request.getParameter("miDesc"));
		        param.put("miGenre", request.getParameter("miGenre"));
		        param.put("miCredat", request.getParameter("miCredat"));
		        param.put("miCnt", request.getParameter("miCnt"));
		        param.put("miNum", request.getParameter("miNum"));
		        
		        int result = miRepo.updateMovieInfo(param);
		        request.setAttribute("msg", "회원수정이 실패하였습니다.");
		        request.setAttribute("uri", "/movie-info/update?miNum=" + request.getParameter("miNum"));
		        if (result == 1) {
		            request.setAttribute("msg", "회원수정이 성공하였습니다.");
		            request.setAttribute("uri", "/movie-info/list");
		  
		        
		        }
		}else if("delete".equals(uri)) {
			String miNum = request.getParameter("miNum");
			int result = miRepo.deleteMovieInfo(miNum);
			request.setAttribute("msg", "회원삭제가 실패하였습니다.");
			request.setAttribute("uri", "/movie-info/view?miNum=" + request.getParameter("miNum"));
			if(result==1) {
				request.setAttribute("msg", "회원삭제가 성공하였습니다.");
				request.setAttribute("uri", "/movie-info/list");
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}
		}
	}
}


