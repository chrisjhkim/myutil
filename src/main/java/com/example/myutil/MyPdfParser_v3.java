package com.example.myutil;


//import com.example.myutil.pdf.ParsedData;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.pdfbox.Loader;
//import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//
//import java.io.IOException;


//@Slf4j
public class MyPdfParser_v3 {
//
//
//	public static ParsedData parseFrom(String filePath) {
//		try {
//			PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(filePath));
//
//			PDFTextStripper pdfTextStripper = new PDFTextStripper();
//			String parsedString = pdfTextStripper.getText(document);
//
////			System.out.println("pdfText = " + pdfText);
//			String[] lines = parsedString.split("\r\n");
//			for (int i = 0; i < lines.length; i++) {
//				log.debug("{}. {}", i, lines[i]);
//			}
//			return ParsedData.builder()
//					.docNumber(lines[21])
//					.bizName(lines[22])
//					.bizNumber(lines[23])
//					.repName(lines[24])
//					.repBirth(lines[25].split("-")[0])
//					.bizAddress(lines[26])
//					.bizStartDate(lines[27])
//					.bizRegDate(lines[28])
//					.bizType(lines[37])
//					.bizSector(lines[38])
//					.build();
//
//
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
////	public static ParsedData parseFrom(byte[] fileByte) {
////
////
////		PDDocument document = PDDocument.load(new File("example.pdf"));
////
////		// PDF의 모든 페이지에서 텍스트를 추출합니다.
////		PDFTextStripper pdfTextStripper = new PDFTextStripper();
////		String pdfText = pdfTextStripper.getText(document);
////
////		// 텍스트를 출력합니다.
////		System.out.println(pdfText);
////
////		try {
////			PDFStreamParser pdfStreamParser = new PDFStreamParser(fileByte);
////			List<Object> parsedList = pdfStreamParser.parse();
////
////			for (int i = 0; i < parsedList.size(); i++) {
////				log.info("{}. {} \t {}", i,parsedList.get(i).getClass(),  parsedList.get(i));
////			}
////
////
////			return new ParsedData();
////
////		} catch (IOException e) {
////			e.printStackTrace();
////			return null;
////		}
//
////
////
////		try {
////			PDDocument doc = getPdDocument(fileByte);
////			String parsedString = parseTextFromDocument(doc);
//////			log.debug("parsedString = {}" , parsedString);
////			String[] lines = parsedString.split("\r\n");
////			for (int i = 0; i < lines.length; i++) {
////				log.debug("{}. {}", i, lines[i]);
////			}
////			return ParsedData.builder()
////					.docNumber(lines[21])
////					.bizName(lines[22])
////					.bizNumber(lines[23])
////					.repName(lines[24])
////					.repBirth(lines[25].split("-")[0])
////					.bizAddress(lines[26])
////					.bizStartDate(lines[27])
////					.bizRegDate(lines[28])
////					.bizType(lines[37])
////					.bizSector(lines[38])
////					.build();
////		} catch (IOException e) {
////			e.printStackTrace();
////			return null;
////		}
////	}
//
//	private static String parseTextFromDocument(PDDocument doc) throws IOException {
//		return new PDFTextStripper().getText(doc);
//	}
//
//	private static PDDocument getPdDocument(byte[] fileByte) throws IOException {
//
////		InputStream targetStream = new ByteArrayInputStream(fileByte);
////		return PDDocument.load(targetStream);
//		return null;
//	}
//

}
