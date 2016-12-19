package mainui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import config.WordContentConfig;
import po.ConfigInfo;
import po.WordInfo;
import util.DataFactory;
/**
 * WordContent : 
 * 		To show the information of word
 */
public class WordContent extends JPanel{
	
	private static final long serialVersionUID = -3000677005620925673L;
	
	private WordPanel translation;
	
	private JLabel img;
	private ConfigInfo baidu_config=new ConfigInfo();

	public WordContent() {
		baidu_config.initConfig(DataFactory.getDataService().choose.getBaidu_rank());
		setLayout(null);
		setBounds(baidu_config.LOC_Content_X, baidu_config.LOC_Content_Y, baidu_config.Content_WIDTH, baidu_config.Content_HEIGHT);
		translation = new WordPanel();
		add(translation);
		translation.setVisible(true);
	}
	
	public void updateContent(WordInfo info) {
		this.translation.updateContent(info.getWord(), info.getDescrption());
		repaint();
	}
	
	private class WordPanel extends JPanel{
		
		private static final long serialVersionUID = -7982365518141482173L;
		
		private JLabel wordName;
		private JLabel wordDescription;
		
		public WordPanel() {
			setBounds(0, 0, baidu_config.Content_WIDTH, baidu_config.Content_HEIGHT-10);
			setLayout(null);
	//		wordName = new JLabel("");
	//		wordName.setBounds(10, 0, this.getWidth()-40, 50);
			wordDescription = new JLabel("");
			wordDescription.setBounds(10, 10, this.getWidth()-10, this.getHeight() - 10);
			wordDescription.setVerticalAlignment(JLabel.TOP);
			wordDescription.setBorder(BorderFactory.createTitledBorder("[ 百度词典 ]"));
			wordDescription.setBackground(Color.BLUE);
//			Font name = wordName.getFont();
		//	wordName.setFont(new Font(name.getFontName(),Font.BOLD,name.getSize() + 10));
			wordDescription.setForeground(Color.blue);
		//	wordName.setForeground(Color.darkGray);
		//	add(wordName);
			add(wordDescription);
			//wordDescription.setVisible(true);
		}


		public void updateContent(String name, String description) {
			//wordName.setText(">> "+name);
			wordDescription.setText(description);
		}
	
		public void updateConfig(){
			baidu_config.initConfig(DataFactory.getDataService().choose.getBaidu_rank());
			setBounds(0, 0, baidu_config.Content_WIDTH, baidu_config.Content_HEIGHT-10);
			setLayout(null);
	//		wordName = new JLabel("");
	//		wordName.setBounds(10, 0, this.getWidth()-40, 50);
			wordDescription = new JLabel("");
			wordDescription.setBounds(10, 10, this.getWidth()-10, this.getHeight() - 10);
			wordDescription.setVerticalAlignment(JLabel.TOP);
			wordDescription.setBorder(BorderFactory.createTitledBorder("[ 百度词典 ]"));
			wordDescription.setBackground(Color.BLUE);
//			Font name = wordName.getFont();
		//	wordName.setFont(new Font(name.getFontName(),Font.BOLD,name.getSize() + 10));
			wordDescription.setForeground(Color.blue);
		//	wordName.setForeground(Color.darkGray);
		//	add(wordName);
			add(wordDescription);			
		}
		
	}

}
