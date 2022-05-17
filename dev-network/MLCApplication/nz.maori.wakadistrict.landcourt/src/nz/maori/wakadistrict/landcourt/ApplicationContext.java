package nz.maori.wakadistrict.landcourt;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.shim.ChaincodeStub;

class ApplicationContext extends Context {

    public ApplicationContext(ChaincodeStub stub) {
        super(stub);
        this.contractList = new ContractList(this);
    }

    public ContractList contractList;

}