import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

    private List<Person> persons = new ArrayList<>();
    saveHandler save = new saveHandler();
    clearHandler clear = new clearHandler();
    int clrk = 0;
    int mngr = 0;
    int cstmr = 0;

    public static class EmptyTextField extends Exception {
        public EmptyTextField(){
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

    public App() {
        persons = new ArrayList<>();
        // TODO add implementations for all milestones here
        btnSave.addActionListener(save);
        rbClerk.addActionListener(this);
        rbManager.addActionListener(this);
        rbCustomer.addActionListener(this);
        btnClear.addActionListener(clear);
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
    }

    public static void main(String[] args) {
        // add here how to make GUI visible
        App frame = new App();
        frame.setContentPane(frame.pnlMain);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setVisible(true);
    }

    static void giveReward(int n) {

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

                    Person p = new Person.Manager(tfName.getText(), age, monthsWorked, salary);
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
        }
        if (e.getSource() == rbManager) {
            mngr = 1;
        }
        if (e.getSource() == rbCustomer){
            cstmr = 1;
        }


    }
}
