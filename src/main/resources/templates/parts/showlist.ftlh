<#macro showlist>
    <div>
        <h3>Список спектаклей</h3>
    </div>
    <div class="form-group row">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" value="${filter!""}" class="form-control" placeholder="Название представления">
            <button type="submit" class="btn btn-primary ml-2">Find</button>
        </form>
    </div>

    <!-- Контейнер для горизонтального слайдера -->
    <div class="d-flex overflow-auto" style="gap: 1rem;">
        <#list shows as show>
            <div class="card" style="width: 18rem; flex: 0 0 auto;">
                <a href="/shows/${show.id}" class="text-decoration-none text-dark">
                    <#if show.filename??>
                        <img src="/img/${show.filename}" class="card-img-top" alt="${show.title}">
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">${show.title}</h5>
                        <p class="card-text">
                            <b>Длительность:</b> ${show.duration} мин<br>
                            <b>Жанр:</b> ${show.ganre}<br>
                            <b>Возрастное ограничение:</b> ${show.ageRating}+
                        </p>
                    </div>
                </a>
            </div>
        <#else>
            <div>No shows</div>
        </#list>
    </div>
</#macro>
