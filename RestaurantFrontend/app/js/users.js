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
            $("#userList").html("Działam hahaha!");
        }).fail(function (res) {
            $("#userList").html("Jeszcze nie działam, bo Maciek nie dał mi endpointa 😢");
        });
    };

    getUserList();
})