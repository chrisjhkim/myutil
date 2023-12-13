package com.example.myutil.log;

import java.time.LocalDateTime;


public class LogLineBuilder {
	private StringBuilder sb = new StringBuilder();
	private LocalDateTime time;




	public LogLineBuilder append(Object object){
		sb.append(object);
		return this;
	}

	public LogLine build(){
		return new LogLine(this.time, this.sb.toString());
	}

	public void startWithTime(LocalDateTime time) {
		this.time = time;
	}

	public boolean hasText() {
		return this.sb.length() != 0;
	}
}
