package mainui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.WordContentConfig;
import po.ConfigInfo;
import po.WordInfo;
import util.DataFactory;
/**
 * WordContent : 
 * 		To show the information of word
 */
public class WordContent_Youdao extends JPanel{
	
	private static final long serialVersionUID = -3000677005620925673L;
	
	private WordPanel translation;
	
	private JLabel img;
	private ConfigInfo Youdao_config=new ConfigInfo();

	public WordContent_Youdao() {
		Youdao_config.initConfig(DataFactory.getDataService().choose.getYoudao_rank());
		setLayout(null);
		setBounds(Youdao_config.LOC_Content_X, Youdao_config.LOC_Content_Y, Youdao_config.Content_WIDTH, Youdao_config.Content_HEIGHT);
		translation = new WordPanel();
		add(translation);
	}
	
	public void updateConfig(){
		Youdao_config.initConfig(DataFactory.getDataService().choose.getYoudao_rank());
		setLayout(null);
		setBounds(Youdao_config.LOC_Content_X, Youdao_config.LOC_Content_Y, Youdao_config.Content_WIDTH, Youdao_config.Content_HEIGHT);
		translation = new WordPanel();
		add(translation);
	}
	public void updateContent(WordInfo info) {
		this.translation.updateContent(info.getWord(), info.getDescrption());
		repaint();
	}
	
	private class WordPanel extends JPanel{
		
		private static final long serialVersionUID = -7982365518141482173L;
		
		//private JLabel wordName;
		private JLabel wordDescription;
		
		public WordPanel() {
			setBounds(0, 0, Youdao_config.Content_WIDTH, Youdao_config.Content_HEIGHT - 10);
			setLayout(null);
			wordDescription = new JLabel("");
			wordDescription.setBounds(10, 10, this.getWidth()-10, this.getHeight() - 10);
			wordDescription.setVerticalAlignment(JLabel.TOP);
			wordDescription.setBorder(BorderFactory.createTitledBorder("[ 有道词典 ]"));
			wordDescription.setBackground(Color.BLUE);
			wordDescription.setForeground(Color.blue);
			add(wordDescription);
		}
		
		public void updateConfig(){
//			baidu_config.initConfig(DataFactory.getDataService().choose.getBaidu_rank());
			Youdao_config.initConfig(DataFactory.getDataService().choose.getYoudao_rank());
			setBounds(0, 0, Youdao_config.Content_WIDTH, Youdao_config.Content_HEIGHT - 10);
			setLayout(null);
			wordDescription = new JLabel("");
			wordDescription.setBounds(10, 10, this.getWidth()-10, this.getHeight() - 10);
			wordDescription.setVerticalAlignment(JLabel.TOP);
			wordDescription.setBorder(BorderFactory.createTitledBorder("[ 有道词典 ]"));
			wordDescription.setBackground(Color.BLUE);
			wordDescription.setForeground(Color.blue);
			add(wordDescription);
		}

		public void updateContent(String name, String description) {
		//	wordName.setText(name);
			DataFactory.getDataService().wordCardInfo.setYoudaoTrans(description);
			wordDescription.setText(description);
		}
		
	}

}
