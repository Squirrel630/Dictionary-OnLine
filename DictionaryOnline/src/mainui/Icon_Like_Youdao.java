package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import po.ConfigInfo;
import util.DataFactory;

public class Icon_Like_Youdao extends JButton implements ActionListener{
	private JLabel img;
	
	private ConfigInfo youdao_config=new ConfigInfo();
	public Icon_Like_Youdao() {
		youdao_config.initConfig(DataFactory.getDataService().choose.getYoudao_rank());
		setLayout(null);
		setBounds(youdao_config.LOC_Like_X, youdao_config.LOC_Like_Y, youdao_config.Like_WIDTH+10, youdao_config.Like_HEIGHT+10);
		img = new JLabel(new ImageIcon("Icon_Like.png"));
		img.setBounds(5, 5, youdao_config.Like_WIDTH,youdao_config.Like_HEIGHT);
		add(img);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		DataFactory.getDataService().addYoudaoLike();
//		DataFactory.getDataService().writeToServer();
	}

	public void updateConfig(){
//		this.setEnabled(false);
		removeActionListener(this);
		youdao_config.initConfig(DataFactory.getDataService().choose.getYoudao_rank());
		setLayout(null);
		setBounds(youdao_config.LOC_Like_X, youdao_config.LOC_Like_Y, youdao_config.Like_WIDTH+10, youdao_config.Like_HEIGHT+10);
		img = new JLabel(new ImageIcon("Icon_Like.png"));
		img.setBounds(5, 5, youdao_config.Like_WIDTH,youdao_config.Like_HEIGHT);
		add(img);
		addActionListener(this);
	}
}
