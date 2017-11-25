
$(function () {
    function getUserList() {
        $.ajax({
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*"
            },
            contentType: "application/json; charset=utf-8",
            url: "//localhost:8888",
        }).done(function (res) {
            $("#dishList").html("Działam hahaha!");
        }).fail(function (res) {
            $("#dishList").html("A ja to w ogóle leżę i nie działam");
        });
    };

    getUserList();
})