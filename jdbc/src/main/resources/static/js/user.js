class userClass  {
     constructor ( )
     {



          this.userName = "";
          this.userId = "";
          this.createUser = function ()
          {
               var myAjax = new myAjaxClass();
               var localURL = window.location.href;

               var method = "GET";
               var url = "/players/home";
               var body = "";

               myAjax.createRequestObj();
               myAjax.configureRequesObj( method , url , body );

               
          };
          this.deleteUser = function () {
               console.log ("Delete User");
          };
          this.addEvents = function ()
          {

               document.getElementById( 'manage-player__newPlayer' ).addEventListener( 'click' , this.createUser );
               document.getElementById( 'manage-player__deletePlayer' ).addEventListener( 'click' , this.deleteUser );

          }
     }

};
