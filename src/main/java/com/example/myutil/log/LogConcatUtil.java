package com.example.myutil.log;

import java.util.Collections;

public class LogConcatUtil {


	public static LogFile concatFiles(LogFile file1, LogFile file2){

		LogFile result = LogFile.concat(file1, file2);
		Collections.sort(result.getLogLines());


		return result;
	}

}
