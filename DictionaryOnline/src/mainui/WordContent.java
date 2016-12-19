package mainui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.First_Config;
import config.WordContentConfig;
import po.ConfigInfo;
import po.WordInfo;
/**
 * WordContent : 
 * 		To show the information of word
 */
public class WordContent extends JPanel{
	
	private static final long serialVersionUID = -3000677005620925673L;
	
	private WordPanel translation;
	
	private JLabel img;
	public First_Config configInfo; 
	public WordContent() {
		setLayout(null);
		setBounds(WordContentConfig.LOC_X, WordContentConfig.LOC_Y, WordContentConfig.WIDTH, WordContentConfig.HEIGHT);
		translation = new WordPanel();
		add(translation);
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
			setBounds(0, 0, WordContentConfig.WIDTH, WordContentConfig.HEIGHT-10);
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


		public void updateContent(String name, String description) {
			wordName.setText(">> "+name);
			wordDescription.setText(description);
		}
		
//		public void setVisible_Baidu(Boolean flag){
//			if(!flag)
//				this.setVisible(false);
//			else 
//				this.setVisible(true);
//		}
	}

}
