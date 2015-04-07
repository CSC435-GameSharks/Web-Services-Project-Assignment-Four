package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


/**
 * Created by kirito on 3/25/15.
 */
@Entity
public class WoWSpell extends  Model{
    private int lvl;
    private String sName;
    private int num;

    /**
     * @param sNameIn the name of the spell
     * @param lvlIn the min lvl needed for the spell
     */
    public WoWSpell(String sNameIn, int lvlIn, int numIn){
        this.sName = sNameIn;
        this.lvl = lvlIn;
        this.num = numIn;

    }


    public String getName(){
        return sName;
    }

    public int getLvl(){
        return lvl;
    }

    public int getNum(){return num;}

}
