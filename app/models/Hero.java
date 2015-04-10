package models;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.json.*;

/**
 *
 * @author csaroff
 */
public class Hero {
    private int id;
    private String name;
    private String className;
    private int gender;
    private int level;
    private boolean hardcore;
    private List<ActiveSkill> activeSkills;
    private List<PassiveSkill> passiveSkills;
    private Map<String, Item> items;
    private Map<String, Double> stats;
    private int lastUpdated;
    public Hero(JsonObject objIn){
        name = objIn.getString("name");
        id = objIn.getInt("id");
        className = objIn.getString("class");
        level = objIn.getInt("level");
        hardcore = objIn.getBoolean("hardcore");
        gender = objIn.getInt("gender");
        lastUpdated = objIn.getInt("last-updated");
        JsonArray jsonActiveSkills = objIn.getJsonObject("skills").getJsonArray("active");
        activeSkills = new ArrayList<ActiveSkill>();
        for(JsonValue jsonActiveSkill : jsonActiveSkills){
            if(((JsonObject)jsonActiveSkill).size() != 0){
                JsonObject jsonObj = ((JsonObject)(jsonActiveSkill)).getJsonObject("skill");
                activeSkills.add(new ActiveSkill(jsonObj));
            }
        }

        JsonArray jsonPassiveSkills = objIn.getJsonObject("skills").getJsonArray("passive");
        passiveSkills = new ArrayList<PassiveSkill>();
        for(JsonValue jsonPassiveSkill : jsonPassiveSkills){
            if(((JsonObject)jsonPassiveSkill).size() != 0){
                JsonObject jsonObj = ((JsonObject)(jsonPassiveSkill)).getJsonObject("skill");
                passiveSkills.add(new PassiveSkill(jsonObj));
            }
        }

        JsonObject jsonItems = objIn.getJsonObject("items");
        items = new HashMap<String, Item>();
        for(String key: jsonItems.keySet()){
        	
        	String id = ((JsonObject)(jsonItems.get(key))).getString("id");
        	System.out.println(key + ": " + id);
            items.put(key, controllers.DiabloItem.makeServerAPIRequest(id));
        }
        
        JsonObject jsonStats = objIn.getJsonObject("stats");
        stats = new LinkedHashMap<String, Double>();
        for(String statKey : jsonStats.keySet()){
            stats.put(statKey, jsonStats.getJsonNumber(statKey).doubleValue());
        }
        //dead = objIn.getBoolean("dead");
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getClassName(){
        return className;
    }

    public int getLevel() {
        return level;
    }

    public boolean isHardcore() {
        return hardcore;
    }

    public int getGender() {
        return gender;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }
    public Map<String, Double> getStats(){
        return stats;
    }
    public List<ActiveSkill> getActiveSkills(){
        return activeSkills;
    }
    public List<PassiveSkill> getPassiveSkills(){
        return passiveSkills;
    }
    public Map<String, Item> getItems(){
        return items;
    }
}