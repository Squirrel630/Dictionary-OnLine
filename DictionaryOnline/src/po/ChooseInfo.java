package po;

import java.util.Set;

public class ChooseInfo {
	
//	private String word;//Ҫ�����ĵ���
	private boolean isBaiduChosen=true;//�ٶ��Ƿ�ѡ��
	private boolean isYoudaoChosen=true;//�е��Ƿ�ѡ��
	private boolean isBingChosen=true;//��Ӧ�Ƿ�ѡ��
	private int clientflag=2;
	private int Like_Baidu;
	private int Like_Youdao;
	private int Like_Bing;
	
	public ChooseInfo() {
		// TODO �Զ����ɵĹ��캯�����
//		clientflag=2;
		Like_Baidu=0;
		Like_Bing=0;
		Like_Youdao=0;
	}
	public int getLikeBaidu(){
		return Like_Baidu;
	}
	public int getLikeYoudao(){
		return Like_Youdao;
	}
	public int  getLikeBing() {
		return Like_Bing;
	}
	
	public void addLikeBaidu(){
		Like_Baidu++;
	}
	public void addLikeBing(){
		Like_Bing++;
	}
	public void addLikeYoudao(){
		Like_Youdao++;
	}
	public void setLikeBaidu(int likebaidu){
		Like_Baidu=likebaidu;
	}
	public void setLikeYoudao(int likeyoudao){
		Like_Youdao=likeyoudao;
	}
	public void setLikeBing(int likebing){
		Like_Bing=likebing;
	}
	public int getClientFlag(){
		return clientflag;
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
