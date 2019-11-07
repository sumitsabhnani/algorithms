package codechef.julycookoff2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.codechef.com/COOK96B/problems/ENCMSG
public class EncMsg {
    private static char[] reverse = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            int length = Integer.parseInt(br.readLine());
            char encoded[] = new char[length];
            char message[] = br.readLine().toCharArray();
            int end = length;
            if(length%2 == 1)
                end--;
            for(int i=0; i < end; i++) {
                encoded[i] = (i%2 == 0)? reverse[message[i+1]-'a']: reverse[message[i-1]-'a'];
            }
            if(end != length)
                encoded[length-1] = reverse[message[length-1] - 'a'];
            System.out.println(String.valueOf(encoded));
        }
    }
}
