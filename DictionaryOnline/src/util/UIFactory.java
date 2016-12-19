package util;

import config.LoginButtonConfig;
import mainui.ChooseBox;
import mainui.Icon_Baidu;
import mainui.Icon_ICIBA;
import mainui.Icon_Like_Baidu;
import mainui.Icon_Like_ICIBA;
import mainui.Icon_Like_Youdao;
import mainui.Icon_Search;
import mainui.Icon_Youdao;
import mainui.LoginButton;
import mainui.MainFrame;
import mainui.QueryButton;
import mainui.WordContent;
import mainui.WordContent_ICIBA;
import mainui.WordContent_Youdao;
import mainui.WordInputField;
import mainui.WordList;

/**
 * 鐢变簬鎵�鏈塁omponent閮芥槸鍞竴鐨勶紝鍥犳涓嶅Θ鍏ㄩ儴閫氳繃Factory璁块棶锛屼互纭繚鍗曚竴瀵硅薄
 */
public class UIFactory {
	
	private static MainFrame frame;
	private static QueryButton queryButton;
	private static LoginButton loginButton;
	private static WordContent wordContent;
	private static WordContent_Youdao wordContent_Youdao;
	private static WordContent_ICIBA wordContent_ICIBA;
	private static WordInputField wordInputField;
	private static WordList wordList;
	private static Icon_Baidu icon_Baidu;
	private static Icon_Youdao icon_Youdao;
	private static Icon_ICIBA icon_ICIBA;
	private static Icon_Like_Baidu like_Baidu;
	private static Icon_Like_Youdao like_Youdao;
	private static Icon_Like_ICIBA like_ICIBA;
	private static Icon_Search icon_search;
	private static ChooseBox chooseBox;
	
//	public static 
	
	
	public static MainFrame getMainFrameInstance() {
		if(frame == null) {
			frame = new MainFrame();
		}
		return frame;
	}
	
	public static QueryButton getQueryButtonInstance() {
		if(queryButton == null) {
			queryButton = new QueryButton();
		}
		return queryButton;
	}
	
	public static ChooseBox getChooseBox() {
		if(chooseBox == null) {
			chooseBox = new ChooseBox();
		}
		return chooseBox;
	}
	
	public static LoginButton getLoginButtonInstance() {
		if(loginButton == null) {
			loginButton = new LoginButton();
		}
		return loginButton;
	}
	
	public static WordContent getWordContentInstance() {
		if(wordContent == null) {
			wordContent = new WordContent();
		}
		return wordContent;
	}
	
	
	public static WordContent_Youdao getWordContent_Youdao() {
		if(wordContent_Youdao == null) {
			wordContent_Youdao = new WordContent_Youdao();
		}
		return wordContent_Youdao;
	}
	
	public static WordContent_ICIBA getWordContent_ICIBA() {
		if(wordContent_ICIBA == null) {
			wordContent_ICIBA = new WordContent_ICIBA();
		}
		return wordContent_ICIBA;
	}
	
	
	public static WordInputField getWordInputFieldInstance() {
		if(wordInputField == null) {
			wordInputField = new WordInputField();
		}
		return wordInputField;
	}
	
	public static WordList getWordListInstance() {
		if(wordList == null) {
			wordList = new WordList();
		}
		return wordList;
	}
	
	public static Icon_Baidu getIcon_Baidu() {
		if(icon_Baidu == null) {
			icon_Baidu = new Icon_Baidu();
		}
		return icon_Baidu;
	}
	
	public static Icon_Youdao getIcon_Youdao() {
		if(icon_Youdao == null) {
			icon_Youdao = new Icon_Youdao();
		}
		return icon_Youdao;
	}
	
	public static Icon_ICIBA getIcon_ICIBA() {
		if(icon_ICIBA == null) {
			icon_ICIBA = new Icon_ICIBA();
		}
		return icon_ICIBA;
	}
	
	public static Icon_Like_Baidu getIcon_Like_Baidu() {
		if(like_Baidu == null) {
			like_Baidu = new Icon_Like_Baidu();
		}
		return like_Baidu;
	}
	
	public static Icon_Like_Youdao getIcon_Like_Youdao() {
		if(like_Youdao == null) {
			like_Youdao = new Icon_Like_Youdao();
		}
		return like_Youdao;
	}
	
	public static Icon_Like_ICIBA getIcon_Like_ICIBA() {
		if(like_ICIBA == null) {
			like_ICIBA = new Icon_Like_ICIBA();
		}
		return like_ICIBA;
	}
	
	public static Icon_Search getIcon_Search() {
		if(icon_search == null) {
			icon_search = new Icon_Search();
		}
		return icon_search;
	}
	
}
