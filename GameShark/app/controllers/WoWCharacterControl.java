package controllers;

import models.WoWCharacter;
import models.WoWFormCharacter;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;


/**
 * Created by kirito on 3/26/15.
 */
public class WoWCharacterControl extends Controller {

    public static Result index(){
        String name = session("name");
        String realm = session("realm");

        if(name != null && realm != null){
            response().setContentType("text/html");
            return ok(views.html.character.render(new WoWCharacter(name, realm)));
        }else{
            response().setContentType("text/html");
            return ok(views.html.character.render(new WoWCharacter("null", "null")));
        }


    }

    public static Result getCharacter(){
        //String name = Form.form
        Form<WoWFormCharacter> characterForm = Form.form(WoWFormCharacter.class);
        WoWFormCharacter woWFormCharacter = characterForm.bindFromRequest().get();

        session("name", woWFormCharacter.name);
        session("realm", woWFormCharacter.realm);

        response().setContentType("text/html");
        return ok(views.html.character.render(new WoWCharacter(woWFormCharacter.name, woWFormCharacter.realm)));
    }
}
