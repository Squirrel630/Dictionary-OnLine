package mainui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.IconConfig;
import po.ConfigInfo;
import util.DataFactory;

public class Icon_ICIBA  extends JPanel {
	private JLabel img;
	
	private ConfigInfo bing_config=new ConfigInfo();
	public Icon_ICIBA() {
		bing_config.initConfig(DataFactory.getDataService().choose.getBing_rank());
		setLayout(null);
		setBounds(bing_config.LOC_Icon_X, bing_config.LOC_Icon_Y, bing_config.Icon_WIDTH, bing_config.Icon_HEIGHT);
		img = new JLabel(new ImageIcon("Icon_ICIBA.png"));
		img.setBounds(0, 0, bing_config.Icon_WIDTH, bing_config.Icon_HEIGHT);
		add(img);
//		translation = new WordPanel();
//		add(translation);
	}
	
	public void updateConfig(){
		bing_config.initConfig(DataFactory.getDataService().choose.getBing_rank());
//		bing_config.initConfig(DataFactory.getDataService().choose.getBing_rank());
		setLayout(null);
		setBounds(bing_config.LOC_Icon_X, bing_config.LOC_Icon_Y, bing_config.Icon_WIDTH, bing_config.Icon_HEIGHT);
		img = new JLabel(new ImageIcon("Icon_ICIBA.png"));
		img.setBounds(0, 0, bing_config.Icon_WIDTH, bing_config.Icon_HEIGHT);
		add(img);
		//this.repaint();
	}
}
