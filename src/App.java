import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    int clrk = 0;
    int mngr = 0;
    int cstmr = 0;

    public App() {
        persons = new ArrayList<>();
        // TODO add implementations for all milestones here
        btnSave.addActionListener(save);
        rbClerk.addActionListener(this);
        rbManager.addActionListener(this);
        rbCustomer.addActionListener(this);
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

    public class saveHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(clrk == 1){
                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
                    int monthsWorked = Integer.parseInt(tfMonths.getText());
                    double salary = Double.parseDouble(tfSalary.getText());
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
                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
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
                    String name = tfName.getText();
                    int age = Integer.parseInt(tfAge.getText());
                    int monthsWorked = Integer.parseInt(tfMonths.getText());
                    double salary = Double.parseDouble(tfSalary.getText());
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
            } catch (NumberFormatException e1) {
                System.out.println();
            }
            for (Person p: persons
                 ) {

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
