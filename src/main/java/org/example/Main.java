// Inheritance, abstraction, encaptulation, polymorphism
//Random randomizer = new Random();
package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        greet("Deni");
        greet("Amna");

        String wordd = "Supercalifragilisticexpialidocious";

        char character = wordd.charAt(3);
        System.out.println("The 4th character of the word is " + character);

        // moze var ili type
        var text = "includes text";
        var wholeNumber = 123;
        double decimalNumber = 3.141592653;
        boolean isTrue = true;
        System.out.println("The variable's type is text. Its value is " + text);
        System.out.println("The variable's type is integer. Its value is " + wholeNumber);
        System.out.println("The variable's type is decimal number. Its value is " + decimalNumber);
        System.out.println("The variable's type is truth value. Its value is " + isTrue);

        // samo u pocetku stavimo int i kad mijenjamo value ne stavljamo int.
        // ako smo stavili int ne moze biti string
        int broj = 147;
        System.out.println("Broj value is " + broj);
        broj = 33;
        System.out.println("Broj value is " + broj);

        var brojevi = new ArrayList<Integer>();
        brojevi.add(2);
        brojevi.add(7);

        // tries to remove the number from the index 4, does not work as expected!
        //numbers.remove(4);

        // this removes the number 4 from the list
        brojevi.remove(Integer.valueOf(2));

        Collections.sort(brojevi);
        for (Integer poRedu2 : brojevi) {
            System.out.println(poRedu2);
        }



        // Create an ArrayList of Strings
        var list = new ArrayList<String>();
        //ArrayList<String> teachers = new ArrayList<String>();

        // Add some elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Access elements
        System.out.println(list.get(0));  // Prints "Apple"
        System.out.println(list.get(1));  // Prints "Banana"

        //access odjednom sve
        for (String lista : list) {
            System.out.println(lista);
        }

        //po redu
        Collections.sort(list);
        for (String poRedu : list) {
            System.out.println(poRedu);
        }


        // Get the size of the list
        System.out.println("Size: " + list.size());  // Prints "Size: 3"

        // Remove an element
        list.remove(1);  // Removes "Banana"

        // Print updated list
        System.out.println(list);

        //spajanje var
        String cao = "Hi";
        String ime = " Deni";
        String pozdrav = cao + ime;
        System.out.println(pozdrav);
        System.out.println("cao" + " Deni");

        // Scanner
        Scanner reader= new Scanner(System.in);
        //ovdje ispod ide code
        System.out.print("Your name: ");
        String name = reader.nextLine(); //reading a string

        System.out.print("How old are you: ");
        int age = Integer.parseInt(reader.nextLine()); //reading an integer
        System.out.println("Your name is: " + name + ", and you are " + age + " years old.");

        //if else

        System.out.println("Choose a number: ");
        int number = Integer.parseInt(reader.nextLine());
        if (number > 10) {
            System.out.println("This number is greater than 10"); }
        else if ( number < 10) {
            System.out.println("This number is less than 10");
        } else {
            System.out.println("This number is equal to 10"); }

        var texttext = "demo";
        if (texttext.equals("dedededede")) {
            System.out.println("This is the demo text");}
        else {
            System.out.println("This is not demo text");
        }

        // using not conditional !
        System.out.println("Is the string equal to 'milk'?");
        var word = "milk";

        if (!(word.equals("milk"))) {
            System.out.println("No!");
        } else {
            System.out.println("Yes");
        }


        int brooj = 1;
        while (brooj < 11 ) {
            System.out.println(brooj);
            brooj++;
        }

        //  System.out.print("Type the first number: ");
        //int prviBr = Integer.parseInt( reader.nextLine() );

        //System.out.print("Type the second number: ");
        //int drugiBr = Integer.parseInt( reader.nextLine() );

        //System.out.print("Total: " + suma(prviBr,drugiBr) );}


    }
        // methods
        public static void greet(String name) {
            System.out.println("Hello " + name + "!");}

        //public static int suma(int prviBr, int drugiBr) {
            //return prviBr + drugiBr;}







}