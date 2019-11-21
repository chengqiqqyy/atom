$(document).ready(function(){

  var bt = $('#btn1')
  var btn = $('#btn')
  var content = $('.contents')

  var page = 1
  var anime = ['upToDown_left','rightTop','upToDown_right']

  $('#btn1').click(function(){
    $('#box').addClass('ltr1')
  })
  $('#btn2').click(function(){
    $('#box').addClass('ltr2')
  })
  $('#btn3').click(function(){
    $('#box').addClass('trans1')
  })
  $('#btn4').click(function(){
    $('#box').addClass('trans2')
    $('#box2').addClass('trans2')
  })
  $('#btn5').click(function(){
    $('#box').addClass('trans3')
  })
  $('#btn6').click(function(){
    $('#text').show()
    $('#text').addClass('popout')
  })

  // var a = 1
  // $('#btn7').click(function(){
  //   if(a == 1){
  //     $('#text').removeClass('shack2')
  //     $('#text').addClass('shack1')
  //     a = -a
  //   }else{
  //     $('#text').removeClass('shack1')
  //     $('#text').addClass('shack2')
  //     a = -a
  //   }
  // })

  $('#btn7').bind('click',function(event){
    $('#text').css('animation','shack1 0.5s')
  })
  $('#text').bind('animationend',function(){
    if($(this).hasClass('popout')){
      $(this).removeClass('popout')
    }
    $(this).css('animation','')
  })

  var a = 0
  $('#btn8').click(function(){
    let box = $('#box3')
    if(a == 0){
      box.animate({left:'200px'},'slow','swing')
    }else if(a == 1){
      box.animate({},function(){
        box.css({'transform':'rotate(45deg)','transition-duration':'0.5s'})
      })
    }
    else if (a == 2) {
      box.animate({},function(){
        box.css({'transform':'rotateY(45deg) rotate(45deg)','transition-duration':'0.5s','perspective':'1000px'})
      })
    }

    a += 1
    box.css('animation','')
    // alert(a)
  })


  //index.html
  btn.click(function(){
    if(page == 4){
      content.animate({left:'0px',top:'0px'},'slow')
      page = 0
    }
    if(page == 1){
      content.animate({left:'0px',top:'-300px'},'slow')
    }else if(page == 2){
      content.animate({left:'-300px',top:'0px'},'slow')
    }else if(page == 3){
      content.animate({left:'-300px',top:'-300px'},'slow')
    }
    page += 1
  })

})
