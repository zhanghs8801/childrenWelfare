//Blood_Wolf JQ插件包，支持开源，如有使用或二次开发，请标明出处，谢谢合作！
//#ff8a00; 翰臣科技有限公司VI色系
//本站由杭州翰臣科技有限公司进行全程策划/页面设计/程序开发完成. 24小时技术支持——翰臣科技：http://www.68hanchen.com

window.onload = function () {
	for (var ii = 0; ii < document.links.length; ii++)
		document.links[ii].onfocus = function () { this.blur() }
};

//导航栏
$(function(){
  $(".activesss").hover(function(){
	$(".Locate ul").stop(true,true);
    $(this).children('').next().stop(true,true).slideDown("fast");
  },function(){
    $(this).children('').next().stop(true,true).slideUp("fast");
  });
});


//产品切换
$(function(){	    
	qs();
  });

function qs(){
	$(".dh .activesss").hover(
		function(){
			$(this).stop(true,false).delay(0).animate({bottom:"10px"}, 500);
		},
		function(){
			$(this).stop(true,false).delay(0).animate({bottom:"0px"}, 500);
		}
	);
	
}

