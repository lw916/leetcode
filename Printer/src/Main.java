import java.io.*;
import java.util.*;
import java.lang.*;


class Main{

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<>();
        while(input.hasNextLine()){
            str.add(input.nextLine());
        }
        for( int i = 1; i <= Integer.parseInt(str.get(0)); i++ ){
            System.out.println(countNum(str.get(i)));
        }
    }

    public static int countNum(String strs){
        int flag = 0, length = strs.length(), count = 0, i = 0;
        while( i < length ){
            if(Character.isUpperCase(strs.charAt(i)) && flag == 1 || Character.isLowerCase(strs.charAt(i)) && flag == 0){
                count++;
            }else if(Character.isUpperCase(strs.charAt(i)) && flag == 0 || Character.isLowerCase(strs.charAt(i)) && flag == 1){
                if(i+1 <= length - 1){
                    if(Character.isUpperCase(strs.charAt(i)) && Character.isUpperCase(strs.charAt(i+1)) || Character.isLowerCase(strs.charAt(i)) && Character.isLowerCase(strs.charAt(i+1))){
                        flag = 1 - flag;
                    }
                    count += 2;
                }else{
                    count += 2;
                }
            }else{
                count += 2;
            }
            i++;
        }
        return count;
    }
}