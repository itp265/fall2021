
/**
 * Enumeration class CardIssuer - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Issuer{
   // enum type matched with an ARRAY of possible things a user could type-in
	VISA(new String[]{"visa"}), // an array of Strings
    MASTER_CARD(new String[]{"master_card", "master card"}),
    AMEX(new String[]{"american express", "amex", "american", "american_express"}),
    DISCOVER(new String[]{"discover"}),
    UNKNOWN(new String[]{"unknown"}) ;
	
	
	private String[] matchingTypes;
	
	private Issuer(String[] data) {
		matchingTypes = data;
	}
    public static Issuer matchCardType(String type) {
    	Issuer match = UNKNOWN; // assume no match
    
    	for(Issuer thing: Issuer.values()) { // array of each enum type
    		
    		String[] arrayOfWords = thing.matchingTypes;
    		for(String s: arrayOfWords) { // look through it's matchingTYpe array
    			if(type.equalsIgnoreCase(s)) { // see if string matches what we are looking at
    				match = thing;
    			}
    		}
    	}
    	
    	return match; 
    	
    }
	
   
}
