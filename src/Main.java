public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Ivanov Ivan Ivanovich", 35000, 1);
        employees[2] = new Employee("Petrov Mischele", 45000, 1);
        employees[3] = new Employee("Brown Freen Petrovich", 55000, 2);
        employees[4] = new Employee("Frey Ivan", 135000, 4);
        employees[5] = new Employee("Grey White Lee", 325000, 3);

        printEmployees();
        printSalary();
        printEmployeeWithMinSalary();
        printEmployeeWithMaxSalary();
        printAverageSalary();
        printFullNames();

    }

    private static void printEmployees(){
        for (Employee employee : employees){
            if(employee == null)
                continue;
            System.out.println(employee);
        }
    }

    private static void printSalary(){
        double totalSalary = 0;
        for (Employee employee : employees){
            if(employee == null)
                continue;
            totalSalary += employee.getSalary();
        }
        System.out.println("Зарплата всех сотрудников составляет: " + totalSalary);
    }

    private static void printEmployeeWithMinSalary(){
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees){
            if(employee != null && employee.getSalary() < minSalary) {
                employeeWithMinSalary = employee;
                minSalary = employeeWithMinSalary.getSalary();
            }
        }
        if (employeeWithMinSalary != null)
            System.out.println("Сотрудник с наименьшей зарплатой: " + employeeWithMinSalary);
        else
            System.out.println("Сотрудники отсутствуют");
    }

    private static void printEmployeeWithMaxSalary(){
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees){
            if(employee != null && employee.getSalary() > maxSalary) {
                employeeWithMaxSalary = employee;
                maxSalary = employeeWithMaxSalary.getSalary();
            }
        }
        if (employeeWithMaxSalary != null)
            System.out.println("Сотрудник с наибольшей зарплатой: " + employeeWithMaxSalary);
        else
            System.out.println("Сотрудники отсутствуют");
    }

    private static void printAverageSalary(){
        int numberEmployee = 0;
        double averageSalary = 0;
        for (Employee employee : employees){
            if(employee != null) {
                numberEmployee++;
                averageSalary += employee.getSalary();
            }
        }
        averageSalary = numberEmployee > 0 ? averageSalary / numberEmployee : 0;
        System.out.println("Средняя зарплата составляет:" + averageSalary);
    }

    private  static void printFullNames(){
        for (Employee employee : employees){
            if(employee != null)
                System.out.println(employee.getFullName());
        }
    }
}