package com.study.erum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//컨트롤러 등록
@Controller
public class HomeController {
	
	//HTTP GET 요청 처리 메소드
	@GetMapping("/")
	public String index(){
		return "index";
	}
}
