//reference to how I learned how to do this: https://www.the-art-of-web.com/javascript/setcookie/

var todayDate = new Date(); //sets today's date
var cookieExpiration = new Date(todayDate.getTime() + 7 * 24 * 3600 * 1000); //takes todays date and makes an expiration

//sets cookies
function setCookie(field, value) {

    document.cookie = field + "=" + escape(value) + "; path=/; expires=" + cookieExpiration.toGMTString();
}

function getCookie(inputField) {

    var field = (new RegExp(inputField + "=([^;]+)")).exec(document.cookie);
    return (field != null) ? unescape(field[1]) : null;
}

function storeFormValues(form) {

    setCookie("firstName", form.firstName.value);
    setCookie("lastName", form.lastName.value);
    setCookie("email", form.email.value);
    //if (selectionList.className = 3) setCookie("LastSelection", )
    console.log("Cookies are Saved");
    return true;
}

function expireCookie(field) {

    var expire = new Date(todayDate.getTime() - 24 * 3600 * 1000); //sets a time in the past to cause the cookie to instantly expire

    document.cookie = field + "null; path=/; expires=" + cookieExpiration.toGMTString();
}

function clearCookies() {

    expireCookie("firstName");
    expireCookie("lastName");
    expireCookie("email");
    alert("Previous information has been cleared");
    //console.log("Cookies are Cleared");
}