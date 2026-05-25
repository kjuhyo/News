<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>실시간 뉴스 피드</title>
    <link rel="stylesheet" href="/css/news.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<header class="top-bar">
    <a href="/home" class="home-btn">
        ← 홈으로 돌아가기
    </a>
</header>
<div class="news-container">
    <h1>${categoryName}</h1>
    <main id="newsBox" class="news-grid"></main>
</div>

<template id="newsTemplate">
    <article class="news-card">
        <div class="card-content">
            <h2 class="card-title">
                <a href="#" target="_blank" rel="noopener noreferrer" class="news-link"></a>
            </h2>
            <p class="card-description"></p>
            <div class="card-footer">
                <span class="news-creator"></span>
                <span class="news-read"></span>
            </div>
            <span class="news-date"></span>
        </div>
    </article>
</template>
</body>
<script>
    $(document).ready(function() {
        $.ajax({
            url: "/api/news/${categoryId}",
            type: "GET",
            success: function(data) {
                const $newsBox = $("#newsBox");
                const $template = $("#newsTemplate").prop("content");

                $.each(data, function(index, news) {
                    const $clone = $($template).clone();

                    $clone.find(".news-link").addClass("news-click").attr("href", news.link || "#").text(news.title || "제목 없음");
                    $clone.find(".card-description").text(news.description || "내용이 없습니다.");
                    $clone.find(".news-creator").text(news.creator ? news.creator +" 기자" : "편집부");
                    $clone.find(".news-read").text(news.isRead === true ?  "읽음" : "읽지 않음").toggleClass("is-read", news.isRead);
                    $clone.find(".news-date").text(news.pubDate || "");

                    $newsBox.append($clone);
                });
            },
            error: function () {
                $("#newsBox").text("뉴스를 불러올 수 없습니다.");
            }
        });
    });

    $(document).on("click", ".news-click", function(e) {
        e.preventDefault();

        const $card = $(this).closest(".news-card");
        const $read = $card.find(".news-read");
        $read.text("읽음").toggleClass("is-read", true);

        const url = $(this).attr("href");
        window.open(url, "_blank");

        const articleId = url.substring(url.lastIndexOf("/") + 1);

        $.ajax({
            url: "/api/news/read",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                articleId: articleId
            }),
            success: function() {},
            error: function() {}
        });
    });
</script>
</html>