package com.talhakoc.libraryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberListDto {
	private Integer memberId;
	private String memberName;
}
