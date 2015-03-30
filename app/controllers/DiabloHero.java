package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import javax.json.*;
import java.util.*;
import java.io.*;
import Diablo.*;
import java.net.URL;
import java.net.MalformedURLException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import play.mvc.*;
import play.libs.ws.*;
import play.libs.F.Function;
import play.libs.F.Promise;
public class DiabloHero extends Controller {
    /**
     * @return A Diablo Career using the user supplied realm and character name
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

    public static Result index(String battleID, String hero) {
    	return ok(diabloHero.render(makeServerAPIRequest(battleID, hero)));
    }

}
