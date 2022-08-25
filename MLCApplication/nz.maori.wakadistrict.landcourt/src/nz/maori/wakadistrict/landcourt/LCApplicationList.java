package nz.maori.wakadistrict.landcourt;

import nz.maori.wakadistrict.landcourt.ledgerapi.StateList;
import org.hyperledger.fabric.contract.Context;

/*
 * A list of Landcourt application states (LODGED | REFUSED | ACCEPTED
 * It used the ledgerAPI StateList class
 */
public class LCApplicationList {

    private StateList stateList;

    // constructor
    public LCApplicationList(Context ctx) {
        this.stateList = StateList.getStateList(ctx, LCApplicationList.class.getSimpleName(), LCApplication::deserialize);
    }
    
    public LCApplicationList addApplication(LCApplication _application) {
        stateList.addState(_application);
        return this;
    }
    
    public LCApplication getApplication(String _applicationKey) {
        return (LCApplication) this.stateList.getState(_applicationKey);
    }

    public LCApplicationList updateApplication(LCApplication application) {
        this.stateList.updateState(application);
        return this;
    }

}
