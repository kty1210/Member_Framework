package com.study.erum.repository;

import java.util.List;

import com.study.erum.dto.MemberDTO;

public interface MemberRepository {


	public int save(MemberDTO memberDTO);

	public MemberDTO login(MemberDTO memberDTO);

	public List<MemberDTO> findAll();

	public MemberDTO findById(Long id);

	public void delete(Long id);

	public MemberDTO findByMemberEmail(String loginEmail);

	public int update(MemberDTO memberDTO);
}
