/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author csaroff
 */
import javax.json.JsonObject;
public class Skill{
    public final String IMAGE_URL_PREFIX="http://media.blizzard.com/d3/icons/skills/64/";
    private String slug;
    private String name;
    private String icon;
    private int level;
    private String tooltipUrl;
    private String description;
    //private String simpleDescription;
    private String skillCalcId;
    public Skill(JsonObject objIn){
        slug=objIn.getString("slug");
        name=objIn.getString("name");
        icon=objIn.getString("icon");
        level=objIn.getInt("level");
        tooltipUrl=objIn.getString("tooltipUrl");
        description=objIn.getString("description");
        skillCalcId=objIn.getString("skillCalcId");
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public int getLevel() {
        return level;
    }

    public String getTooltipUrl() {
        return tooltipUrl;
    }

    public String getDescription() {
        return description;
    }

    //public String getSimpleDescription() {
    //    return simpleDescription;
    //}

    public String getSkillCalcId() {
        return skillCalcId;
    }
    
}
