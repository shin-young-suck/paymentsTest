package com.simple.boottest.categoryy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.boottest.categoryy.cateRepository;
import com.simple.boottest.categoryy.cateVo;

@Controller
@RequestMapping("/cate")
public class cateController {
	

		@Autowired
		cateRepository cr;
		@GetMapping("list.do")
		public String list(Model model) {
			Iterable<cateVo> cateList=cr.findAll();
			model.addAttribute("cateList",cateList);
			return "/cate/list";
		}
	

}
