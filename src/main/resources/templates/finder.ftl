<#import "parts/base.ftl" as b>
<@b.page>
<div class="container blackbg rounded">
    <br/>
<div class="row mt-3">
    <div class="col"></div>
    <div class="col"><h1 class="text-center">Finder</h1></div>
    <div class="col"></div>
</div>
<div class="row mt-4">
    <div class="col-4">
        <h2>Game</h2>
        <form method="post">
            <div class="form-group">
                <label for="exampleFormControlSelect1">Game</label>
                <select class="form-control" id="exampleFormControlSelect1" name="gameName">
                             <option></option>
                         <#list gamesToAdd as g>
                             <option>${g}</option>
                         </#list>

                </select>
                <div class="mt-3"><label for="exampleFormControlSelect1">Approximate skill</label></div>
                <select class="form-control" id="exampleFormControlSelect1" name="skill">
                    <option></option>
                    <option>Retard</option>
                    <option>Noob</option>
                    <option>Medium</option>
                    <option>Pro</option>
                    <option>Cyborg</option>
                </select>

            </div>

    </div>
    <div class="col-4 border-left border-right border-white">
        <h2>Person</h2>
        <label for="exampleFormControlSelect1">Age</label>

        <div class="row">
            <div class="col">
                <input type="text" name="oldFrom" value=""
                       class="form-control"
                       placeholder="From" />
            </div>
            <div class="col">
                <input type="text" name="oldTo" value=""
                       class="form-control"
                       placeholder="To" />
            </div>
        </div>

        <div class="mt-3"><label for="exampleFormControlSelect1 ">Gender</label></div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="M" name="male">
            <label class="form-check-label" for="inlineCheckbox1"><i class="fas fa-mars fa-2x"></i></label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="F" name="female">
            <label class="form-check-label" for="inlineCheckbox2"><i class="fas fa-venus fa-2x"></i></label>
        </div>

    </div>
    <div class="col-4">
        <h2>Find by name</h2>
        <label for="exampleFormControlSelect1">Name</label>
            <input type="text" name="username" value=""
                   class="form-control"
                   placeholder="NickName" />

    </div>
    </div>
    <div class="row mt-3 mb-3">

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="col"><input type="submit" class="btn btn-dark btn-lg btn-block" value="Find"/></div>

    </div>
    <div class="row"></div>
    </form>

</div>
<div class="card-columns" id="user-list">
    <#if users??>
    <#list users as user>
        <#if !(me.id==user.id)>
        <div class="card my-3 blackbg">
        <#if user.ava??>
        <img src="/img/${user.ava}" class="card-img-top cardImg" />
        </#if>
            <div class="m-2">
                <#if user.old??>
                <span>Age: ${user.old}</span>
                </#if>
                <#if user.sex??><#if user.sex><i class="fas fa-mars fa-2x ml-2"></i><#else><i class="fas fa-venus fa-2x ml-2"></i></#if></#if>
            </div>
            <div class="card-footer text-muted container">
                <div class="row">
                    <a class="col align-self-center" href="/user/${user.id}" ><h4>${user.username}</h4></a>
                </div>
            </div>
        </div>
        </#if>
    </#list>
    </#if>
</div>



</@b.page>