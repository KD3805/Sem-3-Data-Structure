import java.util.HashMap;

class ImplementHashMap {

  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();

    map.put("Kishan", 25);
    map.put("Parth", 69);

    System.out.println("Size of map is:- " + map.size());

    System.out.println(map);

    if (map.containsKey("Parth")) {
      // Mapping
      int a = map.get("Parth");

      // Printing value for the corresponding key
      System.out.println("value for key" + " \"Parth\" is:- " + a);
    }
  }
}
