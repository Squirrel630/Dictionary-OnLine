package web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import po.WordInfo;

//�е������㷨
public class Search_Youdao {
	public static WordInfo lookUp(String word){
		java.util.Scanner input = null;
		String explanation = "";
		try {
			URL url = new URL("http://dict.youdao.com/search?le=eng&q=" + word + "&keyfrom=dict.top");
			input = new java.util.Scanner(url.openStream(),"UTF-8");
			boolean explanBeginFlag = false; //��ʼ���ķ���ı�־
			String pronType="<span class=\"pronounce\">";
			String pronBegin="<span class=\"phonetic\">";
			String pronEnd="</span>";
			//��ȡ����
			while(input.hasNext()){
				String s = input.nextLine();
				if(s.indexOf(pronType)>=0){
					int begin = s.indexOf(pronType) + pronType.length();
					int end = s.length();
					explanation += s.subSequence(begin, end);
				}
				else if(s.indexOf(pronBegin)>=0){
					int begin = s.indexOf(pronBegin) + pronBegin.length();
					int end = s.indexOf(pronEnd);
					explanation += s.subSequence(begin, end);
				}
				else if(s.indexOf("<div class=\"trans-container\">")>=0){
					break;
				}
			}
			explanation=explanation+"<br/>";
			//��ȡ���ķ���
			while(input.hasNext()){
				String s = input.nextLine();
				if(s.equals("   <ul>"))
					explanBeginFlag=true;
				else if(!explanBeginFlag)
					continue;
				else if(s.equals("    </ul>"))
					break;
				else{
					int begin = s.indexOf("<li>") + 4;
					int end = s.indexOf("</li>");
					explanation += s.subSequence(begin, end);
				//	explanation += "<br/>";
				}
			}
			explanation=explanation+"<br/>";
			if(explanation!=null&&!explanation.equals(""))
				explanation="<html>"+explanation+"</html>";
			 WordInfo result=new WordInfo(word,explanation);
			 return result;
			//return explanation;
		} catch (MalformedURLException ex){
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch(IOException ex){
			ex.printStackTrace();
		}
		return null;
	}
}
