<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group">
            <label class="col-sm2 col-form-label"> User Name : </label>
            <div class="col-sm-5">
            <input type="text" name="username" class="form-control" placeholder="User name"/>
            </div>
           </div>
        <div class="form-group">
            <label> Password: </label>
            <div class="col-sm-5">
            <input type="password" name="password"  class="form-control" placeholder="password"/>
            </div>
            </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <#if !isRegisterForm ><a href="/registration">Add new user</a></#if>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Sign out</button>
    </form>
</#macro>