package message;

import java.io.Serializable;

public class WordSearchMessage implements Serializable{
		
		private String word;//要搜索的单词
		private boolean isBaiduChosen=false;//百度是否被选择
		private boolean isYoudaoChosen=false;//有道是否被选择
		private boolean isBingChosen=false;//必应是否被选择
		
		public WordSearchMessage(String word) {
			// TODO Auto-generated constructor stub
			this.word=word;
		}
		
		public String getWord(){
			return word;
		}
		
		public boolean getBaidu(){
			return isBaiduChosen;
		}
		
		public boolean getYoudao(){
			return isYoudaoChosen;
		}

		public boolean getBing(){
			return isBingChosen;
		}
		
		public void setBaidu(boolean isBaiduChosen){
			this.isBaiduChosen=isBaiduChosen;
		}
		
		public void setYoudao(boolean isYoudaoChosen){
			this.isYoudaoChosen=isYoudaoChosen;
		}
		
		public void setBing(boolean isBingChosen){
			this.isBingChosen=isBingChosen;
		}
}

