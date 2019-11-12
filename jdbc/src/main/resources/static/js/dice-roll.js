var dice_roll;
var opacity;
var delayInMilliseconds = 1000;
var dicesIMG = new Array;
var loopCounter = 0;
var returnJson;
function doYouWantToRolldice()
{

     console.log ("Activate rolling screen");
     activeSection = document.getElementById('dice-roll');
     fixSizeLocation ( activeSection );
     document.getElementById('diceRollingBTN').addEventListener( 'click', letsRollTheDice );
     dicesIMG = document.getElementsByClassName('dice-roll__rollDices--dices--img');
     console.log ( dicesIMG );
}
function stopRolling ()
{
     console.log ("stopRolling");
     activeSection = document.getElementsByTagName('hgroup')[0];
     fixSizeLocation ( activeSection );

}
function letsRollTheDice ()
{
     console.log (" Roll the dice ");
     var localURL = window.location.href;
     var method = "POST";
     var url = "/players/" + userId + "/games";
     var body = JSON.stringify({"name": userName});

     createRequestObj();
     configureRequesObj( method , url , body , "getRollTheDice ( jsonObj )");
     document.getElementById('diceRollingBTN').textContent = "Rolling...";
     startRollingDice();
}
function getRollTheDice( jsonObj )
{
     returnJson = jsonObj;
}
function startRollingDice()
{
     if ( loopCounter < 15)
     {
          loopCounter ++;
          for ( var i in dicesIMG )
          {
               if (typeof dicesIMG[i].src !== 'undefined')
               {
                    random = Math.floor(Math.random() * 6) + 1;
                    root = dicesIMG[i].src.substring(0, dicesIMG[i].src.length-5);
                    dicesIMG[i].src = root + random + ".svg";
               }

          }
          myVar = setTimeout(startRollingDice, 150);

     }
     else
     {
               console.log (returnJson);
               var type = returnJson["Message"]["Type"];
               var message = returnJson["Message"]["Message"];
               if ( type == "SUCCESS")
               {
                    var Roll = returnJson["Roll"];
                    console.log (Roll["result"]);
                    // chec if is a win or loose
                    if ( Roll["result"] =="LOST" )
                    {
                         document.getElementById('diceRollingBTN').textContent = "You lost, try again!";
                    }
                    else if ( Roll["result"] =="LOST" )
                    {
                         document.getElementById('diceRollingBTN').textContent = "Yay! you win! keep it up!";
                    }
                    var Dices = returnJson["Dices"];
                    for ( var i in dicesIMG )
                    {
                         if (typeof dicesIMG[i].src !== 'undefined')
                         {
                              // Put the results in the dices
                              root = dicesIMG[i].src.substring(0, dicesIMG[i].src.length-5);
                              dicesIMG[i].src = root + Dices[i]['roll'] + ".svg";
                         }
                    }
               }
               else if ( type == "ERROR")
               {
                    alert ( message );
               }
               loopCounter = 0;
     }
}
