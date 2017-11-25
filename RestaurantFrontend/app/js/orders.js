
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
            $("#orderList").html("Działam hahaha!");
        }).fail(function (res) {
            $("#orderList").html("Ja tutaj też nie działam :O");
        });
    };

    getUserList();
})