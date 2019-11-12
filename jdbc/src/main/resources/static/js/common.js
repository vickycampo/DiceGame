function fixSizeLocation ( targetDiv )
{
     if ( targetDiv != null)
     {
          //we base our sizing and body
          var referenceWidth = document.getElementsByTagName('hgroup')[0].clientWidth;
          var referenceHeight = document.getElementsByTagName('hgroup')[0].clientHeight;

          var marginSize = 0;
          targetDiv.style.width = ( referenceWidth ) + "px";
          targetDiv.style.height = ( referenceHeight - 5) + "px"

          targetDiv.style.top = document.getElementsByTagName('hgroup')[0].offsetTop + 5 +"px";
          targetDiv.style.margin = marginSize +"px";
     }

}
function doSessionStorage()
{
     if (( sessionStorage.getItem("userName") != null )&&( sessionStorage.getItem("userName") != "" ))
     {
          userName = sessionStorage.getItem("userName");

     }
     else
     {
          sessionStorage.setItem("userName", userName);
     }

     if (( sessionStorage.getItem("userId") != null )&&( sessionStorage.getItem("userId") != "" ))
     {
          userId = sessionStorage.getItem("userId");
          doYouWantToRolldice();
     }
     else
     {
          sessionStorage.setItem("userId", userId);
     }
}
