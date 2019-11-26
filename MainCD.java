package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainCD {
   public static void main(String[] args) {
      List<CD> list = new ArrayList<CD>();
      list.add(new CD("AbdElhalime", "Kalimate", 7d));
      list.add(new CD("Abd elouahab doukali", "Rahel Joual", 10.25d));
      list.add(new CD("Bob Marly", "No women No cry", 10.25d));
      list.add(new CD("Cat stevens", "Wild World", 15.30d));
      System.out.println("Avant le tri : ");
      Iterator<CD> it = list.iterator();
      while(it.hasNext())
         System.out.println(it.next());
      Collections.sort(list);
      System.out.println("Après le tri : ");
      it = list.iterator();
      while(it.hasNext())
         System.out.println(it.next());
   }
}