package mainui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import config.WordFieldConfig;
import util.DataFactory;

public class WordInputField extends JComboBox<String>  implements KeyListener{

	private static final long serialVersionUID = -3579632215369712581L;
	
	private JTextField editor = null;	
	
	private DocumentListener inputListener = new DocumentListener() {

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			query(editor.getText(), editor.getCaretPosition());
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			query(editor.getText(), editor.getCaretPosition());
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			query(editor.getText(), editor.getCaretPosition());
		}
    };

	public WordInputField() {
		setBounds(WordFieldConfig.LOC_X, WordFieldConfig.LOC_Y, WordFieldConfig.WIDTH, WordFieldConfig.HEIGHT);
		setEditable(true);
		
		setModel(new DefaultComboBoxModel<>(new String[]{""}));
		editor = (JTextField) getEditor().getEditorComponent();
		//editor.getDocument().addDocumentListener(inputListener);
		editor.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char   ch   =   e.getKeyChar(); 
        if   (ch   ==   KeyEvent.CHAR_UNDEFINED||Character.isISOControl(ch)||ch   ==   KeyEvent.VK_DELETE) {//
        	return;
        }
        int   caretPosition   =   editor.getCaretPosition(); 
        String   str   =   editor.getText();
        if   (str.length()   ==   0) 
            return; 
        query(str, caretPosition);
	}
	
	private void query(String filter, int loc){
		Iterator<String> words;
		words = DataFactory.getDataService().lenovo(filter);
		if(words.hasNext()) {
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
			while(words.hasNext()) {
				model.addElement(words.next());
			}
			setModel(model);
            editor.setCaretPosition(loc); 
            showPopup();
		} 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}	
	
	public String getWord() {
		return this.editor.getText();
	}
}
