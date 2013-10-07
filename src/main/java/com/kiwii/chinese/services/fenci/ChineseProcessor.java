package com.kiwii.chinese.services.fenci;

import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;


public class ChineseProcessor {

	public static void main(String[] args) throws IOException {
		/*
		String[] res = StringService.kMismatch("今天我们来看看当今世界上有那些名人", "今天", 1);
		String[] res2 = StringService.kMismatch("今天我们来看看当今世界上有那些名人", "天今", 1);
		for(String s : res){
			System.out.println(s);
		}
		for(String s : res2){
			System.out.println(s);
		}
		*/
		IKSegmenter ik = new IKSegmenter(new StringReader("今天我们来看看当今世界上有那些名人"),true);
		Lexeme ci = null;
		while((ci=ik.next())!=null){
			System.out.println(ci.getLexemeText());
		}
		
	}
}
