import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("[Intersection Detector]\n");
    int options;

    int point_x = 0;
    int point_y = 0;

    int area_1_x = 0;
    int area_1_y = 0;
    int area_1_width = 0;
    int area_1_height = 0;

    int area_2_x = 0;
    int area_2_y = 0;
    int area_2_width = 0;
    int area_2_height = 0;

    do { 
        System.out.println("1. Enter point");
        System.out.println("2. Enter Area 1");
        System.out.println("3. Enter Area 2");
        System.out.println("4. Point-Area Intersection");
        System.out.println("5. Area-Area Intersection");
        System.out.println("6. View info");
        System.out.println("7. Quit");
        System.out.print("Select option: ");
        options = input.nextInt();

        switch (options) {
            case 1:              
                System.out.print("Enter x-coordinate of Point: ");
                point_x = input.nextInt();
                System.out.print("Enter y-coordinate of Point: ");
                point_y = input.nextInt();
                System.out.println("\nPoint coordinates updated.\n");
                break;
            case 2:
                System.out.print("Enter x-coordinate of Area 1: ");
                area_1_x = input.nextInt();
                System.out.print("Enter y-coordinate of Area 1: ");
                area_1_y = input.nextInt();
                System.out.print("Enter width of Area 1: ");
                area_1_width = input.nextInt();
                System.out.print("Enter height of Area 1: ");
                area_1_height = input.nextInt();
                System.out.println("\nArea 1 updated\n");
                break;
            case 3:
                System.out.print("Enter x-coordinate of Area 2: ");
                area_2_x = input.nextInt();
                System.out.print("Enter y-coordinate of Area 2: ");
                area_2_y = input.nextInt();
                System.out.print("Enter width of Area 2: ");
                area_2_width = input.nextInt();
                System.out.print("Enter height of Area 2: ");
                area_2_height = input.nextInt();
                System.out.println("\nArea 2 updated\n");
                break;
            case 4:
                System.out.print("Use Area 1 or Area 2? ");
                int chosenArea = input.nextInt();
                int leftArea;
                int rightArea;
                int topArea;
                int bottomArea;

                if (chosenArea == 1) {
                    leftArea = area_1_x - area_1_width; 
                    topArea = area_1_y;
                    rightArea = area_1_x + area_1_width;
                    bottomArea = area_1_y + area_1_height;
                }
                else if (chosenArea == 2) {
                    leftArea = area_2_x - area_2_width;
                    topArea = area_2_y;
                    rightArea = area_2_x + area_2_width;
                    bottomArea = area_2_y + area_2_height;
                } else {
                    System.out.println("Invalid. Please try again");
                    break;
                }
                boolean isPointInsideArea =
                    point_x >= leftArea &&
                    point_x <= rightArea &&
                    point_y >= topArea &&
                    point_y <= bottomArea;

                if (isPointInsideArea) {
                    System.out.println("\nThe point is in Area "+chosenArea+".\n");
                } else {
                    System.out.println("\nThe point is NOT in Area "+chosenArea+ ".\n");
                }
                break;
            case 5:
                int left1 = area_1_x;
                int top1 = area_1_y;
                int right1 = area_1_x + area_1_width;
                int bottom1 = area_1_y + area_1_height;

                int left2 = area_2_x;
                int top2 = area_2_y;
                int right2 = area_2_x + area_2_width;
                int bottom2 = area_2_y + area_2_height;

                boolean isAreaIntersecting =
                    left1 <= right2 &&
                    right1 >= left2 &&
                    top1 <= bottom2 &&
                    bottom1 >= top2;
                if (isAreaIntersecting) {
                    System.out.println("The two areas intersect.\n");
                } else {
                    System.out.println("\nThe two areas do NOT intersect.\n");
                }
                break;
            case 6:
                System.out.println("\nPoint x: " + point_x + ", y: " + point_y);
                System.out.println("Area 1 x: " + area_1_x + ", y: " + area_1_y + ", width: " + area_1_width + ", height: " +area_1_height);
                System.out.println("Area 2 x: " + area_2_x + ", y: " + area_2_y + ", width: " + area_2_width + ", height: " +area_2_height + "\n");
                break;
            case 7:
                System.out.println("Shutting off...");
                break;
            default: 
                System.out.println("\nInvalid option. Try again.");
                break;     
        }

    } while (options != 7);
    input.close();
    }
}
