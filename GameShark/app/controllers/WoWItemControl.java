package controllers;

import models.*;
import play.data.Form;
import play.mvc.*;

/**
 * Created by kirito on 3/28/15.
 */
public class WoWItemControl extends Controller {

    public static Result getWoWItem(){
        Form<WoWFormItem> itemForm = Form.form(WoWFormItem.class);
        WoWFormItem wowFormItem = itemForm.bindFromRequest().get();


        response().setContentType("text/html");
        return  ok(views.html.wowitem.render(wowFormItem, calcStats(wowFormItem)));
    }

    private static WoWStats calcStats(WoWFormItem formItemIn){
        WoWStats statsReturn = new WoWStats();
        if(formItemIn.head == null){
            statsReturn.str = 0;
            statsReturn.agi = 0;
            statsReturn.sta = 0;
            statsReturn.ints = 0;
            statsReturn.spi = 0;
        }else{
            statsReturn.str = 1;
            statsReturn.agi = 1;
            statsReturn.sta = 1;
            statsReturn.ints = 1;
            statsReturn.spi = 1;
        }
        return statsReturn;
    }

}
