package Diablo;

import java.util.*;
import java.sql.*;
import java.util.Properties;

public class Database{
private static final String DB_URL = "jdbc:mysql://127.0.0.1/diablo";
private static final String USER = "root";
private static final String PASS = "password";
	public static void cacheItem(Item item){
   	Connection conn = null;
      Statement stmt = null;
      try{
         //STEP 2: Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         //STEP 3: Open a connection
         System.out.println("Connecting to a selected database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         System.out.println("Connected database successfully...");
         
         //STEP 4: Execute a query
         System.out.println("Inserting records into the table...");
         stmt = conn.createStatement();

         String tableName="items";
         String columns = "itemID, ";
         String values = "'"+item.getTooltipParams() + "', ";
         for(String columnName : item.getRawAttributes().keySet()){
            columns+=columnName+", ";
            values+="'"+item.getRawAttributes().get(columnName)+"', ";
         }
         columns=columns.trim().replaceAll(",$", "");
         values=values.trim().replaceAll(",$", "");

         String sql = "INSERT INTO " + tableName + " (" 
         + columns +") VALUES(" + values +");";
         System.out.println(sql);
         
         stmt.executeUpdate(sql);
         System.out.println("Inserted records into the table...");

      }catch(SQLException se){
         se.printStackTrace();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if(stmt!=null)
               conn.close();
         }catch(SQLException se){}
         try{
            if(conn!=null)
               conn.close();
         }catch(SQLException se){
            se.printStackTrace();
         }
      }
	}
   private static List<String> getColumnNames(ResultSetMetaData rsmd){
      List<String> columnNames = new ArrayList<String>();
      try{
         for(int i=1; i<=rsmd.getColumnCount(); i++){
            columnNames.add(rsmd.getColumnLabel(i));
         }
      }catch(SQLException ex){
         ex.printStackTrace();
      }
      return columnNames;
   }
   public static Item getItem(String toolTipId){
      Connection conn = null;
      Statement stmt = null;
      LinkedHashMap<String, Double> rawAttributes = new LinkedHashMap<String, Double>();
      Item item = null;
      try {
         // Step 1: Allocate a database Connection object
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
 
         // Step 2: Allocate a Statement object within the Connection
         stmt = conn.createStatement();
 
         // Step 3: Execute a SQL SELECT query
         String sqlStr = "select * from items where itemID = "
              + "'" + toolTipId + "'";
 
         ResultSet rset = stmt.executeQuery(sqlStr);  // Send the query to the server
         if (!rset.isBeforeFirst() ) {    
            return null; 
         }
         rset.next();
         List<String> columnNames = getColumnNames(rset.getMetaData());
         columnNames.remove("itemID");
         for(String columnName : columnNames) {
            double d = rset.getDouble(columnName);
            if (!rset.wasNull()) {
               System.out.println(columnName + ": " + d);
               rawAttributes.put(columnName, d);
            }
         }
         item = new Item(toolTipId, rawAttributes);
     }catch(ClassNotFoundException cnfe){
         cnfe.printStackTrace();
     }catch (SQLException ex) {
        ex.printStackTrace();
     } finally {
        try {
           // Step 5: Close the resources
           if (stmt != null) stmt.close();
           if (conn != null) conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
     }
      return item;
   }
}