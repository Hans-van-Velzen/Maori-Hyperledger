	/*
	SPDX-License-Identifier: Apache-2.0
	*/
package nz.maori.wakadistrict.landcourt;


import nz.maori.wakadistrict.landcourt.ledgerapi.StateList;
import org.hyperledger.fabric.contract.Context;

public class ContractList {

	    private StateList stateList;

	    public ContractList(Context ctx) {
	        this.stateList = StateList.getStateList(ctx, ContractList.class.getSimpleName(), CommercialPaper::deserialize);
	    }

	    public ContractList addContract(ApplicationContract application) {
	        stateList.addState(application);
	        return this;
	    }

	    public ApplicationContract getApplication(String contractKey) {
	        return (ApplicationContract) this.stateList.getState(contractKey);
	    }

	    public ContractList updateApplication(ApplicationContract application) {
	        this.stateList.updateState(application);
	        return this;
	    }
	}
}
