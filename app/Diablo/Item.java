package Diablo;

import javax.json.*;
import java.util.Map;
import java.util.LinkedHashMap;
public class Item{
	public static final String IMAGE_URL_PREFIX="http://media.blizzard.com/d3/icons/items/large/";
	private String id;
	private String name; 	
	private String icon;
	private String displayColor;
	private String tooltipParams;
	private LinkedHashMap<String, Double> rawAttributes;
	public Item(JsonObject objIn){
		this.id=objIn.getString("id");
		this.name=objIn.getString("name");
		this.icon=objIn.getString("icon");
		this.displayColor=objIn.getString("displayColor");
		this.tooltipParams=objIn.getString("tooltipParams");
		this.tooltipParams=tooltipParams.substring(tooltipParams.indexOf("/")+1);
        JsonObject jsonRawAttributes = objIn.getJsonObject("attributesRaw");
        rawAttributes = new LinkedHashMap<String, Double>();
        if(jsonRawAttributes!=null){
        	for(String rawAttributesKey : jsonRawAttributes.keySet()){
            	rawAttributes.put(rawAttributesKey.split("#")[0], jsonRawAttributes.getJsonObject(rawAttributesKey).getJsonNumber("max").doubleValue());
        	}
    	}
	}
	public Item(String tooltipParams,LinkedHashMap<String, Double> rawAttributes){
		this.rawAttributes=rawAttributes;
	}
	//public String toHtmlString(){
    //    StringBuilder sbReturn = new StringBuilder();
    //    sbReturn.append("           </br>\n");
    //    sbReturn.append("Name:    " + this.getName()+ "</br>\n");
    //    sbReturn.append("<img src=\"" + IMAGE_URL_PREFIX + this.getIcon() + ".png\">" + "</br>\n");
    //    return sbReturn.toString();
	//}

	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getIcon(){
		return icon;
	}
	public String getDisplayColor(){
		return displayColor;
	}
	public String getTooltipParams(){
		return tooltipParams;
	}
	public LinkedHashMap<String, Double> getRawAttributes(){
		return rawAttributes;
	}
}