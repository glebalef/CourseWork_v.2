public class    Main {
    static Employee[] employeesList = new Employee[10];

    public static void main(String[] args) {

        employeesList[0] = new Employee("Маша Крац", 1, 100000);
        employeesList[1] = new Employee("Петя Артамонов", 5, 15000);
        employeesList[2] = new Employee("Костя Дзю", 3, 9900);
        employeesList[3] = new Employee("Микка Хаккинен", 3, 5000);
        employeesList[4] = new Employee("Кими Райкконен", 2, 38000);
        employeesList[5] = new Employee("Майкл Фелпс", 2, 88400);
        employeesList[6] = new Employee("Альберт Эйнштейн", 2, 100000);
        employeesList[7] = new Employee("Луис Армстронг", 4, 56000);
        employeesList[8] = new Employee("Николь Кидман", 5, 149999);
        employeesList[9] = new Employee("Ева Грин", 5, 10000);

        // Использование методов:
//        printAll();
//        System.out.println("Обшая сумма затрат на ЗП составляет: "+findSum()+" рублей");
//        System.out.println("Минимальная зарплата равна: "+findMin()+" рублей"+" и ее получает - "+findMinEmployee());
//        System.out.println("Максимальная зарплата равна: "+findMax()+" рублей"+" и ее получает - "+findMaxEmployee().getName());
//        System.out.println("Средняя зарплата равна: "+findAverage()+" рублей");
//        printNameOnly();

        // Проверка метода по Индексации:
        //raiseSalaryToAll(50);
        //System.out.printf("%.2f", employeesList[5].getSalary()); // 400 -> 600

        // Проверка метода по поиску Max в департаменте:

        System.out.println(); // пустая строка
        System.out.println("Максимаотная зарплата в департаменте " + findMaxEmployeeInDept(2).getName());
        System.out.println("Минимальная в департаменте " + findMinEmployeeInDept(2).getName());
        System.out.println("Сумма по департаменту " + findDeptTotalSalary(2));
        System.out.printf("Средняя по департаменту "+ "%.2f",findDeptAverage(2));
        System.out.println();
        raiseDeptSalary(2, 10); // по департменту 2 поднимаем на 10%
        System.out.println(employeesList[4].getSalary());
        System.out.println(employeesList[7].getSalary());
        printAllLess(10000);
        printAllMore(99000);
        printDept(2);

    }

    //Метод 1, Печать всех
    private static void printAll() {
        for (int i = 0; i < employeesList.length; i++) {
            System.out.println(employeesList[i]);
        }
    }

    //Метод 2, Найти сумму
    private static int findSum() {
        int sum = 0;
        for (int i = 0; i < employeesList.length; i++) {
            sum += employeesList[i].getSalary();
        }
        return sum;
    }

    // Метод 3,4 Найти минимум и максимум

    private static double findMin() {
        double min = employeesList[0].getSalary();
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() < min)
                min = employeesList[i].getSalary();
        }
        return min;
    }

    private static String findMinEmployee() {
        Employee minEmployee = employeesList[0];
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() == findMin())
                minEmployee = employeesList[i];
        }
        return minEmployee.getName();
    }

    private static double findMax() {
        double max = employeesList[0].getSalary();
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() > max)
                max = employeesList[i].getSalary();
        }
        return max;
    }

    private static Employee findMaxEmployee() {
        Employee maxEmployee = employeesList[0];
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() == findMax())
                maxEmployee = employeesList[i];
        }
        return maxEmployee;
    }

    // Метод 5, найти среднее
    private static float findAverage() {
        float average = findSum() / (float) employeesList.length;
        return average;
    }

    // Метод 6, вывести только ФИО
    private static void printNameOnly() {
        for (int i = 0; i < employeesList.length; i++) {
            System.out.println(employeesList[i].getName());
        }
    }

    // Методы для Уровня 2

    // Индексация на заданный %
    private static void raiseSalaryToAll(double raiseRate) { // задать уровень повышения в процентах
        for (int i = 0; i < employeesList.length; i++) {
            double raiseRateCalculation = raiseRate / 100 + 1;
            employeesList[i].setSalary(employeesList[i].getSalary() * raiseRateCalculation);
        }

    }

    // Максимальная зарплата в отделе
    private static Employee findMaxEmployeeInDept(int deptNumber) {
        Employee maxEmployee = employeesList[0];
        double maxSalary = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getDepartment() == deptNumber && employeesList[i].getSalary() > maxSalary) {
                maxSalary = employeesList[i].getSalary();
                maxEmployee = employeesList[i];
            }
        }
        return maxEmployee;
    }

    // Минимальная зарплата в отделе

    private static Employee findMinEmployeeInDept(int deptNumber) {
        Employee minEmployee = employeesList[0];
        double minSalary = findSum();
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() < minSalary && employeesList[i].getDepartment() == deptNumber) {
                minSalary = employeesList[i].getSalary();
                minEmployee = employeesList[i];
            }
        }
        return minEmployee;
    }

    // Сумма зарплат в отделе
    private static double findDeptTotalSalary(int deptNumber) {
        double depTotal = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if (deptNumber == employeesList[i].getDepartment()) {
                depTotal += employeesList[i].getSalary();
            }
        }
        return depTotal;
    }

    // Cредняя ЗП по депратаменту:

    private static double findDeptAverage(int deptNumber) {
        double deptTotal = 0;
        int deptCount = 0;
        for (int i = 0; i < employeesList.length; i++) {
            if (deptNumber == employeesList[i].getDepartment()) {
                deptTotal += employeesList[i].getSalary();
                deptCount++;
            }
            }
            return deptTotal/deptCount;
        }

    // Индексация заданного отдела на заданный %
    private static void raiseDeptSalary(int deptNumber, double raiseRate) {
        for (int i = 0; i < employeesList.length; i++) {
            if (deptNumber == employeesList[i].getDepartment()) {
                double raiseRateCalculation = raiseRate / 100 + 1;
                employeesList[i].setSalary(employeesList[i].getSalary() * raiseRateCalculation);
            }

        }
    }

    // Вывод сотрудников с зарлатой меньше заданного числа:
    private static void printAllLess(int baseSalary) {
        System.out.println("Сотрдуники получающие меньше "+baseSalary+" рублей:");
        for (int i = 0; i < employeesList.length; i++) {
            if (baseSalary >= employeesList[i].getSalary()) {
                System.out.println(employeesList[i].getName());
            }
        }
    }

    // Вывод сотрудников с зарлатой больше заданного числа:
    private static void printAllMore(int baseSalary) {
        System.out.println("Сотрдуники получающие больше "+baseSalary+" рублей:");
        for (int i = 0; i < employeesList.length; i++) {
            if (baseSalary <= employeesList[i].getSalary()) {
                System.out.println(employeesList[i].getName());
            }
            }
        }
// Печать сотрудников отдного отдела:
        private static void printDept (int deptNumber) {
            System.out.println("В отделе "+deptNumber+" работают: ");
            for (int i = 0; i < employeesList.length; i++) {
                if (employeesList[i].getDepartment()==deptNumber) {
                    System.out.println(employeesList[i].getName());
                }
            }
        }
    }

