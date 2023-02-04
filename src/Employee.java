public class Employee {

    private static int idGenerator = 1;
    private final String fullName;
    private double salary;
    private int department;
    private final int id;


    public Employee(String fullName, double salary, int department) {
        this.fullName   = fullName;
        this.salary     = salary;
        this.department = department;
        this.id         = idGenerator++;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String toString(){
        return "id=" + id + " Сотрудник:" + fullName + " в отделе:" + department + " получает зп:" + salary;
    }

    public String toStringWithoutDepartment(){
        return "id=" + id + " Сотрудник:" + fullName + " получает зп:" + salary;
    }
}
