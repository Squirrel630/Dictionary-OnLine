package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import po.WordCardInfo;
import util.DataFactory;

public class PictureUtil {
	
	private WordCardInfo wordCardInfo;
	
	private void setWordCardInfo(){
		this.wordCardInfo.setSendUser(DataFactory.getDataService().wordCardInfo.getSendUser());
		this.wordCardInfo.setReceiveUser(DataFactory.getDataService().wordCardInfo.getReceiveUser());
		this.wordCardInfo.setBaiduTrans(DataFactory.getDataService().wordCardInfo.getBaiduTrans());
		this.wordCardInfo.setYoudaoTrans(DataFactory.getDataService().wordCardInfo.getYoudaoTrans());
		this.wordCardInfo.setBingTrans(DataFactory.getDataService().wordCardInfo.getBingTrans());
	}
	
	public PictureUtil(){
		int width = 100;   
        int height = 100;   
//        String s = "你好";   
           
        File file = new File("C:/Users/lsn/Desktop/Dic/DictionaryOnline/image/image.jpg");   
           
        Font font = new Font("Serif", Font.BOLD, 10);   
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
        Graphics2D g2 = (Graphics2D)bi.getGraphics();   
        g2.setBackground(Color.WHITE);   
        g2.clearRect(0, 0, width, height);   
        g2.setPaint(Color.RED);   
           
        FontRenderContext context = g2.getFontRenderContext();   
        Rectangle2D bounds = font.getStringBounds("send from: "+wordCardInfo.getSendUser(), context);   
        double x = (width - bounds.getWidth()) / 2;   
        double y = (height - bounds.getHeight()) / 2;   
        double ascent = -bounds.getY();   
        double baseY = y + ascent;   
           
        g2.drawString("send from: "+wordCardInfo.getSendUser(), (int)x, (int)baseY);   
           
        try {
			ImageIO.write(bi, "jpg", file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}    
	}
}