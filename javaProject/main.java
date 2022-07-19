import java.util.*; 
import java.util.Scanner;  // Import the Scanner classclear
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class main {
    private static Scanner x;
    
    static int method(){
        Scanner input= new Scanner(System.in);
        System.out.println("Welcome to my nutrition app!");
        System.out.println("1 - Enter new data");
        System.out.println("2 - See old data");
        System.out.println("8 - To quit");

        System.out.println("Please enter what you would like to do:");
        int option = input.nextInt();
        System.out.println(option);
        return option;
        
    }
    static void food() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter date: ");
        String date = input.nextLine();

        System.out.print("Please enter the food you ate: ");
        String food = input.nextLine();

        System.out.print("How many calories? ");
        int calories = input.nextInt();

        try{
            FileWriter fw = new FileWriter("myfileltxt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println();
            pw.println(date);
            pw.println("---------------------");
            pw.print(food + " - "); 
            pw.print(calories + " calories");
            pw.println();
            pw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }


        System.out.println(food + " with " + calories + " calories will be added!");


    }
    public static void readFile(File f) throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
        fr.close();
        }
    public static void main(String []args) throws FileNotFoundException{
        
        Macro macro1 = new Macro();
        boolean done = false;
        System.out.println("Im in!");

        do{

        
        
        

        int option = method();
        if(option == 1)
        {
            food();

            Scanner sc = new Scanner(System.in);
        System.out.println("How much protein: ");
        macro1.protein = sc.nextInt();

        System.out.println("How many carbs: ");
        macro1.carbs = sc.nextInt();

        try{
            FileWriter fw = new FileWriter("myfileltxt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println();
            pw.println("Protein consumed - " + macro1.protein); 
            pw.println("Carbs consumed - " + macro1.carbs);
            pw.println();
            pw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        }
        if(option == 2){
            File f = new File("myfileltxt");
            try{
                readFile(f);
            }
            catch(IOException e){
                e.printStackTrace();
            }
            

            

        }
        if(option == 8){
            done = true;
        }

        
    }
    while(done == false);
}
}