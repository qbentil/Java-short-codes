package academy.Bentilzone;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;
        while(!quit){
            int num;
            System.out.println("Enter 7 to Print actions: ");
            while (!scanner.hasNextInt()){
                System.out.println("Invalid menu input");
                System.out.println("Enter 7 to Print actions ");
                scanner.next();
            }
            num = scanner.nextInt();
            switch (num){
                case 0:
                    System.out.println("Quiting program.......");
                    quit = true;
                    break;
                case 1:
                    binToDecimal();
                    break;
                case 2:
                    decToBinary();
                    break;
                case 3:
                    decToOctal();
                    break;
                case 4:
                    octToDecimal();
                    break;
                case 5:
                    decToHexadecimal();
                    break;
                case 6:
                    HexToDecimal();
                    break;
                case 7:
                    printMenu();
                    break;
                default:
                    System.out.println("Action not found!");
                    break;
            }
        }
    }
    public static int binToDecimal(double binaryNumber){
        int remainder, i=0, decNum =0;
        while (binaryNumber !=0){
            remainder = (int)binaryNumber % 10;
            decNum = (int) (decNum + remainder * Math.pow(2, i));
            i++;
            binaryNumber/=10;
        }
        return decNum;
    }
    public static int decToBinary(int decimalNumber){
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
    public static int decToOctal(int decimalNumber){
        int remainder, i=0;
        double octNum =0;
        while (decimalNumber !=0){
            remainder = decimalNumber % 8;
            octNum = (octNum + remainder * Math.pow(10, i));
            i++;
            decimalNumber/=8;
        }
        return (int)octNum;
    }
    public static int octToDecimal(int octalNumber){
        int remainder, i=0;
        double decNum =0;
        while (octalNumber !=0){
            remainder = octalNumber % 10;
            decNum = (decNum + remainder * Math.pow(8, i));
            i++;
            octalNumber/=10;
        }
        return (int)decNum;
    }
    public static int decToHexadecimal(int decimalNumber){
        int remainder, i=0;
        double hexNum =0;
        while (decimalNumber !=0){
            remainder = decimalNumber % 16;
            hexNum = (hexNum + remainder * Math.pow(10, i));
            i++;
            decimalNumber/=16;
        }
        return (int)hexNum;
    }
    public static int HexToDecimal(int hexNum){
        int remainder, i=0;
        double decNum =0;
        while (hexNum !=0){
            remainder = hexNum % 10;
            decNum = (decNum + remainder * Math.pow(16, i));
            i++;
            hexNum/=10;
        }
        return (int)decNum;
    }
    public static void binToDecimal(){
        double num;
        System.out.println("Enter Binary number: ");
        while (!scanner.hasNextDouble()){
            System.out.println("Invalid binary input!");
            System.out.println("Enter a binary number");
            scanner.next();
        }
        num = scanner.nextDouble();
        if(containDigit(num, 0) || containDigit(num, 0)){
            System.out.println("Decimal: "+binToDecimal(num));
        }else{
            System.out.println("Number is not binary");
        }
    }
    public static void decToBinary(){
        int num;
        System.out.println("Enter an integer: ");
        while (!scanner.hasNextInt()){
            System.out.println("Invalid integer input!");
            System.out.println("Enter an integer: ");
            scanner.next();
        }
        num = scanner.nextInt();
        System.out.println("Binary number: "+decToBinary(num));
    }
    public static void decToOctal(){
        int num;
        System.out.println("Enter an integer: ");
        while (!scanner.hasNextInt()){
            System.out.println("Invalid integer input!");
            System.out.println("Enter an integer: ");
            scanner.next();
        }
        num = scanner.nextInt();
        System.out.println("Octal Number: "+decToOctal(num));
    }
    public static void octToDecimal(){
        int num;
        System.out.println("Enter an octal number: ");
        while (!scanner.hasNextInt()){
            System.out.println("Invalid octal input!");
            System.out.println("Enter an octal number");
            scanner.next();
        }
        num = scanner.nextInt();
        System.out.println("Decimal: "+octToDecimal(num));
    }
    public static void HexToDecimal(){
        int num;
        System.out.println("Enter a hexadecimal number: ");
        while (!scanner.hasNextInt()){
            System.out.println("Invalid hexadecimal input!");
            System.out.println("Enter a hexadecimal number");
            scanner.next();
        }
        num = scanner.nextInt();
        System.out.println("Decimal: "+HexToDecimal(num));
    }
    public static void decToHexadecimal(){
        int num;
        System.out.println("Enter an integer: ");
        while (!scanner.hasNextInt()){
            System.out.println("Invalid integer input!");
            System.out.println("Enter an integer number");
            scanner.next();
        }
        num = scanner.nextInt();
        System.out.println("Hexadecimal number: "+decToHexadecimal(num));
    }
    public static boolean containDigit(double number, int digit){
        int rem;
        while (number > 0){
            rem = (int)number % 10;
            if(rem == digit){
                return true;
            }
            number /=10;
        }
        return false;
    }
    public static void printMenu(){
        System.out.println("===============================");
        System.out.println("Program Menu: \nPress: " +
                "\n0- to Quit program" +
                "\n1- to Convert binary to decimal" +
                "\n2- to Convert Decimal to Binary number" +
                "\n3- to Convert Decimal to Octal number" +
                "\n4- to Convert Octal number to Decimal" +
                "\n5- to Convert Decimal to Hexadecimal number" +
                "\n6- to Convert Hexadecimal number to Decimal" +
                "\n7- to Print program actions menu");
        System.out.println("===============================");
    }
}
