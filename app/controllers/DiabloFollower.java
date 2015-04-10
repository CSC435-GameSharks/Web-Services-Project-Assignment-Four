package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import models.Follower;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.diabloFollower;
public class DiabloFollower extends Controller {
    public static Result index(String follower) {
        if(follower.equals("")){
            return ok(diabloFollower.render(false,null));
        }
    	return ok(diabloFollower.render(true,makeServerAPIRequest(follower)));
    }
    public static Result getJson(String follower){
    	Follower myFollower = makeServerAPIRequest(follower);
    	if(myFollower!=null){
    		return ok(play.libs.Json.toJson(myFollower));
    	}else{
    		return badRequest("There is no follower " + follower);
    	}
    }
    private static Follower makeServerAPIRequest(String strFollower){
        Follower diabloFollower = null;
        InputStream is = null;
        try{
            is = new URL("http://us.battle.net/api/d3/data/follower/" + strFollower).openStream();
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();

            diabloFollower = new Follower(jsonObject);
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return diabloFollower;
    }



}
