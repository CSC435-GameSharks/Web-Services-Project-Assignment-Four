package controllers;

import java.io.IOException;

import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;



import models.Career;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.diabloCareer;
public class DiabloCareer extends Controller {


    /**
     * @return A models Career using the user supplied realm and character name
     */
    private static Career makeServerAPIRequest(String  battleTagName, String battleTagCode){
        Career diabloPlayer = null;
        InputStream is = null;
        
        try{
            is = new URL("http://us.battle.net/api/d3/profile/" + battleTagName + "-" + battleTagCode + "/").openStream();
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            if(jsonObject!=null)
                diabloPlayer = new Career(jsonObject);
            else
                return null;
        } catch(Exception e){
        	e.printStackTrace();
        }finally {
            try {
                if(is!=null)
                    is.close();
            } catch (IOException ex) {
            	ex.printStackTrace();
            }
        }
        
        return diabloPlayer;
    }

    public static Result index(String battleTagName, String battleTagCode) {
    	boolean exists = false;
    	if(!battleTagName.equals("") && !battleTagCode.equals("")){
    		exists = true;
    	}
    	return ok(diabloCareer.render(exists, makeServerAPIRequest(battleTagName, battleTagCode)));
    }
    
    public static Result getJson(String battleTagName, String battleTagCode){
    	if(!battleTagName.equals("") && !battleTagCode.equals("")){
    		Career career = makeServerAPIRequest(battleTagName, battleTagCode);
    		if(career!=null){
    			return ok(play.libs.Json.toJson(career));
    		}else{
    			return badRequest("The career profile associated with "+battleTagName+"-"+battleTagCode+" does not exist.");
    		}
    	}else{
    		return badRequest("The battleTagName and the battleTagId must not be empty");
    	}
    }
}
