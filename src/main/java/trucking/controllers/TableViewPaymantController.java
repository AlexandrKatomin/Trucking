package trucking.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.DoubleStringConverter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import trucking.MainAppWithBtm;
import trucking.entity.Contract;
import trucking.entity.PaymantOfContract;
import trucking.entity.Trip;
import trucking.entity.TypeOfPaymant;
import trucking.service.*;

import java.util.Date;

/**
 * Created by Alex on 27.08.2017.
 */
public class TableViewPaymantController {

    @FXML TableView<PaymantOfContract> tableViewPaymant;

    @FXML TableColumn<PaymantOfContract,Date> columnDate;

    @FXML TableColumn<PaymantOfContract,Double> columnSumm;

    @FXML TableColumn<PaymantOfContract,String> columnContract;

    @FXML TableColumn<PaymantOfContract,TypeOfPaymant> columnType;

    ClassPathXmlApplicationContext context = MainAppWithBtm.getContext();

    PaymantOfContractService paymantOfContractService = context.getBean("PaymantOfContractService", PaymantOfContractService.class);

    ObservableList<PaymantOfContract> listPayants;

    void initializeTableViewPaymant(){
        tableViewPaymant.setEditable(true);
        listPayants=FXCollections.observableList(paymantOfContractService.getAll());
        tableViewPaymant.setItems(listPayants);
    }

    void initializeColumnDate(){
        columnDate.setCellValueFactory(new PropertyValueFactory<PaymantOfContract, Date>("dateOfPaymant"));
        columnDate.setCellFactory(TextFieldTableCell.<PaymantOfContract, Date>forTableColumn(new DateStringConverter()));
        columnDate.setOnEditCommit((TableColumn.CellEditEvent<PaymantOfContract, Date> t) -> {
            PaymantOfContract paymantOfContract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            paymantOfContract.setDateOfPaymant(t.getNewValue());
            paymantOfContractService.save(paymantOfContract);
        });
    }

    void initializeColumnSumm(){
        columnSumm.setCellValueFactory(new PropertyValueFactory<PaymantOfContract, Double>("summ"));
        columnSumm.setCellFactory(TextFieldTableCell.<PaymantOfContract, Double>forTableColumn(new DoubleStringConverter()));
        columnSumm.setOnEditCommit((TableColumn.CellEditEvent<PaymantOfContract, Double> t) -> {
            PaymantOfContract paymantOfContract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            paymantOfContract.setSumm(t.getNewValue().doubleValue());
            paymantOfContractService.save(paymantOfContract);
        });
    }

    //todo make smart select, example: last 10 contracts, and add button: add all contracts
    void initializeColumnContract(){
        ContractService contractService = context.getBean("ContractService", ContractService.class);
        ObservableList<String> numbersOfContractsList = FXCollections.observableArrayList(contractService.getAllNumbersOfContracts());
        columnContract.setCellValueFactory(new PropertyValueFactory<PaymantOfContract, String>("id_contract"));
        columnContract.setCellFactory(ComboBoxTableCell.forTableColumn(numbersOfContractsList));
        columnContract.setOnEditCommit((TableColumn.CellEditEvent<PaymantOfContract, String> t) -> {
            PaymantOfContract paymantOfContract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            Contract contract = contractService.findByNumberContract(t.getNewValue());
            paymantOfContract.setContract(contract);
            paymantOfContractService.save(paymantOfContract);
        });
    }
    void initializeColumnType(){
        TypeOfPaymantService typeOfPaymantService = context.getBean("TypeOfPaymantService", TypeOfPaymantService.class);
        ObservableList<TypeOfPaymant> typeOfPaymantList = FXCollections.observableArrayList(typeOfPaymantService.getAll());
        columnType.setCellValueFactory(new PropertyValueFactory<PaymantOfContract, TypeOfPaymant>("id_typeOfPaymant"));
        columnType.setCellFactory(ComboBoxTableCell.forTableColumn(typeOfPaymantList));
        columnType.setOnEditCommit((TableColumn.CellEditEvent<PaymantOfContract, TypeOfPaymant> t) -> {
            PaymantOfContract paymantOfContract = t.getTableView().getItems().get(t.getTablePosition().getRow());
            TypeOfPaymant typeOfPaymant = t.getNewValue();
            paymantOfContract.setTypeOfPaymant(typeOfPaymant);
            paymantOfContractService.save(paymantOfContract);
        });
    }

    @FXML
    void initialize(){
        initializeTableViewPaymant();
        initializeColumnDate();
        initializeColumnSumm();
        initializeColumnContract();
        initializeColumnType();
    }



}
