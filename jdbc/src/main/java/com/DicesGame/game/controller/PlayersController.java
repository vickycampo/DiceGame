package com.DicesGame.game.controller;


import com.DicesGame.game.dataAccess.*;
import com.DicesGame.game.model.*;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
public class PlayersController
{
    private List<Player> players;
    private Player singlePlayers;
    private List<Roll> rolls;
    private Roll singleRoll;
    private List<Dice> dices;
    private Dice singleDice;

    private PlayerRepository playerRepo  = new PlayerRepository();
    private RollRepository rollRepo  = new RollRepository();
    private DiceRepository diceRepo  = new DiceRepository();

    @GetMapping
    public String homePage (  )
    {
        this.clearData ();
        players = playerRepo.findAll();
        String jsonString = "{" + this.toString() + "}";
        JSONObject sendData = new JSONObject( jsonString );
        return sendData.toString();
    }

    //POST: /players: crea un jugador
    @PostMapping ( value = "/players" )
    public String createPlayer ( @RequestBody String dataString )
    {
        this.clearData ();
        //check if name available
        JSONObject getData = new JSONObject( dataString );
        String name = getData.getString("name");

        List<Player> players = null;
        if ( name.equals("") )
        {
            name = "Anonymous";
        }
        else
        {
            players = playerRepo.findByName( name );
        }
        if (( players != null )&&( players.size() > 0 ))
        {
            //players exists and cannot be added again
            String jsonString = generateMessageJson ( "ERROR", "That name already exists in the db." );
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
        this.clearData ();
        //check if name available
        JSONObject getData = new JSONObject( dataString );
        String playerId = getData.getString("playerId");
        String name = getData.getString("name");
        List<Player> players = null;
        if ( name.equals("") )
        {
            name = "Anonymous";
        }
        else
        {
            players = playerRepo.findByName( name );
        }

        if (( players != null )&&( players.size() > 0 ))
        {
            //players exists and cannot be added again
            String jsonString = generateMessageJson ( "ERROR", "That new name already exists in the db." );

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
        this.clearData ();
        try
        {
            //check if we have this player in the db
            Player players = playerRepo.findByPlayerid( playerId );
            if ( players != null )
            {
                playerId = playerRepo.delete(playerId);
                String jsonString = generateMessageJson ( "SUCCESS", "Player was removed from the db." );
                JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
                sendData.put("playerId", playerId);
                return sendData.toString();
            }
            else
            {
                String jsonString = generateMessageJson ( "ERROR", "No player was found with this playerId" );
                JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
                return sendData.toString();
            }

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
        this.clearData ();
        //set parameters for this game
        int numberOfDices = 2;
        int min = 1;
        int max = 6;
        //throw the dices
        int[] results = new int[numberOfDices];
        int range = (max - min) + 1;
        int sum = 0;
        for (int i = 0; i < numberOfDices; i++)
        {
            do
            {
                results[i] = (int) (Math.random() * range) + min;
            } while ( (results[i] < min ) || (results[i] > max ) );
            sum += results[i];
        }
        //check the result - win - the sum is 7 / loose anything else.
        String result;
        if ( sum == 7)
        {
            result = "WIN";
        }
        else
        {
            result = "LOOSE";
        }



        try
        {
            //save in the rolls table (using the player id / get the roll id for dices)
            int rollId = rollRepo.save( playerId , result );
            //save in the dices table (using the rolls Id)
            for (int i = 0; i < numberOfDices; i++)
            {
                int diceId = diceRepo.save( rollId , i , results[i] );
            }
            //add success message
            StringBuilder jsonString = new StringBuilder( generateMessageJson ( "SUCCESS", "Successful roll ." ) );

            //get player, rolls and dices info
            this.singlePlayers = playerRepo.findByPlayerid( playerId );
            this.singleRoll = rollRepo.findByRollid ( rollId );
            this.dices = diceRepo.findByRollsId( rollId );

            jsonString.append(this.toString());
            JSONObject sendData = new JSONObject( "{" + jsonString.toString() + "}" );
            return sendData.toString();


        }
        catch ( Exception e )
        {
            String jsonString = generateMessageJson ( "ERROR", e.getMessage() );
            JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
            return sendData.toString();
        }

    }

    //DELETE / players / {id} / games: elimina las tiradas del jugador.
    @DeleteMapping (value = "/players/{playerId}/games")
    public boolean deletePlayerRolls ( @PathVariable String playerId )
    {
        this.clearData ();
        return false; //returns if they were deleted
    }

    //GET / players / {id} / games: devuelve el listado de jugadas por un jugador.
    @GetMapping (value = "/players/{playerId}/games")
    public String getPlayerRolls (@PathVariable String playerId )
    {
        this.clearData ();

        //get player, rolls and dices info
        this.singlePlayers = playerRepo.findByPlayerid( playerId );
        this.rolls = rollRepo.findAllByPlayerid ( playerId );
        Iterator iterator = this.rolls.iterator();
        int thisRollId;

        while ( iterator.hasNext() )
        {
            thisRollId =  ((Roll)iterator.next()).getId();
            try
            {
                dices = diceRepo.findByRollsId( thisRollId );
                this.dices.addAll( dices );
                dices.clear();
            }
            catch (NullPointerException e)
            {

                String jsonString = generateMessageJson ( "ERROR", "Error 262 - " + e.getMessage() );
                JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
                return sendData.toString();
            }

        }
        StringBuilder jsonString = new StringBuilder();
        jsonString.append(this.toString());
        JSONObject sendData = new JSONObject( "{" + jsonString.toString() + "}" );
        return sendData.toString();
    }

    @Override
    public String toString ()
    {
        StringBuilder jsonString = new StringBuilder ("");
        if ( ( players != null ) && ( !players.isEmpty() ) )
        {
            jsonString.append("\"Employes\": [");
            players.forEach( player -> jsonString.append( player.toString() + ", " ) );
            jsonString.delete(jsonString.length()-2 , jsonString.length());
            jsonString.append("]");

        }
        if ( ( rolls != null ) && ( !rolls.isEmpty() ) )
        {
            if ( ! jsonString.toString().equals("") )
            {
                jsonString.append(", ");
            }
            jsonString.append("\"Rolls\": [");
            rolls.forEach( roll -> jsonString.append( roll.toString() + ", " ) );
            jsonString.delete(jsonString.length()-2 , jsonString.length());
            jsonString.append("]");

        }
        if ( (dices != null) && ( !dices.isEmpty() ) )
        {
            if ( ! jsonString.toString().equals("") )
            {
                jsonString.append(", ");
            }
            jsonString.append("\"Dices\": [");
            dices.forEach( dice -> jsonString.append( dice.toString() + ", " ) );
            jsonString.delete(jsonString.length()-2 , jsonString.length());
            jsonString.append("]");

        }
        if ( singlePlayers != null )
        {
            if ( ! jsonString.toString().equals("") )
            {
                jsonString.append(", ");
            }
            jsonString.append("\"Employe\":");
            jsonString.append( singlePlayers.toString() );

        }
        if ( singleRoll != null )
        {
            if ( ! jsonString.toString().equals("") )
            {
                jsonString.append(", ");
            }
            jsonString.append("\"Roll\":");
            jsonString.append( singleRoll.toString() );

        }
        if ( singleDice != null )
        {
            if ( ! jsonString.toString().equals("") )
            {
                jsonString.append(", ");
            }
            jsonString.append("\"Dice\":");
            jsonString.append( singleDice.toString() );

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

    public void clearData ()
    {
        if ( players != null)
        {
            players.clear();
        }
        if ( rolls != null)
        {
            rolls.clear();
        }
        if ( dices != null) {
            dices.clear();
        }

        singlePlayers = null;
        singleRoll = null;
        singleDice = null;
    }







}
