package com.zhou.home.ui;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page.do")
public class HomeAction {

	/**
	 * 载入下拉的地址数据
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @throws Exception
	 */
	@RequestMapping(params="method=getcity", method = RequestMethod.GET)
	public void loadQhdm(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		
		Class.forName("org.sqlite.JDBC");
	    Connection conn = DriverManager.getConnection("jdbc:sqlite:gua.db");//filename为你的SQLite数据名称
	    Statement stat = conn.createStatement();
	    stat.executeUpdate("drop table if exists people;");
	    stat.executeUpdate("create table people (name, occupation);");
	    PreparedStatement prep = conn.prepareStatement(
	      "insert into people values (?, ?);");

	    prep.setString(1, "Gandhi");
	    prep.setString(2, "politics");
	    prep.addBatch();
	    prep.setString(1, "Turing");
	    prep.setString(2, "computers");
	    prep.addBatch();
	    prep.setString(1, "Wittgenstein");
	    prep.setString(2, "smartypants");
	    prep.addBatch();

	    conn.setAutoCommit(false);
	    prep.executeBatch();
	    conn.setAutoCommit(true);

	    ResultSet rs = stat.executeQuery("select * from people;");
	  
	    String putOut = "";
	    while (rs.next()) {
	    	putOut += "name = " + rs.getString("name");
	    }
	    rs.close();
	    conn.close();
		//String defaultDist = request.getParameter("defaultDist");// 默认的行政区划

		// [{'nevalue':'310000','contents':'上海市','inputcpy':'SHS','inputcwb':'HIY'}]
		// 返回前台
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(putOut);
		pw.flush();
		pw.close();
	}
	
}
