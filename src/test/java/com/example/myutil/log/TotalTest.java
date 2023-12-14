package com.example.myutil.log;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로그 파일 관련 통합 테스트")
public class TotalTest {

	private static final String PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";

	@Test
	void test(){
		saveFile(
				"20231213.log",
				"1.log",
				"2.log",
				"3.log",
				"4.log"
		);

	}

	private void saveFile(String destFileName, String ... fileNames){
		if ( fileNames.length < 1 ) {
			throw new IllegalArgumentException("if single file, why concat file?");
		}
		LogFile result = new LogFileReader(PATTERN).readLogFile(fileNames[0]);

		for ( int i = 1 ; i < fileNames.length ; i ++ ) {
			LogFile fileToAdd = new LogFileReader(PATTERN).readLogFile(fileNames[i]);
			result = LogConcatUtil.concatFiles(result, fileToAdd);
		}
		LogFileWriter.saveAsFile(result, destFileName);

	}
}
