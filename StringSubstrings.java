package Udemy.demo;

import java.util.ArrayList;
import java.util.List;

public class StringSubstrings {
    public static void main(String[] args) {
        String str = "HashAgile";
     // String str = "BreakingBad";
     // String str = "TitTat";


        int n = 0;

        for(int i = 0; i<str.length()-1; i++){
            String str1 = String.valueOf(str.charAt(i));
            if ((str1.toUpperCase()).equals(str1)){
                n = i;
            }
        }

        String first = str.substring(0,n);
        String second = str.substring(n);

        List<String> temp1 = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();

        for (int i=0; i<first.length(); i++){
            temp1.add(first.substring(0, i + 1));
        }
        for (int i=0; i<second.length(); i++){
            temp2.add(second.substring(0,i+1));
        }

        int i = 0;
        for (String s:temp1) {
            if (i<temp2.size()) {
                System.out.println((s+temp2.get(i)).toUpperCase());
                i++;
            }
            else {
                System.out.println((s+temp2.get(temp2.size()-1)).toUpperCase());
            }
        }
        if (temp1.size()<temp2.size()){
            while (i != temp2.size()) {
                String str1;
                str1 = temp1.get(temp1.size() - 1) + temp2.get(temp2.size() - 1);
                System.out.println(str1.toUpperCase());
                i++;
            }
        }


    }
}

