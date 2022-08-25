package nz.maori.wakadistrict.landcourt.archive;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Signature {
	private String name;
	private LocalDateTime signedDate;
	private Signature signature;
	
	// constructors
	// 3 parameters
	Signature (String _name, LocalDateTime _date, Signature _signature) {
		this.name = _name;
		this.signedDate = _date;
		this.signature = _signature;
	}

	// 2 parameters -- signed as of now()
	Signature (String _name, Signature _signature) {
		this.name = _name;
		this.signedDate = LocalDateTime.now();
		this.signature = _signature;
	}

	public Signature getSignature() {
		return this;
	}

	public static byte[] serialize(Signature _signature) {
		// TODO Auto-generated method stub
		return null;
	}
}
