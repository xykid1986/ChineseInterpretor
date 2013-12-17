package com.kiwii.chinese.services.fenci;

import java.io.IOException;

public interface ChineseAnalyzer {
	
	String[] tokenize(String input) throws IOException;
}
