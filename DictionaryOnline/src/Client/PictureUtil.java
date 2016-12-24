package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

import po.WordCardInfo;
import util.DataFactory;

public class PictureUtil {
	private final int sendLoc_X=300;
	private final int sendLoc_Y=10;
	private final int TransLoc_X1=50;
	private final int TransLoc_Y1=120;
	private final int TransLoc_X2=50;
	private final int TransLoc_Y2=240;
	private final int TransLoc_X3=50;
	private final int TransLoc_Y3=360;
	private final int rectWidth=700;
	private final int rectHeight=500;
	private final int transWidth=650;
	private final int transHeight=100;
	private Graphics2D g2;
	private WordCardInfo wordCardInfo=new WordCardInfo();
	
	private void setWordCardInfo(){
		this.wordCardInfo.setSendUser(DataFactory.getDataService().wordCardInfo.getSendUser());
		this.wordCardInfo.setReceiveUser(DataFactory.getDataService().wordCardInfo.getReceiveUser());
		this.wordCardInfo.setBaiduTrans(DataFactory.getDataService().wordCardInfo.getBaiduTrans());
		this.wordCardInfo.setYoudaoTrans(DataFactory.getDataService().wordCardInfo.getYoudaoTrans());
		this.wordCardInfo.setBingTrans(DataFactory.getDataService().wordCardInfo.getBingTrans());
		this.wordCardInfo.setWordname(DataFactory.getDataService().wordCardInfo.getWordname());
		
//		this.wordCardInfo.setChooseFlag(chooseFlag);
	}
	
	private void drawPic(){
        String sendfrom=wordCardInfo.getSendUser();
        sendfrom="send from: "+sendfrom;
//        g2.drawLine(x1, y1, x2, y2);
		g2.drawString(sendfrom, sendLoc_X,sendLoc_Y);   
		g2.drawString(wordCardInfo.getWordname(), sendLoc_X,sendLoc_Y+20);
		g2.drawRect(20, TransLoc_Y1-20,transWidth ,transHeight);
		g2.drawRect(20, TransLoc_Y2-20, transWidth, transHeight);
		g2.drawRect(20, TransLoc_Y3-20, transWidth, transHeight);
		g2.drawString("Baidu:", TransLoc_X1, TransLoc_Y1);
		g2.drawString(wordCardInfo.getBaiduTrans(), TransLoc_X1, TransLoc_Y1+10);
		g2.drawString("Youdao:", TransLoc_X2, TransLoc_Y2);
		g2.drawString(wordCardInfo.getYoudaoTrans(), TransLoc_X2, TransLoc_Y2+10);
		g2.drawString("Bing:", TransLoc_X3, TransLoc_Y3);
		g2.drawString(wordCardInfo.getBingTrans(), TransLoc_X3, TransLoc_Y3+10);		
	}
	public PictureUtil(){
		setWordCardInfo();
		String path=PictureUtil.class.getResource("").toString();
		path=path.replace('\\', '/');
		path=path.substring(6, path.length());
		File file = new File(path+"image/image.jpg");   
//        System.out.println(path);   
        Font font = new Font("Serif", Font.BOLD, 60);   
        BufferedImage bi = new BufferedImage(rectWidth, rectHeight, BufferedImage.TYPE_INT_RGB);   
        g2 = (Graphics2D)bi.getGraphics();   
        g2.setBackground(Color.WHITE);   
        g2.clearRect(0, 0, rectWidth, rectHeight);   
        g2.setPaint(Color.RED);   
      
        FontRenderContext context = g2.getFontRenderContext();   
        drawPic();
        try {
			ImageIO.write(bi, "jpg", file);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}  
		int length = 0;
		byte[] sendBytes = null;
		FileInputStream fis = null;
        try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		try {
			sendBytes = new byte[fis.available()];
			fis.read( sendBytes );
			fis.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
        DataFactory.getDataService().wordCardInfo.setPic(sendBytes);
        DataFactory.getDataService().wordCardInfo.setImage(bi);  
	}
}
