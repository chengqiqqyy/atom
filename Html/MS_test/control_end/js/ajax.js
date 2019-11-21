function ajaxx(url,success,error){
  var xhr = new XMLHttpRequest();
  xhr.open('POST',url,true)
  xhr.send()
  xhr.onreadystatechange = function(e){
    if(xhr.readyState === 4){
      if(xhr.status >=200 && xhr.status < 300 || xhr.status === 304){
        // console.log('Connect success!!')
        success(xhr);
      }else{
        // console.log('Connect fail!!')
        error(xhr);
      }
    }
  }
}
