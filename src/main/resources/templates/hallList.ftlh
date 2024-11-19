
<#import "parts/common.ftlh" as c>
<@c.page>
    <div>Список залов:</div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Назввание</th>
            <th>Вместительность</th>
        </tr>
        </thead>
        <tbody>
        <#list halls as hall>
            <tr>
                <td>${hall.id}</td>
                <td>${hall.name}</td>
                <td>${hall.seatCapacity}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>