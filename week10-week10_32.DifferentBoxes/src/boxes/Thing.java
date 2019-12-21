package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        
        this.name = name;
        if (weight <0){
            throw new IllegalArgumentException();
        }
        this.weight = weight;
        
        
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    public boolean equals(Object object){
        if (object == null){
            return false;
        }
        
        if (getClass() != object.getClass()){
            return false;
        }
        
        final Thing compared = (Thing) object;
        
        if ((this.name == null) || !this.name.equals(compared.name)){
            return false;
        }
        
        return true;
    }
    
    public int hashCode(){
        if (this.name == null){
            return 7;
        }
        
        return this.name.hashCode();
    }


}
