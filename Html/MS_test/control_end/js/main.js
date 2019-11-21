$(document).ready(function(){
  var p = false
  var hide = 500
  var show = 1000
  var a = $('.page-1')
  var b = $('.page-2')
  var btn = $('.btn')

  btn.click(function(){
    if(p){
      b.hide(hide)
      a.fadeIn(show)
      p = !p
      return
    }
    a.hide(hide)
    b.fadeIn(show)
    p = !p
  })

})
