<#import "parts/base.ftl" as b>
<@b.page>
<h1>Edit your profile</h1>
    <form method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label class="col-sm-2 col-form-label">User Name</label>
            <div class="col-sm-6">
                <input type="text" name="username" value="<#if user.username??>${user.username}</#if>"
                       class="form-control"
                       placeholder="NickName" />
            </div>
            <label class="col-sm-2 col-form-label">Age</label>
            <div class="col-sm-6">
                <input type="text" name="old" value="<#if user.old??>${user.old}<#else></#if>"
                       class="form-control"
                       placeholder="Old" />
            </div>
            <label class="col-sm-2 col-form-label">E-mail</label>
            <div class="col-sm-6">
                <input type="email" name="email" value="<#if user.email??>${user.email}<#else></#if>"
                       class="form-control"
                       placeholder="Email" />
            </div>
            <label class="col-sm-2 col-form-label">Tell about yourself</label>
            <div class="col-sm-6">
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="4" name="about" ><#if user.about??>${user.about}<#else></#if></textarea>
            </div>
            <label class="col-sm-2 col-form-label mt-3">Gender</label>
            <div class="form-check mt-1">
                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="M"<#if user.sex??><#if user.sex>checked</#if></#if>>
                <label class="form-check-label" for="exampleRadios1">
                    <i class="fas fa-mars fa-2x"></i>
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="F" <#if user.sex??><#if !user.sex>checked</#if></#if>>
                <label class="form-check-label" for="exampleRadios2">
                    <i class="fas fa-venus fa-2x"></i>
                </label>
            </div>
            <label class="col-sm-2 col-form-label">Avatar</label>
            <div class="form-group col-sm-6">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile" />
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="col-sm-6"><input type="submit" class="btn btn-primary btn-bg" value="Save"/></div>
    </form>
</@b.page>