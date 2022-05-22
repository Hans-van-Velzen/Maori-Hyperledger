package nz.maori.wakadistrict.landcourt;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.logging.Logger;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.json.JSONObject;

import nz.maori.wakadistrict.landcourt.ledgerapi.State;

@DataType()
public class LCApplication extends State implements ContractInterface {
    // Enumerate LandCourt Application state values
    public final static String LODGED = "LODGED";
    public final static String ACCEPTED = "ACCEPTED";
    public final static String REFUSED = "REFUSED";

	@Property()
	private String key;
	@Property()
	private String ApplicationDetails="";
	@Property()
    private String state="";
	
	// setter and getters
    private LCApplication setKey(String _key) {
    	this.key = _key;
		return this;
	}
    
    public String getKey() {
		return key;
	}

    private LCApplication setApplicationDetails(String _applicationDetails) {
    	this.key = _applicationDetails;
		return this;
	}

    public String getApplicationDetails() {
		return ApplicationDetails;
	}

    public String getState() {
        return state;
    }

    public LCApplication setState(String state) {
        this.state = state;
        return this;
    }


    // use the classname for the logger, this way you can refactor
    private final static Logger LOG = Logger.getLogger(ApplicationContract.class.getName());

    /**
     * Define a custom context for the landcourt application
     */
    @Override
    public Context createContext(ChaincodeStub stub) {
        return new ApplicationContext(stub);
    }
    
    // Empty constructor
    public LCApplication() {
    }

    @Override
    public String toString() {
    	return "Key::"+ this.key + " Details::" + ApplicationDetails;
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

    // The actual methods / transactions
    // * LodgeLCApplication
    // * UpdateLCApplicationStatus
    @Transaction
    public void LodgeLCApplication (ApplicationContext ctx, String Application) {
    	// create an instance of a LCApplication
    	// generate the correct Key
    	LCApplication application = LCApplication.createInstance(key, Application, null);
    	
        // Add the application to the list of all similar applications in the 
    	// ledger world state
    	//ctx.LCApplicationList.addApplication(application);
    }

    @Transaction
    public void UpdateLCApplicationStatus (ApplicationContext ctx, String Application, String newStatus) {
    	
    }
    
    /**
     * Deserialize a state data to commercial paper
     *
     * @param {Buffer} data to form back into the object
     */
    public static LCApplication deserialize(byte[] data) {
        JSONObject json = new JSONObject(new String(data, UTF_8));
        String key = json.getString("key");
        String applicationDetails = json.getString("applicationDetails");
        String state = json.getString("state");        
        return createInstance(key, applicationDetails, state);
    }

    public static byte[] serialize(LCApplication application) {
        return State.serialize(application);
    }

    public static LCApplication createInstance(String key, String applicationDetails, String state) {
        return new LCApplication().setKey(key).setApplicationDetails(applicationDetails).setState(state);
    }

}
