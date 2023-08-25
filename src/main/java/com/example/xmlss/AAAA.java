package com.example.xmlss;

public class AAAA {
    public static void main(String[] args) {

        int[] ertekek = {-2, 1, 4, 2, 5, -10};


        for (int i = 0; i < ertekek.length; i++) {
            for (int j = 1; j < ertekek.length  -1;  j++) {
                if(ertekek[j-1] < ertekek[j] ){
                    int temp = ertekek[j-1];
                    ertekek[j-1] = ertekek[j];
                    ertekek[j] = temp;
                }
            }
        }
    }
}
