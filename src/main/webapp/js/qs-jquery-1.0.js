//Blood_Wolf JQ�������֧�ֿ�Դ������ʹ�û���ο����������������лл������
//#ff8a00; �����Ƽ����޹�˾VIɫϵ
//��վ�ɺ��ݺ����Ƽ����޹�˾����ȫ�̲߻�/ҳ�����/���򿪷����. 24Сʱ����֧�֡��������Ƽ���http://www.68hanchen.com

window.onload = function () {
	for (var ii = 0; ii < document.links.length; ii++)
		document.links[ii].onfocus = function () { this.blur() }
};

//������
$(function(){
  $(".activesss").hover(function(){
	$(".Locate ul").stop(true,true);
    $(this).children('').next().stop(true,true).slideDown("fast");
  },function(){
    $(this).children('').next().stop(true,true).slideUp("fast");
  });
});


//��Ʒ�л�
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

