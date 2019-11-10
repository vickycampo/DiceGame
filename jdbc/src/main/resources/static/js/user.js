class userClass  {
     constructor ( )
     {
          this.userName = "";
          this.userId = "";
          this.createUser = function () {
               alert ("Creating user");
          };
          this.deleteUser = function () {
               alert ("Delete User");
          };
          this.addEvents = function ()
          {
               document.getElementById( 'manage-player__newPlayer' ).addEventListener( 'click' , clickUserMenu );
               document.getElementById( 'manage-player__deletePlayer' ).addEventListener( 'click' , clickUserMenu );

          }
     }

};

/* Events functions */
function clickUserMenu(event)
{
     var id = event.target.id;
     console.log ( id );
     if ( id == "manage-player__newPlayer")
     {

     }
     else if ( id == "manage-player__deletePlayer")
     {

     }
}
