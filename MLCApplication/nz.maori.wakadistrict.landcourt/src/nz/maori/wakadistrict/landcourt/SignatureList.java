package nz.maori.wakadistrict.landcourt;

import java.util.List;

//import nz.maori.wakadistrict.landcourt.SignatureListImpl;
//import nz.maori.wakadistrict.landcourt.Signature;

public interface SignatureList {

	List<Signature> addSignature(Signature _signature);
	
	Signature getSignature (String key);
	
	List<Signature> deleteSignature(String key);
}
