package com.example.minirpgjavafx;

import java.util.Scanner;


public class Main {



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Game g = new Game();
        g.adventure(scanner);


    }

}
