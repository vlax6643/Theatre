<#import "parts/common.ftlh" as c>
<@c.page>
    <h1>Manage Sessions</h1>

    <h2>Add New Session</h2>
    <form action="/session/addSession" method="post">
        <select name="showId" required>
            <#list shows as show>
                <option value="${show.id}">${show.title}</option>
            </#list>
        </select>
        <input type="datetime-local" name="date" required />
        <select name="hallId" required>
            <#list halls as hall>
                <option value="${hall.id}">${hall.name}</option>
            </#list>
        </select>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Add Session</button>
    </form>

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
                <td>
                    <form action="/session/delete" method="post">
                        <input type="hidden" name="sessionId" value="${session.id}" />
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>