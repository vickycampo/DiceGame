package com.DicesGame.game.controller;


import com.DicesGame.game.model.Player;
import com.DicesGame.game.dataAccess.PlayerRepository;
import com.DicesGame.game.model.Roll;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class PlayersController
{
    private List<Player> players;
    private Player singlePlayers;
    private PlayerRepository playerRepo  = new PlayerRepository();
    @GetMapping
    public String homePage (  )
    {
        players = playerRepo.findAll();
        String jsonString = "{" + this.toString() + "}";
        JSONObject sendData = new JSONObject( jsonString );
        return sendData.toString();
    }

    //POST: /players: crea un jugador
    @PostMapping ( value = "/players" )
    public String createPlayer ( @RequestBody String dataString )
    {
        //check if name available
        JSONObject getData = new JSONObject( dataString );
        String name = getData.getString("name");

        if (name == "")
        {
            name = "Anonymous";
        }
        List<Player> players = playerRepo.findByName( name );
        if (( players != null )&&( players.size() > 0 ))
        {
            //players exists and cannot be added again
            String jsonString = generateMessageJson ( "ERROR", "That name already exists in the db." );
            System.out.println( jsonString );
            JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
            return sendData.toString();
        }
        else
        {

            try
            {
                String playerId = playerRepo.save( name );
                String jsonString = generateMessageJson ( "SUCCESS", "Player added to the db." );
                JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
                sendData.put("playerId", playerId);
                return sendData.toString();
            }
            catch (Exception e)
            {
                String jsonString = generateMessageJson ( "ERROR", e.getMessage() );
                JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
                return sendData.toString();
            }


        }
    }

    //PUT / players: modifica el nombre del jugador
    //@RequestMapping( value = "/employees", produces = "application/json", method = {RequestMethod.PUT})
    @PutMapping  ( value = "/players" )
    public String modifyPlayer ( @RequestBody String dataString )
    {
        //check if name available
        JSONObject getData = new JSONObject( dataString );
        String playerId = getData.getString("playerId");
        String name = getData.getString("name");

        if (name == "")
        {
            name = "Anonymous";
        }
        List<Player> players = playerRepo.findByName( name );
        if (( players != null )&&( players.size() > 0 ))
        {
            //players exists and cannot be added again
            String jsonString = generateMessageJson ( "ERROR", "That new name already exists in the db." );
            System.out.println( jsonString );
            JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
            return sendData.toString();
        }
        else
        {
            try
            {
                playerId = playerRepo.update(playerId ,  name );
                String jsonString = generateMessageJson ( "SUCCESS", "Player modified in the db." );
                JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
                sendData.put("playerId", playerId);
                return sendData.toString();
            }
            catch (Exception e)
            {
                String jsonString = generateMessageJson ( "ERROR", e.getMessage() );
                JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
                return sendData.toString();
            }
        }
    }

    @DeleteMapping (value = "/players/{playerId}")
    public String deletePlayer ( @PathVariable String playerId )
    {
        try
        {
            playerId = playerRepo.delete(playerId);
            String jsonString = generateMessageJson ( "SUCCESS", "Player was removed from the db." );
            JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
            sendData.put("playerId", playerId);
            return sendData.toString();
        }
        catch (Exception e)
        {
            String jsonString = generateMessageJson ( "ERROR", e.getMessage() );
            JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
            return sendData.toString();
        }

    }

    //POST / players / {id} / games /: un jugador específico realiza una tirada de los dados.
    @PostMapping (value = "/players/{playerId}/games")
    public String rollDices ( @PathVariable String playerId )
    {
        //playerRepo.diceRoll ( id );
        return playerId; //returns the id of the roll.
    }

    //DELETE / players / {id} / games: elimina las tiradas del jugador.
    @DeleteMapping (value = "/players/{playerId}/games")
    public boolean deletePlayerRolls ( @PathVariable String playerId )
    {
        return false; //returns if they were deleted
    }

    //GET / players / {id} / games: devuelve el listado de jugadas por un jugador.
    @GetMapping (value = "/players/{playerId}/games")
    public List<Roll> getPlayerRolls (@PathVariable String playerId )
    {
        Player player = playerRepo.findByPlayerid( playerId );
        List<Roll> playerRolls = player.getPlayerRolls();
        return playerRolls;
    }
    @Override
    public String toString ()
    {
        StringBuilder jsonString = new StringBuilder("\"Employe\": [");
        if ( !players.isEmpty() )
        {
            players.forEach( player -> jsonString.append( player.toString() + ", " ) );
            jsonString.delete(jsonString.length()-2 , jsonString.length());
            jsonString.append("]");
            players.clear();
        }
        else if ( singlePlayers != null )
        {
            jsonString.append( singlePlayers.toString() );
            singlePlayers = null;
        }
        return jsonString.toString();
    }
    public String generateMessageJson ( String type, String message )
    {
        StringBuilder jsonString = new StringBuilder("Message:{");
        jsonString.append("\"Type\":\"" + type + "\", ");
        jsonString.append("\"Message\":\"" + message + "\" ");
        jsonString.append("}");
        return jsonString.toString();
    }







}
