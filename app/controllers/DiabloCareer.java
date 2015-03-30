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
public class DiabloCareer extends Controller {


    /**
     * @return A Diablo Career using the user supplied realm and character name
     */
    private static Career makeServerAPIRequest(String  battleTagName, String battleTagCode){
        Career diabloPlayer = null;
        InputStream is = null;
        
        try{
            is = new URL("http://us.battle.net/api/d3/profile/" + battleTagName + "-" + battleTagCode + "/").openStream();
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            //if(jsonObject==null){
            //    return null;
            //}
            diabloPlayer = new Career(jsonObject);
        } catch(Exception e){
        	e.printStackTrace();
        }finally {
            try {
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
        //is = new URL("http://us.battle.net/api/d3/profile/" + battleTagName + "-" + battleTagCode + "/").openStream();
    	//WSRequest request = 
    	//	ws.url("http://us.battle.net/api/d3/profile/" 
    	//		+ battleTagName + "-" + battleTagCode + "/");
 /*
        return ok(diabloCareer.render(exists, new Diablo.Career(
        	Json.createReader(new StringReader("{"+"  \"battleTag\" : \"FaithPaladin#1761\","
+"  \"paragonLevel\" : 0,"
+"  \"paragonLevelHardcore\" : 0,"
+"  \"paragonLevelSeason\" : 0,"
+"  \"paragonLevelSeasonHardcore\" : 0,"
+"  \"heroes\" : [ {"
+"    \"paragonLevel\" : 0,"
+"    \"seasonal\" : false,"
+"    \"name\" : \"Paladin\","
+"    \"id\" : 1937977,"
+"    \"level\" : 47,"
+"    \"hardcore\" : false,"
+"    \"gender\" : 0,"
+"    \"dead\" : false,"
+"    \"class\" : \"monk\","
+"    \"lastupdated\" : 1378313644"
+"  }, {"
+"    \"paragonLevel\" : 0,"
+"    \"seasonal\" : false,"
+"    \"name\" : \"DragonPally\","
+"    \"id\" : 43830163,"
+"    \"level\" : 21,"
+"    \"hardcore\" : false,"
+"    \"gender\" : 0,"
+"    \"dead\" : false,"
+"    \"class\" : \"crusader\","
+"    \"last-updated\" : 1400154191"
+"  }, {"
+"    \"paragonLevel\" : 0,"
+"    \"seasonal\" : false,"
+"    \"name\" : \"ElricSnow\","
+"    \"id\" : 33666925,"
+"    \"level\" : 5,"
+"    \"hardcore\" : true,"
+"    \"gender\" : 0,"
+"    \"dead\" : false,"
+"    \"class\" : \"barbarian\","
+"    \"last-updated\" : 1370217234"
+"  }, {"
+"    \"paragonLevel\" : 0,"
+"    \"seasonal\" : false,"
+"    \"name\" : \"Winry\","
+"    \"id\" : 14837166,"
+"    \"level\" : 2,"
+"    \"hardcore\" : false,"
+"    \"gender\" : 1,"
+"    \"dead\" : false,"
+"    \"class\" : \"wizard\","
+"    \"last-updated\" : 1338502382"
+"  }, {"
+"    \"paragonLevel\" : 0,"
+"    \"seasonal\" : false,"
+"    \"name\" : \"Tweak\","
+"    \"id\" : 14840108,"
+"    \"level\" : 2,"
+"    \"hardcore\" : false,"
+"    \"gender\" : 0,"
+"    \"dead\" : false,"
+"    \"class\" : \"witch-doctor\","
+"    \"last-updated\" : 1338502818"
+"  }, {"
+"    \"paragonLevel\" : 0,"
+"    \"seasonal\" : false,"
+"    \"name\" : \"Heathcliff\","
+"    \"id\" : 56017817,"
+"    \"level\" : 1,"
+"    \"hardcore\" : false,"
+"    \"gender\" : 0,"
+"    \"dead\" : false,"
+"    \"class\" : \"crusader\","
+"    \"last-updated\" : 1418518631"
+"  }, {"
+"    \"paragonLevel\" : 0,"
+"    \"seasonal\" : false,"
+"    \"name\" : \"YujiKaido\","
+"    \"id\" : 14839767,"
+"    \"level\" : 1,"
+"    \"hardcore\" : false,"
+"    \"gender\" : 0,"
+"    \"dead\" : false,"
+"    \"class\" : \"demon-hunter\","
+"    \"last-updated\" : 1338502494"
+"  }, {"
+"    \"paragonLevel\" : 0,"
+"    \"seasonal\" : false,"
+"    \"name\" : \"Elric\","
+"    \"id\" : 14836905,"
+"    \"level\" : 1,"
+"    \"hardcore\" : false,"
+"    \"gender\" : 0,"
+"    \"dead\" : false,"
+"    \"class\" : \"wizard\","
+"    \"last-updated\" : 1338501880"
+"  } ],"
+"  \"lastHeroPlayed\" : 56017817,"
+"  \"lastUpdated\" : 1400154191,"
+"  \"kills\" : {"
+"    \"monsters\" : 25418,"
+"    \"elites\" : 975,"
+"    \"hardcoreMonsters\" : 277"
+"  },"
+"  \"highestHardcoreLevel\" : 5,"
+"  \"timePlayed\" : {"
+"    \"barbarian\" : 0.015,"
+"    \"crusader\" : 0.0020,"
+"    \"demon-hunter\" : 0.0,"
+"    \"monk\" : 1.0,"
+"    \"witch-doctor\" : 0.0010,"
+"    \"wizard\" : 0.0030"
+"  },"
+"  \"progression\" : {"
+"    \"act1\" : true,"
+"    \"act2\" : true,"
+"    \"act3\" : true,"
+"    \"act4\" : true,"
+"    \"act5\" : false"
+"  },"
+"  \"fallenHeroes\" : [ ],"
+"  \"blacksmith\" : {"
+"    \"slug\" : \"blacksmith\","
+"    \"level\" : 5,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 5"
+"  },"
+"  \"jeweler\" : {"
+"    \"slug\" : \"jeweler\","
+"    \"level\" : 7,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 1"
+"  },"
+"  \"mystic\" : {"
+"    \"slug\" : \"mystic\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 1"
+"  },"
+"  \"blacksmithHardcore\" : {"
+"    \"slug\" : \"blacksmith\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : -1,"
+"    \"stepMax\" : 5"
+"  },"
+"  \"jewelerHardcore\" : {"
+"    \"slug\" : \"jeweler\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 1"
+"  },"
+"  \"mysticHardcore\" : {"
+"    \"slug\" : \"mystic\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 1"
+"  },"
+"  \"blacksmithSeason\" : {"
+"    \"slug\" : \"blacksmith\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : -1,"
+"    \"stepMax\" : 5"
+"  },"
+"  \"jewelerSeason\" : {"
+"    \"slug\" : \"jeweler\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 1"
+"  },"
+"  \"mysticSeason\" : {"
+"    \"slug\" : \"mystic\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 1"
+"  },"
+"  \"blacksmithSeasonHardcore\" : {"
+"    \"slug\" : \"blacksmith\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : -1,"
+"    \"stepMax\" : 5"
+"  },"
+"  \"jewelerSeasonHardcore\" : {"
+"    \"slug\" : \"jeweler\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 1"
+"  },"
+"  \"mysticSeasonHardcore\" : {"
+"    \"slug\" : \"mystic\","
+"    \"level\" : 0,"
+"    \"stepCurrent\" : 0,"
+"    \"stepMax\" : 1"
+"  },"
+"  \"seasonalProfiles\" : {"
+"    \"season0\" : {"
+"      \"seasonId\" : 0,"
+"      \"paragonLevel\" : 0,"
+"      \"paragonLevelHardcore\" : 0,"
+"      \"kills\" : {"
+"        \"monsters\" : 25418,"
+"        \"elites\" : 975,"
+"        \"hardcoreMonsters\" : 277"
+"      },"
+"      \"timePlayed\" : {"
+"        \"barbarian\" : 0.015,"
+"        \"crusader\" : 0.0020,"
+"        \"demon-hunter\" : 0.0,"
+"        \"monk\" : 1.0,"
+"        \"witch-doctor\" : 0.0010,"
+"        \"wizard\" : 0.0030"
+"      },"
+"      \"highestHardcoreLevel\" : 5,"
+"      \"progression\" : {"
+"        \"act1\" : true,"
+"        \"act2\" : true,"
+"        \"act3\" : true,"
+"        \"act4\" : true,"
+"        \"act5\" : false"
+"      }"
+"    },"
+"    \"season1\" : {"
+"      \"seasonId\" : 1,"
+"      \"paragonLevel\" : 0,"
+"      \"paragonLevelHardcore\" : 0,"
+"      \"kills\" : {"
+"        \"monsters\" : 0,"
+"        \"elites\" : 0,"
+"        \"hardcoreMonsters\" : 0"
+"      },"
+"      \"timePlayed\" : {"
+"        \"barbarian\" : 1.0,"
+"        \"crusader\" : 1.0,"
+"        \"demon-hunter\" : 1.0,"
+"        \"monk\" : 1.0,"
+"        \"witch-doctor\" : 1.0,"
+"        \"wizard\" : 1.0"
+"      },"
+"      \"highestHardcoreLevel\" : 0,"
+"      \"progression\" : {"
+"        \"act1\" : false,"
+"        \"act2\" : false,"
+"        \"act3\" : false,"
+"        \"act4\" : false,"
+"        \"act5\" : false"
+"      }"
+"    }"
+"  }"
+"}"
)).readObject()
)));
*/
    }

}
