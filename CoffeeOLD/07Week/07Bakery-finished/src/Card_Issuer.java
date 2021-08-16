
/**
 * Enumeration class CardIssuer - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Card_Issuer{
    VISA(new String[]{"visa"}),
    MASTER_CARD(new String[]{"master_card", "master card"}),
    AMEX(new String[]{"american express", "amex", "american"}),
    DISCOVER(new String[]{"discover"}),
    UNKNOWN(new String[]{"unknown"}) ;
	
	
	private String[] matchingTypes;
	
	private Card_Issuer(String[] data) {
		matchingTypes = data;
	}
    public static Card_Issuer matchCardType(String type) {
    	Card_Issuer match = UNKNOWN; // assume no match
    	for(Card_Issuer thing: Card_Issuer.values()) { // array of each enum type
    		for(String s: thing.matchingTypes) { // look through it's matchingTYpe array
    			if(type.equalsIgnoreCase(s)) { // see if string matches what we are looking at
    				match = thing;
    			}
    		}
    	}
    	
    	return match; 
    	
    }
	
   
}
