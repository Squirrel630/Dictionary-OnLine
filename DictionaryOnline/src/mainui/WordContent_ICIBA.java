package mainui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.WordContentConfig;
import po.WordInfo;
/**
 * WordContent : 
 * 		To show the information of word
 */
public class WordContent_ICIBA extends JPanel{
	private static final long serialVersionUID = -3000677005620925673L;
	private WordPanel translation;
	private JLabel img;
	public WordContent_ICIBA() {
		setLayout(null);
		setBounds(WordContentConfig.LOC_X, WordContentConfig.LOC_Y3, WordContentConfig.WIDTH, WordContentConfig.HEIGHT);
		translation = new WordPanel();
		add(translation);
	}
	
	public void updateContent(WordInfo info) {
		this.translation.updateContent(info.getWord(), info.getDescrption());
		repaint();
	}
	
	private class WordPanel extends JPanel{
		
		private static final long serialVersionUID = -7982365518141482173L;
		private JLabel wordDescription;
		
		public WordPanel() {
			setBounds(0, 0, WordContentConfig.WIDTH, WordContentConfig.HEIGHT - 10);
			setLayout(null);
			wordDescription = new JLabel("");
			wordDescription.setBounds(10, 10, this.getWidth()-10, this.getHeight() - 10);
			wordDescription.setVerticalAlignment(JLabel.TOP);
			wordDescription.setBorder(BorderFactory.createTitledBorder("[ ��Ӧ�ʵ� ]"));
			wordDescription.setBackground(Color.BLUE);
			wordDescription.setForeground(Color.blue);
			add(wordDescription);

		}

		public void updateContent(String name, String description) {
			wordDescription.setText(description);
		}
		
	}

}
