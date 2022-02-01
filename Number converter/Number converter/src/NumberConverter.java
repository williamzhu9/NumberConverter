import static java.lang.Long.parseLong;
import java.util.ArrayList;
import java.util.Scanner;


public class NumberConverter {
    public static void main(String[] args){
        //Declaring Variables
        int selection, DecOutput;
        long Dec;
        String type;

        Scanner menu = new Scanner(System.in);
        ArrayList<Character> Output = new ArrayList<>();

        do {
            Output.clear();
            System.out.println("Which converter would you like to use? Please select from the following options ");
            System.out.println("""
                    1. Decimal to Hexadecimal
                    2. Decimal to Binary
                    3. Hexadecimal to Decimal
                    4. Hexadecimal to Binary
                    5. Binary to Decimal
                    6. Binary to Hexadecimal
                    7. Exit program""");
            try {
                selection = Integer.parseInt(menu.nextLine());
            } catch (Exception e){
                selection = 0;
            }
            switch(selection){
                case 1:
                    type = "Decimal";
                    Dec = (parseLong(UserInput.GetInput(type)));
                    Calculations.DecToHex(Output,Dec);

                    for(int i = Output.size(); i > 0; i--) System.out.print(Output.get(i-1));
                    break;
                case 2:
                    type = "Decimal";
                    Dec = (parseLong(UserInput.GetInput(type)));
                    Calculations.DecToBin(Output,Dec);

                    for(int i = Output.size(); i > 0; i--) System.out.print(Output.get(i-1));
                    break;
                case 3:
                    type = "Hex";
                    DecOutput = Calculations.HexToDec(UserInput.GetInput(type));
                    System.out.println(DecOutput);
                    break;
                case 4:
                    type = "Hex";
                    Calculations.HexToBin(Output,UserInput.GetInput(type));
                    for (Character character : Output) System.out.print(character);
                    break;
                case 5:
                    type = "Bin";
                    DecOutput = Calculations.BinToDec(UserInput.GetInput(type));
                    System.out.println(DecOutput);
                    break;
                case 6:
                    type = "Bin";
                    Calculations.BinToHex(Output,UserInput.GetInput(type));
                    for(int i = Output.size(); i > 0; i--) System.out.print(Output.get(i-1));
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid input please try again");
            }
            System.out.println();
        } while(selection != 7);
    }
}
