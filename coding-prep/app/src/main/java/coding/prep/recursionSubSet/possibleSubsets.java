package org.dsaPractice.recursionSubSet;

import java.util.ArrayList;

public class possibleSubsets {
    public static void main(String[] args) {
        System.out.println(findPossibleItemsWithReturn("","abc"));
        
    }

    static void findPossibleItemsNoReturn(String p,String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }


        char ch = up.charAt(0);
        findPossibleItemsNoReturn(p + ch, up.substring(1));
        findPossibleItemsNoReturn(p, up.substring(1));
    }

    static ArrayList<String> findPossibleItemsWithReturn(String p,String up) {
        if(up.isEmpty() && !p.isEmpty()){
            ArrayList<String> a = new ArrayList<>();
            a.add(p);
            return a;
        }

        char ch = up.charAt(0);
        ArrayList<String> firstHalf = findPossibleItemsWithReturn(p + ch, up.substring(1));
        ArrayList<String> secondHalf = findPossibleItemsWithReturn(p, up.substring(1));
        firstHalf.addAll(secondHalf);
        return firstHalf;
    }
}
