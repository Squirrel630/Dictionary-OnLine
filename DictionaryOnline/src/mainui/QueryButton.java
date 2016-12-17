package mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import message.WordSearchMessage;
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
		
//			WordSearchMessage wsm=new WordSearchMessage(word); //选择的翻译选项
//			wsm.setBaidu(jcbBaidu.isSelected());
//			wsm.setBing(jcbBing.isSelected());
//			wsm.setYoudao(jcbYoudao.isSelected());
			
			int error_flag=0;
			for(int i=0;i<word.length();i++){
				char c=word.charAt(i);
				if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z'))){
					WordInfo error_result=new WordInfo(word, "NOTICE:　Input error! Please input again!");
					UIFactory.getWordContentInstance().updateContent(error_result);
					UIFactory.getWordContent_Youdao().updateContent(error_result);
					UIFactory.getWordContent_ICIBA().updateContent(error_result);
					error_flag=1;
					return;
				}
			}
			
			if(error_flag==0){
			WordInfo baidu_result;
			WordInfo youdao_result;
			WordInfo ICIBA_result;
			baidu_result=DataFactory.getDataService().baidu_trans(word);
			youdao_result=DataFactory.getDataService().youdao_trans(word);
			ICIBA_result=DataFactory.getDataService().ICIBA_trans(word);
			
			if(baidu_result.getDescrption()==""){
				baidu_result=new WordInfo(word, "NOTICE: NOT FOUND!");
			}
			if(youdao_result.getDescrption()==""){
				youdao_result=new WordInfo(word, "NOTICE: NOT FOUND!");
			}
			if(ICIBA_result.getDescrption()==""){
				ICIBA_result=new WordInfo(word, "NOTICE: NOT FOUND!");
			}
			if(baidu_result!=null&&youdao_result!=null&&ICIBA_result!=null){
				UIFactory.getWordContentInstance().updateContent(baidu_result);
				UIFactory.getWordContent_Youdao().updateContent(youdao_result);
				UIFactory.getWordContent_ICIBA().updateContent(ICIBA_result);
			}
			}
//			else{
//				baidu_result=new WordInfo(word,"not found");
//				UIFactory.getWordContentInstance().updateContent(baidu_result);
//				UIFactory.getWordContent_Youdao().updateContent(youdao_result);
//				UIFactory.getWordContent_ICIBA().updateContent(ICIBA_result);
//			}
			UIFactory.getWordListInstance().reDictionary(word);;
		//	int location = 5;
		//	UIFactory.getWordListInstance().receiveQueryResult(location);
		}
	}
	
}
