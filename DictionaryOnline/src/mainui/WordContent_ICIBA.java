package mainui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import po.ConfigInfo;
import po.WordInfo;
import util.DataFactory;
/**
 * WordContent : 
 * 		To show the information of word
 */
public class WordContent_ICIBA extends JPanel{
	private static final long serialVersionUID = -3000677005620925673L;
	private WordPanel translation;
	private JLabel img;

	private ConfigInfo Bing_config=new ConfigInfo();

	public WordContent_ICIBA() {
		Bing_config.initConfig(DataFactory.getDataService().choose.getBing_rank());
		setLayout(null);
		setBounds(Bing_config.LOC_Content_X, Bing_config.LOC_Content_Y, Bing_config.Content_WIDTH, Bing_config.Content_HEIGHT);
		translation = new WordPanel();
		add(translation);
	}
	
	public void updateConfig(){
		Bing_config.initConfig(DataFactory.getDataService().choose.getBing_rank());
		setLayout(null);
		setBounds(Bing_config.LOC_Content_X, Bing_config.LOC_Content_Y, Bing_config.Content_WIDTH, Bing_config.Content_HEIGHT);
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
			setBounds(0, 0, Bing_config.Content_WIDTH, Bing_config.Content_HEIGHT - 10);
			setLayout(null);
			wordDescription = new JLabel("");
			wordDescription.setBounds(10, 10, this.getWidth()-10, this.getHeight() - 10);
			wordDescription.setVerticalAlignment(JLabel.TOP);
			wordDescription.setBorder(BorderFactory.createTitledBorder("[ 必应词典 ]"));
			wordDescription.setBackground(Color.BLUE);
			wordDescription.setForeground(Color.blue);
			add(wordDescription);

		}

		public void updateConfig(){
			Bing_config.initConfig(DataFactory.getDataService().choose.getBing_rank());
			setBounds(0, 0, Bing_config.Content_WIDTH, Bing_config.Content_HEIGHT - 10);
			setLayout(null);
			wordDescription = new JLabel("");
			wordDescription.setBounds(10, 10, this.getWidth()-10, this.getHeight() - 10);
			wordDescription.setVerticalAlignment(JLabel.TOP);
			wordDescription.setBorder(BorderFactory.createTitledBorder("[ 必应词典 ]"));
			wordDescription.setBackground(Color.BLUE);
			wordDescription.setForeground(Color.blue);
			add(wordDescription);
		}

		public void updateContent(String name, String description) {
			DataFactory.getDataService().wordCardInfo.setBingTrans(description);
			wordDescription.setText(description);
		}
		
	}

}
