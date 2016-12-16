package web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import po.WordInfo;

	//��Ӧ�����㷨
public class Search_Bing {
		public static WordInfo lookUp(String word){
			java.util.Scanner input = null;
			String explanation = null;
			try {
				URL url = new URL("http://cn.bing.com/dict/search?q=" +word);
				input = new java.util.Scanner(url.openStream(),"UTF-8");
				String startString="��Ӧ�ʵ�Ϊ���ṩ"+word+"�����壬";
				while(input.hasNext()){
					String s = input.nextLine();
					int index=s.indexOf(startString);
					if(index>=0){
						//��ȡ���벿�ֵ����н�β
						String temp=s.substring(index+startString.length(),s.length());
						int endIndex=temp.indexOf("\"");
						if(endIndex>=0){
							//��ȡ���벿��
							String content=temp.substring(0,endIndex);
							explanation=content;
							break;
						}
					}	
				}
				if(explanation!=null&&!explanation.equals(""))
					explanation="<html>"+word+"<br/>"+explanation+"</html>";
				WordInfo result=new WordInfo(word,explanation);
				 return result;
				//	return explanation;
			} catch (MalformedURLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} catch(IOException ex){
				ex.printStackTrace();
			}
			return null;
		}

}
