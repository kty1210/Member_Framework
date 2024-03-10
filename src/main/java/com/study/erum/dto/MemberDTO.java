package com.study.erum.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

//DTO 변수와 save.jsp에 있는 name이 반드시 일치해야 @ModelAttribue를 사용 가능.
public class MemberDTO {
  private Long id;
  private String memberEmail;
  private String memberPassword;
  private String memberName;
  private int memberAge;
  private String memberMobile;
}