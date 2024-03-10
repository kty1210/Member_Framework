package com.study.erum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  
  
  @GetMapping("/")
  public String findAll(Model model){
    List<MemberDTO> memberDTOList = memberService.findAll();
    model.addAttribute("memberList", memberDTOList);
    return "list";
  }
  
  @GetMapping
  public String findById(@RequestParam("id") Long id, Model model){
    MemberDTO memberDTO = memberService.findById(id);
    model.addAttribute("member", memberDTO);
    return "detail";
  }
  
  
  @GetMapping("/delete")
  public String delete(@RequestParam("id") Long id){
    memberService.delete(id);
    return "redirect:/member/";
  }
  
  @GetMapping("/update")
  public String updateFrom(HttpSession session, Model model){
    //세션에 저장된 나의 이메일 가져오기
    String loginEmail = (String) session.getAttribute("loginEmail");
    MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
    model.addAttribute("member", memberDTO);
    return "update";
  }
  
  @PostMapping("/update")
  public String update(@ModelAttribute MemberDTO memberDTO){
    boolean result = memberService.update(memberDTO);
    if(result){
      return "redirect:/member?id=" + memberDTO.getId();
    }else{
      return "index";
    }
  }
}