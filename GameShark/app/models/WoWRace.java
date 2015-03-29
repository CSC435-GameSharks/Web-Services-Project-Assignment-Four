package models;

//import javax.json.JsonObject;

/**
 * Created by kirito on 3/25/15.
 */
/**
 *This class is used to make a WoW Race Object. Example: Human, Troll
 */
public class WoWRace {
    private int intID;
    private int intMask;
    private String sSide;
    private String sName;

    /**
     * creates a race object from a JsonObject
     * @param objIn
     */
    WoWRace(/*JsonObject objIna*/){
        //intID = objIn.getInt("id");
        //intMask = objIn.getInt("mask");
        //sSide = objIn.getString("side");
        //sName = objIn.getString("name");
    }

    /**
     *
     * @return the races id
     */
    public int getID(){
        return intID;
    }

    /**
     *
     * @return return the mask
     */
    public int getMask(){
        return intMask;
    }

    /**
     *
     * @return the race's side
     */
    public String getSide(){
        return sSide;
    }

    /**
     *
     * @return  the race's name
     */
    public String getName(){
        return sName;
    }



}
