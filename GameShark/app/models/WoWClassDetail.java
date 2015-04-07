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
public class WoWClassDetail extends Model {
    @Id
    private Integer intID;
    private int specID;
    @Constraints.Required
    private String sName;
    private String sBio;
    //private List<String> aryRoles;
    //private List<WoWSpec> arySpecs;
    //private List<WoWSpell> arySpells;
    //private List<WoWTalent> aryTalents;


    /*
    private String[] aryRoles;
    private WoWSpec[] arySpecs;
    private WoWSpell[] arySpells;
    private WoWTalent[] aryTalents;
    */

    /**
     * @param sNameIn the name of the WoW Class
     * @param intIDIn the id for the WoW Class
     */
    public WoWClassDetail(String sNameIn, int intIDIn, String sBioIn, int specID){
        this.sName = sNameIn;
        this.intID = intIDIn;
        this.sBio = sBioIn;
        this.specID = specID;


        /*
        this.aryRoles = null;
        this.arySpecs = null;
        this.arySpells = null;
        this.aryTalents = null;
        */
    }

    /**
     * @return the classes Name
     */
    public String getName(){
        return sName;
    }

    /**
     * @return the classes ID
     */
    public int getID(){
        return intID;
    }

    public void setSpecID(int specIDin){
        specID = specIDin;
    }

    public int getSpecID(){return specID; }

    public static Finder<Integer, WoWClassDetail> find = new Finder<Integer, WoWClassDetail>(
            Integer.class, WoWClassDetail.class
    );

    /**
     * @return an array of roles that are the classes
     * roles
     */

    /*
    public String[] getRoles(){
        return aryRoles;
    }

    public void setRoles(String[] aryIn){
        this.aryRoles = aryIn;
    }

    public String getRolesString(){
        String sReturn = "";
        boolean bFirstPass = true;
        for(int i = 0; i < aryRoles.length; i++){
            if(bFirstPass){
                sReturn += aryRoles[i];
                bFirstPass = false;
            }else{
                sReturn += ", " + aryRoles[i];
            }
        }
        return sReturn;
    }

    public String getRolesStringNoSpace(){
        String sReturn = "";
        boolean bFirstPass = true;
        for(int i = 0; i < aryRoles.length; i++){
            if(bFirstPass){
                sReturn += aryRoles[i];
                bFirstPass = false;
            }else{
                sReturn += "," + aryRoles[i];
            }
        }
        return sReturn;
    }
    */

    /**
     * @return an array of strings that are the classes
     * specs
     */
    /*
    public WoWSpec[] getSpecs(){
        return arySpecs;
    }

    public void setSpecs(WoWSpec[] aryIn){
        this.arySpecs = aryIn;
    }
    */

    /**
     * @return an array of WoWSpell objects
     */
    /*
    public WoWSpell[] getSpells(){
        return arySpells;
    }

    public void setSpells(WoWSpell[] aryIn){
        this.arySpells = aryIn;
    }
    */
    /**
     * @return an array of WoWTalent objects
     */
    /*
    public WoWTalent[] getTalents(){
        return aryTalents;
    }

    public void setTalents(WoWTalent[] aryIn){
        this.aryTalents = aryIn;
    }
    */
}
