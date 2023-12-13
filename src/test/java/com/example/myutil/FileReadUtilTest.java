package com.example.myutil;

import com.example.myutil.file.FileReadUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class FileReadUtilTest {


	@Test
	void testRead() throws IOException {
		List<String> result = FileReadUtil.readFileAsList("abc.txt");
		System.out.println("result = " + result);

	}
}