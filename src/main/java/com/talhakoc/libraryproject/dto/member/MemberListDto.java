package com.talhakoc.libraryproject.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberListDto {
	private Integer memberId;
	private String memberName;
}
