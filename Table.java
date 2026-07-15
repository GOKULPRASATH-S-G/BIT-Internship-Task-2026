import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int size=0;
        while (true){
            System.out.print("Enter array size (for P×P array): ");
            String n=sc.nextLine();
            try{
                size=Integer.parseInt(n);
                if(size>0) {
                    break;
                }else{
                    System.out.println("Invalid array size");
                }
            }catch(Exception e){
                System.out.println("Invalid input");
            }
        }

        int[][] m= new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size; j++){
                m[i][j] =2+r.nextInt(8)*2; 
            }
        }
        System.out.println("\nGenerated 2D array:");
        displayArray(m,size,-1);
        int num=0;
        while (true){
            System.out.print("\nEnter a number to highlight (even number 2-16): ");
            String input=sc.nextLine();
            try{
                num=Integer.parseInt(input);
                if(num>=2 && num<=16 && num%2==0){
                    break;
                }else{
                    System.out.println("Enter an even number between 2 and 16");
                }
            }catch(Exception e) {
                System.out.println("Invalid input");
            }
        }
        
        System.out.println("Array with " + num + " highlighted:");
        int occurrences=displayArray(m,size,num);
        System.out.println("\nNumber " + num + " appeared " + occurrences + " time(s)");
    }
    static int displayArray(int[][] grid,int size,int highlight) {
        int count=0;
        System.out.print("     ");
        for(int i= 0;i<size;i++){
            System.out.print(i + "    "); 
        }
        System.out.println();

        for(int i=0;i< size;i++) {
            System.out.print("   +");
            for(int j=0;j<size;j++) {
                System.out.print("----+");
            }
            System.out.println();
            System.out.print(i + "  |");
            for(int j=0;j<size;j++) {
                if (grid[i][j]== highlight) {
                    System.out.print("[" + grid[i][j] + "] |");
                    count++;
                } else {
                    System.out.print(" " + grid[i][j] + "  |");
                }
            }
            System.out.println();
        }
        System.out.print("   +");
        for (int j=0;j<size;j++) {
            System.out.print("----+");
        }
        System.out.println();
        return count;
    }
}