import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*Parse url
        You want to hack a website now. First, get all the available parameters that you can find in the URL. Then print them in the "key : value" format. If a parameter doesn't have value, print "not found".

        If you find the password (parameter pass), you should print its value after all parameters once again, but with a key password. If a URL does not contain parameter pass, do not print anything after the listed parameters. However, if pass parameter is present, its value cannot be empty.

        Note: the order of parameters should be the same as in the URL.
        Advice: Check examples for better understanding and carefully learn the structure of the URL.


        Sample Input:
        https://target.com/index.html?pass=12345&port=8080&cookie=&host=localhost

        Sample Output:
        pass : 12345
        port : 8080
        cookie : not found
        host : localhost
        password : 12345


        Sample Input:
        https://target.com/index.html?port=8080&cookie=&host=localhost

        Sample Output:
        port : 8080
        cookie : not found
        host : localhost*/

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