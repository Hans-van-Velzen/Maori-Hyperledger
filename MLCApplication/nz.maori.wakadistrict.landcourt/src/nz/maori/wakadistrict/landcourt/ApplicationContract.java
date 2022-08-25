package nz.maori.wakadistrict.landcourt;

import java.util.logging.Logger;

import nz.maori.wakadistrict.landcourt.ledgerapi.State;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import org.hyperledger.fabric.contract.annotation.Property;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeStub;

@Contract(name = "nz.maori.wakadistrict.landcourt", info = @Info(title = "Application contract", description = "contract for an application with the landcourt", version = "0.0.1", license = @License(name = "SPDX-License-Identifier: Apache-2.0", url = ""), contact = @Contact(email = "hans@data-uuv.com", name = "waka district landcourt contract", url = "http://java-contract.me")))
@Default
public class ApplicationContract implements ContractInterface {

	@Property()
	private LCApplicationList applications;
//	@Property()
//	private Context ctx;
	
    // use the classname for the logger, this way you can refactor
    private final static Logger LOG = Logger.getLogger(ApplicationContract.class.getName());

    /**
     * Define a custom context for the landcourt application
     */
    @Override
    public Context createContext(ChaincodeStub stub) {
        return new ApplicationContext(stub);
    }
    
    // constructor --> create an empty applicationList
    public ApplicationContract() {
//    	this.ctx = createContext(null);
//    	this.applications = new LCApplicationList(ctx);
    }

    /**
     * Instantiate to perform any setup of the ledger that might be required.
     *
     * @param {Context} ctx the transaction context
     */
    @Transaction
    public void instantiate(ApplicationContext ctx) {
        // No implementation required with this example
        // It could be where data migration is performed, if necessary
        LOG.info("No data migration to perform");
    }

    /**
     * Issue commercial paper
     *
     * @param {Context} ctx the transaction context
     * @param {String} applicant
     * @param {String} status
     * @param {String} applicationDetails (complex type)
     * @param {String} maturityDateTime paper maturity date
     * @param {Integer} faceValue face value of paper
     */
    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void LodgeLCApplication (ApplicationContext ctx, String _key, String _applicationDetails) {
    	// create an instance of a LC Application
    }

}
