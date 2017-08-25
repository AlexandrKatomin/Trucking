package trucking.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import trucking.MainAppWithBtm;
import trucking.entity.CircleTrip;
import trucking.entity.Company;
import trucking.service.CompanyService;

/**
 * Created by Alex on 24.08.2017.
 */
public class TableViewCompanyController {

    @FXML
    TableView<Company> tableViewCompany;

    @FXML
    TableColumn<Company,String> columnName;

    @FXML TableColumn<Company,String> columnAdress;

    ClassPathXmlApplicationContext context = MainAppWithBtm.getContext();

    CompanyService companyService = context.getBean("CompanyService", CompanyService.class);

    ObservableList<Company> listTrip;

    void initializeTableViewCompany(){
        tableViewCompany.setEditable(true);
        listTrip = FXCollections.observableList(companyService.getAll());
        tableViewCompany.setItems(listTrip);
    }

    void initializeColumnName(){
        columnName.setCellValueFactory(new PropertyValueFactory<Company, String>("name"));
        columnName.setCellFactory(TextFieldTableCell.<Company>forTableColumn());
        columnName.setOnEditCommit((TableColumn.CellEditEvent<Company, String> t) -> {
            Company company = t.getTableView().getItems().get(t.getTablePosition().getRow());
            company.setName(t.getNewValue());
            companyService.save(company);
        });
    }

    void  initializeColimnAdress(){
        columnAdress.setCellValueFactory(new PropertyValueFactory<Company, String>("adress"));
        columnAdress.setCellFactory(TextFieldTableCell.<Company>forTableColumn());
        columnAdress.setOnEditCommit((TableColumn.CellEditEvent<Company, String> t) -> {
            Company company = t.getTableView().getItems().get(t.getTablePosition().getRow());
            company.setAdress(t.getNewValue());
            companyService.save(company);
        });
    }

    @FXML
    public void initialize() {
        initializeTableViewCompany();
        initializeColumnName();
        initializeColimnAdress();
    }
}
