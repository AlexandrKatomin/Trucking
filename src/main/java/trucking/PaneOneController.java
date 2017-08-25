package trucking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Alex on 18.08.2017.
 */
public class PaneOneController {

    @FXML private Button btnContract;

    @FXML private Button btnCompany;

    @FXML private  Button btnTrip;

    @FXML private  Button btnCircleTrip;

    @FXML private  Button btnExpense;

    @FXML private  Button btnPaymant;

    AnchorPane anchorPaneContract;
    AnchorPane anchorPaneTrip;
    AnchorPane anchorPaneCompany;
    AnchorPane anchorPaneCircleTrip;
    AnchorPane anchorPaneExpense;
    AnchorPane anchorPanePaymant;

    BorderPane currentBorder;

    String path="fxml2/tables/";
    String nameFileAncorPaneCircleTrip="tableViewCircleTrip.fxml";
    String nameFileAncorPaneCompany="tableViewCompany.fxml";
    String nameFileAncorPaneContract="tableViewContract.fxml";
    String nameFileAncorPaneExpense="tableViewExpense.fxml";
    String nameFileAncorPanePaymant="tableViewPaymant.fxml";
    String nameFileAncorPaneTrip="tableViewTrip.fxml";


     BorderPane getCurrentBorder(){
         if(currentBorder ==null){
             BorderPane border = MainAppWithBtm.getRoot();
             return (BorderPane) border.lookup("#borderFromOnePane");
         }
         return currentBorder;
     }

    URL getURLNode(String fullPath){
        return getClass().getProtectionDomain().getClassLoader().getResource(fullPath);
    }

    public  Parent getNode(String fullPath,Parent parent) throws IOException {
        if(parent==null){
            URL tableUrl =getURLNode(fullPath);
            parent=FXMLLoader.load(tableUrl);
        }
        return parent;
    }
    public AnchorPane getAnchorPaneContract() throws IOException {
        anchorPaneContract=(AnchorPane)getNode(path+nameFileAncorPaneContract,anchorPaneContract);
        return anchorPaneContract;
    }
    public AnchorPane getAnchorPaneCircleTrip() throws IOException {
        anchorPaneCircleTrip=(AnchorPane)getNode(path+nameFileAncorPaneCircleTrip,anchorPaneCircleTrip);
        return anchorPaneCircleTrip;
    }

    public AnchorPane getAnchorPaneCompany() throws IOException {
        anchorPaneCompany=(AnchorPane)getNode(path+nameFileAncorPaneCompany,anchorPaneCompany);
        return anchorPaneCompany;
    }
    public AnchorPane getAnchorPaneExpense() throws IOException {
        anchorPaneExpense=(AnchorPane)getNode(path+nameFileAncorPaneExpense,anchorPaneExpense);
        return anchorPaneExpense;
    }
    public AnchorPane getAnchorPanePaymant() throws IOException {
        anchorPanePaymant=(AnchorPane)getNode(path+nameFileAncorPanePaymant,anchorPanePaymant);
        return anchorPanePaymant;
    }
    public AnchorPane getAnchorPaneTrip() throws IOException {
        anchorPaneTrip=(AnchorPane)getNode(path+nameFileAncorPaneTrip,anchorPaneTrip);
        return anchorPaneTrip;
    }

    @FXML
    void switchContract(ActionEvent event) throws IOException {
       currentBorder=getCurrentBorder();
       currentBorder.setCenter(getAnchorPaneContract());
    }

    @FXML
    void switchTrip(ActionEvent event) throws IOException {
        currentBorder=getCurrentBorder();
        currentBorder.setCenter(getAnchorPaneTrip());
    }

    @FXML
    void switchCompany(ActionEvent event) throws IOException {
        currentBorder=getCurrentBorder();
        currentBorder.setCenter(getAnchorPaneCompany());
    }
    @FXML
    void switchCircleTrip(ActionEvent event) throws IOException {
        currentBorder=getCurrentBorder();
        currentBorder.setCenter(getAnchorPaneCircleTrip());
    }

    @FXML
    void switchExpanse(ActionEvent event) throws IOException {
        currentBorder=getCurrentBorder();
        currentBorder.setCenter(getAnchorPaneExpense());
    }

    @FXML
    void swinthPaymant(ActionEvent event) throws IOException {
        currentBorder=getCurrentBorder();
        currentBorder.setCenter(getAnchorPanePaymant());
    }

}
