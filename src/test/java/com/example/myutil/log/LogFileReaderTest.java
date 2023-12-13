package com.example.myutil.log;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

class LogFileReaderTest {

	@Test
	void testRead()  {

		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);



		LogFile logFile = new LogFileReader(pattern).readLogFile("abc.txt");
		logFile.getLogLines().stream()
				.map(logLine -> logLine.toReadableString(formatter))
				.forEach(System.out::print);


	}
}