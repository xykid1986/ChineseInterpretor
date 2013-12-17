package com.kiwii.chinese.services.search;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("vocabularySearcher")
public class VocabularySearcherImpl implements VocabularySearcher {
	
	@Autowired
	private RestTemplate temp;

	@Override
	@SuppressWarnings({"unchecked","rawtypes"})
	public List<ChineseWord> search(String input){
		String url = "http://localhost:9200/dictionary/chinese/_search";
		String query = "{\"query\":{\"match\":{\"simplified\":\""+input+"\"}},\"size\":10}";
		
		HttpHeaders headers = new HttpHeaders();
		Map<String, String> vars = new HashMap<String,String>();
		vars.put("charset", "utf-8");//must set charset for chinese words in json body
		headers.setContentType(new MediaType("application","json",vars));
		HttpEntity request= new HttpEntity(query,headers);
		
		ResponseEntity<ElasticSearchResult> res = temp.exchange(url,HttpMethod.POST,request,ElasticSearchResult.class);
		
		List<ChineseWord> result = new ArrayList<ChineseWord>();
		for(Hit hit: (List<Hit>)res.getBody().getAllHits()){
			result.add(buildWord((Map<String, Object>) hit.get_source()));
		}
		return result;
	}
	
	//as each chinese word is returned as a map, need to build the object based on the map.
	@SuppressWarnings("unchecked")
	private ChineseWord buildWord(Map<String, Object> map){
		ChineseWord word = new ChineseWord();
		word.setId((String) map.get("id"));
		word.setPronouncation((String) map.get("pronouncation"));
		word.setSimplified((String) map.get("simplified"));
		word.setTraditional((String) map.get("traditional"));
		word.setDescriptions((List<String>) map.get("descriptions"));
		return word;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/app-context.xml");
		VocabularySearcher s = ctx.getBean("vocabularySearcher", VocabularySearcher.class);
		long start = System.currentTimeMillis();
		//s.search("今天，爸爸和我一起到大海边玩");
		for(ChineseWord word : s.search("今天")){
			System.out.println(word);
		}
		System.out.println("Search time: "+(System.currentTimeMillis()-start)+"ms");
	}

	@Override
	public boolean exactHit(String input) {
		String url = "http://localhost:9200/dictionary/chinese/_search";
		String query = "{\"query\":{\"match_phrase\":{\"simplified\":\""+input+"\"}},\"size\":10}";
		
		HttpHeaders headers = new HttpHeaders();
		Map<String, String> vars = new HashMap<String,String>();
		vars.put("charset", "utf-8");//must set charset for chinese words in json body
		headers.setContentType(new MediaType("application","json",vars));
		HttpEntity request= new HttpEntity(query,headers);
		
		ResponseEntity<ElasticSearchResult> res = temp.exchange(url,HttpMethod.POST,request,ElasticSearchResult.class);
		
		if(res.getBody().getAllHits().size()>0){
			return true;
		}
		return false;
	}
	
}
