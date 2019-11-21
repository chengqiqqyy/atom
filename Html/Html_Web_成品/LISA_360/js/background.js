
$(document).ready(function(){

  if(!Modernizr.csstransitions){
    $("#content").delay(5000).animate({right:"-10px", opacity: "0.8"},5000,"easeInOutQuad");
  }

  $('.fsb-slider').fsbslider({"animation_time":20,"animation_type":"crossfade","pattern":10});

});
