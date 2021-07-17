// Themanbentil made it💖

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // print Program Menu
        menu();
        boolean quit = false;
        while(!quit){
            System.out.print("Enter menu Option: ");
            int num;
            while (!scanner.hasNextInt()){
                System.out.println("Invalid menu input");
                menu();
                scanner.next();
            }
            num = scanner.nextInt();
            switch (num){
                case 0:
                    System.out.println("Quiting program.......");
                    quit = true;
                    break;
                case 1:
                    fromDecimal();
                    break;
                case 2:
                    fromBinary();
                    break;
                case 3:
                    menu();
                    break;
                default:
                    System.out.println("Action not found!");
                    break;
            }
        }
    }

    // Initing function

    // Decimal to others1
    public static void fromDecimal() {
        int num;
        System.out.print("Enter Decimal Number: ");
        while (!scanner.hasNextInt()){
            System.out.println("Invalid Decimal input!");
            System.out.println("Enter an Decimal Number: ");
            scanner.next();
        }
        num = scanner.nextInt();

        // Output calculateed figures
        System.out.println("Binary number: " + decToBinary(num));
        System.out.println("Octal number: " + decToOctal(num));
        System.out.println("Hexadecimal number: " + decToHexadecimal(num) + "\n");



    }


    // comnverting from binary
    public static void fromBinary() {
        String str;
        System.out.print("Enter Binary Number: ");

        str = scanner.next();
        while (!str.matches("^[01]+$")){
            System.out.println("Invalid Binary number!");
            System.out.print("Enter Binary number: ");
            // scanner.nextLine();
            str = scanner.next();
        }

        int num = Integer.parseInt(str);


        // Output calculated figures
        System.out.println("Decimal number: " + binToDecimal(num));
        System.out.println("Octal number: " + binToOct(num));
        System.out.println("Hexadecimal number: " + binToHex(num));
    }


    // Decimal Calculation
    static int decToBinary(int decimalNumber){
        int remainder, i=0;
        double binNum =0;
        while (decimalNumber !=0){
            remainder = decimalNumber % 2;
            binNum = (binNum + remainder * Math.pow(10, i));
            i++;
            decimalNumber/=2;
        }
        return (int)binNum;
    }
    static int decToOctal(int decimalNumber){
        int remainder, i=0;
        double octNum =0;
        while (decimalNumber !=0){
            remainder = decimalNumber % 8;
            octNum = octNum + (remainder * Math.pow(10, i));
            i++;
            decimalNumber/=8;
        }
        return (int)octNum;
    }
    static String decToHexadecimal(int decimalNumber){
        int remainder;
        String hexNum = "";
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while (decimalNumber > 0){
            remainder = decimalNumber % 16;
            hexNum = hexchars[remainder] + hexNum;
            decimalNumber/=16;
        }
        return hexNum;
    }


    // Binary Calculations
    static int binToDecimal(int binaryNumber){
        int remainder, i=0, decNum =0;
        while (binaryNumber !=0){
            remainder = binaryNumber % 10;
            decNum += remainder * Math.pow(2, i);
            i++;
            binaryNumber/=10;
        }
        return decNum;
    }

    static int binToOct(int binaryNumber)
    {
        int octal = binToDecimal(binaryNumber);
        return decToOctal(octal);
    }

    static String binToHex(int binaryNumber)
    {
        int decimal = binToDecimal(binaryNumber);
        return decToHexadecimal(decimal);
    }

    static void menu(){
        System.out.println("===============================");
        System.out.println("Program Menu:" +
                "\n0- to Quit program" +
                "\n1- to Convert from Decimal" +
                "\n2- to Convert from Binary" +
                "\n3- to Print program actions menu");
        System.out.println("===============================");
    }
}
