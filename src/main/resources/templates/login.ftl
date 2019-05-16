<#import "parts/base.ftl" as b>
<#import  "parts/logOrReg.ftl" as l>
<@b.page>
<!--
        <form action="login" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" value="Sign In"/></div>
        </form>
        -->
<@l.login "/login" false/>
</@b.page>