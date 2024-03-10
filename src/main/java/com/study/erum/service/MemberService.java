package com.study.erum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.erum.dto.MemberDTO;
import com.study.erum.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  
  public int save(MemberDTO memberDTO) {
	    return memberRepository.save(memberDTO);
	  }

  public boolean login(MemberDTO memberDTO) {
	    MemberDTO loginMember = memberRepository.login(memberDTO);
	    if(loginMember != null){
	      return true;
	    }else{
	      return false;
	    }
	  }

  public List<MemberDTO> findAll() {
	    return memberRepository.findAll();
	}

  public MemberDTO findById(Long id) {
	    return memberRepository.findById(id);
	  }
  
}
