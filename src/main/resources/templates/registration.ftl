<#import "parts/common.ftl" as htmlBase>
<#import "parts/login.ftl" as loginBase>

<@htmlBase.page>
Add new user
<!--message-->
    ${message}
<@loginBase.login "/registration" />
<!--<form action="/registration" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
    <div><input type="submit" value="Sign In"/></div>
</form>-->
</@htmlBase.page>