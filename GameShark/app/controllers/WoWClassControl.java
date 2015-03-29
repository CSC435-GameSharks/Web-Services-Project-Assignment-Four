package controllers;

import models.*;
import play.data.Form;
import play.mvc.*;
import play.data.Form;
import scala.collection.immutable.List;


/**
 * Created by kirito on 3/27/15.
 */
public class WoWClassControl extends Controller {

    public static Result getWoWClass(){
        Form<WoWFormClass> classForm = Form.form(WoWFormClass.class);
        WoWFormClass wowFormClass = classForm.bindFromRequest().get();

        //Make WoWClass Detail
        String tempName = "Warrior";
        int tempClassID = 1;
        String tempSpecID = "0";

        if(wowFormClass.classID != null){
            tempClassID = Integer.parseInt(wowFormClass.classID);
            if(wowFormClass.classID.equals("1")){
                tempName = "Warrior";
            }else if(wowFormClass.classID.equals("2")){
                tempName = "Paladin";
            }
        }

        if(wowFormClass.specID != null){
            tempSpecID = wowFormClass.specID;
        }
        WoWClassDetail wowClass = new WoWClassDetail(tempName, tempClassID, "Insert Bio Here");
        WoWSpell[] wowSpells = initSpells();
        WoWTalent[] wowTalents = initTalents();
        WoWSpec[] wowSpecs = initSpecs();
        String[] aryRoles = {"Role 1","Role 2","Role 3"};
        wowClass.setRoles(aryRoles);

        response().setContentType("text/html");
        return ok(views.html.wowclass.render(wowClass, wowSpells, wowTalents, wowSpecs, Integer.parseInt(tempSpecID)));
    }

    private static WoWSpell[] initSpells(){
        WoWSpell[] wowSpells = new WoWSpell[15];
        wowSpells[0] = new WoWSpell("Spell 1", 1, 1);
        wowSpells[1] = new WoWSpell("Spell 2", 1, 2);
        wowSpells[2] = new WoWSpell("Spell 3", 1, 3);
        wowSpells[3] = new WoWSpell("Spell 4", 1, 4);
        wowSpells[4] = new WoWSpell("Spell 5", 1, 5);
        wowSpells[5] = new WoWSpell("Spell 6", 1, 6);
        wowSpells[6] = new WoWSpell("Spell 7", 1, 7);
        wowSpells[7] = new WoWSpell("Spell 8", 1, 8);
        wowSpells[8] = new WoWSpell("Spell 9", 1, 9);
        wowSpells[9] = new WoWSpell("Spell 10", 1, 10);
        wowSpells[10] = new WoWSpell("Spell 11", 1, 11);
        wowSpells[11] = new WoWSpell("Spell 12", 1, 12);
        wowSpells[12] = new WoWSpell("Spell 13", 1, 13);
        wowSpells[13] = new WoWSpell("Spell 14", 1, 14);
        wowSpells[14] = new WoWSpell("Spell 15", 1, 15);

        return wowSpells;
    }

    private static WoWTalent[] initTalents(){
        WoWTalent[] wowTalents = new WoWTalent[15];
        wowTalents[0] = new WoWTalent("Talent 1", 15, 1);
        wowTalents[1] = new WoWTalent("Talent 2", 15, 2);
        wowTalents[2] = new WoWTalent("Talent 3", 15, 3);
        wowTalents[3] = new WoWTalent("Talent 4", 30, 4);
        wowTalents[4] = new WoWTalent("Talent 5", 30, 5);
        wowTalents[5] = new WoWTalent("Talent 6", 30, 6);
        wowTalents[6] = new WoWTalent("Talent 7", 45, 7);
        wowTalents[7] = new WoWTalent("Talent 8", 45, 8);
        wowTalents[8] = new WoWTalent("Talent 9", 45, 9);
        wowTalents[9] = new WoWTalent("Talent 10", 60, 10);
        wowTalents[10] = new WoWTalent("Talent 11", 60, 11);
        wowTalents[11] = new WoWTalent("Talent 12", 60, 12);
        wowTalents[12] = new WoWTalent("Talent 13", 75, 13);
        wowTalents[13] = new WoWTalent("Talent 14", 75, 14);
        wowTalents[14] = new WoWTalent("Talent 15", 75, 15);

        return wowTalents;

    }

    private static WoWSpec[] initSpecs(){
        WoWSpec[] woWSpecs = new WoWSpec[3];
        woWSpecs[0] = new WoWSpec("Spec 1", 0);
        woWSpecs[1] = new WoWSpec("Spec 2", 1);
        woWSpecs[2] = new WoWSpec("Spec 3", 2);

        return woWSpecs;
    }
}
