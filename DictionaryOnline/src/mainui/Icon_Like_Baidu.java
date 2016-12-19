package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import config.LikeConfig;
import util.DataFactory;
import util.UIFactory;

public class Icon_Like_Baidu  extends JButton implements ActionListener{
	private JLabel img;
	
	public Icon_Like_Baidu() {
		setLayout(null);
		setBounds(LikeConfig.LOC_X, LikeConfig.LOC_Y, LikeConfig.WIDTH+10, LikeConfig.HEIGHT+10);
		img = new JLabel(new ImageIcon("Icon_Like.png"));
		img.setBounds(5, 5, LikeConfig.WIDTH, LikeConfig.HEIGHT);
		add(img);
		addActionListener(this);
		//addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DataFactory.getDataService().addBaiduLike();
	}

}
