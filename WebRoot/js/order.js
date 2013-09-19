$(function(){

	//…Ë÷√µÍ∆Ã–≈œ¢
	var select_shops = $('#select-shop');
	$.get("order.htm?method=getshops",function(json){
		select_shops.empty();
		$(eval(json)).each(function(index,elem){
			select_shops.append("<option value='" + elem.shopId + "'>" + elem.name + "</option>"); 
		});
		select_shops.change();
	});
});