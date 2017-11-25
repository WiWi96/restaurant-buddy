$(function () {
    function getUserList() {
        $.ajax({
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*"
            },
            contentType: "application/json; charset=utf-8",
            url: "//10.4.0.117:8080/admin/users",
        }).done(function (res) {
            $("#userList").html("Działam hahaha!");
        }).fail(function (res) {
            $("#userList").html("Jeszcze nie działam, bo Maciek nie dał mi endpointa 😢");
        });
    };

    getUserList();
})