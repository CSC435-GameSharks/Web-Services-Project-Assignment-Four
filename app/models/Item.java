package models;

import javax.json.*;

import java.util.LinkedHashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.data.validation.*;


@Entity
@Table (name = "items")
public class Item extends Model{
	private static final long serialVersionUID = -1755646676202909709L;
	public static final String IMAGE_URL_PREFIX="http://media.blizzard.com/d3/icons/items/large/";
	@Id
	private String id;
	public static Finder<String, Item> find
    = new Model.Finder<>(String.class, Item.class);
	@Constraints.Required
	private String name; 	
	@Constraints.Required
	private String icon;
	@Constraints.Required
	private String displayColor;
	@Constraints.Required
	private String tooltipParams;
	@Constraints.Required
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
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setIcon(String icon){
		this.icon=icon;
	}
	public String getIcon(){
		return icon;
	}
	public void setDisplayColor(String displayColor){
		this.displayColor=displayColor;
	}
	public String getDisplayColor(){
		return displayColor;
	}
	public void setTooltipParams(String tooltipParams){
		this.tooltipParams=tooltipParams;
	}
	public String getTooltipParams(){
		return tooltipParams;
	}
	public LinkedHashMap<String, Double> getRawAttributes(){
		return rawAttributes;
	}
}