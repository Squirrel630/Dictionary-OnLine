package web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import po.WordInfo;

	//必应爬虫算法
public class Search_Bing {
		public static WordInfo lookUp(String word){
			java.util.Scanner input = null;
			String explanation = null;
			try {
				URL url = new URL("http://cn.bing.com/dict/search?q=" +word);
				input = new java.util.Scanner(url.openStream(),"UTF-8");
				String startString="必应词典为您提供"+word+"的释义，";
				while(input.hasNext()){
					String s = input.nextLine();
					int index=s.indexOf(startString);
					if(index>=0){
						//截取翻译部分到整行结尾
						String temp=s.substring(index+startString.length(),s.length());
						int endIndex=temp.indexOf("\"");
						if(endIndex>=0){
							//截取翻译部分
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
