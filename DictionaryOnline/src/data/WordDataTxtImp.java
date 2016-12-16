package data;

import java.lang.reflect.Array;
import java.util.Iterator;

import dataservice.WordDataService;
import po.WordInfo;
import web.Search_Baidu;
import web.Search_Bing;
import web.Search_Youdao;

public class WordDataTxtImp extends WordDataService{
	
	public Iterator<String> readDictionary(){
		return WORD_TIRE.prefixSearchWord("a").iterator();
	}


	@Override
	public Iterator<String> lenovo(String word) {
		return WORD_TIRE.prefixSearchWord(word).iterator();
	}
	@Override
	public String description(String word){
		return null;//WORD_TIRE.getDescription(word);
	}
	
	public WordInfo query(String word) {
		return WORD_TIRE.getQuery(word);
	}

	public Iterator<String> lenovo_list(String word) {
		return WORK_BK.query(word, RADIUS).iterator();
	}
	
	public WordInfo baidu_trans(String word){
		return Search_Baidu.lookUp(word); 
	};
	public WordInfo youdao_trans(String word){
		return Search_Youdao.lookUp(word); 
	};
	public WordInfo ICIBA_trans(String word){
		return Search_Bing.lookUp(word); 
	};

}
