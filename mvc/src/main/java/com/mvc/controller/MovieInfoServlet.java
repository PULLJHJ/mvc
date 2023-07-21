package com.mvc.controller;

import java.io.IOException;
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
		String path = "";
		if("/movie-info/list".equals(uri)) {
			List<Map<String,String>> movieInfoList = miRepo.selectMovieInfoList();
			request.setAttribute("movieInfoList", movieInfoList);
			path = "/WEB-INF/views/movie-info/list.jsp";
		}else if("/class-info/view".equals(uri)) {
			List<Map<String,String>> movieInfoList = miRepo.selectMovieInfoList();
			request.setAttribute("movieInfoList", movieInfoList);
			path = "/WEB-INF/views/movie-info/view.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
