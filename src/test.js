$(function () {
    
    //functionの引数にfunctionを渡さないといけない。
    
    $("#dialogButton").click(function () {
        /* 必要なときに、必要なdiv要素を生成して、利用する */
        var x = $("<div></div>").dialog({
            autoOpen: false
        });
        /* ダイアログの中身は、どこかから取ってきたり、べた書きしたり */
        x.html('<div class="message">message</h1>');
        /* ダイアログのオプションを設定して */
        x.dialog("option", {
            title: "ダイアログのタイトル",
            width: 300,
            height: 200,
            modal: true,
            resizable : false,
            draggable : false, // ドラッグできないようにする。
            buttons: {
                "OK": function () {
                    $(this).dialog("close");
                }
            }
        }).prev(".ui-dialog-titlebar").css("background","#2E2EFE");
        /* ダイアログを開きます */
        x.dialog("open");
    });
});
