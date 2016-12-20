package data;

import java.io.IOException;
import java.util.Iterator;

import Client.Client;
import dataservice.WordDataService;
import po.ChooseInfo;
import po.UserInfo;
//import po.myuserInfo;
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
		return myuserInfo;
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
		// TODO �Զ����ɵķ������
		choose.addLikeBaidu();
		System.out.println(choose.getLikeBaidu());
	}


	@Override
	public void addBingLike() {
		// TODO �Զ����ɵķ������
		choose.addLikeBing();
	}


	@Override
	public void addYoudaoLike() {
		// TODO �Զ����ɵķ������
		choose.addLikeYoudao();
	};
	
	public void DisplayUI(){
		//����
		if(choose.getLikeBaidu()!=0||choose.getLikeBing()!=0||choose.getLikeYoudao()!=0){
			if(choose.getLikeBaidu()>choose.getLikeBing()){
			  if(choose.getLikeBaidu()>choose.getLikeYoudao()){
				  choose.setBaidu_rank(1);
				  if(choose.getLikeBing()>choose.getLikeYoudao()){
					  choose.setBing_rank(2);
					  choose.setYoudao_rank(3);
				  }
				  else{
					  choose.setBing_rank(3);
					  choose.setYoudao_rank(2);
				  }
			  }
			  else {
				  choose.setBaidu_rank(2);
				  choose.setYoudao_rank(1);
				  choose.setBing_rank(3);
			  }
		}
		else{
			if(choose.getLikeBaidu()>choose.getLikeYoudao()){
				choose.setBaidu_rank(2);
				choose.setBing_rank(1);
				choose.setYoudao_rank(3);
			}
			else{
				choose.setBaidu_rank(3);
				if(choose.getLikeBing()>choose.getLikeYoudao()){
					choose.setBing_rank(1);
					choose.setYoudao_rank(2);
				}
				else{
					choose.setBing_rank(2);
					choose.setYoudao_rank(1);
				}
			}
		}
		}
		
		//������ʾ
		UIFactory.getWordContentInstance().setVisible(choose.getBaidu());
		UIFactory.getIcon_Like_Baidu().setVisible(choose.getBaidu());
		UIFactory.getIcon_Baidu().setVisible(choose.getBaidu());
		
		UIFactory.getWordContent_Youdao().setVisible(choose.getYoudao());
		UIFactory.getIcon_Like_Youdao().setVisible(choose.getYoudao());
		UIFactory.getIcon_Youdao().setVisible(choose.getYoudao());
		
		UIFactory.getWordContent_ICIBA().setVisible(choose.getBing());
		UIFactory.getIcon_Like_ICIBA().setVisible(choose.getBing());
		UIFactory.getIcon_ICIBA().setVisible(choose.getBing());
		
		System.out.println(choose.getBaidu_rank()+" "+choose.getBing_rank()+"  "+choose.getYoudao_rank());
		UIFactory.getIcon_Baidu().updateConfig();
		UIFactory.getIcon_ICIBA().updateConfig();
		UIFactory.getIcon_Youdao().updateConfig();
	}

	@Override
	public void writeToServer() {
		// TODO �Զ����ɵķ������
        try {
        	client = new Client();
        	client.getOutputToServer().writeObject(choose);
			boolean a = client.getInputFromServer().readBoolean();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void shareCard(){
		wordCardInfo.setSendUser(myuserInfo.getUsername());
		String receiveuser="";
		wordCardInfo.setReceiveUser(receiveuser);
		wordCardInfo.setChooseFlag(0);
		try {
			client.getOutputToServer().writeObject(wordCardInfo);
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
     //   String message="";
		try {
			Boolean flag = client.getInputFromServer().readBoolean();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	};
	
	public  void setCountLike(int baidu,int youdao,int bing){
		choose.setLikeBaidu(baidu);
		choose.setLikeBing(bing);
		choose.setLikeYoudao(youdao);
	};

//	public void getUser(){
//		myuserInfo=LogIn.getUser();
//	};
	
	public void checkmessage(){
//    	getUser();
		System.out.println(myuserInfo.getUsername());
    	wordCardInfo.setReceiveUser(myuserInfo.getUsername());
    	wordCardInfo.setChooseFlag(1);
       	client = new Client();
        try {
			client.getOutputToServer().writeObject(wordCardInfo);
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
        String message="";
		try {
			message = client.getInputFromServer().readUTF();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
//        flag = a;
        if(message!=""){
        	String[] getmeaasge=message.split("$");
        	wordCardInfo.setSendUser(getmeaasge[0]);
        	wordCardInfo.setReceiveUser(getmeaasge[1]);
        	//myuserInfo.wordCardInfo
        	int i=2;
        	while(getmeaasge[i]!=null){
        	String temp=getmeaasge[i];
        	i++;
        	if(temp=="baidu"){
        		wordCardInfo.setBaiduTrans(getmeaasge[i]);	
        	}
        	else if(temp=="youdao"){
        		wordCardInfo.setYoudaoTrans(getmeaasge[i]);
        	}
        	else {
				wordCardInfo.setBingTrans(getmeaasge[i]);
			}
        	i++;
        	}
        }
	};
	
	public int getBaiduFromServer(){
		int result = 0;
		try {
        	client = new Client();
        	choose.setClientFlag(2);
        	client.getOutputToServer().writeObject(choose);
        	result = client.getInputFromServer().readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int getYoudaoFromServer(){
		int result = 0;
		try {
        	client = new Client();
        	choose.setClientFlag(3);
        	client.getOutputToServer().writeObject(choose);
        	result = client.getInputFromServer().readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int getBingFromServer(){
		int result = 0;
		try {
        	client = new Client();
        	choose.setClientFlag(4);
        	client.getOutputToServer().writeObject(choose);
        	result = client.getInputFromServer().readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}
