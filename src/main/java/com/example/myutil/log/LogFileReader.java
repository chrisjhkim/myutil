package com.example.myutil.log;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LogFileReader {

	private final String logTimePattern;
	private final DateTimeFormatter formatter;

	public LogFileReader(String logTimePattern) {
		this.logTimePattern = logTimePattern;
		this.formatter = DateTimeFormatter.ofPattern(logTimePattern);
	}

	public LogFile readLogFile(String filePath){
		File file = new File(filePath);

		try (FileReader fileReader = new FileReader(file);
		     BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			// 파일이 존재하는지 확인
			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				throw new IllegalArgumentException("no such file " +filePath);
			}

			String line;
			// 파일의 모든 내용을 한 줄씩 읽어 출력
			List<LogLine> lines = new ArrayList<>();

			LogLineBuilder lineBuilder = new LogLineBuilder();
			while ((line = bufferedReader.readLine()) != null) {

				if ( isStart(line) ) {
					if ( lineBuilder.hasText() )
						lines.add(lineBuilder.build());
					lineBuilder = new LogLineBuilder();
					lineBuilder.startWithTime(getTime(line));
				}
				lineBuilder.append(getText(line));
				lineBuilder.append("\n");

			}

			return new LogFile(lines);
		} catch (IOException e) {
			System.out.println("파일을 읽어오는 도중 오류가 발생했습니다: " + e.getMessage());
			throw new IllegalStateException(e);
		}
	}

	private String getText(String line) {
		if ( isStart(line)){
			return line.substring(this.logTimePattern.length());
		}else{
			return line;
		}
	}

	private LocalDateTime getTime(String line) {
		String testTime = line.substring(0, this.logTimePattern.length());
		return LocalDateTime.parse(testTime, this.formatter);
	}

	private boolean isStart(String line) {
		if ( line.length() < this.logTimePattern.length() )
			return false;

		try {
			String testTime = line.substring(0, this.logTimePattern.length());
			LocalDateTime.parse(testTime, this.formatter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
