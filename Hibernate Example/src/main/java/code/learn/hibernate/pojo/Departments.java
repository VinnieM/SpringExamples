package code.learn.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
public class Departments {

  @Id
//  @GeneratedValue
  @Column(name = "dept_no")
  private String deptNo;

  @Column(name = "dept_name")
  private String deptName;

  public Departments() {
  }

  public Departments(String deptNo, String deptName) {
    this.deptNo = deptNo;
    this.deptName = deptName;
  }

  public String getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(String deptNo) {
    this.deptNo = deptNo;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
}
