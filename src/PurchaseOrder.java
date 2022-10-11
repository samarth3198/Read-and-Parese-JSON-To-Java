import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Imported Gson library
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class PurchaseOrder {

    public static void main (String args[]) {

        // gson object
        Gson gson = new Gson();
        PurchaseOrder purchaseOrderObj = new PurchaseOrder();

        // Read the file location
        String filePath = "/Users/samar/OneDrive/Documents/purchaseorder.json";

        // Try block
        try
        {
            // Read the contents from the file
            String contents = new String((Files.readAllBytes(Paths.get(filePath))));

            // Reading json data from a file
            PersonDetail personDetail = gson.fromJson(contents, PersonDetail.class);

            // Parsing json data to object/struct
            PersonDetail writePersonDetail = purchaseOrderObj.parseJsonDataToObject(personDetail);

            // Converting java object to json and writing it into the file
            purchaseOrderObj.writeToJsonFile(writePersonDetail);
        }

        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Method to convert json to java object
    private PersonDetail parseJsonDataToObject(PersonDetail personDetail) {

        PersonDetail writeObject = new PersonDetail();
        ShippingDetails shipObject = new ShippingDetails();
        BillingDetails billObject = new BillingDetails();

        // Initializing Shipping Details Object
        shipObject.setName(personDetail.shipTo.getName());
        shipObject.setAddress(personDetail.shipTo.getAddress());
        shipObject.setZip(personDetail.shipTo.getZip());
        shipObject.setCity(personDetail.shipTo.getCity());
        shipObject.setState(personDetail.shipTo.getState());

        // Initializing Billing Details Object
        billObject.setName(personDetail.billTo.getName());
        billObject.setAddress(personDetail.billTo.getAddress());
        billObject.setCity(personDetail.billTo.getCity());
        billObject.setState(personDetail.billTo.getState());
        billObject.setZip(personDetail.billTo.getZip());

        // Initializing Person Details Object
        writeObject.setName(personDetail.getName());
        writeObject.setPrice(personDetail.getPrice());
        writeObject.setSku(personDetail.getSku());
        writeObject.setShipTo(shipObject);
        writeObject.setBillTo(billObject);

        return writeObject;
    }

    // Method for writing java object to json file
    private void writeToJsonFile(PersonDetail personDetail) {

        // Gson object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // try block
        try {
            FileWriter fileWriter = new FileWriter("output.json");

            // method to convert java object to json and write to file
            gson.toJson(personDetail, fileWriter);

            fileWriter.flush(); // flush data to file
            fileWriter.close(); // close write
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}