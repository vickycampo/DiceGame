var userName = "";
var userId = "";

function addEventsUser()
{
  var registerLINK = document.getElementById('manage-player--menu__newPlayer');
  var exitLINK = document.getElementById('manage-player--menu__deletePlayer');
  registerLINK.addEventListener( 'click' , showHideForm );
  exitLINK.addEventListener( 'click', deleteUser );
  showHideButons( userId );
}

function createUser()
{
  userName = document.getElementById('playerName').value;

  if ( userName != "")
  {
    var myAjax = new myAjaxClass();
    var localURL = window.location.href;

    var method = "GET";
    var url = "/players/home";
    var body = "";

    myAjax.createRequestObj();
    myAjax.configureRequesObj( method , url , body );
    showHideButons( userId );
    showHideForm();
  }
  else
  {
    console.log (userName);
    document.getElementById('userErrorMessage').textContent = "Name is missing.";

    document.getElementById('userErrorMessage').classList.add ("show-error");
  }


}

function deleteUser()
{
  console.log ("Delete User");
  showHideButons( userId );
}


function showHideButons( userId )
{
  console.log ("showHideButons");
  console.log (userId);
  var modifyPlayerBTN = document.getElementById( 'modifyPlayer' );
  var createPlayerBTN = document.getElementById( 'createPlayer' );

  /* Show hide buttons */
  if (userId == "")
  {
    modifyPlayerBTN.style.display = "none";
    createPlayerBTN.style.display = "inline-block";
    createPlayerBTN.addEventListener( 'click', createUser );
  }
  else
  {
    modifyPlayerBTN.style.display = "inline-block";
    createPlayerBTN.style.display = "none";
    modifyPlayerBTN.addEventListener( 'click', modifyUser );
  }
};
function showHideForm()
{
  console.log ("showHideForm");
  var formContainer = document.getElementById('manage-player__form--container');
  /* Show / hide form */
  if (formContainer.classList.contains( "show" ))
  {
    formContainer.classList.remove ("show");
    formContainer.classList.add ("hide");
  }
  else if (formContainer.classList.contains( "hide" ))
  {
    formContainer.classList.remove ("hide");
    formContainer.classList.add ("show");
  }
  document.getElementById('userErrorMessage').textContent = " "

};
