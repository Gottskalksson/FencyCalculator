$(function () {
    var button = $("#button");
    var result = $("#result");
    var noLabourCheckbox = $("#noLabour");
    var labourRow = $("#labour");


    button.on("click", function () {
        result.css("visibility", "visible");
    });

    noLabourCheckbox.on("click", function () {
        // console.log("dziala");
        console.log(noLabourCheckbox.checked);
    })
});