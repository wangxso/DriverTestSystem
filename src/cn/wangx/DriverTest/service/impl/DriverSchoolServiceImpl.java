package cn.wangx.DriverTest.service.impl;

import cn.wangx.DriverTest.dao.DriverSchoolDao;
import cn.wangx.DriverTest.dao.impl.DriverSchoolDaoImpl;
import cn.wangx.DriverTest.pojo.DriverSchool;
import cn.wangx.DriverTest.service.DriverSchoolService;

import java.util.List;

public class DriverSchoolServiceImpl implements DriverSchoolService {
    private DriverSchoolDao driverSchoolDao = new DriverSchoolDaoImpl();
    @Override
    public List<DriverSchool> findDriverSchoolPagination(int start, int end) {
        return driverSchoolDao.findDriverSchoolPagination(start, end);
    }

    @Override
    public int findDriverSchoolNumber() {
        return driverSchoolDao.findDriverSchoolNumber();
    }

    @Override
    public DriverSchool findDriverSchoolById(int id) {
        return driverSchoolDao.findDriverSchoolById(id);
    }
}
