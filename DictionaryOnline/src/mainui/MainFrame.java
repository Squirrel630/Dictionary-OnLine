package mainui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.MainFrameConfig;
import po.ChooseInfo;
import util.UIFactory;
/**
 * A Controller
 */
public class MainFrame extends JFrame{

	private static final long serialVersionUID = 8328872782891372697L;
	
	public MainFrame() {
		init();
	}
	
	public static ChooseInfo chooseInfo;
	
	private void init() {
		this.setTitle("Squirrel & Big Pang's Dictionary");
		int width = MainFrameConfig.WIDTH;
		int height = MainFrameConfig.HEIGHT;
		
		this.setSize(width,height);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dimension.width - width)>>1,((dimension.height - height)>>1) - 15);
		
		
		initComponent();
		
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initComponent() {
		Container container = getContentPane();
		container.add(UIFactory.getQueryButtonInstance());
		container.add(UIFactory.getLoginButtonInstance());
		container.add(UIFactory.getWordContentInstance());
		container.add(UIFactory.getWordContent_Youdao());
		container.add(UIFactory.getWordContent_ICIBA());
		container.add(UIFactory.getWordInputFieldInstance());
		container.add(UIFactory.getIcon_Baidu());
		container.add(UIFactory.getIcon_Youdao());
		container.add(UIFactory.getIcon_ICIBA());
		container.add(UIFactory.getIcon_Like_Baidu());
		container.add(UIFactory.getIcon_Like_Youdao());
		container.add(UIFactory.getIcon_Like_ICIBA());
		container.add(UIFactory.getIcon_Search());
		container.add(UIFactory.getChooseBox());
		container.add(UIFactory.getShareCardButton());
		container.add(UIFactory.getOnlineUserButton());
		container.add(UIFactory.getCheckMessageButton());
	}

	
}
