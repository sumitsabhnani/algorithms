package others;

public class StrPermutations {

    String in;
    StringBuilder out;
    boolean used[];

    public StrPermutations(String in) {
        this.in = in;
        out = new StringBuilder();
        used = new boolean[in.length()];
    }


    public static void main(String[] args) {
        StrPermutations strPermutations = new StrPermutations("abc");
        //strPermutations.combinations();
        strPermutations.permute("ABC", 0, 2);
    }

    public void permute(){
        if(in.length() == out.length()){
            System.out.println(out);
            return;
        }
        for (int i=0; i< in.length() ; i++){
            if(!used[i]) {
                out.append(in.charAt(i));
                used[i] = true;
                permute();
                used[i] = false;
                out.setLength(out.length() - 1);
            }
        }
    }

    public void permute(String str, int l, int r) {
        if(l == r) {
            System.out.println(str);
        } else {
            for(int i = l; i <=r ; i++) {
                str = swap(str, l, i);
                permute(str, l+1, r);
            }
        }
    }

    private String swap(String str, int l, int i){
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[l];
        arr[l] = temp;
        return new String(arr);
    }
}
