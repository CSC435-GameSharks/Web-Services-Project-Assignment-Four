/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonValue;
/**
 *
 * @author Chaskin Saroff
 */
public class Career {
    private String battleTag;
    private int paragonLevel;
    private int paragonLevelHardcore;
    private int paragonLevelSeason;
    private int paragonLevelSeasonHardcore;
    List<AbbreviatedHero> heroes;
    private int lastHeroPlayed;
    private int lastUpdated;
    private Kill kills;

    public Career(JsonObject objIn){
        battleTag = objIn.getString("battleTag");
        paragonLevel = objIn.getInt("paragonLevel");
        paragonLevelHardcore = objIn.getInt("paragonLevelHardcore");
        paragonLevelSeason = objIn.getInt("paragonLevelSeason");
        paragonLevelSeasonHardcore = objIn.getInt("paragonLevelSeasonHardcore");
        
        JsonArray jsonHeroes = objIn.getJsonArray("heroes");
        ArrayList<AbbreviatedHero> heroes = new ArrayList<AbbreviatedHero>();
        for(JsonValue jsonHero : jsonHeroes){
            heroes.add(new AbbreviatedHero((JsonObject)(jsonHero)));
        }
        this.heroes=heroes;
        
        lastHeroPlayed = objIn.getInt("lastHeroPlayed");
        lastUpdated = objIn.getInt("lastUpdated");
        kills = new Kill(objIn.getJsonObject("kills"));
    }
    public String getBattleTag() {
        return battleTag;
    }

    public int getParagonLevel() {
        return paragonLevel;
    }

    public int getParagonLevelHardcore() {
        return paragonLevelHardcore;
    }

    public int getParagonLevelSeason() {
        return paragonLevelSeason;
    }

    public int getParagonLevelSeasonHardcore() {
        return paragonLevelSeasonHardcore;
    }

    public List<AbbreviatedHero> getHeroes(){
        return heroes;
    }

    public int getLastHeroPlayed(){
        return lastHeroPlayed;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public Kill getKills() {
        return kills;
    }
    
}
