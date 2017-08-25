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
import trucking.entity.CircleTrip;
import trucking.entity.Expense;
import trucking.entity.TypeOfExpense;
import trucking.service.CircleTripService;
import trucking.service.ExpenseService;
import trucking.service.ITypeOfExpenseService;
import trucking.service.TypeOfExpenseService;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Alex on 24.08.2017.
 */
public class TableViewExpanseController {
    @FXML
    TableView<Expense> tableViewExpense;

    @FXML
    TableColumn<Expense, Double> columnSumm;

    @FXML
    TableColumn<Expense, Date> columnDate;

    @FXML
    TableColumn<Expense, TypeOfExpense> columnType;

    @FXML
    TableColumn<Expense, CircleTrip> columnCircleTrip;

    @FXML
    TableColumn<Expense, String> columnDescription;

    @FXML
    public void initialize() {
        ClassPathXmlApplicationContext context = MainAppWithBtm.getContext();
        ExpenseService expenseService = context.getBean("ExpenseService", ExpenseService.class);
        tableViewExpense.setEditable(true);

        ObservableList<Expense> expenses = FXCollections.observableList(expenseService.getAll());
        tableViewExpense.setItems(expenses);

        /* --------------------------------------- column summ --------------------------------------------*/
        columnSumm.setCellValueFactory(new PropertyValueFactory<Expense, Double>("summ"));
        columnSumm.setCellFactory(TextFieldTableCell.<Expense, Double>forTableColumn(new DoubleStringConverter()));
        columnSumm.setOnEditCommit((TableColumn.CellEditEvent<Expense, Double> t) -> {
            Expense expense = t.getTableView().getItems().get(t.getTablePosition().getRow());
            expense.setSumm(t.getNewValue().doubleValue());
            expenseService.save(expense);
        });
         /* --------------------------------------- column date --------------------------------------------*/
        columnDate.setCellValueFactory(new PropertyValueFactory<Expense, Date>("dateExpense"));
        columnDate.setCellFactory(TextFieldTableCell.<Expense, Date>forTableColumn(new DateStringConverter()));
        columnDate.setOnEditCommit((TableColumn.CellEditEvent<Expense, Date> t) -> {
            Expense expense = t.getTableView().getItems().get(t.getTablePosition().getRow());
            expense.setDateExpense(t.getNewValue());
            expenseService.save(expense);
        });

          /* --------------------------------------- column type --------------------------------------------*/
        TypeOfExpenseService typeOfExpense = context.getBean("TypeOfExpenseService", TypeOfExpenseService.class);
        ObservableList<TypeOfExpense> types = FXCollections.observableArrayList(typeOfExpense.getAll());
        columnType.setCellValueFactory(new PropertyValueFactory<Expense, TypeOfExpense>("typeOfExpense"));
        columnType.setCellFactory(ComboBoxTableCell.forTableColumn(types));
        columnType.setOnEditCommit((TableColumn.CellEditEvent<Expense, TypeOfExpense> t) -> {
            Expense expense = t.getTableView().getItems().get(t.getTablePosition().getRow());
            TypeOfExpense typeOfExpense1 = t.getNewValue();
            expense.setTypeOfExpense(typeOfExpense1);
            expenseService.save(expense);
        });

        /* --------------------------------------- column circle trip --------------------------------------------*/
        CircleTripService circleTripService = context.getBean("CircleTripService", CircleTripService.class);
        ObservableList<CircleTrip> drivers = FXCollections.observableArrayList(circleTripService.getAll());
        columnCircleTrip.setCellValueFactory(new PropertyValueFactory<Expense, CircleTrip>("circleTrip"));
        columnCircleTrip.setCellFactory(ComboBoxTableCell.forTableColumn(drivers));
        columnCircleTrip.setOnEditCommit((TableColumn.CellEditEvent<Expense, CircleTrip> t) -> {
            Expense expense = t.getTableView().getItems().get(t.getTablePosition().getRow());
            CircleTrip circleTrip = t.getNewValue();
            expense.setCircleTrip(circleTrip);
            expenseService.save(expense);
        });

        /* --------------------------------------- column description --------------------------------------------*/
        columnDescription.setCellValueFactory(new PropertyValueFactory<Expense, String>("description"));
        columnDescription.setCellFactory(TextFieldTableCell.<Expense>forTableColumn());
        columnDescription.setOnEditCommit((TableColumn.CellEditEvent<Expense, String> t) -> {
            Expense expense = t.getTableView().getItems().get(t.getTablePosition().getRow());
            expense.setDescription(t.getNewValue());
            expenseService.save(expense);
        });


    }
}
