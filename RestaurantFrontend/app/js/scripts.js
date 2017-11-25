$(function () {
    $("#nav").load("/nav.html", function () {
        $("[data-toggle='popover']").popover({
            "html": true,
            "content": $(".notification-list").html()
        })

        $(".notification-link").on("click", function (e) {
            $(this)
                .find(".badge")
                .removeClass("badge-primary")
                .addClass("badge-secondary")
                .html("0");
        });

        $(".notifications-dismiss").on("click", function (e) {
            e.stopPropagation();
            e.preventDefault();
            $(this).parent().find(".notifications").empty();
        })
    });
})