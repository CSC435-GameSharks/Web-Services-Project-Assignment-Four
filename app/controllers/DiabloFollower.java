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
public class DiabloFollower extends Controller {
    public static Result index(String follower) {

    	return ok(diabloFollower.render(!follower.equals(""),makeServerAPIRequest(follower)));
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
