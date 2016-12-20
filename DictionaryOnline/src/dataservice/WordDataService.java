package dataservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import Client.Client;
import Client.LogIn;
import data.BKTree;
import data.LevensteinDistance;
import data.MetricSpace;
import data.Trie;
import mainui.ChooseBox;
import po.ChooseInfo;
import po.UserInfo;
import po.WordCardInfo;
import po.WordInfo;


public abstract class  WordDataService{
	
	protected final static Trie WORD_TIRE;
	protected final static BKTree<String> WORK_BK;
	protected final static double RADIUS=3;
//	protected final static 
	public static ChooseInfo choose=new ChooseInfo();
	public static UserInfo myuserInfo;
	protected Client client;
	public static WordCardInfo wordCardInfo=new WordCardInfo();

	/**
	 * The initial of dictionary
	 */
	static {
		MetricSpace<String> ms = new LevensteinDistance();
		WORK_BK = new BKTree<String>(ms);
	    
		WORD_TIRE = new Trie();
		Scanner input = null;
		try {
			input = new Scanner(new File("data/dictionary"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		};
		
		while(input.hasNext()){
			String line=input.nextLine();
			String[] lineArr = line.split("\\t"); 
			String word=lineArr[1];
			String interpretation=lineArr[2];
			for(int i=3;i<lineArr.length;i++){
			interpretation=interpretation+lineArr[i];
			}
			WORD_TIRE.insert(word,interpretation);
			WORK_BK.put(word);
			}
	}
	public abstract WordInfo baidu_trans(String word);
	public abstract WordInfo youdao_trans(String word);
	public abstract WordInfo ICIBA_trans(String word);
	public abstract Iterator<String> lenovo(String word);
	public abstract Iterator<String> readDictionary();
	public abstract Iterator<String> lenovo_list(String word);
	public abstract WordInfo query(String word);
	public abstract String description(String word);
	
//	public abstract void getUser();
	public abstract void initLike(ChooseInfo getlike);
	public abstract UserInfo checkuser();
	public abstract void addBaiduLike();
	public abstract void addBingLike();
	public abstract void writeToServer();
	public abstract void addYoudaoLike();
	public abstract void DisplayUI(); 
	public abstract void shareCard();
	public abstract void setCountLike(int baidu,int youdao,int bing);
	public abstract void checkmessage();
//	public abstract void setWordcard();
	public abstract int getBaiduFromServer();
	public abstract int getBingFromServer();
	public abstract int getYoudaoFromServer();
	
}
