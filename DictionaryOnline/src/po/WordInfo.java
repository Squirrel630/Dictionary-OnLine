package po;

public class WordInfo implements java.io.Serializable {
	private String word;
	private String descrption;
	
	public WordInfo() {
		// TODO 自动生成的构造函数存根
	}
	public String getWord() {
		return word;
	}
	public String getDescrption() {
		return descrption;
	}
	/**
	 * @param word
	 * @param descrption
	 */
	public WordInfo(String word, String descrption) {
		super();
		this.word = word;
		this.descrption = descrption;
	}
	
	
}
