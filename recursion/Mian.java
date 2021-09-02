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
        int num = 1;
        System.out.println("Enter your option: ");
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        }else {
            System.out.println("Enter a number");
        }
        System.out.println(firstFactorial(num));
    }
  
  
    public static int firstFactorial(int num) {
        if (num == 1){
            return num;
        }
        return firstFactorial(num-1) *num;
  }
}

  