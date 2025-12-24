package com.talhakoc.libraryproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.talhakoc.libraryproject.dto.AddMemberDto;
import com.talhakoc.libraryproject.dto.MemberListDto;
import com.talhakoc.libraryproject.model.Member;

import com.talhakoc.libraryproject.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	// ---------------------------------------------------------
	// 1) ÜYE EKLE (DTO → Entity mapping)
	// ---------------------------------------------------------
	public void addMember(AddMemberDto dto) {

		Member member = new Member();
		member.setMemberName(dto.getMemberName());

		memberRepository.save(member);
	}

	// ---------------------------------------------------------
	// 2) TÜM ÜYELERİ LİSTELE (Entity → DTO mapping)
	// ---------------------------------------------------------

	public List<MemberListDto> listMembers() {
		return memberRepository.findAll().stream().map(m -> new MemberListDto(m.getMemberId(), m.getMemberName()))
				.collect(Collectors.toList());
	}
}