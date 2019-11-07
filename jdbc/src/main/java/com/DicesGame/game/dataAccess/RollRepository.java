package com.DicesGame.game.dataAccess;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.DicesGame.game.model.Roll;
import com.DicesGame.game.config.JdbcDataSource;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RollRepository
{
    private JdbcTemplate jdbcTemplate;
    private static final Logger LOGGER = Logger.getLogger( PlayerRepository.class.getName() );

    public RollRepository()
    {
        try
        {
            jdbcTemplate = JdbcDataSource.getTemplate();
        }
        catch ( Exception e)
        {
            LOGGER.log(Level.FINE, "Error in DB connection", e.getCause());
        }

    }
    public int save ( String playersid , String result ) throws Exception
    {
        try
        {
            String insertSql =  "INSERT INTO rolls ( playersid, result ) VALUES ( ? , ? )";
            KeyHolder holder = new GeneratedKeyHolder();

            int row = jdbcTemplate.update(new PreparedStatementCreator()
            {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException
                {
                    PreparedStatement ps =connection.prepareStatement( insertSql, Statement.RETURN_GENERATED_KEYS );
                    ps.setString(1, playersid);
                    ps.setString(2, result);
                    return ps;
                }
            }, holder );
            int newRollId = (int)holder.getKey().longValue();
            return newRollId;
        }
        catch (DataAccessException e)
        {
            throw ( new Exception (e.getMessage()));
        }
    }
    public Roll findByRollid ( int rollId)
    {
        List<Roll> rolls = new ArrayList<>();
        jdbcTemplate.query(
                "SELECT * FROM rolls WHERE id = ?", new Object[] { rollId },
                (resultSet, rowNum) -> new Roll(resultSet.getInt("id"), resultSet.getString("playersid"), resultSet.getString("result"))
        ).forEach(roll -> rolls.add(roll));
        System.out.println("Size  - " + rolls.size());
        if ( rolls.size() > 0)
        {
            Iterator iter = rolls.iterator();
            Roll singleRoll = (Roll) iter.next();
            return ( singleRoll );
        }
        else
        {
            return null;
        }
    }
    public List<Roll> findAllByPlayerid ( String playerId)
    {
        List<Roll> rolls = new ArrayList<>();
        jdbcTemplate.query(
                "SELECT * FROM rolls WHERE playersid = ?", new Object[] { playerId },
                (resultSet, rowNum) -> new Roll(resultSet.getInt("id"), resultSet.getString("playersid"), resultSet.getString("result"))
        ).forEach(roll -> rolls.add(roll));
        return (rolls);
    }

}
