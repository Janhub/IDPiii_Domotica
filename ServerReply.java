package cms;

public class ServerReply {
	private final String noodKnop = "noodknop";
	private final String verlichtingAan = "lichtaan";
	private final String verlichtingUit = "lichtuit";
	
	public String reply(String s){
		String bericht = s;
		
		if(bericht.equalsIgnoreCase(noodKnop)){
			return "noodok";
		}
		else if(bericht.equalsIgnoreCase(verlichtingAan)){
			return "aanok";
			
		}
		else if (bericht.equalsIgnoreCase(verlichtingUit)){
			return "uitok";
		}
		else{
			return "nietherkend";
		}
		
	}

}
