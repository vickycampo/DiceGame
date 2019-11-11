
/*

1.- A client event occurs.
2.- An XMLHttpRequest object is created.
3.- The XMLHttpRequest object is configured.
4.- The XMLHttpRequest object makes an asynchronous request to the Webserver.
5.- The Webserver returns the result containing XML document.
6.- The XMLHttpRequest object calls the callback() function and processes the result.
7.- The HTML DOM is updated.

*/

//2. An XMLHttpRequest object is created.
function createRequestObj()
{
     try
     {
          // Opera 8.0+, Firefox, Safari
          ajaxRequest = new XMLHttpRequest();
     }
     catch (e)
     {
          // Internet Explorer Browsers
          try
          {
               ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
          }
          catch (e)
          {

               try
               {
                    ajaxRequest = new ActiveXObject( "Microsoft.XMLHTTP" );
               }
               catch (e)
               {
                    // Something went wrong
                    alert( "Your browser broke!" );
                    return false;
               }
          }
     }

}
//3.- The XMLHttpRequest object is configured.
function configureRequesObj ( method , url , body , triggerFunction)
{
     /*
          Methods:"GET", "POST", "PUT", "DELETE"
          async: default true.
                - false: does not return until the response is received
                - true: a completed transaction is provided using event listeners
     */
     // Here processRequest() is the callback function.
     url = "http://localhost:8080" + url;

     ajaxRequest.onreadystatechange = function ()
     {
          if (this.readyState == 4 && this.status == 200)
          {
               jsonObj = null;
               jsonObj = JSON.parse( this.response );
               eval ( triggerFunction );
          }
     };
     ajaxRequest.open( method , url );
     ajaxRequest.setRequestHeader("Content-Type", "application/json");
     ajaxRequest.send( body );
}
