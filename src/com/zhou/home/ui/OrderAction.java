package com.zhou.home.ui;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.zhou.home.model.ShopInfo;
import com.zhou.home.utils.BaseUtil;

@Controller
@RequestMapping("/order.htm")
public class OrderAction {

	@RequestMapping
	public String show(){
		return "order";
	}
	
	@RequestMapping(params="method=getshops", method = RequestMethod.GET)
	public void loadQhdm(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		ShopInfo shopInfo1 = new ShopInfo(1, "杨浦五角场店");
		ShopInfo shopInfo2 = new ShopInfo(2, "浦东正大店");
		
		List<ShopInfo> shopInfos = new ArrayList<ShopInfo>();
		shopInfos.add(shopInfo1);
		shopInfos.add(shopInfo2);
		Gson gson = new Gson();
		String shopsJson = gson.toJson(shopInfos);
		BaseUtil.return2View(response, shopsJson);
	}
}
