import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> myMap = new LinkedHashMap<>();
        String partWithParams = scanner.nextLine().split("\\?")[1];
        String[] parts = partWithParams.split("&");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].endsWith("=")) {
                myMap.put(parts[i].split("=")[0], "not found");
            } else {
                myMap.put(parts[i].split("=")[0], parts[i].split("=")[1]);
            }
        }
        if (myMap.containsKey("pass")) {
            myMap.put("password", myMap.get("pass"));
        }
        for (Map.Entry<String, String> temp : myMap.entrySet()) {
            System.out.println(temp.getKey() + " : " + temp.getValue());
        }
    }
}