package com.DicesGame.game.controller;

import com.DicesGame.game.dataAccess.DiceRepository;
import com.DicesGame.game.dataAccess.PlayerRepository;
import com.DicesGame.game.dataAccess.RollRepository;
import com.DicesGame.game.model.Dice;
import com.DicesGame.game.model.Player;
import com.DicesGame.game.model.Roll;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestController
public class GameController
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

    //GET / players /:
    // devuelve el listado de todos los jugadores del sistema con su porcentaje medio de éxitos
    @GetMapping ( value = "/players")
    public String getPlayersStatistics (  )
    {
        this.clearData ();
        try
        {
            players = playerRepo.findAll();
        }
        catch ( Exception e )
        {
            String jsonString = generateMessageJson ( "ERROR", "Error 43 - " + e.getMessage() );
            JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
            return sendData.toString();
        }

        Iterator playerIterator = players.iterator();

        StringBuilder jsonString = new StringBuilder(this.toString());
        jsonString.append(", \"WinsPercentage\":[");
        double winsAverage = 0.00;

        String playerId = "";
        while ( playerIterator.hasNext() )
        {
            playerId = ((Player)playerIterator.next()).getPlayerId();
            try
            {
                HashMap<String, Double> results = rollRepo.findAverageWins( playerId );

                jsonString.append( "{");
                jsonString.append( "\"PlayerId\":\"" + playerId + "\", ");
                jsonString.append( "\"Wins\":\"" + results.get("WIN") + "\", ");
                jsonString.append( "\"Loses\":\"" + results.get("LOST") + "\", ");
                jsonString.append( "\"WinsPercentage\":\"" + results.get("AVG_WINS") + "\", ");
                jsonString.append( "\"WinsPercentage\":\"" + results.get("AVG_LOSTS") + "\" ");
                jsonString.append( "}, ");


                jsonString.append("");
            }
            catch ( NullPointerException e )
            {
                //Nothing, there can be a player that has no plays
                System.out.println("Nothing, there can be a player that has no plays");
            }

        }
        jsonString.delete(jsonString.length()-2 , jsonString.length());
        jsonString.append("]");

        JSONObject sendData = new JSONObject( "{" + jsonString.toString() + "}" );
        return sendData.toString();

    }

    //GET / players / ranking:
    // devuelve el ranking medio de todos los jugadores del sistema.
    // Es decir, el porcentaje medio de éxitos.
    @GetMapping ( value="/players/ranking" )
    public String getAllPlayersRanking ()
    {
        JSONObject sendData = new JSONObject( rollRepo.findAllAverageWins() );
        return sendData.toString();
    }

    //GET / players / ranking / loser: devuelve el jugador con peor porcentaje de éxito.
    @GetMapping ( value="/players/ranking/loser" )
    public String getBiggestLoser ()
    {
        this.clearData ();
        try
        {
            List<String> playerIds = playerRepo.findAllIds();
            String biggestLoser = rollRepo.findBiggestLoser( playerIds );
            System.out.println( biggestLoser );
            JSONObject sendData = new JSONObject( biggestLoser );
            return sendData.toString();
        }
        catch ( Exception e )
        {
            String jsonString = generateMessageJson ( "ERROR", "Error 111 - " +  e.getMessage());
            JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
            return sendData.toString();
        }

    }

    //GET / players / ranking / winner: devuelve el jugador con mejor porcentaje de éxito.
    @GetMapping ( value="/players/ranking/winner" )
    public String getBiggestWinner ()
    {

        this.clearData ();
        try
        {
            List<String> playerIds = playerRepo.findAllIds();
            String biggestWinner = rollRepo.findBiggestWinner( playerIds );
            System.out.println( biggestWinner );
            JSONObject sendData = new JSONObject( biggestWinner );
            return sendData.toString();
        }
        catch ( Exception e )
        {
            String jsonString = generateMessageJson ( "ERROR", "Error 132 - " +  e.getMessage());
            JSONObject sendData = new JSONObject( "{" + jsonString + "}" );
            return sendData.toString();
        }
    }













    @Override
    public String toString ()
    {
        StringBuilder jsonString = new StringBuilder ("");
        if ( ( players != null ) && ( !players.isEmpty() ) )
        {
            jsonString.append("\"Players\": [");
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
            jsonString.append("\"Player\":");
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
