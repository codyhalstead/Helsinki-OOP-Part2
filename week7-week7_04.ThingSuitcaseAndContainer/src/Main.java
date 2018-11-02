public class Main {
    public static void main(String[] Container) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        // adding 100 suitcases with one brick in each
        int i=0;
        while(i<100){
            Suitcase suitcase=new Suitcase(100);
            Thing brick = new Thing("brick", 1+i);
            suitcase.addThing(brick);
            container.addSuitcase(suitcase);
            i++;
        }
    }
}