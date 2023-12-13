package com.example.myutil.log;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class LogConcatUtilTest {


	@Test
	void test(){
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);


		LogFile logFile1 = new LogFileReader(pattern).readLogFile("abc.txt");
		LogFile logFile2 = new LogFileReader(pattern).readLogFile("bbbb.txt");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==============================");
		LogConcatUtil.concatFiles(logFile1, logFile2);
		System.out.println("==============================");

	}
}