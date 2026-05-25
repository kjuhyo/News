<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>뉴스 카테고리 선택</title>
    <link rel="stylesheet" href="/css/home.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>

<body>

<div class="container">
    <h1>뉴스 카테고리 선택</h1>
    <div id="categoryBox" class="category-box">
    </div>
</div>

<script>
    $(document).ready(function () {
        $.ajax({
            url: "/api/categories",
            type: "GET",
            dataType: "json",

            success: function (data) {
                const $box = $("#categoryBox");
                $box.empty();

                if (!data || data.length === 0) {
                    $box.text("등록된 카테고리가 없습니다.");
                    return;
                }

                $.each(data, function (i, cat) {

                    const $btn = $("<button></button>")
                        .addClass("category-btn")
                        .text(cat.name)
                        .attr("data-id", cat.id)
                        .attr("data-rss", cat.rssUrl);

                    $btn.on("click", function () {
                        $(".category-btn").removeClass("active");
                        $(this).addClass("active");

                        if (cat.id) {
                            location.href = "/news?categoryId=" + cat.id;
                        }
                    });

                    $box.append($btn);
                });
            },

            error: function () {
                alert("카테고리 조회 에러가 발생 했습니다.")
            }
        });

    });
</script>

</body>
</html>