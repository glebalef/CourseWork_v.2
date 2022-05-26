public class    Main {
    static Employee[] employeesList = new Employee[10];

    public static void main(String[] args) {

        employeesList[0] = new Employee("Маша Крац", "1", 10000);
        employeesList[1] = new Employee("Петя Артамонов", "1", 15000);
        employeesList[2] = new Employee("Костя Дзю", "1", 99);
        employeesList[3] = new Employee("Микка Хаккинен", "2", 18000);
        employeesList[4] = new Employee("Кими Райкконен", "2", 38000);
        employeesList[5] = new Employee("Майкл Фелпс", "3", 400);
        employeesList[6] = new Employee("Альберт Эйнштейн", "3", 100000);
        employeesList[7] = new Employee("Луис Армстронг", "4", 56000);
        employeesList[8] = new Employee("Николь Кидман", "5", 149999);
        employeesList[9] = new Employee("Ева Грин", "5", 22000);

        // Использование методов:
        printAll();
        System.out.println("Обшая сумма затрат на ЗП составляет: "+findSum()+" рублей");
        System.out.println("Минимальная зарплата равна: "+findMin()+" рублей"+" и ее получает - "+findMinEmployee());
        System.out.println("Максимальная зарплата равна: "+findMax()+" рублей"+" и ее получает - "+findMaxEmployee());
        System.out.println("Средняя зарплата равна: "+findAverage()+" рублей");
        printNameOnly();

    }

    //Метод 1, Печать всех
    private static void printAll() {
        for (int i = 0; i < employeesList.length; i++) {
            System.out.println(employeesList[i].toString());
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

    private static int findMin () {
        int min = employeesList[0].getSalary();
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() < min)
                min = employeesList[i].getSalary();
        }
        return min;
    }
    private static String findMinEmployee () {
        Employee minEmployee = employeesList[0];
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() == findMin())
                minEmployee = employeesList[i];
        } return minEmployee.getName();
    }
    private static int findMax () {
        int max = employeesList[0].getSalary();
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() > max)
                max = employeesList[i].getSalary();
        }
        return max;
    }

    private static String findMaxEmployee () {
        Employee maxEmployee = employeesList[0];
        for (int i = 0; i < employeesList.length; i++) {
            if (employeesList[i].getSalary() == findMax())
                maxEmployee = employeesList[i];
        }
        return maxEmployee.getName();
    }

    // Метод 5, найти среднее
    private static float findAverage () {
        float average = findSum() / (float)employeesList.length;
        return average;
    }

    // Метод 6, вывести только ФИО
    private static void printNameOnly () {
        for (int i = 0; i < employeesList.length; i++) {
            System.out.println(employeesList[i].getName());
        }
    }
}
