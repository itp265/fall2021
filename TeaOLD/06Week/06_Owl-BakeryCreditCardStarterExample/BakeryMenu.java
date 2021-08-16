
/**
 * Enumeration class BakeryMenu - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum BakeryMenu
{
    CUPCAKE1(Cake.BROWNIE, Frosting.SALTED_CARAMEL),
    CUPCAKE2(Cake.FUNFETTI, Frosting.RASPBERRY);
    
    
    private Cake cakeType;
    private Frosting frosting;
    
    private BakeryMenu(Cake c, Frosting f){
         cakeType = c;
         frosting = f;
    }
    
}
