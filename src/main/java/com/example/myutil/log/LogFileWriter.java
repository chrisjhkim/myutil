package com.example.myutil.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class LogFileWriter {


	public static void saveAsFile(LogFile logFile, String fileName){
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		List<String> lines = logFile.getLogLines().stream()
				.map(logLine -> logLine.toReadableString(formatter))
				.collect(Collectors.toList());

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (String line : lines) {
				writer.write(line);
//				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
