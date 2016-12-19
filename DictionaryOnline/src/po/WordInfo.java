package po;

public class WordInfo implements java.io.Serializable {
	private String word;
	private String descrption;
	
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
