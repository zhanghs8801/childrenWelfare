<#assign ctx=request.contextPath />
<html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/css/bootstrapValidator.css" rel="stylesheet">
    <link href="${ctx}/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${ctx}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${ctx}/css/animate.css" rel="stylesheet">
    <link href="${ctx}/css/style.css" rel="stylesheet">
	<style type="text/css">
		.xl_biaoti{width:700px;margin:0 auto;zoom:1;}
		.xl_biaoti:after{display:block;clear:both;content:"";visibility:hidden;height:0}
		.xl_biaoti h3{line-height: 26px;float: left;margin:0;padding-left:200px}
		.xl_biaoti p{float: right;margin:0px}
		.help-block{
		    text-align: left;
		    position: absolute;
		    right: -312px;
		    width: 300px;
		    top: 3px;
		}
	</style>
</head>

<body class="gray-bg">
	<div>
		<h1 class="logo-name" style="text-align: center;padding-top:40px">PPTV VIP+</h1>
    </div>
    <div class="xl_biaoti">
    	<h3>欢迎注册和使用PPTV VIP+</h3>
    	<!-- <P>如果您已有账号，<a href="login.html">点这里去登录</a></P> -->
	</div>
    <div class="middle-box text-center loginscreen animated fadeInDown" style="padding-top:2px">
	        <div>
	            <form id="registerForm" class="m-t" role="form" action="${ctx}/user/" method="post">
	                <div class="form-group">
	                     <input type="text" name="teamName" class="form-control" placeholder="公司/团队名称" >
	                </div>
	                <div class="form-group">
	                     <input type="text" name="bizDesc" class="form-control" placeholder="业务简述">
	                </div>
	                <div class="form-group" style="margin-top:50px">
	                     <input type="email" name="email" class="form-control" placeholder="登录邮箱" >
	                </div>
	                <div class="form-group">
	                     <input type="password" name="password" class="form-control" placeholder="密码" >
	                </div>
	                <div class="form-group">
	                     <input id="repassword" type="password" name="repassword" class="form-control" placeholder="再次确认密码" >
	                </div>
	                <div class="form-group" style="margin-top:50px">
	                     <input type="text" name="contact" class="form-control" placeholder="联系人" >
	                </div>
	                <div class="form-group">
	                     <input type="tel" name="mobile" class="form-control" placeholder="手机号" >
	                </div>
	                <div class="form-group">
	                     <input type="number" name="qq" class="form-control" placeholder="QQ" >
	                </div>
	                <div class="form-group">
	                     <div id="popup-captcha"></div>
	                </div>
	                <div class="form-group">
	                     <div class="checkbox i-checks"><label> <input id="claim" type="checkbox" checked="checked"><i></i> 已阅读并同意<a href="#">服务条款</a></label></div>
	                </div>
	                <button id="createAccount" type="submit" class="btn btn-primary block full-width m-b">创建</button>
	                <p class="text-muted text-center"><small>已有账号?</small></p>
	                <a class="btn btn-sm btn-white btn-block" href="${ctx}/login/">登录</a>
	            </form>
	        </div>
	</div>
	
    <div style="width: 700px;text-align: center;margin:0 auto"><p class="m-t"> <small>Copyright &copy; 2007-2014 PPLive Inc.上海聚力传媒技术有限公司 All Rights Reserved.</small> </p></div>	
    <!-- Mainly scripts -->
    <script src="${ctx}/js/jquery-2.1.1.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/bootstrapValidator.js"></script>
    <script src="${ctx}/js/gt.js"></script>
    <!-- iCheck -->
    <script src="${ctx}/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
            
			$('.i-checks>label,.iCheck-helper').on('click', function(){
				if($('.icheckbox_square-green').hasClass('checked')){
					$('#claim').attr('checked','checked');
					$('#createAccount').removeClass('disabled');
				}else{
					$('#claim').removeAttr('checked');
					$('#createAccount').addClass('disabled');
				}
			});
			
			if($('#claim').attr('checked')=='checked'){
            	$('#createAccount').removeClass('disabled');
            }else{
            	$('#createAccount').addClass('disabled');
			}
			
			//validate
			$('#registerForm').bootstrapValidator({
				 live: 'disabled',//当表单验证不通过时，阻止submit按钮变为disable
		         message: 'This value is not valid',
		         feedbackIcons: {
		             valid: 'glyphicon glyphicon-ok',
		             invalid: 'glyphicon glyphicon-remove',
		             validating: 'glyphicon glyphicon-refresh'
		         },
		         // 注意，fields以字段的名称，即name属性为校验基准
		         fields: {
		             teamName: {
		                 validators: {
		                     notEmpty: {
		                         message: '公司/团队名称为必填字段，不能为空'
		                     }
		                 }
		             },
		             email: {
		                 validators: {
		                     notEmpty: {
		                        message: '邮箱为必填字段，不能为空'
		                     },
		                     emailAddress: {
		                        message: '邮箱格式不正确'
		                     },
		                     remote: {
	                            url: "${ctx}/oauth?"+$("input[type=email][name=email]").val(),
	                            message: '邮箱已被注册',
	                            delay:1000
	                        }
		                 }
		             },
		             password: {
		                 validators: {
		                     notEmpty: {
		                         message: '密码为必填字段，不能为空'
		                     },
		                     stringLength: {
		                         min: 6,
		                         max: 15,
		                         message: '密码长度须大于6位，小于15位'
		                     },
		                     regexp: {
		                         regexp: /^[a-zA-Z0-9_\.]+$/,
		                         message: '密码只能是字母或数字构成，可包含._特殊字符'
		                     }
		                 }
		             },
		             repassword: {
		                 validators: {
		                 	 notEmpty: {
		                         message: '确认密码为必填字段，不能为空'
		                     },
		                     identical: {
		                         field: 'password',
		                         message: '所输入的确认密码与密码不一致'
		                     },
		                     stringLength: {
		                         min: 6,
		                         max: 15,
		                         message: '确认密码长度须大于6位，小于15位'
		                     }
		                 }
		             },
		             contact: {
		                 validators: {
		                     notEmpty: {
		                         message: '联系人为必填字段，不能为空'
		                     }
		                 }
		             },
		             mobile: {
		                 validators: {
		                     notEmpty: {
		                         message: '手机号码为必填字段，不能为空'
		                     }
		                     ,
		                     regexp: {
		                         regexp: /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/,
		                         message: '请输入有效的11位手机号码'
		                     }
		                 }
		             },
		             'qq': {
		                 validators: {
		                     notEmpty: {
		                         message: 'QQ为必填字段，不能为空'
		                     }
		                 }
		             }
		         }
		    })
			
            $("#createAccount").on('click', function(){
    			$("#registerForm").bootstrapValidator('validate');
				var validator = $("#registerForm").data('bootstrapValidator');
				var result = validator.isValid()
				if(!result){
					return false;
				}
				$("#registerForm").submit();
        	});
        });
    </script>
</body>
</html>
</html>