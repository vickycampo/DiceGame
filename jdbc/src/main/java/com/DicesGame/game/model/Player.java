package com.DicesGame.game.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player
{
    private int id;
    private String name;
    private String date;
    private List<Roll> playerRolls;
    public Player( int id, String name, String date )
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {

        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) throws Exception
    {
        if ((name != "") && (name != null))
            this.name = name;
        else
            throw (new Exception ("Error 36 - Invalid Player Name"));
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date) throws Exception
    {
        String pattern  = "\\d{4}-\\d{2}-\\d{2}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(date);

        if (m.matches( ))
        {
            this.date = date;
        }
        else
        {
            throw (new Exception ("Error 58 - Invalid date format"));
        }

    }

    public List<Roll> getPlayerRolls()
    {
        return playerRolls;
    }
}
