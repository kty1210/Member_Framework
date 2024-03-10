package com.study.erum.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.erum.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
	
	//MyBatis 연동 DB 연산
	private final SqlSessionTemplate sql;

	public int save(MemberDTO memberDTO) {
	    System.out.println("memberDTO = " + memberDTO);
	    return sql.insert("Member.save", memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) {
	    return sql.selectOne("Member.login", memberDTO);
	}

	public List<MemberDTO> findAll() {
	    return sql.selectList("Member.findAll");
	  }

	public MemberDTO findById(Long id) {
	    return sql.selectOne("Member.findById", id);
	  }
}