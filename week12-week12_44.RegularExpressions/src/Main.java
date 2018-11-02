
public class Main {

    public static void main(String[] args) {
        // write test code here
        
    }
    public static boolean isAWeekDay(String string){
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")){
            return true;
        }
        return false;
    }
    
    public static boolean allVowels(String string){
        if (string.matches("[aeiouäö]*")){
            return true;
        }
        return false;
    }
    
    public static boolean clockTime(String string){
         return string.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");
    //    if (string.length() == 8){
    //        if (string.charAt(2) == ':' && string.charAt(5) == ':'){
    //            int x = 0;
    //            for ( String i : string.split(":")){
    //               if(x == 0){
    //                    int y = Integer.parseInt(i);
    //                    if(y > 23){
    //                        return false;
    //                    }
    //                    x++;
    //                }
    //                if(x == 1){
    //                    int y = Integer.parseInt(i);
    //                    if(y > 59){
    //                        return false;
    //                    }
    //                }
    //            }
    //            return true;
    //        }
    //    }
    //    return false;
    }
}
