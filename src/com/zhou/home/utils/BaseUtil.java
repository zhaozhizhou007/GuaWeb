package com.zhou.home.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class BaseUtil {
	// �����������ݵ�ǰ̨
	public static void return2View(HttpServletResponse response,String putOut){
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(putOut);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(pw != null){
				pw.flush();
				pw.close();

			}
		}
	}
}
