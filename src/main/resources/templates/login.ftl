<#import "parts/common.ftl" as htmlBase>
<#import "parts/login.ftl" as loginBase>

<@htmlBase.page>
Login page
<@loginBase.login "/login" />
<a href="/registration">Registration</a>
</@htmlBase.page>