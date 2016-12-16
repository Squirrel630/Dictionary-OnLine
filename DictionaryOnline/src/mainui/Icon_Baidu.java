package mainui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.IconConfig;

public class Icon_Baidu extends JPanel{
	private JLabel img;
	
	public Icon_Baidu() {
		setLayout(null);
		setBounds(IconConfig.LOC_X, IconConfig.LOC_Y, IconConfig.WIDTH, IconConfig.HEIGHT);
		img = new JLabel(new ImageIcon("Icon_Baidu.png"));
		img.setBounds(0, 0, IconConfig.WIDTH, IconConfig.HEIGHT);
		add(img);
	}
	
}
