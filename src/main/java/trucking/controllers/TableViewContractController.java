package trucking.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.Callback;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.DoubleStringConverter;
import trucking.MainAppWithBtm;
import trucking.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import trucking.service.CarService;
import trucking.service.CompanyService;
import trucking.service.ContractService;
import trucking.service.DriverService;

import java.util.Date;



/**
 * Created by Alex on 19.08.2017.
 */
public class TableViewContractController {
    @FXML
    TableView<Contract> tableViewContract;

    @FXML
    TableColumn<Contract, String> columnNumber;

    @FXML
    TableColumn<Contract, Date> columnDate;

    @FXML
    TableColumn<Contract, Double> columnPrice;

    @FXML
    TableColumn<Contract, Double> columnCargo;

    @FXML
    TableColumn<Contract, Driver> columnDriver;

    @FXML
    TableColumn<Contract, String> columnCar;

    @FXML
    TableColumn<Contract, Boolean> columnOurCar;

    @FXML
    TableColumn<Contract, Company> columnCompany;

    ClassPathXmlApplicationContext context = MainAppWithBtm.getContext();

    ContractService contractService = context.getBean("ContractService", ContractService.class);

    ObservableList<Contract> listContract;

    //this servise and this list  used by column car
    CarService carService = context.getBean("CarService", CarService.class);

    ObservableList<String> listCars = FXCollections.observableArrayList(carService.getAllModel());


    void showAlert(String title, String headertext, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        //   alert.initOwner(MainAppWithBtm.getPrimaryStage());  ???
        alert.setTitle(title);
        alert.setHeaderText(headertext);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    void initializeTableViewContract() {
        tableViewContract.setEditable(true);
        listContract = FXCollections.observableList(contractService.getAll());
        tableViewContract.setItems(listContract);
    }

    void initializeColumnNumber() {
        columnNumber.setCellValueFactory(new PropertyValueFactory<Contract, String>("numberContract"));
        columnNumber.setCellFactory(TextFieldTableCell.<Contract>forTableColumn());
        columnNumber.setOnEditCommit((TableColumn.CellEditEvent<Contract, String> t) -> {
            Contract contract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            contract.setNumberContract(t.getNewValue());
            contractService.save(contract);
        });
    }

    void initialazeColumnDate() {
        columnDate.setCellValueFactory(new PropertyValueFactory<Contract, Date>("date"));
        columnDate.setCellFactory(TextFieldTableCell.<Contract, Date>forTableColumn(new DateStringConverter()));
        columnDate.setOnEditCommit((TableColumn.CellEditEvent<Contract, Date> t) -> {
            Contract contract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            contract.setDate(t.getNewValue());
            contractService.save(contract);
        });
    }

    void initializeColumnPrice() {
        columnPrice.setCellValueFactory(new PropertyValueFactory<Contract, Double>("price"));
        columnPrice.setCellFactory(TextFieldTableCell.<Contract, Double>forTableColumn(new DoubleStringConverter()));
        columnPrice.setOnEditCommit((TableColumn.CellEditEvent<Contract, Double> t) -> {
            Contract contract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            contract.setPrice(t.getNewValue().doubleValue());
            contractService.save(contract);
        });
    }

    void initializeColumnCargo() {
        columnCargo.setCellValueFactory(new PropertyValueFactory<Contract, Double>("cargoWeight"));
        columnCargo.setCellFactory(TextFieldTableCell.<Contract, Double>forTableColumn(new DoubleStringConverter()));
        columnCargo.setOnEditCommit((TableColumn.CellEditEvent<Contract, Double> t) -> {
            Contract contract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            contract.setCargoWeight(t.getNewValue());
            contractService.save(contract);
        });
    }

    void initializeColumnDriver() {
        DriverService driverService = context.getBean("DriverService", DriverService.class);
        ObservableList<Driver> drivers = FXCollections.observableArrayList(driverService.getAll());
        columnDriver.setCellValueFactory(new PropertyValueFactory<Contract, Driver>("driver"));
        columnDriver.setCellFactory(ComboBoxTableCell.forTableColumn(drivers));
        columnDriver.setOnEditCommit((TableColumn.CellEditEvent<Contract, Driver> t) -> {
            Contract contract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            Driver driver = t.getNewValue();
            contract.setDriver(driver);
            contractService.save(contract);
        });
    }

    void initializeColumnCar() {
        listCars = FXCollections.observableArrayList(carService.getAllModel());
        columnCar.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contract, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contract, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getCar().getModel());
            }
        });
        columnCar.setCellFactory(ComboBoxTableCell.forTableColumn(listCars));
        columnCar.setOnEditCommit((TableColumn.CellEditEvent<Contract, String> t) -> {
            Contract contract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            Car car = carService.getByModel(t.getNewValue());
            contract.setCar(car);
            contractService.save(contract);
        });
    }

    void initializeColumnOurCar() {
        columnOurCar.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contract, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Contract, Boolean> param) {
                Contract contract1 = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(contract1.isOurCar());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        contract1.setOurCar(newValue);
                    }
                });
                return booleanProp;
            }
        });
        columnOurCar.setCellFactory(new Callback<TableColumn<Contract, Boolean>,
                TableCell<Contract, Boolean>>() {
            @Override
            public TableCell<Contract, Boolean> call(TableColumn<Contract, Boolean> p) {
                CheckBoxTableCell<Contract, Boolean> cell = new CheckBoxTableCell<Contract, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
    }

    void initializeColumnCompany() {
        CompanyService companyService = context.getBean("CompanyService", CompanyService.class);
        ObservableList<Company> companyList = FXCollections.observableArrayList(companyService.getAll());
        columnCompany.setCellValueFactory(new PropertyValueFactory<Contract, Company>("company"));
        columnCompany.setCellFactory(ComboBoxTableCell.forTableColumn(companyList));
        columnCompany.setOnEditCommit((TableColumn.CellEditEvent<Contract, Company> t) -> {
            Contract contract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            Company company = t.getNewValue();
            contract.setCompany(company);
            contractService.save(contract);
        });
    }

    @FXML
    public void initialize() {
        initializeTableViewContract();
        initializeColumnNumber();
        initialazeColumnDate();
        initializeColumnPrice();
        initializeColumnCargo();
        initializeColumnCar();
        initializeColumnOurCar();
        initializeColumnDriver();
        initializeColumnCompany();
    }
}