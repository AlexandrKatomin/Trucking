package trucking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.net.URL;

/**
 * Created by Alex on 18.08.2017.
 */
public class MainAppWithBtm extends Application{
    private static BorderPane root= new BorderPane();

    private static ClassPathXmlApplicationContext context ;

    public static ClassPathXmlApplicationContext getContext(){return context;}


    public static BorderPane getRoot(){       return root;    }
    @Override
    public void start(Stage primaryStage) throws Exception {
       // URL munuBarUrl=getClass().getResource("fxml2/myMenu2.fxml");
        URL s=getClass().getProtectionDomain().getClassLoader().getResource("fxml2/myMenu2.fxml");
        System.out.println(s);






       // FXMLLoader loader = new FXMLLoader();
        URL munuBarUrl=getClass().getProtectionDomain().getClassLoader().getResource("fxml2/myMenu2.fxml");
        HBox box=FXMLLoader.load(munuBarUrl);
        URL paneOneUrl= getClass().getProtectionDomain().getClassLoader().getResource("fxml2/PaneOne.fxml");
        AnchorPane paneOne= FXMLLoader.load(paneOneUrl);
        context=new ClassPathXmlApplicationContext("aplicationContext.xml");
        root.setTop(box);
        root.setCenter(paneOne);
        Scene scene = new Scene(root,1000,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
