package collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class Main2 {
   public static void main(String[] args) {

      ArrayList<String> aList = new ArrayList<String>();
      aList.add("1");
      aList.add("é");

        Iterator it = aList.iterator();
       while (it.hasNext()) {
          System.out.println(it.next());
         if((it.next()).equals("1")) it.remove();
       }


      Map<Integer, String> map = new HashMap<Integer, String>();
      map.put(1, "un");
      map.put(2, "deux");
      map.put(3, "trois");
      map.put(4, "quatres");
      map.put(5, "cinq");

      //set methode
      Set<Integer> setInt = map.keySet();
      Iterator<Integer> it = setInt.iterator();
      System.out.println("Parcours d'une Map avec keySet : ");
      while(it.hasNext()){
         int key = it.next();
         System.out.println("Valeur pour la clé " + key + " = " + map.get(key));
      }
      

      //set entery  methode
      Set<Entry<Integer, String>> setEntry = map.entrySet();
      Iterator<Entry<Integer, String>> itEntry = setEntry.iterator();
      System.out.println("Parcours d'une Map avec setEntry : ");
      while(itEntry.hasNext()){
         Entry<Integer, String> entry = itEntry.next();
         System.out.println("Valeur pour la clé " + entry.getKey() + " = " + entry.getValue());
      }
      
      
      Collection<String> col = map.values();
      Iterator<String> itString = col.iterator();
      System.out.println("Parcours de la liste des valeurs d'une Map avec values : ");
      while(itString.hasNext()){
         String value = itString.next();
         System.out.println("Valeur : " + value);
      }
      System.out.println("-----------------------------------");





    
   }
}
