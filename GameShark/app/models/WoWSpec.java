package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


/**
 * Created by kirito on 3/25/15.
 */
/**
 *This class is used to make a WoW Spec Object
 */
@Entity
public class WoWSpec extends Model {
    private int specID;
    private String sName;

    public WoWSpec(String sNameIn, int specIDIn){
        this.sName = sNameIn;
        this.specID = specIDIn;
    }

    public String getName(){
        return sName;
    }

    public int getID(){
        return specID;
    }

}
