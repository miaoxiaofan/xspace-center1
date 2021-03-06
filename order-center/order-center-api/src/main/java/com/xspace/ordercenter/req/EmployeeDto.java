package com.xspace.ordercenter.req;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDto implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.employeeID
     *
     * @mbg.generated
     */
    private Integer employeeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.userName
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.phoneNum
     *
     * @mbg.generated
     */
    private String phonenum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.createTime
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.lastUpdate
     *
     * @mbg.generated
     */
    private Date lastupdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table employee
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.employeeID
     *
     * @return the value of employee.employeeID
     *
     * @mbg.generated
     */
    public Integer getEmployeeid() {
        return employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.employeeID
     *
     * @param employeeid the value for employee.employeeID
     *
     * @mbg.generated
     */
    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.userName
     *
     * @return the value of employee.userName
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.userName
     *
     * @param username the value for employee.userName
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.phoneNum
     *
     * @return the value of employee.phoneNum
     *
     * @mbg.generated
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.phoneNum
     *
     * @param phonenum the value for employee.phoneNum
     *
     * @mbg.generated
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.age
     *
     * @return the value of employee.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.age
     *
     * @param age the value for employee.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.createTime
     *
     * @return the value of employee.createTime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.createTime
     *
     * @param createtime the value for employee.createTime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.lastUpdate
     *
     * @return the value of employee.lastUpdate
     *
     * @mbg.generated
     */
    public Date getLastupdate() {
        return lastupdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.lastUpdate
     *
     * @param lastupdate the value for employee.lastUpdate
     *
     * @mbg.generated
     */
    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", employeeid=").append(employeeid);
        sb.append(", username=").append(username);
        sb.append(", phonenum=").append(phonenum);
        sb.append(", age=").append(age);
        sb.append(", createtime=").append(createtime);
        sb.append(", lastupdate=").append(lastupdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}