package data;

import java.lang.reflect.Array;
import java.util.Iterator;

import Client.LogIn;
import dataservice.WordDataService;
import mainui.ChooseBox;
import po.ChooseInfo;
import po.UserInfo;
import po.WordInfo;
import util.UIFactory;
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
	
	public UserInfo checkuser(){
		return LogIn.getUser();
	};
	
//	public void choose(){
//		choose=ChooseBox.getChoose();
//	};
	
	public void initLike(ChooseInfo getlike){
		choose.setLikeBaidu(getlike.getLikeBaidu());
		choose.setLikeBing(getlike.getLikeBing());
		choose.setLikeYoudao(getlike.getLikeYoudao());
	}


	@Override
	public void addBaiduLike() {
		// TODO 自动生成的方法存根
		choose.addLikeBaidu();
		System.out.println(choose.getLikeBaidu());
	}


	@Override
	public void addBingLike() {
		// TODO 自动生成的方法存根
		choose.addLikeBing();
	}


	@Override
	public void addYoudaoLike() {
		// TODO 自动生成的方法存根
		choose.addLikeYoudao();
	};
	
	public void DisplayUI(){
		//排序
		if(choose.getLikeBaidu()>choose.getLikeBing()){
			  if(choose.getLikeBaidu()>choose.getLikeYoudao()){
				  
			  }
		}
		
		//设置显示
		UIFactory.getWordContentInstance().setVisible(choose.getBaidu());
		UIFactory.getIcon_Like_Baidu().setVisible(choose.getBaidu());
		UIFactory.getIcon_Baidu().setVisible(choose.getBaidu());
		
		UIFactory.getWordContent_Youdao().setVisible(choose.getYoudao());
		UIFactory.getIcon_Like_Youdao().setVisible(choose.getYoudao());
		UIFactory.getIcon_Youdao().setVisible(choose.getYoudao());
		
		UIFactory.getWordContent_ICIBA().setVisible(choose.getBing());
		UIFactory.getIcon_Like_ICIBA().setVisible(choose.getBing());
		UIFactory.getIcon_ICIBA().setVisible(choose.getBing());
	}


	@Override
	public void setBaiduVisible(int i) {
		// TODO 自动生成的方法存根
		
	}
}
