$(function () {

    function _defaultDialogObj() {
                        /* 必要なときに、必要なdiv要素を生成して、利用する */
        var x = $("<div></div>").dialog({
            autoOpen: false
        });
//        /* ダイアログの中身は、どこかから取ってきたり、べた書きしたり */
//        x.html('<div class="message">messages</h1>');
        
        /* ダイアログのオプションを設定して */
        var defaultDialogObject = x.dialog("option", {
            title: "警告",
            width: 300,
            height: 200,
            modal: true,
            resizable : false,
            draggable : false
        });
        
        return defaultDialogObject;
    }
    /**
    *
    */
    function confirmDialog(message, callback) {
        
        
        var dialogObj = _defaultDialogObj();
        
        /* ダイアログの中身は、どこかから取ってきたり、べた書きしたり */
        dialogObj.html('<div class="message">' + message + '</h1>');
        
        dialogObj.dialog("option", {
            buttons: {
                "OK": function() {
                    $(this).dialog("close");
                    callback();
                },
                "キャンセル" : function() {
                    $(this).dialog("close");   
                }
            }
        });
        
        dialogObj.prev(".ui-dialog-titlebar").css("background","#CCDCFF");
        /* ダイアログを開きます */
        dialogObj.dialog("open");
    }
    
    
    $("#dialogButton").click(function () {
        var message = "本当に削除してもよろしいですか？";
        confirmDialog(message, function() {alert('aaaa');});
    });
});
