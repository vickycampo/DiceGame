package com.DicesGame.game.dataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.DicesGame.game.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerRepository
{
    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public static String generateRandomId ()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public static List<Player> getAllPlayers ()
    {
        List<Player> players = new ArrayList<>();
        jdbcTemplate.query(
                "SELECT * FROM players",
                (resultSet, rowNum) -> new Player(resultSet.getString("playerId"), resultSet.getString("name"), resultSet.getString("date"))
        ).forEach(player -> players.add(player));
        return (players);
    }
    public static List<Player> getPlayersByName ( String playerName )
    {
        List<Player> players = new ArrayList<>();
        jdbcTemplate.query(
                "SELECT * FROM players WHERE name = ?", new Object[] { playerName },
                (resultSet, rowNum) -> new Player(resultSet.getString("playerId"), resultSet.getString("name"), resultSet.getString("date"))
        ).forEach(player -> players.add(player));
        return (players);
    }
    public static Player getPlayersById ( String playerId )
    {
        List<Player> players = new ArrayList<>();
        jdbcTemplate.query(
                "SELECT * FROM players WHERE id = ?", new Object[] { playerId },
                (resultSet, rowNum) -> new Player(resultSet.getString("playerId"), resultSet.getString("name"), resultSet.getString("date"))
        ).forEach(player -> players.add(player));
        return (players.get(0));
    }

}
