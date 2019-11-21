$(document).ready(function(){

  $('button').click(function(){
    console.log($(window).width());
    console.log($(window).height());
  });

  $('#news').iziModal({
    iframe: true,
    iframeURL: "news.html",
    iframeHeight: 650,
    width: 970,
  });
  $(document).on('click','.news',function(event){
    event.preventDefault();
    $('#news').iziModal('open');
  });


  $('#modal2').iziModal({
    // title: "Profile",
    iframe: true,
    iframeHeight: 650,
    iframeURL: "biography.html",
    width: 990,
    group: 'group1'
  });

  $(document).on('click','.biography',function(event){
    event.preventDefault();
    $('#modal2').iziModal('open');
  });

  $('#modal7').iziModal({
    iframe: true,
    iframeHeight: 600,
    width: 1130,
    iframeURL: "photos.html",
    group: 'group1'
  });
  $(document).on('click','.photos',function(event){
    event.preventDefault();
    $('#modal7').iziModal('open');
  });
});
