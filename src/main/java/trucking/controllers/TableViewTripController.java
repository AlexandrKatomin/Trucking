package trucking.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import trucking.MainAppWithBtm;
import trucking.entity.*;
import trucking.repository.CircleTripRepository;
import trucking.service.CircleTripService;
import trucking.service.ContractService;
import trucking.service.TripService;
import trucking.service.TypeOfTripService;

import java.util.Date;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 * Created by Alex on 19.08.2017.
 */
public class TableViewTripController {

    @FXML    TableView<Trip>  tableViewTrip;

    @FXML    TableColumn<Trip,Integer> columnNumberInCirle;
    @FXML    TableColumn<Trip,Date> columnDateBegin;
    @FXML    TableColumn<Trip,Date> columnDateEnd;
    @FXML    TableColumn<Trip,Double> columnKm;
    @FXML    TableColumn<Trip,Double> columnFuel;

    @FXML    TableColumn<Trip,String> columnPlaceLoad;
    @FXML    TableColumn<Trip,String> columnPlaceUnload;

    @FXML    TableColumn<Trip,String> columnContract;
    @FXML    TableColumn<Trip,CircleTrip> columnCircleTrip;
    @FXML    TableColumn<Trip,TypeOfTrip> columnType;



    @FXML
    public void initialize() {
        ClassPathXmlApplicationContext context = MainAppWithBtm.getContext();
        TripService tripService = context.getBean("TripService", TripService.class);
        tableViewTrip.setEditable(true);

        ObservableList<Trip> listTrip = FXCollections.observableList(tripService.getAll());
        tableViewTrip.setItems(listTrip);

        /* --------------------------------------- column number CircleTrip --------------------------------------------*/
        columnNumberInCirle.setCellValueFactory(new PropertyValueFactory<Trip,Integer>("numberInCircleTrip"));
        columnNumberInCirle.setCellFactory(TextFieldTableCell.<Trip,Integer>forTableColumn(new IntegerStringConverter()));
        columnNumberInCirle.setOnEditCommit((TableColumn.CellEditEvent<Trip, Integer> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            trip.setNumberInCircleTrip(t.getNewValue());
            tripService.save(trip);
        });


        /* --------------------------------------- column date begin --------------------------------------------*/
        columnDateBegin.setCellValueFactory(new PropertyValueFactory<Trip, Date>("dateBegin"));
        columnDateBegin.setCellFactory(TextFieldTableCell.<Trip,Date>forTableColumn(new DateStringConverter()));
        columnDateBegin.setOnEditCommit((TableColumn.CellEditEvent<Trip, Date> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            trip.setDateBegin(t.getNewValue());
            tripService.save(trip);
        });

        /* --------------------------------------- column date end --------------------------------------------*/
        columnDateEnd.setCellValueFactory(new PropertyValueFactory<Trip, Date>("dateEnd"));
        columnDateEnd.setCellFactory(TextFieldTableCell.<Trip,Date>forTableColumn(new DateStringConverter()));
        columnDateEnd.setOnEditCommit((TableColumn.CellEditEvent<Trip, Date> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            trip.setDateEnd(t.getNewValue());
            tripService.save(trip);
        });


        /* --------------------------------------- column number km --------------------------------------------*/
        columnKm.setCellValueFactory(new PropertyValueFactory<Trip,Double>("km"));
        columnKm.setCellFactory(TextFieldTableCell.<Trip,Double>forTableColumn(new DoubleStringConverter()));
        columnKm.setOnEditCommit((TableColumn.CellEditEvent<Trip, Double> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            trip.setKm(t.getNewValue());
            tripService.save(trip);
        });

        /* --------------------------------------- column number fuel  --------------------------------------------*/
        columnFuel.setCellValueFactory(new PropertyValueFactory<Trip,Double>("fuel_consumption"));
        columnFuel.setCellFactory(TextFieldTableCell.<Trip,Double>forTableColumn(new DoubleStringConverter()));
        columnFuel.setOnEditCommit((TableColumn.CellEditEvent<Trip, Double> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            trip.setKm(t.getNewValue());
            tripService.save(trip);
        });

         /* --------------------------------------- column place load --------------------------------------------*/
        columnPlaceLoad.setCellValueFactory(new PropertyValueFactory<Trip, String>("placeOfLoad"));
        columnPlaceLoad.setCellFactory(TextFieldTableCell.<Trip>forTableColumn());
        columnPlaceLoad.setOnEditCommit((TableColumn.CellEditEvent<Trip, String> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            trip.setPlaceOfLoad(t.getNewValue());
            tripService.save(trip);
        });

         /* --------------------------------------- column place load --------------------------------------------*/
        columnPlaceUnload.setCellValueFactory(new PropertyValueFactory<Trip, String>("placeOfLoad"));
        columnPlaceUnload.setCellFactory(TextFieldTableCell.<Trip>forTableColumn());
        columnPlaceUnload.setOnEditCommit((TableColumn.CellEditEvent<Trip, String> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            trip.setPlaceOfUnload(t.getNewValue());
            tripService.save(trip);
        });


         /* --------------------------------------- column contract --------------------------------------------*/

        ContractService contractService= context.getBean("ContractService", ContractService.class);
        ObservableList<String> contractList= FXCollections.observableArrayList(contractService.getAllContractWithoutTrip());
        columnContract.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Trip, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Trip, String> param) {
                 String  currentValue = param.getValue().getContract().getNumberContract();
                 return new ReadOnlyObjectWrapper( currentValue);
            }
        });
        columnContract.setCellFactory(ComboBoxTableCell.forTableColumn(contractList));
        columnContract.setOnEditCommit((TableColumn.CellEditEvent<Trip,String> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            Contract contract = contractService.findByNumberContract(t.getNewValue());
            trip.setContract(contract);
            tripService.save(trip);
        });
         /* --------------------------------------- column circle trip --------------------------------------------*/
        CircleTripService circleTripService= context.getBean("CircleTripService", CircleTripService.class);
        ObservableList<CircleTrip> drivers =FXCollections.observableArrayList(circleTripService.getAll());
        columnCircleTrip.setCellValueFactory(new PropertyValueFactory<Trip,CircleTrip>("circleTrip"));
        columnCircleTrip.setCellFactory(ComboBoxTableCell.forTableColumn(drivers));
        columnCircleTrip.setOnEditCommit((TableColumn.CellEditEvent<Trip,CircleTrip> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            CircleTrip circleTrip =t.getNewValue();
            trip.setCircleTrip(circleTrip);
            tripService.save(trip);
        });

         /* --------------------------------------- column type --------------------------------------------*/
        TypeOfTripService typeOfTripService= context.getBean("TypeOfTripService", TypeOfTripService.class);
        ObservableList<TypeOfTrip> typeOfTrips =FXCollections.observableArrayList(typeOfTripService.getAll());
        columnType.setCellValueFactory(new PropertyValueFactory<Trip,TypeOfTrip>("typeOfTrip"));
        columnType.setCellFactory(ComboBoxTableCell.forTableColumn(typeOfTrips));
        columnType.setOnEditCommit((TableColumn.CellEditEvent<Trip,TypeOfTrip> t) -> {
            Trip trip = t.getTableView().getItems().get(t.getTablePosition().getRow());
            TypeOfTrip typeOfTrip =t.getNewValue();
            trip.setTypeOfTrip(typeOfTrip);
            tripService.save(trip);
        });

    }

}
