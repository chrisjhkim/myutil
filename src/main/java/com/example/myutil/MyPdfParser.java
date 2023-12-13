package com.example.myutil;


import com.example.myutil.pdf.ParsedData;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * implementation 'org.apache.pdfbox:pdfbox:1.8.17'
 * pdfbox 2버전대 , 3버전대 는 호환이 되지 않는다.
 */
@Slf4j
public class MyPdfParser {

	public static ParsedData parseFrom(byte[] fileByte) throws IOException {
		PDDocument doc = getPdDocument(fileByte);
		String parsedString = parseTextFromDocument(doc);
//			log.trace("parsedString = {}" , parsedString);
		String[] lines = parsedString.split("\r\n");
		for (int i = 0; i < lines.length; i++) {
			log.debug("{}. {}", i, lines[i]);
		}
		return ParsedData.builder()
				.taxType(getTaxType(lines[20]))
				.docNumber(lines[20].split("\\(")[0].trim())
				.bizName(lines[21])
				.bizNumber(lines[22])
				.repName(lines[23])
				.repBirth(lines[24].split("-")[0])
				.bizAddress(lines[25])
				.bizStartDate(lines[26])
				.bizRegDate(lines[27])
				.bizType(lines[36])
				.bizSector(lines[37])
				.build();


	}

	private static String getTaxType(String input) {
		int startIndex = input.indexOf("(");
		int endIndex = input.indexOf(")");

		if (startIndex != -1 && endIndex != -1) {
			return input.substring(startIndex + 1, endIndex).trim();
		} else {
			throw new IllegalStateException();
		}
	}

	private static String parseTextFromDocument(PDDocument doc) throws IOException {
		return new PDFTextStripper()
				.getText(doc);
	}

	private static PDDocument getPdDocument(byte[] fileByte) throws IOException {
		InputStream targetStream = new ByteArrayInputStream(fileByte);
		return PDDocument.load(targetStream);
	}
}
