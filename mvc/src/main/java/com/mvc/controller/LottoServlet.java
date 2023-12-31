package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> lotto = new ArrayList<>();

	public LottoServlet() {
		Random r = new Random();
		while(lotto.size() < 6) {
			String rNum = (r.nextInt(45) + 1) + "";
			if (!lotto.contains(rNum)) {
				lotto.add(rNum);
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);
		String path = "/WEB-INF/views/";
		if ("lotto".equals(uri)) {
			path += "lotto/lotto.jsp";
		} else if ("comp".equals(uri)) {
			String[] nums = request.getParameterValues("num");
			int correctCnt = 0;
			for(String num:nums) {
				if(lotto.contains(nums)) {
					correctCnt++;
				}
			}

			request.setAttribute("correctCnt", correctCnt);
			path += "lotto/result.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
