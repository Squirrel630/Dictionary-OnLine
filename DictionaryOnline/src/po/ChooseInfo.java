package po;

import java.util.Set;

public class ChooseInfo implements java.io.Serializable{
	
//	private String word;//Ҫ�����ĵ���
	private boolean isBaiduChosen=true;//�ٶ��Ƿ�ѡ��
	private boolean isYoudaoChosen=true;//�е��Ƿ�ѡ��
	private boolean isBingChosen=true;//��Ӧ�Ƿ�ѡ��
	private int clientflag=2;
	private int Like_Baidu;
	private int Like_Youdao;
	private int Like_Bing;
	private int Baidu_rank=1;
	private int Youdao_rank=2;
	private int Bing_rank=3;
	
	public ChooseInfo() {
		// TODO �Զ����ɵĹ�a�캯�����
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
	public int getBaidu_rank() {
		return Baidu_rank;
	}
	public void setBaidu_rank(int baidu_rank) {
		Baidu_rank = baidu_rank;
	}
	public int getYoudao_rank() {
		return Youdao_rank;
	}
	public void setYoudao_rank(int youdao_rank) {
		Youdao_rank = youdao_rank;
	}
	public int getBing_rank() {
		return Bing_rank;
	}
	public void setBing_rank(int bing_rank) {
		Bing_rank = bing_rank;
	}

}
