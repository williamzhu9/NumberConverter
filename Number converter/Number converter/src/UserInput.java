import java.util.Scanner;


public class UserInput {

    static boolean IsValid(String input, String type){
        //For decimal inputs
        if (type.equals("Decimal")){
            if(input.matches("[0-9]+")) return true;
            else System.out.println("Invalid input, please try again");
            return false;
        }
        //Hexadecimal inputs
        else if(type.equals("Hex")){
            if(input.matches("[0-9A-F]+")) return true;
            else System.out.println("Invalid input, please try again");
            return false;
        }
        //Binary inputs
        else {
            if(input.matches("[0-1 ]+")) return true;
            else System.out.println("Invalid input, please try again");
            return false;
        }
    }

    //Collecting initial input from user
    static String GetInput(String type){
        String UserInput;
        //Asking user for input
        do{
            System.out.println("Please enter the number that you would like to convert. ");
            Scanner input = new Scanner(System.in);
            UserInput = input.nextLine();
        } while(!IsValid(UserInput,type));
        return UserInput;
    }
}
