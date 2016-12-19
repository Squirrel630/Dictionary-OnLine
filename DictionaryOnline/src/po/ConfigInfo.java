package po;

import config.First_Config;
import config.Second_Config;
import config.Third_Config;

public class ConfigInfo {
	public static int LOC_Content_X ;
	public static int LOC_Content_Y ;
	public static int Content_WIDTH ;	
	public static int Content_HEIGHT ;

	public static int LOC_Icon_X  ;
	public static int LOC_Icon_Y  ;
	public static int Icon_WIDTH  ;	
	public static int Icon_HEIGHT  ;
	
	public static int LOC_Like_X  ;
	public static int LOC_Like_Y  ;
	public static int Like_WIDTH  ;	
	public static int Like_HEIGHT  ;
	
	public ConfigInfo() {
		// TODO 自动生成的构造函数存根
	LOC_Content_X =0;
		 LOC_Content_Y =0;
		Content_WIDTH =0;	
		  Content_HEIGHT =0;

		  LOC_Icon_X =0;
		  LOC_Icon_Y =0;
		  Icon_WIDTH =0;	
		  Icon_HEIGHT =0;
		
		  LOC_Like_X =0;
		  LOC_Like_Y =0;
		  Like_WIDTH =0;	
		  Like_HEIGHT =0;
	}
	public void initConfig(int rank){
		switch (rank) {
		case 1:{
			LOC_Content_X=First_Config.LOC_Content_X;
			LOC_Content_Y=First_Config.LOC_Content_Y;
			Content_HEIGHT=First_Config.Content_HEIGHT;
			Content_WIDTH=First_Config.Content_WIDTH;
			
			LOC_Icon_X=First_Config.LOC_Icon_X;
			LOC_Icon_Y=First_Config.LOC_Icon_Y;
			Icon_HEIGHT=First_Config.Icon_HEIGHT;
			Icon_WIDTH=First_Config.Icon_WIDTH;
			
			LOC_Like_X=First_Config.LOC_Like_X;
			LOC_Like_Y=First_Config.LOC_Like_Y;
			Like_HEIGHT=First_Config.Like_HEIGHT;
			Like_WIDTH=First_Config.Like_WIDTH;
			
		}break;
		case 2:{
			LOC_Content_X=Second_Config.LOC_Content_X;
			LOC_Content_Y=Second_Config.LOC_Content_Y;
			Content_HEIGHT=Second_Config.Content_HEIGHT;
			Content_WIDTH=Second_Config.Content_WIDTH;
			
			LOC_Icon_X=Second_Config.LOC_Icon_X;
			LOC_Icon_Y=Second_Config.LOC_Icon_Y;
			Icon_HEIGHT=Second_Config.Icon_HEIGHT;
			Icon_WIDTH=Second_Config.Icon_WIDTH;
			
			LOC_Like_X=Second_Config.LOC_Like_X;
			LOC_Like_Y=Second_Config.LOC_Like_Y;
			Like_HEIGHT=Second_Config.Like_HEIGHT;
			Like_WIDTH=Second_Config.Like_WIDTH;
		}break;
		case 3:{
			LOC_Content_X=Third_Config.LOC_Content_X;
			LOC_Content_Y=Third_Config.LOC_Content_Y;
			Content_HEIGHT=Third_Config.Content_HEIGHT;
			Content_WIDTH=Third_Config.Content_WIDTH;
			
			LOC_Icon_X=Third_Config.LOC_Icon_X;
			LOC_Icon_Y=Third_Config.LOC_Icon_Y;
			Icon_HEIGHT=Third_Config.Icon_HEIGHT;
			Icon_WIDTH=Third_Config.Icon_WIDTH;
			
			LOC_Like_X=Third_Config.LOC_Like_X;
			LOC_Like_Y=Third_Config.LOC_Like_Y;
			Like_HEIGHT=Third_Config.Like_HEIGHT;
			Like_WIDTH=Third_Config.Like_WIDTH;
		}break;
		default:
			break;
		}

	}
}
