<#import "parts/common.ftlh" as c>
<@c.page>
    <h1>Сеансы для "${show.title}"</h1>
    <div>
        <p>Длительность: ${show.duration} мин</p>
        <p>Жанр: ${show.ganre}</p>
        <p>Возрастное ограничение: ${show.ageRating}+</p>
    </div>
    <h2>Доступные сеансы</h2>
    <div>
        <#list sessions as session>
            <div>
                <p>Дата: ${session.date?string("yyyy-MM-dd HH:mm")}</p>
                <p>Зал: ${session.hall.name}</p>
                <p>Доступные места: ${session.hall.seatCapacity}</p>
                <a href="/order/${session.id?c}" class="btn btn-primary">Выбрать этот сеанс</a>
            </div>
        </#list>
    </div>
    <#if sessions?size == 0>
        <div>Нет доступных сеансов для этого спектакля</div>
    </#if>
</@c.page>

