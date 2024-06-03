package com.simple.boottest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.simple.boottest.controller.Repository;
import com.simple.boottest.controller.Vo;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mem")
public class memController {
	
	@Autowired
	Repository mr;
	
	
	@GetMapping("/admin")
	public String list(Model model) {
		Iterable<Vo> memList=mr.findAllByOrderByIdAsc();
		model.addAttribute("memList",memList);
		return "mem/list";
	}
	@GetMapping(value="/login")
	public String login() {
		return "/mem/login";
	}
	
	@PostMapping("/login")
//	톰캣서버에 필요한 객체가 있다면 매개변수로 작성하면 사용가능
	public String login(@RequestParam(value = "id") String id ,@RequestParam(value = "pw") String pw, HttpSession session) { // 오버로딩 
		Vo memVo=mr.findByIdAndPw(id, pw);

		if(memVo!=null) {
		session.setAttribute("memVo", memVo);

		return "redirect:/"; // response.sendRedirect("/")			
		}else {
			return "redirect:/mem/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/signup")
	public ModelAndView signup(ModelAndView model) { // 맨위 public String login이랑 비교하면됨.
		model.setViewName("/mem/signup");
		return model;
	}
	
	@PostMapping("/signup")
	public String singup(Vo memVo, HttpSession session) {
		boolean insert=false;
		try {
			Optional<Vo> memOption=mr.findById(memVo.getId()); // 기본으로 제공되는 함수
			if(memOption.isEmpty()) { // 있는지 검사해서 없을때만 저장
				Vo insertMem=mr.save(memVo);
				System.out.println(insertMem);
				if(insertMem!=null) {
					insert=true;
				}else {
					session.setAttribute("msg", "존재하는 아이디입니다.");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("msg", "Email 또는 Phone이 이미 존재합니다.");
		}
		if(insert) {
			return "redirect:/";			
		}else {
			return "redirect:/mem/signup";
		}
	}
	
	@GetMapping("/ajax/findId/{id}")
	public @ResponseBody Optional<Vo> findId(@PathVariable String id) {
		return mr.findById(id);
	}
	@GetMapping("/ajax/findEmail/{email}")
	public @ResponseBody Optional<Vo> findEmail(@PathVariable String email){
		return mr.findByEmail(email);
	}
	@GetMapping("/ajax/findPhone/{phone}")
	public @ResponseBody Optional<Vo> findByPhone(@PathVariable String phone){
		return mr.findByPhone(phone);
	}
}
