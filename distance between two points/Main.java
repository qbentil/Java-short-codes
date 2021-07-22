import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        float x1, x2, y1, y2;
        System.out.print("Enter x1: ");
        x1 = scanner.nextFloat();
        System.out.print("Enter y1: ");
        y1 = scanner.nextFloat();
        System.out.print("Enter x2: ");
        x2 = scanner.nextFloat();
        System.out.print("Enter y2: ");
        y2 = scanner.nextFloat();
        System.out.printf("Length of line is: %.3f",lengthOfLine(x1, x2,y1,y2));  //Final Output

    }
    public static double lengthOfLine(float x1, float x2,float y1,float y2){
        float side1 = x2-x1;
        float side2 = y2-y1;
        double length =  Math.sqrt((side1*side1) + (side2*side2));
        return length;
    }
}
