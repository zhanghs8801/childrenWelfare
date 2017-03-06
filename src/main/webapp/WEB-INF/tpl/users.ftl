<#assign ctx=request.contextPath />
<#list users as user>
  邮箱：${user.email}<br>
</#list>