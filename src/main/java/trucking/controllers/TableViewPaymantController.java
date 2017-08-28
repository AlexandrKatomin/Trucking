package trucking.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import trucking.MainAppWithBtm;
import trucking.entity.Contract;
import trucking.entity.PaymantOfContract;
import trucking.entity.Trip;
import trucking.entity.TypeOfPaymant;
import trucking.service.IPaymantOfContractService;
import trucking.service.TripService;

import java.util.Date;

/**
 * Created by Alex on 27.08.2017.
 */
public class TableViewPaymantController {

    @FXML TableView<PaymantOfContract> tableViewPaymant;

    @FXML TableColumn<PaymantOfContract,Date> columnDate;

    @FXML TableColumn<PaymantOfContract,Double> columnSumm;

    @FXML TableColumn<PaymantOfContract,Contract> columnContract;

    @FXML TableColumn<PaymantOfContract,TypeOfPaymant> columnType;

    ClassPathXmlApplicationContext context = MainAppWithBtm.getContext();

   IPaymantOfContractService paymantOfContractService = context.getBean("IPaymantOfContractService", IPaymantOfContractService.class);

    ObservableList<Trip> listTrip;


}
