package com.study.erum.repository;

import org.springframework.stereotype.Repository;

import com.study.erum.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	public int save(MemberDTO memberDTO) {
	    System.out.println("memberDTO = " + memberDTO);
	    return 0;
	  }
}