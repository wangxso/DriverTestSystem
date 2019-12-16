package cn.wangx.DriverTest.pojo;

import java.util.List;

public class Page<T> {
    private Integer pageNo = 1;     //当前页码数
    private Integer pageSize = 10;   //每页显示的行数
    private Integer totalPage;      //总页数
    private Integer rows;           // 总行数
    private List<T> lists;          // 存放当前页面 数据的集合

    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 在设置当前页码数之前  总页面要赋值
     * @param pageNo
     */
    public void setPageNo(Integer pageNo) {
        if (pageNo<1){
            this.pageNo=1;
        }else  if(pageNo>totalPage){
            this.pageNo = totalPage;
        }else{
            this.pageNo = pageNo;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }


    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
        //自动算出总页数
        this.totalPage= this.rows%pageSize==0?this.rows/pageSize:this.rows/pageSize+1;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}

