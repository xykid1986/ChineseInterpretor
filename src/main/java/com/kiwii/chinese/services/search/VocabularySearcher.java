package com.kiwii.chinese.services.search;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface VocabularySearcher {
	/**
	 * Search for vocabularies with high similarity to input string 
	 * @param input
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	List<ChineseWord> search(String input);
	
	boolean exactHit(String input);
}
