package com.imooc.miaosha.util; 

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Xizhi Yiming Qisheng
 *
 * @date 2022年4月15日 下午5:12:10<br/>
 */
public class HttpUtil {
	public static void main(String[] args) throws Exception{
		
		for(int i=0;i<10;i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						for(int i=0;i<10;i++) {
							URL url = new URL("http://192.168.220.130/index.html");
							HttpURLConnection conn = (HttpURLConnection)url.openConnection();
							InputStream in = conn.getInputStream();
							ByteArrayOutputStream bout  = new ByteArrayOutputStream();
							byte[] buff = new byte[1024];
							int len = 0;
							while((len = in.read(buff)) >= 0) {
								bout.write(buff, 0, len);
							}
							in.close();
							bout.close();
							byte[] response = bout.toByteArray();
							System.out.println(new String(response, "UTF-8"));
							Thread.sleep(3000);
						}
					}catch(Exception e) {
						
					}
				}
			});
			t.start();
		}
	}
}
