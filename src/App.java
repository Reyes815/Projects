import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame implements ActionListener {
    private JPanel pnlMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextArea taPersons;
    private JButton btnSave;
    private JTextField tfAge;
    private JTextField tfMonths;
    private JTextField tfSalary;
    private JButton btnClear;
    private JTextField tfLoad;
    private JButton btnLoad;
    private JButton btnSayHi;
    private JButton btnSavePerson;
    private JButton btnLoadPerson;
    private JButton btnReward;

    private List<Person> persons;
    saveHandler save = new saveHandler();
    clearHandler clear = new clearHandler();
    loadHandler load = new loadHandler();
    greetHandler greet = new greetHandler();
    rewardHandler reward = new rewardHandler();
    int clrk = 0;
    int mngr = 0;
    int cstmr = 0;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static class EmptyTextField extends Exception {
        public EmptyTextField(){
        }
    }

    public static class NotAnEmployee extends Exception {
        public NotAnEmployee(){
        }
    }

    public static class IncorrectInput extends Exception {
        public IncorrectInput(){
        }
    }

    public static class NegativeInput extends Exception {
        public NegativeInput(){
        }
    }

    public static class DidNotWork extends Exception {
        public DidNotWork(){
        }
    }

    public App() {
        persons = new ArrayList<>();
        // TODO add implementations for all milestones here
        btnSave.addActionListener(save);
        btnClear.addActionListener(clear);
        btnLoad.addActionListener(load);
        btnSayHi.addActionListener(greet);
        btnReward.addActionListener(reward);
        rbClerk.addActionListener(this);
        rbManager.addActionListener(this);
        rbCustomer.addActionListener(this);

        tfName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    try {
                        throw new IncorrectInput();
                    } catch (IncorrectInput ex) {
                        JOptionPane.showMessageDialog(null,"Incorrect Input");
                    } finally {
                        tfName.setText("");
                    }
                }
            }
        });

        tfAge.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isAlphabetic(c)) {
                    try {
                        throw new IncorrectInput();
                    } catch (IncorrectInput ex) {
                        JOptionPane.showMessageDialog(null,"Incorrect Input");
                    } finally {
                        tfAge.setText("");
                    }
                }
            }
        });

        tfMonths.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isAlphabetic(c)) {
                    try {
                        throw new IncorrectInput();
                    } catch (IncorrectInput ex) {
                        JOptionPane.showMessageDialog(null,"Incorrect Input");
                    } finally {
                        tfMonths.setText("");
                    }
                }
            }
        });

        tfSalary.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isAlphabetic(c)) {
                    try {
                        throw new IncorrectInput();
                    } catch (IncorrectInput ex) {
                        JOptionPane.showMessageDialog(null,"Incorrect Input");
                    } finally {
                        tfSalary.setText("");
                    }
                }
            }
        });

        tfLoad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isAlphabetic(c)) {
                    try {
                        throw new IncorrectInput();
                    } catch (IncorrectInput ex) {
                        JOptionPane.showMessageDialog(null,"Incorrect Input");
                    } finally {
                        tfLoad.setText("");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        // add here how to make GUI visible
        App frame = new App();
        frame.setContentPane(frame.pnlMain);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setVisible(true);
    }

    public void giveReward(int n) {
        Person p = persons.get(n);
        int stop = 0;

        try {
            if(p instanceof Person.Employee){
                if(((Person.Employee) p).months_worked == 0){
                    throw new DidNotWork();
                }
            }
        } catch (DidNotWork e) {
            JOptionPane.showMessageDialog(null, "Did Not Work");
            stop = 1;
        }

        if(stop == 0) {
            if (p instanceof Person.Employee) {
                double d = ((Person.Employee) p).thirteenthmonth();
                JOptionPane.showMessageDialog(null, (df.format(d)));
            }
        }
    }

    public class rewardHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                int index = Integer.parseInt(tfLoad.getText());
                Person sample = persons.get(index-1);

                if(sample instanceof Person.Customer){
                    throw new NotAnEmployee();
                }else if(sample instanceof Person.Clerk){
                    rbClerk.setSelected(true);
                    giveReward(index-1);
                }else if(sample instanceof Person.Manager){
                    rbManager.setSelected(true);
                    giveReward(index-1);
                }else throw new IncorrectInput();
            } catch (NumberFormatException ignored) {
            } catch (IncorrectInput ex){
                JOptionPane.showMessageDialog(null,"Incorrect Input");
            } catch (IndexOutOfBoundsException e4){
                JOptionPane.showMessageDialog(null, "Index Is Empty");
            } catch (NotAnEmployee e5) {
                JOptionPane.showMessageDialog(null, "Not An Employee");
            } finally {
                tfLoad.setText("");
            }
        }
    }

    public class greetHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Person p: persons
                 ) {
                System.out.println(p);
            }
        }
    }

    public class clearHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tfName.setText("");
            tfAge.setText("");
            tfMonths.setText("");
            tfSalary.setText("");
            tfLoad.setText("");
            taPersons.setText("");
        }
    }

    public class loadHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                int index = Integer.parseInt(tfLoad.getText());
                Person sample = persons.get(index-1);

                if(sample instanceof Person.Customer){
                    rbCustomer.setSelected(true);
                    String str = index+1 + ". Customer - (" + sample.name + ") (" + sample.age + ")";
                    taPersons.setText(str);
                }else if(sample instanceof Person.Clerk){
                    rbClerk.setSelected(true);
                    String str = index+1 + ". Clerk - (" + sample.name + ") (" + sample.age + ")";
                    taPersons.setText(str);
                }else if(sample instanceof Person.Manager){
                    rbManager.setSelected(true);
                    String str = index+1 + ". Manager - (" + sample.name + ") (" + sample.age + ")";
                    taPersons.setText(str);
                }else throw new IncorrectInput();
            } catch (NumberFormatException ignored) {
            } catch (IncorrectInput ex){
                JOptionPane.showMessageDialog(null,"Incorrect Input");
            } catch (IndexOutOfBoundsException e4){
                JOptionPane.showMessageDialog(null, "Index Is Empty");
            }
        }
    }

    public class saveHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(clrk == 1){
                    if(tfName.getText().trim().isEmpty() || tfAge.getText().trim().isEmpty() ||
                            tfMonths.getText().trim().isEmpty() || tfSalary.getText().trim().isEmpty()){
                        throw new EmptyTextField();
                    }

                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
                    int monthsWorked = Integer.parseInt(tfMonths.getText());
                    double salary = Double.parseDouble(tfSalary.getText());

                    if(age < 0 || salary < 0 || monthsWorked < 0){
                        throw new NegativeInput();
                    }

                    Person p = new Person.Clerk(name, age, monthsWorked, salary);
                    persons.add(p);
                    int order = persons.indexOf(p);
                    String str = order+1 + ". Clerk - (" + p.name + ") (" + p.age + ")";
                    taPersons.setText(str);
                    clrk = 0;
                    tfName.setText("");
                    tfAge.setText("");
                    tfMonths.setText("");
                    tfSalary.setText("");
                }
                if(cstmr == 1){
                    if(tfName.getText().trim().isEmpty() || tfAge.getText().trim().isEmpty()){
                        throw new EmptyTextField();
                    }

                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());

                    if(age < 0 ){
                        throw new NegativeInput();
                    }

                    Person p = new Person.Customer(name, age);
                    persons.add(p);
                    int order = persons.indexOf(p);
                    String str = order+1 + ". Customer - (" + p.name + ") (" + p.age + ")";
                    taPersons.setText(str);
                    cstmr = 0;
                    tfName.setText("");
                    tfAge.setText("");
                }
                if(mngr == 1){
                    if(tfName.getText().trim().isEmpty() || tfAge.getText().trim().isEmpty() ||
                            tfMonths.getText().trim().isEmpty() || tfSalary.getText().trim().isEmpty()){
                        throw new EmptyTextField();
                    }

                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
                    int monthsWorked = Integer.parseInt(tfMonths.getText());
                    double salary = Double.parseDouble(tfSalary.getText());

                    if(age < 0 || salary < 0 || monthsWorked < 0){
                        throw new NegativeInput();
                    }

                    Person p = new Person.Manager(name, age, monthsWorked, salary);
                    persons.add(p);
                    int order = persons.indexOf(p);
                    String str = order+1 + ". Manager - (" + p.name + ") (" + p.age + ")";
                    taPersons.setText(str);
                    mngr = 0;
                    tfName.setText("");
                    tfAge.setText("");
                    tfMonths.setText("");
                    tfSalary.setText("");
                }

            } catch (NumberFormatException ignored) {

            } catch (EmptyTextField e2) {
                JOptionPane.showMessageDialog(null,"Empty Text Field Detected");
            } catch (NegativeInput e3) {
                JOptionPane.showMessageDialog(null,"Negative Number Detected");
            } finally {
                tfName.setText("");
                tfAge.setText("");
                tfMonths.setText("");
                tfSalary.setText("");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == rbClerk) {
            clrk = 1;
            tfMonths.setEditable(true);
            tfSalary.setEditable(true);
        }
        if (e.getSource() == rbManager) {
            mngr = 1;
            tfMonths.setEditable(true);
            tfSalary.setEditable(true);
        }
        if (e.getSource() == rbCustomer){
            cstmr = 1;
            tfMonths.setEditable(false);
            tfSalary.setEditable(false);
        }


    }
}
