package tasks;

import java.util.*;

public class ExampleMapping {
    public static void main(String[] args){

//       Object[][] rowData = {
//               {12,"Jeevan",50000},
//               {13,"Jeevan",25000}
//       };

       List<List<Object>> rowData = Arrays.asList(
               Arrays.asList(12,"Jeevan",50000),
               Arrays.asList(13,"Jeevan",25000)
       );

//        String[] columnData = {"ID","Name","Salary"};

        List<String> columnData = Arrays.asList("ID","Name","Salary");

        List<Map<String,Object>> mappedData = new ArrayList<>();

        //using linked hashmap preserves the order of the row data
        for(List<Object> row : rowData){
            Map<String,Object> rowMap = new LinkedHashMap<>();
            for(int i = 0;i<columnData.size();i++){
                rowMap.put(columnData.get(i),row.get(i));
            }
            mappedData.add(rowMap);
        }

        for(Map<String,Object> map : mappedData){
            System.out.println(map);
        }
    }
}
