function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

function setCookie(cname, cvalue, expired) {
  var now = new Date();
  var time = now.getTime();
  var expireTime = time + 1000*expired;
  now.setTime(expireTime);
  document.cookie = cname+'='+cvalue+';expires='+now.toUTCString()+';path=/';
}

function deleteCookie(){
  document.cookie = "token=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
  document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
  document.cookie = "role=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}

function logout(){
  deleteCookie();
  document.location.href = "http://localhost:8080/WebSach/dangnhap";
}

function refreshToken(){
    if(getCookie("refreshToken")==''){
      document.location.href = "/html/login.html";
    }
    else{
      let refresh = {
        "refreshToken" : getCookie("refreshToken")
    }
      $.ajax({
        headers : {
          'Accept' : 'application/json',
          'Content-Type' : 'application/json'
        },
        type : "POST",
        url : "http://localhost:3000/api/v1/auth/refresh-token",
        data : JSON.stringify(refresh),
        success : function(result){
            console.log(result.data.accessToken)
            setCookie("token",result.data.accessToken,900);
        }
    })
    }
}

