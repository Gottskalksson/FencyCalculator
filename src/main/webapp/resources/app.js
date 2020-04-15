$(function () {
    var button = $("#button");
    var fencyForm = $("#fencyForm");
    var app = $("#app");

    function apiCall(method, path, data) {
        var settings = {
            method: method,
            url: "http://localhost:8080" + path,
            contentType: "text"
        };
        if (data) {
            settings.data = JSON.stringify(data);
        }
        return $.ajax(settings);
    }


    function handlingForm() {
        fencyForm.on("submit", function (e) {
            e.preventDefault();
            app.css("visibility", "visible");
        });
    }

    handlingForm();

});