package mainui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import config.baidu_config;
import po.ConfigInfo;
import util.DataFactory;

public class Icon_Baidu extends JPanel{
	private JLabel img;
	
	private ConfigInfo baidu_config=new ConfigInfo();
	public Icon_Baidu() {
		baidu_config.initConfig(DataFactory.getDataService().choose.getBaidu_rank());
		setLayout(null);
		setBounds(baidu_config.LOC_Icon_X, baidu_config.LOC_Icon_Y, baidu_config.Icon_WIDTH, baidu_config.Icon_HEIGHT);
		img = new JLabel(new ImageIcon("Icon_Baidu.png"));
		img.setBounds(0, 0, baidu_config.Icon_WIDTH, baidu_config.Icon_HEIGHT);
		add(img);
	}
	
	public void updateConfig(){
//		baidu_config.initConfig(DataFactory.getDataService().choose.getBaidu_rank());
		baidu_config.initConfig(DataFactory.getDataService().choose.getBaidu_rank());
		setLayout(null);
		setBounds(baidu_config.LOC_Icon_X, baidu_config.LOC_Icon_Y, baidu_config.Icon_WIDTH, baidu_config.Icon_HEIGHT);
		img = new JLabel(new ImageIcon("Icon_Baidu.png"));
		img.setBounds(0, 0, baidu_config.Icon_WIDTH, baidu_config.Icon_HEIGHT);
		add(img);

//		this.repaint();
	}
}
