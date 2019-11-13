
function biggestWinnerRefresh ()
{
     console.log ("biggestWinnerRefresh");
     var localURL = window.location.href;
     var method = "GET";
     var url = "/players/ranking/winner";
     var body = "";

     createRequestObj();
     configureRequesObj( method , url , body , "biggestWinnerRefreshReturn ( jsonObj )");
}
function biggestWinnerRefreshReturn ( JsonReturn )
{
     console.log ("biggestWinnerRefreshReturn");
     console.log ( JsonReturn["Message"] );
     var type = JsonReturn["Message"]["Type"];
     var message = JsonReturn["Message"]["Message"];
     console.log ( type + " - "+ message );
     if ( type == "ERROR")
     {
          alert (message);
     }
     else if ( type == "SUCCESS")
     {
          console.log ( JsonReturn );
     }
}


function biggestLoserRefresh ()
{
     console.log ("biggestLoserRefresh");
     var localURL = window.location.href;
     var method = "GET";
     var url = "/players/ranking/winner";
     var body = "";

     createRequestObj();
     configureRequesObj( method , url , body , "biggestLoserRefreshReturn ( jsonObj )");
}
function biggestLoserRefreshReturn ( JsonReturn )
{
     var type = JsonReturn["Message"]["Type"];
     var message = JsonReturn["Message"]["Message"];
     if ( type == "ERROR")
     {
          alert (message);
     }
     else if ( type == "SUCCESS")
     {
          console.log ( JsonReturn );
     }
}
