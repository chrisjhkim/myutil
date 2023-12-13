package com.example.myutil.pdf;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParsedData {

	private String docNumber;
	private String taxType;
	private String bizName;
	private String bizNumber;
	private String repName;
	private String repBirth;
	private String bizAddress;
	private String bizStartDate;
	private String bizRegDate;
	private String bizType;
	private String bizSector;

}
