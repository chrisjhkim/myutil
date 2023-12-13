package com.example.myutil.log;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
public class LogFile {

	List<LogLine> logLines;

	public static LogFile concat(LogFile file1, LogFile file2) {
		List<LogLine> lines = new ArrayList<>();
		lines.addAll(file1.getLogLines());
		lines.addAll(file2.getLogLines());
		return new LogFile(lines);
	}
}
