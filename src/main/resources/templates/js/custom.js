function currentTime() {
    var date = new Date(); /* creating object of Date class */
    var hour = date.getHours();
    var min = date.getMinutes();
    var sec = date.getSeconds();
    if (min<10) min='0'+min;
    if(sec<10) sec='0'+sec;

    document.getElementById("time").innerText = hour + " : " + min + " : " + sec; /* adding time to the div */
    setTimeout(function(){ currentTime() }, 1000); /* setting timer */
}