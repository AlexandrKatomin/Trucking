package trucking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;





/**
 * Created by Alex on 18.08.2017.
 */
public class MyMenu2Controller {

    @FXML
    private Button btm1;

    @FXML
    private Button btm2;

    @FXML
    void swithOnePane(ActionEvent event){
        try{

            URL paneOneUrl= getClass().getProtectionDomain().getClassLoader().getResource("fxml2/PaneOne.fxml");

            AnchorPane paneOne= FXMLLoader.load(paneOneUrl);
            BorderPane border= MainAppWithBtm.getRoot();
            border.setCenter(paneOne);
            System.out.println("111");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchTwoPane(ActionEvent event){

        try{

            URL paneOneUrl= getClass().getProtectionDomain().getClassLoader().getResource("fxml2/PaneTwo.fxml");
            AnchorPane paneOne= FXMLLoader.load(paneOneUrl);
            BorderPane border=MainAppWithBtm.getRoot();
            border.setCenter(paneOne);

            System.out.println("222");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
