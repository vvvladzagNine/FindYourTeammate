<#import "parts/base.ftl" as b>
<#import "parts/logOrReg.ftl" as l>
<@b.page>
<!--
<form action="registration" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Email: <input type="text" name="email"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Registration"/></div>
</form>
-->
    <@l.login "/registration" true/>
</@b.page>