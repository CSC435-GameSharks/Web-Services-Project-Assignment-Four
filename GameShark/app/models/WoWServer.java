package models;

//import javax.json.JsonArray;
//import javax.json.JsonObject;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

/**
 * Created by kirito on 3/25/15.
 */
public class WoWServer {

    private String type;
    private String population;
    private boolean queue;
    private boolean status;
    private String name;
    private String slug;
    private String battlegroup;
    private String locale;
    private String timezone;
    private String[] aryConnectedRealms;

    /**
     * Class constructor
     */
    public WoWServer() {

    }

    /**
     *
     * @return aName, the name of the server
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return sType, what type of server is it. PVP, PVE
     */
    public String getType(){
        return type;
    }

    /**
     *
     * @return sPopulation, the current population level. Med, Low, High
     */
    public String getPopulation(){
        return population;
    }

    /**
     *
     * @return bQuere, Ture/False if there is a login queue
     */
    public boolean getQueue(){
        return queue;
    }

    /**
     *
     * @return bStatus, T/F is the server is up or not.
     */
    public boolean getStatus(){
        return status;
    }

    /**
     *
     * @return sSlug, the slang name of the server
     */
    public String getSlug(){
        return slug;
    }

    /**
     *
     * @return the name of the battle group.
     */
    public String getBattleGroup(){
        return battlegroup;
    }

    /**
     *
     * @return that language the server is
     */
    public String getLocale(){
        return locale;
    }

    /**
     *
     * @return what time zone the server is in.
     */
    public String getTimezone(){
        return timezone;
    }

}
