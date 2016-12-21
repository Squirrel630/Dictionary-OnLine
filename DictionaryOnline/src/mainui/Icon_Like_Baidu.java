package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

//import config.LikeConfig;
import po.ConfigInfo;
import util.DataFactory;

public class Icon_Like_Baidu  extends JButton implements ActionListener{
	private JLabel img;
	
	private ConfigInfo baidu_config=new ConfigInfo();
	public Icon_Like_Baidu() {
		baidu_config.initConfig(DataFactory.getDataService().choose.getBaidu_rank());
		setLayout(null);
		setBounds(baidu_config.LOC_Like_X, baidu_config.LOC_Like_Y, baidu_config.Like_WIDTH+10, baidu_config.Like_HEIGHT+10);
		img = new JLabel(new ImageIcon("Icon_Like.png"));
		img.setBounds(5, 5, baidu_config.Like_WIDTH,baidu_config.Like_HEIGHT);
		add(img);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DataFactory.getDataService().addBaiduLike();
//		DataFactory.getDataService().writeToServer();
	}

	public void updateConfig(){
		this.setEnabled(false);
		baidu_config.initConfig(DataFactory.getDataService().choose.getBaidu_rank());
		setLayout(null);
		setBounds(baidu_config.LOC_Like_X, baidu_config.LOC_Like_Y, baidu_config.Like_WIDTH+10, baidu_config.Like_HEIGHT+10);
		img = new JLabel(new ImageIcon("Icon_Like.png"));
		img.setBounds(5, 5, baidu_config.Like_WIDTH,baidu_config.Like_HEIGHT);
		add(img);
		addActionListener(this);
	}
}
