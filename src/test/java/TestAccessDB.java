import javafx.beans.property.SimpleStringProperty;
import trucking.entity.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import trucking.repository.CarRepository;
import trucking.repository.ContractRepository;
import trucking.repository.DriverRepository;
import trucking.service.CarService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Alex on 17.08.2017.
 */
public class TestAccessDB {
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
    Date date = ft.parse("1980-11-11");
    Date date2= ft.parse("2016-01-01");
    Date date3= ft.parse("2017-08-08");
    Driver driver=new Driver("Иван","Иванов",date);
    Car car = new Car("копейка","О124на31",date2,3.5D);
    Company company = new Company("компания","белгород");
    Contract contract= new Contract("001",date3,26000,3.7D,true,driver,car,company);
    TypeOfTrip typeOfTrip= new TypeOfTrip(/*new SimpleStringProperty("прямой рейс")*/);
    CircleTrip circleTrip = new CircleTrip("001",0);
    Trip trip = new Trip(1,date3,date2,1700,240D,"белгород","москва",circleTrip,contract,typeOfTrip);
    TypeOfPaymant typeOfPaymant= new TypeOfPaymant("р/с","какой-то номер");
    PaymantOfContract paymantOfContract = new PaymantOfContract(date3,26000D,contract,typeOfPaymant);
    TripProfit tripProfit = new TripProfit(14000D,50000D,36000D,circleTrip);
    TypeOfExpense typeOfExpense = new TypeOfExpense("топливо");
    Expense expense = new Expense(14000D,date3,"",typeOfExpense,circleTrip);

    public TestAccessDB() throws ParseException {
    }

    public  void testAllEntity(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aplicationContext.xml");

        ContractRepository contractReposytory=context.getBean(ContractRepository.class);
        DriverRepository driverRepository=context.getBean(DriverRepository.class);
        CarRepository carRepository;

        CarService carService =context.getBean("CarService",CarService.class);




    }
}
