package trucking;

import trucking.entity.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import trucking.service.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 17.08.2017.
 */
public class Main {
    public Main() throws ParseException {
    }
    public void SSS(IService service){

    }



    public static void main(String[] args) throws SQLException, ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date date  = ft.parse("1980-11-11");
        Date date2= ft.parse("2016-01-01");
        Date date3= ft.parse("2017-08-08");
        Driver driver=new Driver("Иван","Иванов",date);
        Car car = new Car("копейка","О124на31",date2,3.5D);
        Company company = new Company("компания","белгород");
        //Contract contract= new Contract("001",date3,26000,3.7D,true,driver,car,company);
       // TypeOfTrip typeOfTrip= new TypeOfTrip("прямой рейс");
        CircleTrip circleTrip = new CircleTrip("001",0);
        //Trip trip = new Trip(1,date3,date2,1700,240D,"белгород","москва",circleTrip,contract,typeOfTrip);
        TypeOfPaymant typeOfPaymant= new TypeOfPaymant("р/с","какой-то номер");
       // PaymantOfContract paymantOfContract = new PaymantOfContract(date3,26000D,contract,typeOfPaymant);
        TripProfit tripProfit = new TripProfit(14000D,50000D,36000D,circleTrip);
        TypeOfExpense typeOfExpense = new TypeOfExpense("топливо");
        Expense expense = new Expense(14000D,date3,"",typeOfExpense,circleTrip);

        //inintializes servises
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aplicationContext.xml");
        CarService carService =context.getBean("CarService",CarService.class);
        CircleTripService circleTripService=context.getBean("CircleTripService",CircleTripService.class);
        CompanyService companyService=context.getBean("CompanyService",CompanyService.class);
        DriverService driverService=context.getBean("DriverService",DriverService.class);
        ContractService contractService=context.getBean("ContractService",ContractService.class);


        driverService.save(driver);
        carService.save(car);
        companyService.save(company);
        circleTripService.save(circleTrip);

        /*driver=driverService.get(1L);
        company=companyService.get(1L);
        car=carService.get(1L);*/


        Contract contract= new Contract("001",date3,26000,3.7D,true,driver,car,company);

       contractService.save(contract);

        List<Contract> list=contractService.getAll();
        Contract contract1=list.get(0);

        contractService.delete(contract1);



        //cleaner data from db

        contractService.delete(contract1);
        /*
        driverService.delete(1);
        carService.delete(1);
        companyService.delete(1);*/
       // circleTripService.delete(1);



    }
}
