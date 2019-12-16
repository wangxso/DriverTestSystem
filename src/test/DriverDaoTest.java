package test;

import cn.wangx.DriverTest.dao.DriverSchoolDao;
import cn.wangx.DriverTest.dao.impl.DriverSchoolDaoImpl;
import cn.wangx.DriverTest.pojo.DriverSchool;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DriverDaoTest {
    DriverSchoolDao driverSchoolDao = new DriverSchoolDaoImpl();


    @Test
    void testGetNumber(){
        int driverSchoolNumber = driverSchoolDao.findDriverSchoolNumber();
        System.out.println(driverSchoolNumber);
    }

    @Test
    void testPagination(){
        List<DriverSchool> driverSchoolPagination = driverSchoolDao.findDriverSchoolPagination(1, 10);
        System.out.println(driverSchoolPagination.size());
    }

    @Test
    void testFindSchoolById(){
        DriverSchool driverSchoolById = driverSchoolDao.findDriverSchoolById(1);
        System.out.println(driverSchoolById);
    }
}
