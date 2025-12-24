package com.talhakoc.libraryproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talhakoc.libraryproject.dto.AddMemberDto;
import com.talhakoc.libraryproject.dto.MemberListDto;
import com.talhakoc.libraryproject.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	// ---------------------------------------------------------
	// 1) ÜYE EKLE
	// ---------------------------------------------------------
	@PostMapping
	public String addMember(@RequestBody AddMemberDto dto) {
		memberService.addMember(dto);
		return "Üye başarıyla eklendi.";
	}

	// ---------------------------------------------------------
	// 2) TÜM ÜYELERİ LİSTELE
	// ---------------------------------------------------------
	@GetMapping
	public List<MemberListDto> listMembers() {
		return memberService.listMembers();
	}
}
