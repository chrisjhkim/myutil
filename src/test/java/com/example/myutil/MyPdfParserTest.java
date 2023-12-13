package com.example.myutil;

import com.example.myutil.pdf.ParsedData;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class MyPdfParserTest {


//	@Test
//	public void parseFile() throws IOException {
//
//		// Test # Given
//		byte[] fileByte = getFile("C:/Users/chris1108/Downloads/testBlob.pdf");
//
//		// Test # When
//		ParsedData parsedData = MyPdfParser.parseFrom(fileByte);
//
//		// Test # Then
//		assertThat(parsedData).isNotNull();
//		BufferedReader br = new BufferedReader(new InputStreamReader(""))
//
//
//		String expectedDocNumber = "5559-979-1288-298";
//		String expectedBizName = "드림스토어";
//		String expectedBizNumber = "748-45-00971";
//		String expectedRepName = "한상욱";
//		String expectedRepBirth = "761121";
//		String expectedBizAddress = "경기도 구리시 갈매순환로 10, 2002동 2201호(갈매동, 갈매더샵나인힐스)";
//		String expectedBizStartDate = "2023년 08월 22일";
//		String expectedBizRegDate = "2023년 08월 23일";
//		String expectedBizType = "도매 및 소매업|도매 및 소매업"; // 업태
//		String expectedBizSector = "전자상거래 소매업|전자상거래 소매 중개업"; // 업종
//
//
//		assertThat(parsedData.getDocNumber()).isEqualTo(expectedDocNumber);
//		assertThat(parsedData.getBizName()).isEqualTo(expectedBizName);
//		assertThat(parsedData.getBizNumber()).isEqualTo(expectedBizNumber);
//		assertThat(parsedData.getRepName()).isEqualTo(expectedRepName);
//		assertThat(parsedData.getRepBirth()).isEqualTo(expectedRepBirth);
//		assertThat(parsedData.getBizAddress()).isEqualTo(expectedBizAddress);
//		assertThat(parsedData.getBizStartDate()).isEqualTo(expectedBizStartDate);
//		assertThat(parsedData.getBizRegDate()).isEqualTo(expectedBizRegDate);
//		assertThat(parsedData.getBizType()).isEqualTo(expectedBizType);
//		assertThat(parsedData.getBizSector()).isEqualTo(expectedBizSector);
//
//
//
//	}

	@Test
	public void testGetFile(){
		byte[] fileInByte = getFile("C:/Users/chris1108/Downloads/testBlob.pdf");
		assertThat(fileInByte).isNotNull();
	}

	private byte[] getFile(String filePath) {

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

}