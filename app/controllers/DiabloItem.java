package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import models.Item;
import play.mvc.Controller;
import play.mvc.Result;
public class DiabloItem extends Controller {

    public static Result getJson(String item){
    	Item myItem = makeServerAPIRequest(item);
    	if(myItem!=null){
    		return ok(play.libs.Json.toJson(myItem));
    	}else{
    		return badRequest("There is no item with the id " + item);
    	}
    }
    public static Item makeServerAPIRequest(String itemId){
        Item item = null;
        InputStream is = null;
        try{
            is = new URL("http://us.battle.net/api/d3/data/item/" + itemId).openStream();
            System.out.println("http://us.battle.net/api/d3/data/item/" + itemId);
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            item = Item.find.byId(itemId);
            if(item==null){
                item = new Item(jsonObject);
                item.save();
            }
        }catch(Exception e){
        	e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException ex) {
            	ex.printStackTrace();
            }
        }
        
        return item;
    }

}
