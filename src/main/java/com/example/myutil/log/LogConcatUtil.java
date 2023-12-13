package com.example.myutil.log;

import com.example.myutil.file.FileReadUtil;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogConcatUtil {




	public static void concatFiles(String... filePaths){
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";






	}

	public static LogFile concatFiles(LogFile file1, LogFile file2){
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		List<LogLine> lines1 = file1.getLogLines();
		LogFile result = LogFile.concat(file1, file2);
		Collections.sort(result.getLogLines());

//		result.getLogLines().stream()
//				.map(logLine -> logLine.toReadableString(formatter))
//				.forEach(System.out::print);

		return result;
	}

}
