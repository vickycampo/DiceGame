class myAjaxClass
{
     /*

     1.- A client event occurs.
     2.- An XMLHttpRequest object is created.
     3.- The XMLHttpRequest object is configured.
     4.- The XMLHttpRequest object makes an asynchronous request to the Webserver.
     5.- The Webserver returns the result containing XML document.
     6.- The XMLHttpRequest object calls the callback() function and processes the result.
     7.- The HTML DOM is updated.

     */
     constructor ( )
     {
          this.ajaxRequest;  // The variable that makes Ajax possible!
          //2. An XMLHttpRequest object is created.
          this.createRequestObj = function ()
          {
               try
               {
                    // Opera 8.0+, Firefox, Safari
                    this.ajaxRequest = new XMLHttpRequest();
               }
               catch (e)
               {
                    // Internet Explorer Browsers
                    try
                    {
                         this.ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
                    }
                    catch (e)
                    {

                         try
                         {
                              this.ajaxRequest = new ActiveXObject( "Microsoft.XMLHTTP" );
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
          this.configureRequesObj = function ( method , url , body )
          {
               /*
                    Methods:"GET", "POST", "PUT", "DELETE"
                    async: default true.
                          - false: does not return until the response is received
                          - true: a completed transaction is provided using event listeners
               */
               // Here processRequest() is the callback function.
               this.ajaxRequest.onreadystatechange = this.processRequest (this.ajaxRequest);
               this.ajaxRequest.open( method , url );
               this.ajaxRequest.send( body );
          }
          this.processRequest = function ( )
          {
               //The request is completed.
               console.log ( this.ajaxRequest );
               if (this.ajaxRequest.readyState == 4)
               {
                    //DONE: 200
                    if (this.ajaxRequest.status == 200)
                    {
                         if(this.ajaxRequest.readyState == this.ajaxRequest.HEADERS_RECEIVED)
                         {
                              // Get the raw header string
                              var headers = this.ajaxRequest.getAllResponseHeaders();
                              // Convert the header string into an array
                              // of individual headers
                              var arr = headers.trim().split(/[\r\n]+/);
                              // Create a map of header names to values
                              var headerMap = {};
                              arr.forEach(function (line)
                              {
                                   var parts = line.split(': ');
                                   var header = parts.shift();
                                   var value = parts.join(': ');
                                   headerMap[header] = value;
                              });
                              var contentType = headerMap["content-type"];
                              console.log (contentType);
                         }
                    }
               }
          }
     };
};
