
/* ===========index/types/tags/blogs/=============== */

$('.m-toggle').click(function () {
    $('.m-hide-side').toggleClass('m-mobile-show')
})
// $('.m-x').click(function () {
//     $('.m-hide-side').toggleClass('m-mobile-show')
// })
$('#toTop-btn').click(function () {
    $(window).scrollTo(0, 500);
})
$('.about-down').click(function () {
    ap.play();
    $.scrollTo('.about-music', 500);
})
$('.about-music-up').click(function () {
    $(window).scrollTo(0, 500);
})
$('.about-music-down').click(function () {
    $.scrollTo('.about-duu', 500);
})
