package com.example.myutil.log;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class LogFileWriterTest {


	@Test
	void test(){
		String pattern = "yyyy-MM-dd HH:mm:ss,SSS";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		LogFile logFile1 = new LogFileReader(pattern).readLogFile("1.log");
		LogFile logFile2 = new LogFileReader(pattern).readLogFile("2.log");
		LogFile logFile3 = new LogFileReader(pattern).readLogFile("3.log");
		LogFile logFile4 = new LogFileReader(pattern).readLogFile("4.log");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==============================");
		LogFile resultTemp1 = LogConcatUtil.concatFiles(logFile1, logFile2);
		LogFile resultTemp2 = LogConcatUtil.concatFiles(logFile3, logFile4);
		LogFile result = LogConcatUtil.concatFiles(resultTemp1, resultTemp2);

		System.out.println("==============================");

		LogFileWriter.saveAsFile(result, "result_1213_3.log");
	}
}