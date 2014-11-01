
function runTransform(transform){

    document.location = '/transform/run?filename=' + transform;
}

function setIconPosition(){
    var divs = $(".step");
    var topOffset = 150;
    var leftOffset = window.innerWidth / 2;


    divs.each(function(i) {
        var top = topOffset + (i * 100);
        $(this).css("position", "absolute");
        $(this).css("top", top + "px");
        $(this).css("left", leftOffset + "px");
    } );

     $("#parent").css("height", divs.length * 100 + 100);
}


