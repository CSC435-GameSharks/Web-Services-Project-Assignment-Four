package models;
import java.util.List;
import java.util.LinkedHashMap;
public class ItemBuilder{
	//private List<Item> items;
	private LinkedHashMap<String, Double> stats = new LinkedHashMap<String, Double>();
	public ItemBuilder(List<Item> items){
		if(items!=null){
			for(Item item : items){
				System.out.println("itemName=" + item.getName());
				LinkedHashMap<String, Double> rawAttributes = item.getRawAttributes();
				for(String rawAttributesKey : rawAttributes.keySet()){
					if(stats.get(rawAttributesKey)==null){
						stats.put(rawAttributesKey, rawAttributes.get(rawAttributesKey));
					}else{
						Double totalBuildAttributeValue = stats.get(rawAttributesKey);
						Double itemAttributeValue = rawAttributes.get(rawAttributesKey);
						stats.put(rawAttributesKey, totalBuildAttributeValue + itemAttributeValue);
					}
				}
			}
		}
	}
	public LinkedHashMap<String, Double> getStats(){
		for(String statName : stats.keySet()){
			System.out.print(statName + " DOUBLE, ");
		}
		return stats;
	}
	public String toString(){
		return stats.toString();
	}
}