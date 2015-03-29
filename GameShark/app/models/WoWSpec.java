package models;

/**
 * Created by kirito on 3/25/15.
 */
/**
 *This class is used to make a WoW Spec Object
 */
public class WoWSpec {
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
