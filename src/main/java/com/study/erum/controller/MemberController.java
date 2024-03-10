package com.study.erum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.erum.dto.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController {

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
}