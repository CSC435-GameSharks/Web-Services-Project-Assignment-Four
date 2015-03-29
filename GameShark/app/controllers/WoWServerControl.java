package controllers;

import com.avaje.ebean.text.json.JsonElementArray;
import models.WoWServer;
import play.*;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kirito on 3/26/15.
 */
public class WoWServerControl extends Controller {

    public static Result index() {
        //JsonNode json = Json.parse("{\"realms\":[{\"name\":\"r1\", \"status\": \"true\"},{\"name\":\"r2\", \"status\": \"true\"}]}");

        //while(json.elements().hasNext()){
        //json.findValues("realms", jsonNodeList);
        //json;
        //for(int i = 0; i < jsonNodeList.size() - 1; i++){
          //  aryServer.add(Json.fromJson(jsonNodeList.get(i), WoWServer.class));
        //}

        //}


        //return ok(index.render("Server Name: " + server.getName() + ", Status: " + server.getStatus()));
        response().setContentType("text/html");
        return ok(views.html.server.render(getServers()));
        //Content html = views.html.Application.index.render(customer, orders);
    }

    private static WoWServer[] getServers(){
        JsonNode json = Json.parse("{\"name\":\"test\", \"status\": \"true\"}");
        WoWServer[] aryServer = new WoWServer[5];

        for(int i = 0; i < aryServer.length; i++){
            aryServer[i] = Json.fromJson(json, WoWServer.class);
        }

        return aryServer;
    }



}
