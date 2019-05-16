<#macro login path isRegister>
    <form action="${path}" method="post">
        <div  class="form-group">
            <label for="exampleInputName1"> User Name : </label>
            <input type="text" class="form-control" id="exampleInputName1" aria-describedby="emailHelp" placeholder="User name" name="username"/>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1"> Password: </label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
        </div>
        <#if isRegister>
            <div class="form-group">
                <label for="exampleInputPassword1"> Confirm password : </label>
                <input type="password" name="password2" class="form-control" id="exampleInputPassword1" placeholder="Retype password"/>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1"> E-mail : </label>
                 <input type="email" name="email" class="form-control" id="exampleInputPassword1" placeholder="expample@ex.com"/>
             </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input class="btn btn-dark" type="submit" value="<#if isRegister>Registration<#else>Sign In</#if>"/></div>
    </form>

</#macro>