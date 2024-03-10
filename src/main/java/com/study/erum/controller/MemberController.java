package com.study.erum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.erum.dto.MemberDTO;
import com.study.erum.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
  private final MemberService memberService;

  @GetMapping("/save")
  public String saveForm(){
    return "save";
  }
  
  @PostMapping("/save")
  public String save(@ModelAttribute MemberDTO memberDTO){
    int saveResult = memberService.save(memberDTO);
    if(saveResult > 0){
      return "login";
    }else{
      return "save";
    }
  }
  
  @GetMapping("/login")
  public String loginForm() {
	return "login";  
  }
  	
  
  @PostMapping("/login")
  //@ModelAttribute는 전송된 데이터를 객체로 변환해서 매개변수로 사용할수있게 만들어줌
  //HttpSession은 Session역할
  public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
    boolean loginResult = memberService.login(memberDTO);
    if(loginResult){
      session.setAttribute("loginEmail", memberDTO.getMemberEmail());
      return "main";
    }else{
      return "login";
    }
  }
  
}