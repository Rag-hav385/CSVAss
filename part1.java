import edu.duke.*;
import org.apache.commons.csv.*;

/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part1 {
    public void countryinfo(CSVParser parser,String country){
        for (CSVRecord record : parser){
            String con = record.get("Country");
            
            if(con.contains(country)){
                 String  exports1 = record.get("Exports");
                 String  value1 = record.get("Value (dollars)");
                 System.out.println(con + ":" + exports1 + ":" + value1);
             }
        }
    }
    
    public void testcountryinfo(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryinfo(parser , "Nauru");
    }
    
    public void listExportersTwoProducts(CSVParser parser , String ExportItem1 , String ExportItem2){
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            
            if(exports.contains(ExportItem1)){
                if(exports.contains(ExportItem2)){
                    String Country = record.get("Country");
                    System.out.println(Country);
                }
            }
        }
    }
        
        public void testlistExportersTwoProducts(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser , "cotton","flowers");
    }
    
        public void numberOfExporters(CSVParser parser , String element){
            int count = 0;
            for (CSVRecord record : parser){
                
                String exports = record.get("Exports");
                
                if(exports.contains(element)){
                    count = count + 1;
                }
                
        }
        System.out.print(count);
    }
    
        public void testnumberOfExporters(){
            FileResource fr = new FileResource();
            CSVParser parser =  fr.getCSVParser();
            numberOfExporters(parser,"cocoa");
            
            
        }
    public void bigexporters(CSVParser parser , String element){
        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            int n = value.length();
            int m = element.length();
            
            if (n < m){
                String country = record.get("Country");
                System.out.println(country + ":" + value);
            
        }
    }
}

public void testbigexporters(){
    FileResource fr = new FileResource();
    CSVParser parser =  fr.getCSVParser();
    bigexporters(parser , "$999,999,999,999");
}
    
}
