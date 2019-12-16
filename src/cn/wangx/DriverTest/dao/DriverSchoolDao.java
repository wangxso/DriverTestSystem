package cn.wangx.DriverTest.dao;

import cn.wangx.DriverTest.pojo.DriverSchool;

import java.util.List;

/**
 * 驾校表的持久层
 *
 */
public interface DriverSchoolDao {
    /**
     * 分页查询驾校信息
     * @param start 开始位置
     * @param end 结束位置
     * @return 驾校列表
     */
    List<DriverSchool> findDriverSchoolPagination(int start, int end);

    /**
     * 查询驾校个数
     * @return 驾校个数
     */
    int findDriverSchoolNumber();

    /**
     * 通过驾校id查询驾校信息
     * @param id 驾校id
     * @return 驾校信息
     */
    DriverSchool findDriverSchoolById(int id);
}
