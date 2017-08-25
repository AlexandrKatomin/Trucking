package trucking.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import trucking.MainAppWithBtm;
import trucking.entity.CircleTrip;
import trucking.entity.Contract;
import trucking.entity.Trip;
import trucking.service.CircleTripService;


/**
 * Created by Alex on 24.08.2017.
 */
public class TableViewCircleTripController {
    @FXML  TableView<CircleTrip> tableViewCircleTrip;

    @FXML  TableColumn<CircleTrip,String> columnNumber;

    @FXML  TableColumn<CircleTrip,Integer> columnCountDay;

    ClassPathXmlApplicationContext context = MainAppWithBtm.getContext();

    CircleTripService circleTripService = context.getBean("CircleTripService", CircleTripService.class);

    ObservableList<CircleTrip> listTrip;


     void initializeColumnNumber(){
         columnNumber.setCellValueFactory(new PropertyValueFactory<CircleTrip, String>("number"));
         columnNumber.setCellFactory(TextFieldTableCell.<CircleTrip>forTableColumn());
         columnNumber.setOnEditCommit((TableColumn.CellEditEvent<CircleTrip, String> t) -> {
             CircleTrip circleTrip = t.getTableView().getItems().get(t.getTablePosition().getRow());
             circleTrip.setNumber(t.getNewValue());
             circleTripService.save(circleTrip);
         });
     }

     void initializeColumnCountDay(){
         columnCountDay.setCellValueFactory(new PropertyValueFactory<CircleTrip,Integer>("countDay"));
         columnCountDay.setCellFactory(TextFieldTableCell.<CircleTrip,Integer>forTableColumn(new IntegerStringConverter()));
         columnCountDay.setOnEditCommit((TableColumn.CellEditEvent<CircleTrip, Integer> t) -> {
             CircleTrip circleTrip = t.getTableView().getItems().get(t.getTablePosition().getRow());
             circleTrip.setCountDay(t.getNewValue());
             circleTripService.save(circleTrip);
         });
     }

     void initializeTableViewCircleTrip(){
         tableViewCircleTrip.setEditable(true);
         listTrip = FXCollections.observableList(circleTripService.getAll());
         tableViewCircleTrip.setItems(listTrip);

     }

    @FXML
    public void initialize() {
        initializeTableViewCircleTrip();
        initializeColumnNumber();
        initializeColumnCountDay();
    }


}
