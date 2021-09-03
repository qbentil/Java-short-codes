/******************************************************************************

Welcome qBentil Repo.
This Repo Calculates the factorial of a given number using the recursion method
Thembentil made it.
Code with bentil twitter @themanbentil

Check my CPP-Snippets Repo for the c++ version

*******************************************************************************/
import java.util.Scanner;

class Main{
    private static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {  
        int num = 1; //1 is an identity element of multitiplication
        System.out.println("Enter your option: ");
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        }else {
            System.out.println("Enter a number");
        }
        System.out.println(find_factorial(num));
    }
  
  
    public static int find_factorial(int num) {
        if (num == 1 || num == 0 ){ //Return the number if it is 0 or 1
            return num;
        }
        return find_factorial(num-1) *num;  //Using recursion
  }
}

  
