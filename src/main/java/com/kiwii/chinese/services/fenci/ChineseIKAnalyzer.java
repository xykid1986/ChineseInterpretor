package com.kiwii.chinese.services.fenci;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

@Service("chineseAnalyzer")
public class ChineseIKAnalyzer implements ChineseAnalyzer {

	@Override
	public String[] tokenize(String input) throws IOException {
		IKSegmenter ik = new IKSegmenter(new StringReader(input),true);
		List<String> result = new ArrayList<String>();
		Lexeme ci = null;
		while((ci=ik.next())!=null){
			result.add(ci.getLexemeText());
		}
		return result.toArray(new String[result.size()]);
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println(Arrays.toString(new ChineseIKAnalyzer().tokenize("被打击的人数高达120人")));
	}

}
