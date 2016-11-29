package data;
import java.util.Iterator;

import javax.naming.spi.DirStateFactory.Result;

import org.json.JSONArray;
import org.json.JSONObject;
import com.baidu.translate.demo.TransApi;

import po.WordInfo;;


public class Baidu {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20161128000032878";
    private static final String SECURITY_KEY = "zmDiqsw79UMciu3JISEk";

    public static void Baidu(String[] word) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "squirrel";
        String json = api.getTransResult(query, "auto", "zh");
        System.out.println(json);
        System.out.println(parsJson(json));
    }
   
    public static  WordInfo baidu_word(String word) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String json = api.getTransResult(word, "auto", "zh");
        String translation=parsJson(json);
        WordInfo result=new WordInfo(word, translation);
        return result;
    }
	private static String parsJson(String json) {
    	try {
    		JSONObject jsonObject = new JSONObject(json);
    		JSONArray jsonArray = jsonObject.getJSONArray("trans_result");
    		String translation = jsonArray.getJSONObject(0).getString("dst");
    		return translation;
    	} catch (Exception e) {
			return "";
		}
    }

	public static WordInfo baidu_trans(String word) {
		// TODO Auto-generated method stub
		return null;
	}    
}
