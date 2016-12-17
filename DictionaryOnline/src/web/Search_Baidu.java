package web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import po.WordInfo;
//�ٶ������㷨
public class Search_Baidu {
	//public 
	public static WordInfo lookUp(String word){
		java.util.Scanner input = null;
		String explanation = "";
		try {
			URL url = new URL("http://www.iciba.com/" + word);
			input = new java.util.Scanner(url.openStream(),"UTF-8");
			boolean explanBeginFlag = false; //��ʼ���ķ���ı�־
			boolean pronBeginFlag=false; //�����ֶο�ʼ�ı�־
			boolean tenseBeginFlag=false; //ʱ̬ת���ʹ���ת���ֶο�ʼ�ı�־
			
			//��ȡ����
			while(input.hasNext()){
				String s = input.nextLine();
				if(s.indexOf("<div class=\"base-speak\">")>=0)
					pronBeginFlag=true;
				else if(!pronBeginFlag)
					continue;
				else if(s.indexOf("<div class=\"base-word\" >")>=0)
					break;
				else if(s.indexOf("<span>")>=0){
					int begin = s.indexOf("<span>") + new String("<span>").length();
					int end = s.indexOf("</span>");
					if(end<0) continue;
					String temp=s.substring(begin, end);
					if(temp.charAt(0)!=' ')
						explanation+=temp;
				}
			}
			explanation=explanation+"<br/>";
			//��ȡ���ķ���
			while(input.hasNext()){
				String s = input.nextLine();
				if(s.indexOf("<li class=\"clearfix\">")>=0)
					explanBeginFlag=true;
				else if(!explanBeginFlag)
					continue;
				else if(s.indexOf("                                            </ul>")>=0)
					break;
				else if(s.indexOf("<span class=\"prop\">")>=0){
					int begin = s.indexOf("<span class=\"prop\">") + new String("<span class=\"prop\">").length();
					int end = s.indexOf("</span>");
					String temp=s.substring(begin, end);
					explanation+=temp;
				}
				else if(s.indexOf("<span>")>=0){
					int begin = s.indexOf("<span>") + new String("<span>").length();
					int end = s.indexOf("</span>");
					String temp=s.substring(begin, end);
					explanation+=temp;
				}
				
			}
			//explanation=explanation+"<br/>";
			explanation=explanation+"<br/>";
			//��ȡ���Ժ�ʱ̬ת��
			while(input.hasNext()){
				String s = input.nextLine();
				if(s.indexOf("<li class=\"change clearfix\">")>=0)
					tenseBeginFlag=true;
				else if(!tenseBeginFlag)
					continue;
				else if(s.indexOf("                </li>")>=0)
					break;
				else if(s.indexOf("<span>")>=0){
					int begin = s.indexOf("<span>") + new String("<span>").length();
					int end = s.length();
					String temp=s.substring(begin, end);
					explanation+=temp;
				}
				else if(s.indexOf(">")>=0){
					int begin = s.indexOf(">") + new String(">").length();
					int end = s.indexOf("</a>");
					if(end<0)
						continue;
					String temp=s.substring(begin, end);
					explanation+=temp;
				}
				//explanation=explanation+"<br/>";
			}
			explanation=explanation+"<br/>";
			if(explanation!=null&&!explanation.equals(""))
				explanation="<html>"+explanation+"</html>";
			
			 WordInfo result=new WordInfo(word,explanation);
			
			return result;
		} catch (MalformedURLException ex){
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch(IOException ex){
			ex.printStackTrace();
		}
		return null;
	}
}
