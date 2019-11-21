$(document).ready(function() {
  $(window).on('scroll', function() {
    var scrollTop = $(document).scrollTop();
    var menu = $("#menu");
    var items = $(".contents").find(".item");
    var currentId = "";

    items.each(
      function() {
        var im = $(this);
        var itemTop = im.offset().top;
        //console.log(itemTop);
        if (scrollTop > (itemTop - 188)) {
          currentId = "#" + im.attr("id");
        } else {
          return false;
        }
      });

      var currentLink = menu.find(".current");
      if (currentId && currentLink.attr("href") != currentId) {
        currentLink.removeClass("current");
        menu.find("a[href=" + currentId + "]").addClass("current");
      }
    })
    var $a = $("a[href*='item']");
    /*            $a[1].onclick=function(){
    console.log('123');
  }*/
  $a.each(
    function() {
      console.log(this);
      $(this).on('click',
      function() {
        $('html,body').animate({
          scrollTop: $($.attr(this, 'href')).offset().top
        }, 500);
        return false;
      })
    }
  )
});




// $('.2013').on('click',
// function() {
//   $('html,body').animate({
//     scrollTop: $('#2013').offset().top
//   }, 500);
//   return false;
// })
