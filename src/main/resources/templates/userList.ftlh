
<#import "parts/common.ftlh" as c>
<@c.page>
    <div>Список пользователей:</div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Имя пользователя</th>
            <th>Роли</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td>
                    <form action="/user/deleteUser" method="post" style="display:inline;">
                        <input type="hidden" name="userId" value="${user.id}" />
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit">Delete</button>

                    </form>
                    <button onclick="location.href='/user/${user.id}'">Edit</button>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>