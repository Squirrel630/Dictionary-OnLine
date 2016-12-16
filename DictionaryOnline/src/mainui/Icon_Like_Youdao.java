package mainui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.LikeConfig;

public class Icon_Like_Youdao extends JPanel{
	private JLabel img;
	
	public Icon_Like_Youdao() {
		setLayout(null);
		setBounds(LikeConfig.LOC_X, LikeConfig.LOC_Y2, LikeConfig.WIDTH, LikeConfig.HEIGHT);
		img = new JLabel(new ImageIcon("Icon_Like.png"));
		img.setBounds(0, 0, LikeConfig.WIDTH, LikeConfig.HEIGHT);
		add(img);
	}

}
