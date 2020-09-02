package eecs2030.lab7;

public class Fox extends Animal {
    private static int numCreated;
    
    public Fox (){
        Fox.numCreated++;
    }
    
    public String whateverFoxSays(){
        return "no one knows";
    }
    
    public static int getNumCreated(){
        return Fox.numCreated;
    }

    @Override
    public boolean canFly() {
        return false;
    }
}

