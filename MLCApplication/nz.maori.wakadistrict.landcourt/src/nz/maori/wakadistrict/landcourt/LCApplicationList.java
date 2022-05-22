package nz.maori.wakadistrict.landcourt;

import nz.maori.wakadistrict.landcourt.ledgerapi.StateList;
import org.hyperledger.fabric.contract.Context;

public class LCApplicationList {

    private StateList stateList;

    public LCApplicationList(Context ctx) {
        this.stateList = StateList.getStateList(ctx, LCApplicationList.class.getSimpleName(), LCApplication::deserialize);
    }
    
    public LCApplicationList addPaper(LCApplication application) {
        stateList.addState(application);
        return this;
    }
    
    public LCApplication getPaper(String paperKey) {
        return (LCApplication) this.stateList.getState(paperKey);
    }

    public LCApplicationList updatePaper(LCApplication application) {
        this.stateList.updateState(application);
        return this;
    }

}
