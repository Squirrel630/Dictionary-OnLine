package message;

import java.io.Serializable;

public class WordSearchMessage implements Serializable{
		
		private String word;//Ҫ�����ĵ���
		private boolean isBaiduChosen=false;//�ٶ��Ƿ�ѡ��
		private boolean isYoudaoChosen=false;//�е��Ƿ�ѡ��
		private boolean isBingChosen=false;//��Ӧ�Ƿ�ѡ��
		
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

