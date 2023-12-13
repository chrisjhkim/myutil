package com.example.myutil.log;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
public class LogLine implements Comparable<LogLine> {

	private LocalDateTime time;
	private String text;



	public String toReadableString(DateTimeFormatter formatter) {
		return this.time.format(formatter)+ " " + text;

	}


	@Override
	public int compareTo(LogLine other) {
		return this.time.compareTo(other.time);
	}
}
