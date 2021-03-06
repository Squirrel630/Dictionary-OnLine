package po;

import java.util.Set;

public class ChooseInfo implements java.io.Serializable{
	
//	private String word;//要搜索的单词
	private boolean isBaiduChosen=true;//百度是否被选择
	private boolean isYoudaoChosen=true;//有道是否被选择
	private boolean isBingChosen=true;//必应是否被选择
	private int clientflag=2;
	private int Like_Baidu;
	private int Like_Youdao;
	private int Like_Bing;
	private int Baidu_rank=1;
	private int Youdao_rank=2;
	private int Bing_rank=3;
	private int Add_Like_baidu=0;
	private int Add_Like_youdao=0;
	private int Add_Like_bing=0;
	
	public ChooseInfo() {
		// TODO 自动生成的构a造函数存根
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
	public void setClientFlag(int i){
		clientflag = i;
	}

	public void addLikeBaidu(){
		Add_Like_baidu++;
	}
	public void addLikeBing(){
		Add_Like_bing++;
	}
	public void addLikeYoudao(){
		Add_Like_youdao++;
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
	public int getAdd_Like_baidu() {
		return Add_Like_baidu;
	}
	public void setAdd_Like_baidu(int add_Like_baidu) {
		Add_Like_baidu = add_Like_baidu;
	}
	public int getAdd_Like_bing() {
		return Add_Like_bing;
	}
	public void setAdd_Like_bing(int add_Like_bing) {
		Add_Like_bing = add_Like_bing;
	}
	public int getAdd_Like_youdao() {
		return Add_Like_youdao;
	}
	public void setAdd_Like_youdao(int add_Like_youdao) {
		Add_Like_youdao = add_Like_youdao;
	}

}
