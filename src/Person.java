public class Person {
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

    public class Customer extends Person{

        public Customer(String name, int age) {
            super(name, age);
        }
    }

    public class Employee extends Person {
        int months_worked;
        double salary;
        public Employee(String name, int age) {
            super(name, age);
        }

        public double thirteenthmonth(){

        }
    }

    public class Clerk extends Employee {


        public Clerk(String name, int age) {
            super(name, age);
        }

        @Override
        public String toString() {
            return super.toString() + "How may I help you?";
        }
    }

    public class Manager extends Employee {


        public Manager(String name, int age) {
            super(name, age);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


}


