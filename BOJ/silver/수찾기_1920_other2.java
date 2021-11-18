import java.io.*;
import java.util.HashMap;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hm = new HashMap<>();
 
        int n = Integer.parseInt(br.readLine());
        String ns = br.readLine();
        int m = Integer.parseInt(br.readLine());
        String ms = br.readLine();
 
        String nArray[] = ns.split(" ");
        String mArray[] = ms.split(" ");
 
        for (String ss : nArray) {
            hm.put(ss, 0);
        }
 
        for (String ss : mArray) {
            if (hm.containsKey(ss)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
 
        bw.flush();
    }
 
}
