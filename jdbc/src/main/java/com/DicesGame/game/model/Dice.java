package com.DicesGame.game.model;

public class Dice
{
    private int id;
    private int rollid;
    private int dicenumber;
    private int roll;

    public Dice(int id, int rollid, int dicenumber, int roll)
    {
        setId( id );
        setRollid( rollid );
        setDicenumber( dicenumber );
        setRoll( roll );

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollid() {
        return rollid;
    }

    public void setRollid(int rollid) {
        this.rollid = rollid;
    }

    public int getDicenumber() {
        return dicenumber;
    }

    public void setDicenumber(int dicenumber) {
        this.dicenumber = dicenumber;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + this.id + "\"" +
                ", \"rollid\":\"" + this.rollid + "\"" +
                ", \"dicenumber\":\"" + this.dicenumber + "\"" +
                ", \"roll\":\"" + this.roll +
                "\"}";
    }
}
