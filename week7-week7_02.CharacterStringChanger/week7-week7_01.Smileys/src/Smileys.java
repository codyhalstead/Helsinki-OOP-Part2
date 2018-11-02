
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
         printWithSmileys("Method");
         printWithSmileys("Beerbottle");
         printWithSmileys("Interface");
    }

    private static void smileyRow(int length){
        int numOfFaces=length/2+3;
        for(int i=0;i<numOfFaces;i++){
            System.out.print(":)");
        }
        System.out.println("");
    }
    
    private static void printWithSmileys(String message){
        if(message.length()%2==1){
            message+=" ";
        }
        smileyRow(message.length());
        System.out.println(":) "+message+" :)");   
        smileyRow(message.length());
    }
}
