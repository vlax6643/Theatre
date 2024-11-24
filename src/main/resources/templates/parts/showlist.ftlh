<#macro showlist>
    <!-- Дополнительные стили для наложения и текстовых элементов -->
    <style>
        .card-custom {
            border-radius: 15px; /* Закругленные углы */
            overflow: hidden; /* Обрезка содержимого по углам */
            position: relative; /* Для позиционирования наложения и текста */
            width: 35rem; /* Увеличенная ширина карточки */
        }

        .card-custom img {
            height: 450px; /* Увеличенная высота изображения */
            object-fit: cover; /* Изображение заполняет область без искажений */
            width: 100%;
        }

        .card-custom .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.35); /* Затемнение на 35% */
            transition: background-color 0.3s ease;
        }

        .card-custom:hover .overlay {
            background-color: rgba(0, 0, 0, 0.45); /* Затемнение на 45% при наведении */
        }

        .card-custom .card-body {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            padding: 15px;
            background: transparent; /* Убираем белый фон */
            color: #fff; /* Белый текст */
            /* Добавляем тень для лучшей читаемости текста */
            text-shadow: 0 1px 3px rgba(0, 0, 0, 0.8);
        }

        .card-custom .card-title {
            margin-bottom: 5px;
            font-size: 1.25rem;
        }

        .card-custom .card-text {
            font-size: 0.9rem;
        }

        /* Стили для карточки при отсутствии спектаклей */
        .card-custom.no-shows .card-body {
            background: rgba(255, 255, 255, 1);
            color: #000;
            text-shadow: none;
        }

        .card-custom.no-shows .card-title,
        .card-custom.no-shows .card-text {
            color: #000;
        }
    </style>

    <div>
        <h3>Список спектаклей</h3>
    </div>
    <div class="form-group row">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" value="${filter!""}" class="form-control mr-2" placeholder="Название представления">
            <button type="submit" class="btn btn-primary">Найти</button>
        </form>
    </div>

    <div id="multiItemCarousel" class="carousel slide" data-ride="carousel" style="max-width: 1300px; margin: 0 auto;">
        <!-- Слайды -->
        <div class="carousel-inner">
            <#assign chunkSize = 3> <!-- Количество карточек на одном слайде -->
            <#list shows?chunk(chunkSize) as chunk>
                <div class="carousel-item <#if chunk?index == 0>active</#if>">
                    <div class="d-flex justify-content-center">
                        <#list chunk as show>
                            <div class="card mx-2 card-custom">
                                <a href="/shows/${show.id?c}" class="text-decoration-none text-dark">
                                    <#if show.filename??>
                                        <img src="/img/${show.filename}" alt="${show.title}">
                                    <#else>
                                        <img src="/img/placeholder.jpg" alt="${show.title}">
                                    </#if>
                                    <!-- Наложение для затемнения изображения -->
                                    <div class="overlay"></div>
                                </a>
                                <div class="card-body">
                                    <h5 class="card-title">${show.title}</h5>
                                    <p class="card-text mb-0">
                                        <strong>Длительность:</strong> ${show.duration} мин<br>
                                        <strong>Жанр:</strong> ${show.ganre}<br>
                                        <strong>Возрастное ограничение:</strong> ${show.ageRating}+
                                    </p>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </#list>
            <#if shows?size == 0>
                <div class="carousel-item active">
                    <div class="d-flex justify-content-center">
                        <div class="card mx-2 card-custom no-shows">
                            <img src="/img/placeholder.jpg" alt="Нет доступных спектаклей">
                            <div class="card-body text-center">
                                <h5 class="card-title">Нет доступных спектаклей</h5>
                                <p class="card-text">Пожалуйста, загляните позже для обновлений.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </#if>
        </div>

        <!-- Управление -->
        <a class="carousel-control-prev" href="#multiItemCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Предыдущий</span>
        </a>
        <a class="carousel-control-next" href="#multiItemCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Следующий</span>
        </a>
    </div>

    <!-- Подключение необходимых JS для Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</#macro>
