package com.krissirin;

public class Main {

    public static void main(String[] args){

        Plant monstera = new Plant("Laura", 3, false, true);
        while (monstera.size < 10){
            monstera.care();
        }
    }
}
