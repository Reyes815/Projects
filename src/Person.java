public abstract  class Person {
    // TODO implement Person and its subclasses in other Java files
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {

        return "Hello,  my  name  is " + this.name + ".";
    }

    public static class Customer extends Person{

        public Customer(String name, int age) {
            super(name, age);
        }
    }

    public static class Employee extends Person {
        int months_worked;
        double salary;

        public Employee(String name, int age, int months_worked, double salary) {
            super(name, age);
            this.months_worked = months_worked;
            this.salary = salary;
        }

        public Employee(String name, int age) {
            super(name, age);
        }

        public double thirteenthmonth(){
            double pay = 0;
            return pay;
        }
    }

    public static class Clerk extends Employee {


        public Clerk(String name, int age, int months_worked, double salary) {
            super(name, age, months_worked, salary);
        }

        @Override
        public String toString() {
            return super.toString() + "How may I help you?";
        }
    }

    public static class Manager extends Employee {


        public Manager(String name, int age, int months_worked, double salary) {
            super(name, age, months_worked, salary);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


}


