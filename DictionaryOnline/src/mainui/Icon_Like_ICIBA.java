package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import po.ConfigInfo;
import util.DataFactory;

public class Icon_Like_ICIBA  extends JButton implements ActionListener{
	private JLabel img;
	
	private ConfigInfo bing_config=new ConfigInfo();
	public Icon_Like_ICIBA() {
		bing_config.initConfig(DataFactory.getDataService().choose.getBing_rank());
		setLayout(null);
		setBounds(bing_config.LOC_Like_X, bing_config.LOC_Like_Y, bing_config.Like_WIDTH+10, bing_config.Like_HEIGHT+10);
		img = new JLabel(new ImageIcon("Icon_Like.png"));
		img.setBounds(5, 5, bing_config.Like_WIDTH,bing_config.Like_HEIGHT);
		add(img);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		DataFactory.getDataService().addBingLike();
		
	}
	
}
