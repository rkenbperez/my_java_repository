import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LabActivity6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoListViewer());
    }
}

class ToDoListViewer extends JFrame {
    JTable table;
    DefaultTableModel model;
    JButton addTaskButton;
    static ToDoListForm formInstance = null;

    public ToDoListViewer() {
        setTitle("To-Do List Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        addTaskButton = new JButton("Add Task");
        add(addTaskButton, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{"Task Name", "Description", "Status"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        addTaskButton.addActionListener(e -> {
            if (formInstance == null || !formInstance.isDisplayable()) {
                formInstance = new ToDoListForm(this);
            } else {
                formInstance.toFront();
            }
        });

        setVisible(true);
    }

    public void addTask(String name, String description, String status) {
        model.addRow(new Object[]{name, description, status});
    }
}

class ToDoListForm extends JFrame {
    JTextField nameField;
    JTextArea descriptionArea;
    JComboBox<String> statusBox;
    JButton saveButton;

    public ToDoListForm(ToDoListViewer viewer) {
        setTitle("Add New Task");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        nameField = new JTextField();
        descriptionArea = new JTextArea(3, 20);
        statusBox = new JComboBox<>(new String[]{"Not Started", "Ongoing", "Completed"});
        saveButton = new JButton("Save Task");

        formPanel.add(new JLabel("Task Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Task Description:"));
        formPanel.add(new JScrollPane(descriptionArea));
        formPanel.add(new JLabel("Status:"));
        formPanel.add(statusBox);

        add(formPanel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String description = descriptionArea.getText().trim();
            String status = (String) statusBox.getSelectedItem();

            if (!name.isEmpty() && !description.isEmpty()) {
                viewer.addTask(name, description, status);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
