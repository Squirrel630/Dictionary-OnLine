package mainui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.IconSearchConfig;
import config.LikeConfig;

public class Icon_Search extends JPanel{
	private JLabel img;
	
	public Icon_Search() {
		setLayout(null);
		setBounds(IconSearchConfig.LOC_X, IconSearchConfig.LOC_Y, IconSearchConfig.WIDTH, IconSearchConfig.HEIGHT);
		img = new JLabel(new ImageIcon("Icon_Search.png"));
		img.setBounds(0, 0, IconSearchConfig.WIDTH, IconSearchConfig.HEIGHT);
		add(img);
	}
}
