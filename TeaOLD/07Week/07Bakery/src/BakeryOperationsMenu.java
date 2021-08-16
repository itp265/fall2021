
/**
 * Enumeration class BakeryOperationsMenu - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum BakeryOperationsMenu
{
    BAKE_MENU_ITEMS("Bake the regular menu items"),
    SHOW_INVENTORY("Show inventory"),
    SHOW_MENU("Show Bakery menu"),
    HANDLE_CUSTOMER("Go to sales mode (handle customer)"),
    RUN_SELLING_STATS("Run the stats for cupcake sales"),
    LOAD_LOYALTY_MEMBERS("Load pre-existing loyalty members"),
    LOYALTY_MEMBERS("See loyalty members"),
    REGISTER_MEMBER("Register a new loyalty member"),
    QUIT("Quit");
    private String description;
    
    private BakeryOperationsMenu(String d){
         this.description = d;   
    }
    
    public static void printMenu(){
         for(int i = 0 ; i < BakeryOperationsMenu.values().length; i++){
             System.out.println(i + ": " + BakeryOperationsMenu.values()[i].description);
            }
    }
    public static int getNumOptions(){
        return BakeryOperationsMenu.values().length - 1;
    }
}
