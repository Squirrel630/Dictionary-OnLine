package po;

import java.awt.image.BufferedImage;

public class WordCardInfo implements java.io.Serializable{
	private String sendUser;
	private String ReceiveUser;
	
	private String baiduTrans;
	private String youdaoTrans;
	private String bingTrans;
	private byte[] pic;
	private int ChooseFlag;
	
	private String wordname;
	private String PictureName;
	private transient BufferedImage image;
	
	public WordCardInfo() {
		// TODO 自动生成的构造函数存根
		sendUser="";
		ReceiveUser="";
		baiduTrans="";
		youdaoTrans="";
		bingTrans="";
		ChooseFlag=-1;
		image=new BufferedImage(700, 500, BufferedImage.TYPE_INT_RGB);
	}

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
		this.ReceiveUser = receiveUser;
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

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getPictureName() {
		return PictureName;
	}

	public void setPictureName(String pictureName) {
		PictureName = pictureName;
	}

	public String getWordname() {
		return wordname;
	}

	public void setWordname(String wordname) {
		this.wordname = wordname;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
}
