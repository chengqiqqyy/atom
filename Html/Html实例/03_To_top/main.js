$(document).ready(function(){
  var top = $('#backtotop')

  // if($(this).scrollTop()==0) top.hide()

  $(window).scroll(function(){
    if($(this).scrollTop() <= 100){
      top.hide(200)
    }else {
      top.show(200)
    }
  })

  top.click(function(){
    $('html,body').animate({scrollTop:"0px"},500)
  })

})
