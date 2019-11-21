$(document).ready(function(){
  $(".box").mouseover(function(){
    $(this).children("p,h3").addClass("hover")
  })
  $(".box").mouseout(function(){
    $(this).children("p,h3").removeClass("hover")
  })
  $(".box").on("click",function(){
    $(this).next().slideToggle(500)
  })
  $(".close").on("click",function(){
    $(this).parent().slideUp(500)
  })
  $("#top").on("click",function() {
    // $("html,body").scrollTop(0);
    $("html,body").animate({scrollTop:0},100)
  })
})
