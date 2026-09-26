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
    static int[] ids = new int[12];
    static String[] names = new String[12];
    static Double[] weights = new Double[12];
    static int[] ages = new int[12];

    static Scanner scn = new Scanner(System.in);

    // Global how many dog counter
    static int dogDex = 0;

    public static void main(String[] args) throws Exception {
        int selectAct;

        Boolean session = true;

        welcome();
        while (session) {
            selectAct = displayPrompt();
            switch (selectAct) {
                case 1: // create
                    newDog();
                    break;
                case 2: // print
                    printDog(getDog());
                    break;
                case 3: // update
                    editDog(getDog());
                    break;
                case 4:
                    session = false;
                    break;
                case 5:
                    humanize();
                    break;

                default:
                    System.out.println("Bad option.");
                    break;
            }
        }

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
        System.out.println("\t5) Print human ages");

        System.out.print("Enter selection here --> ");
        // INPUT
        menuOption = scn.nextInt(); // also changed it here because it gave an error

        return menuOption;
    }

    // method to add new dog to arrays
    public static void newDog() {
        // create local variables
        int i = 0;
        int id = 0;
        String n = "null";
        Double w = 0.0;
        int a = 0;

        while (i < 5) {
            // check for which iteration of loop we're on, takes in appropriate info or sets
            // info
            switch (i) {
                case 0:
                    System.out.print("Please input id: ");
                    id = scn.nextInt();
                    break;
                case 1:
                    System.out.print("Please input name: ");
                    n = scn.next();
                    break;
                case 2:
                    System.out.print("Please input weight: ");
                    w = scn.nextDouble();
                    break;
                case 3:
                    System.out.print("Please input age: ");
                    a = scn.nextInt();
                    break;

                default:
                    ids[dogDex] = id;
                    names[dogDex] = n;
                    weights[dogDex] = w;
                    ages[dogDex] = a;
                    break;
            }
            i++;
        }
        dogDex++;
    }

    // method to find the index of a dog with a certain ID
    public static int getDog() {
        System.out.println("Input dog ID: ");
        int i = scn.nextInt();
        int index = -1;
        for (int validID : ids) {
            index++;
            if (validID == i) {
                return index;
            }

        }

        return -1; // don't forget to handle this!!
    }

    // method to print out the values of dog from id
    public static void printDog(int i) {
        System.out.printf("|%-4s|%-12s|%-7s|%-4s|%n", "ID", "Name", "Weight", "Age");
        System.out.printf("|%-4d|%-12s|%-7.2f|%-4d|%n", ids[i], names[i], weights[i], ages[i]);
    }

    public static void editDog(int i) {
        int selectedField;
        String newValue;

        System.out.println("Selected dog:");
        printDog(i);

        // copied from provided code
        System.out.println("\nSelect a field to update:");
        System.out.println("\t1) ID");
        System.out.println("\t2) Name");
        System.out.println("\t3) Weight");
        System.out.println("\t4) Age");

        System.out.print("Enter selection here --> ");

        // except this part which threw an error
        selectedField = scn.nextInt();

        System.out.println("New value: ");
        newValue = scn.next();

        switch (selectedField) {
            case 1:
                ids[i] = Integer.parseInt(newValue);
                break;
            case 2:
                names[i] = newValue;
                break;
            case 3:
                weights[i] = Double.parseDouble(newValue);
                break;
            case 4:
                ages[i] = Integer.parseInt(newValue);
                break;

            default:
                System.out.println("Sorry. Bad field.");
                break;
        }

        printDog(i);
    }

    public static void humanize() {
        int humanAge;
        for (int i = 0; i < dogDex; i++) {
            humanAge = ages[i] * 15;
            System.out.printf("|%-12s|%-4d|", names[i], humanAge);
        }
    }

}
