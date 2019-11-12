function getPlayerRolls()
{
     if (( userId != "" ) && ( userId != null))
     {
          //we check if we need to get the rolls
          if ( playerGameList.length == 0 )
          {
               //"/players/{playerId}/games
               var localURL = window.location.href;
               var method = "GET";
               var url = "/players/" + userId + "/games";
               var body = JSON.stringify({"name": userName});

               createRequestObj();
               configureRequesObj( method , url , body , "returnPlayerRolls ( jsonObj )");
          }
     }
}
function returnPlayerRolls ( JsonReturn )
{
     if (typeof JsonReturn["Message"] !== 'undefined')
     {
          var type = JsonReturn["Message"]["Type"];
          var message = JsonReturn["Message"]["Message"];

          if ( type == "ERROR")
          {
               alert (message);
          }
          else if ( type == "SUCCESS")
          {

          }
     }
     if (typeof JsonReturn["Rolls"] !== 'undefined')
     {
          var Rolls = JsonReturn["Rolls"];
     }
     if (typeof JsonReturn["Dices"] !== 'undefined')
     {
          var Dices = JsonReturn["Dices"];
     }
     cleanGameInfo ( Rolls , Dices );
}
function cleanGameInfo ( Rolls , Dices )
{
     for ( var i in Rolls )
     {

          rollId = Rolls[i]["id"];
          if ( playerGameList[rollId] === 'undefined' )
          {
               playerGameList[rollId] = new Array;
               playerGameList[rollId]["result"]= Rolls[i]["id"]["result"];

          }
     }
     for ( var i in Dices )
     {
          console.log ( i );
          console.log ( Dices[i] );
          rollId = Dices[i]["rollid"];
          if ( playerGameList[rollId] !== 'undefined' )
          {
               alert ("linea 65 player games")

          }
     }

}
