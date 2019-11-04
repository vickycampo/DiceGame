package com.DicesGame.game.controller;


import com.DicesGame.game.model.Player;
import com.DicesGame.game.dataAccess.PlayerRepository;
import com.DicesGame.game.model.Roll;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayersController
{
    PlayerRepository playerRepo = new PlayerRepository();



    @GetMapping
    public Player homePage (  )
    {
        Player player = PlayerRepository.getPlayersById( "108bf6f4-dad5-4dbb-bbf8-d46f01456782" );
        return player;
    }
    //POST: /players: crea un jugador
    @PostMapping
    public int createPlayer ( @RequestParam String name )
    {
        //check if name available


        return 0; //returns the id of the player
    }

    //PUT / players: modifica el nombre del jugador
    @PutMapping
    public boolean modifyPlayerName ()
    {
        return false; //returns if the values were updated
    }

    //POST / players / {id} / games /: un jugador específico realiza una tirada de los dados.
    @PostMapping (value = "/players/{ID}/games")
    public int rollDices ( @PathVariable String id )
    {
        return 0; //returns the id of the roll.
    }

    //DELETE / players / {id} / games: elimina las tiradas del jugador.
    @DeleteMapping (value = "/players/{ID}/games")
    public boolean deletePlayerRolls ( @PathVariable String id )
    {
        return false; //returns if they were deleted
    }

    //GET / players / {id} / games: devuelve el listado de jugadas por un jugador.
    @GetMapping (value = "/players/{ID}/games")
    public List<Roll> getPlayerRolls (@PathVariable String ID )
    {
        Player player = PlayerRepository.getPlayersById( ID );
        List<Roll> playerRolls = player.getPlayerRolls();
        return playerRolls;
    }




}
