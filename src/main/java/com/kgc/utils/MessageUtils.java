package com.kgc.utils;
public class MessageUtils {
	
	//用户名
	private static String Uid = "justinbieber";
	
	//接口安全秘钥
	private static String Key = "d41d8cd98f00b204e980";
	
/*	//手机号码，多个号码如13800000000,13800000001,13800000002
	private static String smsMob;
	
	//短信内容
	private static String smsText*/;

	
	public static int sendMsg(String smstext,String smsMob) {
		
		HttpClientUtil client = HttpClientUtil.getInstance();
		
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smstext, smsMob);
	return  result;
	}
}
