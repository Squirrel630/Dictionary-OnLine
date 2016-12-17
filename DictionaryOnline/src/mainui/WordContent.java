package mainui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.WordContentConfig;
import po.WordInfo;
/**
 * WordContent : 
 * 		To show the information of word
 */
public class WordContent extends JPanel{
	
	private static final long serialVersionUID = -3000677005620925673L;
	
	private WordPanel translation;
	
	private JLabel img;
	
	public WordContent() {
		setLayout(null);
		setBounds(WordContentConfig.LOC_X, WordContentConfig.LOC_Y, WordContentConfig.WIDTH, WordContentConfig.HEIGHT2);
		translation = new WordPanel();
		add(translation);
	}
	
	public void updateContent(WordInfo info) {
		this.translation.updateContent(info.getWord(), info.getDescrption());
//		this.translation.updateContent(info.getWord(), "aaa\r\nbbb");
		repaint();
	}
	
	private class WordPanel extends JPanel{
		
		private static final long serialVersionUID = -7982365518141482173L;
		
		private JLabel wordName;
		private JLabel wordDescription;
		
		public WordPanel() {
			setBounds(0, 0, WordContentConfig.WIDTH, WordContentConfig.HEIGHT2-10);
			setLayout(null);
			wordName = new JLabel("");
			wordName.setBounds(10, 0, this.getWidth()-40, 50);
			wordDescription = new JLabel("");
			wordDescription.setBounds(10, 50, this.getWidth()-10, this.getHeight() - 50);
			wordDescription.setVerticalAlignment(JLabel.TOP);
			wordDescription.setBorder(BorderFactory.createTitledBorder("[ 百度词典 ]"));
			wordDescription.setBackground(Color.BLUE);
			Font name = wordName.getFont();
			wordName.setFont(new Font(name.getFontName(),Font.BOLD,name.getSize() + 10));
			wordDescription.setForeground(Color.blue);
			wordName.setForeground(Color.darkGray);
			add(wordName);
			add(wordDescription);
//
//			setBounds(0, 0, WordContentConfig.WIDTH, WordContentConfig.HEIGHT - 10);
//			setLayout(null);
//			wordDescription = new JLabel("");
//			wordDescription.setBounds(10, 10, this.getWidth()-10, this.getHeight() - 10);
//			wordDescription.setVerticalAlignment(JLabel.TOP);
//			wordDescription.setBorder(BorderFactory.createTitledBorder("[ 有道词典 ]"));
//			wordDescription.setBackground(Color.BLUE);
//			wordDescription.setForeground(Color.blue);
//			add(wordDescription);
		}
		
		private void updateContent(WordInfo te) {
			// TODO Auto-generated method stub
		//	wordName=te.getWord();
		//	wordDescription=te.getDescrption();
		}

		public void updateContent(String name, String description) {
			wordName.setText(">> "+name);
		//	wordDescription.setText("aaa\r\nbbb");
		//	wordDescription(true);// 太长时，使允许自动换行
	//		wordDescription.setText("abc\r\nefg");// 手动添加一个换行符“\r\n”
			wordDescription.setText(description);
		}
		
	}

}
