package reference.domain;
 
public class Film {
 
    private String name;
 
    public Film(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    @Override
    public String toString() {
        return getName();
    }
 
    // automatically generated equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
}