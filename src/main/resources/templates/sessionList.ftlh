
<#import "parts/common.ftlh" as c>
<@c.page>
    <h2>Sessions List</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Show</th>
            <th>Date</th>
            <th>Hall</th>
            <th>Available Seats</th>
        </tr>
        </thead>
        <tbody>
        <#list sessions as session>
            <tr>
                <td>${session.id}</td>
                <td>${session.show.title}</td>
                <td>${session.date?string("yyyy-MM-dd HH:mm")}</td>
                <td>${session.hall.name}</td>
                <td>${session.availableSeats}</td>

            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>