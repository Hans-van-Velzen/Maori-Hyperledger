package nz.maori.wakadistrict.landcourt.archive;

import java.util.ArrayList;
import java.util.List;

import org.hyperledger.fabric.contract.Context;

import nz.maori.wakadistrict.landcourt.ledgerapi.State;
import nz.maori.wakadistrict.landcourt.ledgerapi.StateDeserializer;

public class SignatureListImpl implements SignatureList {

    private List<Signature> _List;

    public SignatureListImpl() {
        this._List = new ArrayList<Signature>();
    }

	@Override
	public List<Signature> addSignature(Signature _signature) {
		this._List.add(_signature);
		return this._List;
	}

	@Override
	public Signature getSignature(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Signature> deleteSignature(String key) {
		// TODO Auto-generated method stub
		this._List.remove(0);
		return this._List;
	}

}
