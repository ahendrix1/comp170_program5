/*--------------------------------------------
Program 5: MPLS Dog Management System
	
    Course: COMP 170, Fall I 2026
    System: GNU/Linux
    Author: Avery Hendrix
*/

import java.util.Scanner; //Importing Scanner Class

public class DogManagement {
    /*
     * Global Declaration for parallel arrays and Scanner Object
     */
    // DECLARING PARALEL ARRAYS OUTSIDE OF MAIN METHOD TO HOLD DOG DATA use the
    // static keyword
    //
    static int[] ids = new int[12];
    static String[] names = new String[12];
    static Double[] weights = new Double[12];
    static int[] ages = new int[12];

    // DECLARING SCANNER OBJECT
    static Scanner scn = new Scanner(System.in);

    // Global "what index are we acting on" ctr
    static int dogDex = 0;

    public static void main(String[] args) throws Exception {

    }

    // Welcome method that outputs introductory text explaining program
    public static void welcome() {
        System.out.println(
                "Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system.");
    }

    // Method to display prompt and return integer values
    public static int displayPrompt() {
        // Local Variables
        int menuOption;

        System.out.println("\nSelect a menu option:");
        System.out.println("\t1) Create a dog record");
        System.out.println("\t2) Display dog record");
        System.out.println("\t3) Update dog record");
        System.out.println("\t4) Exit Program");

        System.out.print("Enter selection here --> ");
        // INPUT
        menuOption = Integer.parseInt(scn.nextLine());

        return menuOption;
    }

    public static void newDog() {
        int i = 0;
        while (i < 4) {

        }

    }

    public static int getDog(int id) {

        return 0;

    }

    public static int editDog(int id) {

        return 0;

    }

}
