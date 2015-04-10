package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import models.Hero;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.diabloHero;
public class DiabloHero extends Controller {
    /**
     * @return A models Career using the user supplied realm and character name
     */
    private static Hero makeServerAPIRequest(String battleID, String strHero){
        Hero diabloHero = null;
        InputStream is = null;
        try{
            is = new URL("http://us.battle.net/api/d3/profile/" + battleID + "/hero/" + strHero).openStream();
            System.out.println("http://us.battle.net/api/d3/profile/" + battleID + "/hero/" + strHero);
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            diabloHero = new Hero(jsonObject);
        }catch(Exception e){
        	e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException ex) {
            	ex.printStackTrace();
            }
        }
        
        return diabloHero;
    }

    public static Result index(String battleId, String hero) {
    	return ok(diabloHero.render(makeServerAPIRequest(battleId, hero)));
    }
    
    public static Result getJson(String battleId, String hero){
    	if(!battleId.equals("") && !hero.equals("")){
    		Hero myHero = makeServerAPIRequest(battleId, hero);
    		if(myHero!=null){
    			return ok(play.libs.Json.toJson(myHero));
    		}else{
    			return badRequest("The hero associated with battleId="+battleId+" and hero="+hero+" does not exist.");
    		}
    	}else{
    		return badRequest("The battleTagName and the battleTagId must not be empty");
    	}
    }
}
