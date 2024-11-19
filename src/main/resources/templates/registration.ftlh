<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
Add new user
    <#if message??>
        <div>${message}</div>
    </#if>
<@l.login "/registration" true/>
</@c.page>