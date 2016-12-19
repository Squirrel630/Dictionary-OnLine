package mainui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import config.ChooseBoxConfig;
import util.DataFactory;

public class ChooseBox extends JCheckBox{
	//三个复选框
	private JCheckBox jcbYoudao=new JCheckBox("有道词典",true);
	private JCheckBox jcbBaidu=new JCheckBox("百度词典",true);
	private JCheckBox jcbBing=new JCheckBox("必应词典",true);
//	public static ChooseInfo Ischoose;

	public ChooseBox() {
		// TODO 自动生成的构造函数存根

		setLayout(null);
		setBounds(ChooseBoxConfig.LOC_X, ChooseBoxConfig.LOC_Y, ChooseBoxConfig.WIDTH, ChooseBoxConfig.HEIGHT);
		jcbBaidu.setForeground(Color.DARK_GRAY);
		jcbBaidu.setBounds(0, 0, ChooseBoxConfig.BOXWIDTH, ChooseBoxConfig.HEIGHT-5);
		jcbBaidu.setMnemonic('B');
		jcbYoudao.setForeground(Color.DARK_GRAY);
		jcbYoudao.setBounds(ChooseBoxConfig.LOC_X2, 0, ChooseBoxConfig.BOXWIDTH, ChooseBoxConfig.HEIGHT-5);
		jcbYoudao.setMnemonic('Y');
		jcbBing.setForeground(Color.DARK_GRAY);
		jcbBing.setBounds(ChooseBoxConfig.LOC_X3, 0, ChooseBoxConfig.BOXWIDTH, ChooseBoxConfig.HEIGHT-5);
		jcbBing.setMnemonic('C');
		add(jcbBaidu);
		add(jcbYoudao);
		add(jcbBing);
		
		jcbBaidu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(jcbBaidu.isSelected())
					DataFactory.getDataService().choose.setBaidu(true);
				else 
					DataFactory.getDataService().choose.setBaidu(false);
				DataFactory.getDataService().DisplayUI();
			}
		});
		
		jcbBing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(jcbBing.isSelected())
					DataFactory.getDataService().choose.setBing(true);
				else 
					DataFactory.getDataService().choose.setBing(false);
				DataFactory.getDataService().DisplayUI();
			}
		});
		
		jcbYoudao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(jcbYoudao.isSelected())
					DataFactory.getDataService().choose.setYoudao(true);
				else 
					DataFactory.getDataService().choose.setYoudao(false);
				DataFactory.getDataService().DisplayUI();
//				DataFactory.getDataService().choose();
			}
		});
	}

}
