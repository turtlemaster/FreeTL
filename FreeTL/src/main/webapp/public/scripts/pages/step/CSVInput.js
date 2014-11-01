   function submitForm() {

            document.getElementById("editForm").submit();


        }

function removeFieldType(id) {



    var current = $("#removedIds").val();
    if(current == "") {
        $("#removedIds").val(id);
    }
    else {
        $("#removedIds").val(current + "," + id);
    }
    $("#" + id).remove();

  }