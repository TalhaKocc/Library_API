package com.talhakoc.libraryproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talhakoc.libraryproject.dto.member.AddMemberDto;
import com.talhakoc.libraryproject.dto.member.MemberListDto;
import com.talhakoc.libraryproject.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public String addMember(@RequestBody AddMemberDto dto) {
		memberService.addMember(dto);
		return "Üye başarıyla eklendi.";
	}

	@GetMapping
	public List<MemberListDto> listMembers() {
		return memberService.listMembers();
	}
}
