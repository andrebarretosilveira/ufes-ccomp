// Arquivo novo p/ trabalho

jQuery(document).ready(function($) {

    $(window).scroll(function() {
        if ($(document).scrollTop() > 50) {
            $('nav').addClass('shrink');
        } else {
            $('nav').removeClass('shrink');
        }
    });

    // Smoothscroll
    var $root = $('html, body');
    $('.nav a, .scroll-link').click(function() {
        $root.animate({
            scrollTop: $( $.attr(this, 'href') ).offset().top
        }, 500);
        return false;
    });
 
    $(document).on( 'scroll', function(){
 
        if ($(window).scrollTop() > 100) {
            $('.scroll-top-wrapper').addClass('show');
        } else {
            $('.scroll-top-wrapper').removeClass('show');
        }
    });
 
    $('.scroll-top-wrapper').on('click', scrollToTop);
 
    function scrollToTop() {
        verticalOffset = typeof(verticalOffset) != 'undefined' ? verticalOffset : 0;
        element = $('body');
        offset = element.offset();
        offsetTop = offset.top;
        $('html, body').animate({scrollTop: offsetTop}, 500, 'linear');
    }

    $('document').ready(function() {
        var maxWords = 12;
        var text;

        text = document.getElementById("desc1").innerHTML;
        document.getElementById("desc1").innerHTML = readMore(text, maxWords);
        text = document.getElementById("desc2").innerHTML;
        document.getElementById("desc2").innerHTML = readMore(text, maxWords);
        text = document.getElementById("desc3").innerHTML;
        document.getElementById("desc3").innerHTML = readMore(text, maxWords);
        text = document.getElementById("desc4").innerHTML;
        document.getElementById("desc4").innerHTML = readMore(text, maxWords);
    });

    function readMore(string, maxWords) {       
        var strippedString = $("<p>" + string + "</p>").text().trim();
        var array = strippedString.split(" ");
        var string = array.splice(0, maxWords).join(" ");

        //if(array.length > maxWords) {
            string += " (...)";
        //}

        return string ;
    }

});