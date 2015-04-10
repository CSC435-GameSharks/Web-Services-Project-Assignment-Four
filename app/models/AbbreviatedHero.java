/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javax.json.*;
/**
 *
 * @author csaroff
 */
public class AbbreviatedHero {
    private String name;
    private int id;
    private int level;
    private boolean hardcore;
    private int gender;
    private int lastUpdated;
    private boolean dead;
    public AbbreviatedHero(JsonObject objIn){
        name = objIn.getString("name");
        id = objIn.getInt("id");
        level = objIn.getInt("level");
        hardcore = objIn.getBoolean("hardcore");
        gender = objIn.getInt("gender");
        lastUpdated = objIn.getInt("last-updated");
        dead = objIn.getBoolean("dead");
    }
    //String toHtmlString(){
    //    StringBuilder sbReturn = new StringBuilder();
    //    
    //    sbReturn.append("           </br>\n");
    //    sbReturn.append("<a href=\"DiabloHeroServlet?hero=" + id + "\">" + "Name:    " + this.getName()+ "</a></br>\n");
    //    sbReturn.append("Level:    " + this.getLevel()+ "</br>\n");
    //    sbReturn.append("Dead:    " + (this.dead?"Yes":"No") + "</br>\n");
    //    //sbReturn.append("<a href=\"" "\">" + + " </a>")
    //    
    //    return sbReturn.toString();
    //}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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

    public boolean isDead() {
        return dead;
    }
    
}
