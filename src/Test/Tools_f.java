package Test;

public class Tools_f {
    static int FindSubStr(String s,String sub,int index){
        int len1 = s.length();
        int len2 = sub.length();
        int Index = 0;
        for(int i=0,j=0;i<len2;i++,j++){
            if(index + j >= len1) return -1;
            if(s.charAt(index+j)==sub.charAt(i)) Index=index+j;
            else i=0;
        }
        return Index - len2 + 1;
    }
    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "def";
        System.out.println(FindSubStr(s1,s2,0));
    }
}
