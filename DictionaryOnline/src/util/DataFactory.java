package util;

import data.WordDataTxtImp;
import dataservice.WordDataService;

public class DataFactory {
	
	public static WordDataService getDataService() {
		return getDataService("txt");
	}
	
	public static WordDataService getDataService(String dealType) {
		switch (dealType) {
		case "txt":
			return new WordDataTxtImp();
//			break;
//		case "client":
//			return new ClientDataTxtImp();break
		default:
			break;
		}
		return null;
	}
	
}
