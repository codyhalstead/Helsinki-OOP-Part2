
public class Bird {
 
    private String name;
    private String latinName;
    private int ringingYear;
 
    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }
 
    @Override
    public boolean equals(Object o) {
        // Check whether object o's real type is Bird, if not, return false
        if (!(o instanceof Bird)) {
            return false;
        }
 
        // Now we know that o is a bird, let's convert its type
        Bird bird = (Bird) o;
 
        if (this.latinName == null) {
            return false;
        }
 
        return this.latinName.equals(bird.latinName) &&
               this.ringingYear == bird.ringingYear;
    }
 
    @Override
    public int hashCode() {
        if (this.latinName == null) {
            return this.ringingYear;
        }
 
        return this.latinName.hashCode() + this.ringingYear;
    }
 
    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
}


