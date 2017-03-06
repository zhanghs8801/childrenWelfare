<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${ctx}/css/animate.css" rel="stylesheet">
    <link href="${ctx}/css/style.css" rel="stylesheet">
</head>

<body class="gray-bg">
	<div>
		<h1 class="logo-name" style="text-align: center;padding-top:40px">PPTV VIP+</h1>
    </div>
    <div style="width: 700px;margin:0 auto;"><h3 style="line-height: 26px;">欢迎使用PPTV VIP+，我们将为您提供详细的VIP合作项目数据，如果您遇到问题，请邮件至eraseryuan@pptv.com</h3></div>
    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <form class="m-t" role="form" method="post">
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="请输入登录邮箱" required>
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="请输入密码" required>
                </div>
                <div style="color: red;padding-bottom: 10px;">${message}</div>
                <button type="submit" class="btn btn-primary block full-width m-b">登录</button>

                <a href="#" class="text-right" style="display: block;width: 100%;"><small>忘记密码？</small></a>
                <p class="text-muted text-left"><small>如果您还没有账号</small></p>
                <a class="btn btn-sm btn-white btn-block" href="${ctx}/register/">创建账号</a>
            </form>
        </div>
    </div>
	<div style="width: 700px;text-align: center;margin:0 auto"><p class="m-t"> <small>Copyright &copy; 2007-2014 PPLive Inc.上海聚力传媒技术有限公司 All Rights Reserved.</small> </p></div>
    <!-- Mainly scripts -->
    <script src="${ctx}/js/jquery-2.1.1.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
</body>
</html>