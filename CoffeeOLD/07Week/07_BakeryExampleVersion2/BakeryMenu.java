
/**
 * Enumeration class BakeryMenu - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum BakeryMenu
{
    CUPCAKE1("Sweet and salty", Cake.BROWNIE, Frosting.SALTED_CARAMEL),
    CUPCAKE2("Happiness", Cake.FUNFETTI, Frosting.RASPBERRY),
    CUPCAKE3("Classic Red", Cake.RED_VELVET, Frosting.CREAM_CHEESE),
    CUPCAKE4("Brulee Oreo", Cake.COOKIES_AND_CREAM, Frosting.CREME_BRULEE),
    CUPCAKE5("Midnight Masterpiece", Cake.BELGIAN_DARK_CHOCOLATE, Frosting.DARK_CHOCOLATE_FUDGE);
    
    private String name;
    private Cake cakeType;
    private Frosting frosting;
    
    private BakeryMenu(String name, Cake c, Frosting f){
        this.name = name; 
        cakeType = c;
         frosting = f;
    }
    
    public String getName(){
         return name;   
    }
    public Cake getCakeType(){
        return cakeType;
    }
     public Frosting getFrosting(){
        return frosting;
    }
    
    public String toString(){
         return "The " + this.name + " ( a " + this.getCakeType().toString().toLowerCase() + " cake with " + this.getFrosting().toString().toLowerCase() + " frosting"   ;
    }
    
}
