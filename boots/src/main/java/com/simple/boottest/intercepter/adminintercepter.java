package com.simple.boottest.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.simple.boottest.controller.Vo;

@Component
public class adminintercepter implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//로그인이 되고 Grade<2(0,1)인 사람만 들어올 수 있도록 제한 
		HttpSession session=request.getSession();
		Object memVo_obj=session.getAttribute("memVo");
		
		if(memVo_obj!=null && ((Vo)memVo_obj).getGrade()<2 ) {
			return true;			
		}else {
//			session.setAttribute("msg", "해당 페이지 접근 권한이 없습니다.");
			response.sendRedirect("/");
			return false;
		}
	}
	

}
