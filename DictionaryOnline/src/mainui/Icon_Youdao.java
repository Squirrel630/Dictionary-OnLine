package mainui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.IconConfig;
import po.ConfigInfo;
import util.DataFactory;

public class Icon_Youdao extends JPanel{
	private JLabel img;
	
	private ConfigInfo youdao_config=new ConfigInfo();
	public Icon_Youdao() {
		youdao_config.initConfig(DataFactory.getDataService().choose.getYoudao_rank());
		setLayout(null);
		setBounds(youdao_config.LOC_Icon_X, youdao_config.LOC_Icon_Y, youdao_config.Icon_WIDTH, youdao_config.Icon_HEIGHT);
		img = new JLabel(new ImageIcon("Icon_Youdao.png"));
		img.setBounds(0, 0, youdao_config.Icon_WIDTH, youdao_config.Icon_HEIGHT);
		add(img);
	}
	
	public void  updateConfig(){
		youdao_config.initConfig(DataFactory.getDataService().choose.getYoudao_rank());
		setLayout(null);
		setBounds(youdao_config.LOC_Icon_X, youdao_config.LOC_Icon_Y, youdao_config.Icon_WIDTH, youdao_config.Icon_HEIGHT);
		img = new JLabel(new ImageIcon("Icon_Youdao.png"));
		img.setBounds(0, 0, youdao_config.Icon_WIDTH, youdao_config.Icon_HEIGHT);
		add(img);
		//this.repaint();
	}
}
