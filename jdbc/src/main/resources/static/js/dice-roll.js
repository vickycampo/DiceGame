var dice_roll;
var opacity;
var delayInMilliseconds = 1000;
function doYouWantToRolldice()
{
     console.log ("Roll the Dice");
     dice_roll = document.getElementById('dice-roll');
     dice_roll.classList.remove ("hide");
     dice_roll.classList.add ("show");
     activeSection = dice_roll;
     fixSizeLocation ( activeSection );
}
function stopRolling ()
{
     console.log ("stopRolling");
     dice_roll = document.getElementById('dice-roll');
     dice_roll.classList.remove ("hide");
     dice_roll.classList.add ("show");

     fixSizeLocation ( activeSection );
     activeSection = null;
}
