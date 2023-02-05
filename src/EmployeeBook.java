public class EmployeeBook {

    private final Employee[] employees;

    public EmployeeBook(int size){
        this.employees = new Employee[size];
    }

    public void addEmployee(Employee employee){
        if (employee == null){
            System.out.println("Сотрудник не указан");
            return;
        }
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null){
                index = i;
                break;
            }
        }
        if (index == -1)
            System.out.println("Нет места нового сотруднику");
        else
            employees[index] = employee;
    }

    public void removeEmployee(Employee employee){

        if (employee == null){
            System.out.println("Сотрудник не указан");
            return;
        }

        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if(employee.equals(employees[i])){
                index = i;
                break;
            }
        }
        if (index == -1)
            System.out.println("Сотрудник не найден в списке");
        else
            employees[index] = null;
    }

    public Employee getEmployee(String fullName){
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getFullName() == fullName)
                return employees[i];
        }
        return null;
    }

    public void setSalary(Employee employee, double salary){
        employee.setSalary(salary);
    }

    public void setDepartment(Employee employee, int department){
        employee.setDepartment(department);
    }

    public void printEmployeesByDepartments(){

        int[] numberDepartments = new int[employees.length];
        boolean isFindDepartment;
        int count = 0;

        //получаем существующие отделы по списку сотрудников
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null)
                continue;
            isFindDepartment = isFindDepartment(numberDepartments, employees[i].getDepartment());
            if (!isFindDepartment) {
                numberDepartments[count] = employees[i].getDepartment();
                count++;
            }
        }
        //по департаменту выводим сотрудников
        for (int i = 0; i < numberDepartments.length; i++) {
            if(numberDepartments[i] == 0)
                continue;
            System.out.println("Сотрудники отдела:" + numberDepartments[i]);
            for (int j = 0; j < employees.length; j++) {
                if(employees[j] == null || employees[j].getDepartment() != numberDepartments[i])
                    continue;
                System.out.println(employees[j].getFullName());
            }
        }
    }

    private boolean isFindDepartment(int[] numberDepartments, int department){
        for (int i = 0; i < numberDepartments.length; i++)
            if (numberDepartments[i] == department)
                return true;
        return false;
    }
}
