package com.example.myutil.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadUtil {

	public static byte[] getFile(String filePath) {

		try {
			// 파일 경로를 Path 객체로 변환
			Path path = Paths.get(filePath);

			// 파일을 byte 배열로 읽어옴
			byte[] fileData = Files.readAllBytes(path);

			// 파일 데이터를 사용하거나 처리할 수 있음
			// 예를 들어, 파일을 다른 곳에 저장하거나 네트워크로 전송할 수 있음

			// 파일 데이터 길이 출력
			System.out.println("파일 데이터 길이: " + fileData.length + " 바이트");
			return fileData;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static List<String> readFileAsList(String filePath) {

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
			List<String> result = new ArrayList<>();
			while ((line = bufferedReader.readLine()) != null) {
//				System.out.println(line);
				result.add(line);
			}
			return result;
		} catch (IOException e) {
			System.out.println("파일을 읽어오는 도중 오류가 발생했습니다: " + e.getMessage());
			throw new IllegalStateException(e);
		}
	}

}
