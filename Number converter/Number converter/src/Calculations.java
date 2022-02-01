import java.util.ArrayList;


public class Calculations {

    static void DecToHex(ArrayList<Character> Arr, long Dec){
        char HexDig;

        while(Dec != 0){
            if(Dec % 16 < 10) HexDig = (char)(Dec % 16 + 48);
            else HexDig = (char)(Dec % 16 + 55);
            Arr.add(HexDig);
            Dec /= 16;
        }
    }

    static void DecToBin(ArrayList<Character> Arr, long Dec){
        char BinDig;
        int i = 0;

        while(Dec != 0){
            if(i == 4) {
                Arr.add(' ');
                i = 0;
            }
            else{
                BinDig = (char)(Dec % 2 + 48);
                Arr.add(BinDig);
                Dec /= 2;
                i++;
            }
        }
        if(i != 4) {
            for(int j = 0; j < (4 - i); j++){
                Arr.add('0');
            }
        }
    }

    static int HexToDec(String Hex){
        char HexDig;
        int Dec = 0, j = 0;

        for(int i = Hex.length(); i > 0; i --){
            HexDig = Hex.charAt(i-1);
            if(HexDig >= 'A' && HexDig <= 'F') Dec += (int)((HexDig - 55) * Math.pow(16,j));
            else Dec += (int)((HexDig - 48) * Math.pow(16,j));
            j++;
        }
        return Dec;
    }

    static void HexToBin(ArrayList<Character> Arr, String Hex){
        char HexDig;
        int x, Nib;

        for(int i = 0; i < Hex.length(); i++){
            HexDig = Hex.charAt(i);
            if(HexDig >= 'A' && HexDig <= 'F') Nib = (HexDig - 55);
            else Nib = (HexDig - 48);
            x = 8;
            while (Nib > 0) {
                while (x > Nib) {
                    x /= 2;
                    Arr.add('0');
                }
                Nib -= x;
                x /= 2;
                Arr.add('1');
            }
            while(x > 0){
                Arr.add('0');
                x /= 2;
            }
            Arr.add(' ');
        }
    }

    static int BinToDec(String Bin){
        int Dec = 0, BinDig, j = 0;

        for(int i = Bin.length(); i > 0; i--){
            if(Bin.charAt(i - 1) == ' ') i--;
            BinDig = Bin.charAt(i - 1) - 48 ;
            Dec += BinDig * Math.pow(2,j);
            j++;
        }
        return Dec;
    }

    static void BinToHex(ArrayList<Character> Arr, String Bin){
        int BinDig, temp = 0,j = 0;

        for(int i = Bin.length(); i > 0; i--){
            if(j > 3){
                j = 0;
                DecToHex(Arr,temp);
                temp = 0;
            }
            if(Bin.charAt(i-1) == ' ') i--;
            BinDig = Bin.charAt(i-1) - 48;
            temp += BinDig * Math.pow(2,j);
            j++;
            System.out.println(temp);
        }
        DecToHex(Arr,temp);
    }
}
