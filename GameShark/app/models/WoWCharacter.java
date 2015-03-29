package models;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader
*/

/**
 * Created by kirito on 3/25/15.
 */
public class WoWCharacter {
    private int lastModified;
    private Date dLastModified;
    private String name;
    private String realm;
    private String battlegroup;
    private int iclass;
    private String sClass;
    private int race;
    private String sRace;
    private int gender;
    private int level;
    private int achievementPoints;
    private String thumbnail;
    private String calcClass;
    private int totalHonorableKills;


    public WoWCharacter(/*JsonObject objIn*/ String nameIn, String realmIn){
        //intLastModified = objIn.getInt("lastModified");
        /*sName = objIn.getString("name");
        sRealm = objIn.getString("realm");
        sBattleGroup = objIn.getString("battlegroup");
        intClass = objIn.getInt("class");
        intRace = objIn.getInt("race");
        intGender = objIn.getInt("gender");
        intLevel = objIn.getInt("level");
        intAchievementPoints = objIn.getInt("achievementPoints");
        sThumbnail = objIn.getString("thumbnail");
        sCalcClass = objIn.getString("calcClass");
        intHonorableKills = objIn.getInt("totalHonorableKills");
        */
        //sClass = getClassString();
        //sRace = getRaceString();

        //name = "test";
        name = nameIn;
        //realm = "test Realm";
        realm = realmIn;
        battlegroup = "bg";
        sClass = "Paladin";
        sRace = "Orc";
        gender = 0;
        level = 100;
        achievementPoints = 10000;
        thumbnail = "firetree/104/119247720-avatar.jpg";
        totalHonorableKills = 94;
    }

    /**
     *
     * @return the characters name
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return the characters realm
     */
    public String getRealm(){
        return realm;
    }

    /**
     *
     * @return the characters battle group
     */
    public String getBattleGroup(){
        return battlegroup;
    }

    /**
     *
     * @return the characters class
     */
    public int getCharClassID(){
        return iclass;
    }


    public String getCharClass(){
        return sClass;
    }

    /**
     *
     * @return the characters race
     */
    public int getRaceID(){
        return race;
    }

    public String getRace(){
        return sRace;
    }

    /**
     *
     * @return the characters gender
     */
    public int getGender(){
        return gender;
    }

    /**
     *
     * @return the characters level
     */
    public int getLevel(){
        return level;
    }

    /**
     *
     * @return The character's achievement points
     */
    public int getAchievementPoints(){
        return achievementPoints;
    }

    /**
     *
     * @return The thumbnail?
     */
    public String getThumbnail(){
        return thumbnail;
    }

    /**
     *
     * @return the ClacClass. Not sure what this is
     */
    public String getCalcClass(){
        return calcClass;
    }

    /**
     *
     * @return the number of honorable kills the character has.
     */
    public int getHonorableKills(){
        return totalHonorableKills;
    }


    private String getClassString(){
        String sReturn = null;

        InputStream is = null;

        try{
            is = new URL("http://us.battle.net/api/wow/data/character/classes").openStream();
            /*JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            JsonArray jsonArray = jsonObject.getJsonArray("classes");
            jsonReader.close();

            for(int i = 0; i < jsonArray.size(); i++){
                JsonObject obj = jsonArray.getJsonObject(i);
                if(obj.getInt("id") == intClass){
                    return obj.getString("name");
                }
                //aryServer[i] = new WoWServerControl(obj);
            }
            */
        } catch (MalformedURLException ex) {
            // Logger.getLogger(WoWServServ.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ioe){
            // Logger.getLogger(WoWCharServ.class.getName()).log(Level.SEVERE, null, ioe);

        } catch(Exception e){
            //Logger.getLogger(WoWCharServ.class.getName()).log(Level.SEVERE, null, e);

        }finally {
            try {
                is.close();
            } catch (IOException ex) {
                // Logger.getLogger(WoWCharServ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sReturn;
    }


    private String getRaceString(){
        String sReturn = null;

        InputStream is = null;

        try{
            /*is = new URL("http://us.battle.net/api/wow/data/character/races").openStream();
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            JsonArray jsonArray = jsonObject.getJsonArray("races");
            jsonReader.close();

            for(int i = 0; i < jsonArray.size(); i++){
                JsonObject obj = jsonArray.getJsonObject(i);
                if(obj.getInt("id") == intRace){
                    return obj.getString("name");
                }
            }

        } catch (MalformedURLException ex) {
            //Logger.getLogger(WoWServServ.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ioe){
            // Logger.getLogger(WoWCharServ.class.getName()).log(Level.SEVERE, null, ioe);
        */
        } catch(Exception e){
            //Logger.getLogger(WoWCharServ.class.getName()).log(Level.SEVERE, null, e);

        }finally {
            try {
                is.close();
            } catch (IOException ex) {
                //  Logger.getLogger(WoWCharServ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sReturn;
    }


}
