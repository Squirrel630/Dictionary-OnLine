package po;

public class WordCardInfo implements java.io.Serializable{
	private String sendUser;
	private String ReceiveUser;
	private String baiduTrans;
	private String youdaoTrans;
	private String bingTrans;
	private int ChooseFlag;
	public String getSendUser() {
		return sendUser;
	}
	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}
	public String getBaiduTrans() {
		return baiduTrans;
	}
	public void setBaiduTrans(String baiduTrans) {
		this.baiduTrans = baiduTrans;
	}
	public String getReceiveUser() {
		return ReceiveUser;
	}
	public void setReceiveUser(String receiveUser) {
		ReceiveUser = receiveUser;
	}
	public String getYoudaoTrans() {
		return youdaoTrans;
	}
	public void setYoudaoTrans(String youdaoTrans) {
		this.youdaoTrans = youdaoTrans;
	}
	public String getBingTrans() {
		return bingTrans;
	}
	public void setBingTrans(String bingTrans) {
		this.bingTrans = bingTrans;
	}
	public int getChooseFlag() {
		return ChooseFlag;
	}
	public void setChooseFlag(int chooseFlag) {
		ChooseFlag = chooseFlag;
	}
	
}
