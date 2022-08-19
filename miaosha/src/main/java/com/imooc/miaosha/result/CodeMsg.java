package com.imooc.miaosha.result;
 
public class CodeMsg {
	
	private int code;
	private String msg;
	
	//通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "Client Error");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "Param Error：%s");
	public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "Illegal Request");
	public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "Frequent Visits！");
	//登录模块 5002XX
	public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session Do Not Exist Or Failed");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "Password can't be null");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "Phone can't be null");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "Phone Number Format Error");
	public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "Phone Number Do not Exist");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "Password Error");
	
	
	//商品模块 5003XX
	
	
	//订单模块 5004XX
	public static CodeMsg ORDER_NOT_EXIST = new CodeMsg(500400, "Order Do not Exist");
	
	//秒杀模块 5005XX
	public static CodeMsg MIAO_SHA_OVER = new CodeMsg(500500, "Spike Done");
	public static CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "Can Only Spike Once");
	public static CodeMsg MIAOSHA_FAIL = new CodeMsg(500502, "Spike Failed");
	
	
	private CodeMsg( ) {
	}
			
	private CodeMsg( int code,String msg ) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
	
	
}
