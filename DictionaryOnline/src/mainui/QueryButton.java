package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import config.QueryButtonConfig;
import po.WordInfo;
import util.DataFactory;
import util.UIFactory;

public class QueryButton extends JButton implements ActionListener{

	private static final long serialVersionUID = -6847227296705939178L;

	public QueryButton() {
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBounds(QueryButtonConfig.LOC_X,QueryButtonConfig.LOC_Y,QueryButtonConfig.WIDTH,QueryButtonConfig.HEIGHT);
		setText("Query");
		setToolTipText("Query the word in dictionary");
		addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String item = (String)UIFactory.getWordInputFieldInstance().getSelectedItem();
		if(item.equals("")) {
			;//System.out.println("NothingInput");
		} 
		else {
			String word = (String) UIFactory.getWordInputFieldInstance().getWord();
			WordInfo baidu_result;
			WordInfo youdao_result;
			WordInfo ICIBA_result;
			baidu_result=DataFactory.getDataService().baidu_trans(word);
			youdao_result=DataFactory.getDataService().youdao_trans(word);
			ICIBA_result=DataFactory.getDataService().ICIBA_trans(word);
			if(baidu_result!=null){
				UIFactory.getWordContentInstance().updateContent(baidu_result);
				UIFactory.getWordContent_Youdao().updateContent(youdao_result);
				UIFactory.getWordContent_ICIBA().updateContent(ICIBA_result);
			}
			else{
				baidu_result=new WordInfo(word,"not found");
				UIFactory.getWordContentInstance().updateContent(baidu_result);
			}
			UIFactory.getWordListInstance().reDictionary(word);;
		//	int location = 5;
		//	UIFactory.getWordListInstance().receiveQueryResult(location);
		}
	}
	
}
