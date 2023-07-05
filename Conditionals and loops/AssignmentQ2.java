//Area Of Triangle

import java.util.Scanner;

public class AssignmentQ2{
    public static void main(String[] args) {
        System.out.print("How many sides in a triangle?: ");

        try (Scanner input = new Scanner(System.in)) {
            int sides = input.nextInt();

            if ( sides == 2){

                TwoSides();
            }

            else if ( sides == 3){
                ThreeSides();
            }

            else{
                System.out.println("Please Enter valid number of sides (A triangle is a polygon with three sides having three vertices)");
            }
        }

       
            
        }

        public static void TwoSides() {

            System.out.println("Enter base, Height and Angle (Enter 90 if it is a right triangle)");

            try (Scanner input = new Scanner(System.in)) {
                int base = input.nextInt();
                int height = input.nextInt();
                double angleInDegrees = input.nextInt();

                double angleInRadians = Math.toRadians(angleInDegrees);
                double SineValue = Math.sin(angleInRadians);

                double area2 = 0.5 * base * height * SineValue;

                System.out.println("The are of the Triangle is : " + area2);

               
            }

            
            
        }

        public static void ThreeSides() {

            System.out.println("Enter three Sides: ");

            try (Scanner input = new Scanner(System.in)) {
                int side1 = input.nextInt();
                int side2 = input.nextInt();
                int side3 = input.nextInt();

                float s = (side1 + side2 + side3) / 2;

                double area = s * (s - side1) * (s - side2) * (s - side3);

                double AreaRoot = Math.sqrt(area);

                System.out.println("The are of the Triangle is : " + AreaRoot);

                
            }

        }
        
    }


    

