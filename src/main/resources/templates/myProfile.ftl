<#import "parts/base.ftl" as b>
<@b.page>

<div>
    <div class="container mb-7">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <#if user.ava??>
                    <img src="/img/${user.ava}" class="rounded float-left myImg">
                </#if>
            </div>
            <div class="col"></div>
        </div>
    <#if user.old??>
        <div class="row mt-3">
            <div class="col"></div>
            <div class="col-6">
                <div>
                    <h4 class="text-justify">Age: ${user.old}
                        <#if user.sex??>
                            <#if user.sex><i class="fas fa-mars fa-2x ml-2"></i><#else><i class="fas fa-venus fa-2x ml-2"></i></#if>
                        </#if>
                    </h4>
                </div>
            </div>
            <div class="col"></div>
        </div>
        </#if>
    <#if user.about??>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <div><h5 class="text-justify">About me: ${user.about}</h5></div>
            </div>
            <div class="col"></div>
        </div>
    </#if>
        <#if user.games??>
        <div class="row mt-3">
            <div class="col"></div>
            <div class="col-6">
                <div><h5 class="text-justify">${user.username} plays: </h5></div>
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <div class="list-group-6">

                    <ul class="list-group list-group-horizontal-xl">
                        <#list user.games as game >
                            <li class="list-group-item blackbg">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <span class="text-primary">${game.gameName}</span>
                                        </div>
                                        <div class="col">
                                            <span class="text-light">${game.skill}</span>
                                        </div>
                                        <div class="col">
                                            <span class="text-secondary">${game.experience} years</span>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </#list>

                    </ul>


                </div>

            </div>
            <div class="col"></div>
        </div>
        </#if>



        <#if isMyProfile>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <a class="btn btn-dark mt-2" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                    Add Game
                </a>
                <div class="collapse" id="collapseExample">
                    <h1>Add Game</h1>
                    <form method="post">
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Game</label>
                            <select class="form-control" id="exampleFormControlSelect1" name="gameName">
                         <#list gamesToAdd as g>
                             <option>${g}</option>
                         </#list>
                            </select>
                            <div class="mt-3"><label for="exampleFormControlSelect1">Your approximate skill</label></div>
                            <select class="form-control" id="exampleFormControlSelect1" name="skill">
                                <option>Retard</option>
                                <option>Noob</option>
                                <option>Medium</option>
                                <option>Pro</option>
                                <option>Cyborg</option>
                            </select>
                            <div class="mt-3"><label for="exampleFormControlSelect1 mt-2">Your experience in this game in years</label></div>
                            <select class="form-control" id="exampleFormControlSelect1" name="experience">
                                <option>0</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <div class="col-sm-6 mt-3"><input type="submit" class="btn btn-dark btn-bg" value="Save"/></div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col"></div>
        </div>
        </#if>
        <#if user.voiceChats??>
        <div class="row mt-5">
            <div class="col"></div>
            <div class="col-6">
                <div><h5 class="text-justify">${user.username} communicates via: </h5></div>
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <div class="list-group-6">

                    <ul class="list-group list-group-horizontal-xl">
                        <#list user.voiceChats as voice >
                            <li class="list-group-item blackbg">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <span class="text-light">${voice.voiceName}</span>
                                        </div>
                                        <div class="col">
                                        </div>
                                        <div class="col">
                                            <span class="text-primary">${voice.nick}</span>
                                        </div>

                                    </div>
                                </div>

                            </li>
                        </#list>
                    </ul>


                </div>

            </div>
            <div class="col"></div>
        </div>
        </#if>
    <#if isMyProfile>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <a class="btn btn-dark mt-2" data-toggle="collapse" href="#collapseExample1" role="button" aria-expanded="false" aria-controls="collapseExample1">
                    Add Voice
                </a>
                <div class="collapse" id="collapseExample1">
                    <h1>Add Voice Chat</h1>
                    <form method="post" >
                        <div class="form-group">
                            <select class="form-control" id="exampleFormControlSelect1" name="gameVoice">
                         <#list voicesToAdd as g>
                             <option>${g}</option>
                         </#list>
                            </select>
                            <div class="mt-3">
                                <input type="text" name="nick"
                                       class="form-control"
                                       placeholder="Your nick in this voice chat" />
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <div class="col-sm-6 mt-3"><input type="submit" class="btn btn-dark btn-bg" value="Save"/></div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col"></div>
        </div>
    <div class="row mt-2">
        <div class="col"></div>
        <div class="col-6">
            <a href="/user/${user.id}/edit" class="text-primary">Edit profile</a>
        </#if></div>
        <div class="col"></div>
    </div>
    </div>
</div>
<br/>
<br/>
</@b.page>