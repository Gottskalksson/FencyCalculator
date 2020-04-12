$(function () {
    var button = $("#button");
    var result = $("#result");
    var selectUnit = $("#unit");

    button.on("click", function () {
        result.css("visibility", "visible");
    });

    selectUnit.on("click", function () {
        if (selectUnit.val() === "meter") {
            $("#fencyList").val();
        } else {
            console.log("stopa");
        }
    });
});