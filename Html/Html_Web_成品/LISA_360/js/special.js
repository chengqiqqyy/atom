$(document).ready(function() {
  $(".photos").iziModal({
    iframe: true,
    iframeURL: "images.html",
    iframeHeight: 620,
    width: 980,
  })
  $(document).on('click', '.albums', function (event) {
    event.preventDefault()
    $('.photos').iziModal('open',this)
  })
})
