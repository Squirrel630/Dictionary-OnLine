package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.LikeConfig;
import util.DataFactory;

public class Icon_Like_Youdao extends JButton implements ActionListener{
	private JLabel img;
	
	public Icon_Like_Youdao() {
		setLayout(null);
		setBounds(LikeConfig.LOC_X, LikeConfig.LOC_Y2, LikeConfig.WIDTH, LikeConfig.HEIGHT);
		img = new JLabel(new ImageIcon("Icon_Like.png"));
		img.setBounds(0, 0, LikeConfig.WIDTH, LikeConfig.HEIGHT);
		add(img);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		DataFactory.getDataService().addYoudaoLike();
		
	}

}
