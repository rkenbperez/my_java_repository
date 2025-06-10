import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends Frame implements ActionListener {
    Label questionLabel;
    CheckboxGroup choicesGroup;
    Checkbox[] choices;
    Button nextButton;
    Panel optionsPanel;

    String[] questions = {
            "What does CPU stand for?",
            "Which data structure uses LIFO order?",
            "What is the value of binary 1010?"
    };

    String[][] options = {
            {"Central Processing Unit", "Computer Power Unit", "Control Program Utility", "Central Programming Unit"},
            {"Queue", "Stack", "Array", "Tree"},
            {"8", "10", "12", "15"}
    };

    int[] correctAnswers = {0, 1, 1}; // correct option index for each question

    int currentQuestion = 0;
    int score = 0;

    public LabActivity5QuizAppAWT() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(new BorderLayout());
        setResizable(false);

        // Question Label
        questionLabel = new Label();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setAlignment(Label.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        // Radio buttons using CheckboxGroup
        choicesGroup = new CheckboxGroup();
        choices = new Checkbox[4];
        optionsPanel = new Panel();
        optionsPanel.setLayout(new GridLayout(4, 1));

        for (int i = 0; i < 4; i++) {
            choices[i] = new Checkbox("", choicesGroup, false);
            choices[i].setFont(new Font("Arial", Font.PLAIN, 14)); // Customization 1
            choices[i].setBackground(Color.lightGray); // Customization 2
            optionsPanel.add(choices[i]);
        }

        add(optionsPanel, BorderLayout.CENTER);

        // Next Button
        nextButton = new Button("Next");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 14));
        nextButton.setBackground(Color.orange); // Customization 3
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);

        // Load first question
        loadQuestion();

        // Window close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
            for (int i = 0; i < 4; i++) {
                choices[i].setLabel(options[currentQuestion][i]);
                choices[i].setState(false);
            }
        } else {
            showResult();
        }
    }

    void showResult() {
        questionLabel.setText("You got " + score + " out of " + questions.length + " correct!");
        for (Checkbox cb : choices) {
            cb.setEnabled(false);
        }
        nextButton.setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        Checkbox selected = choicesGroup.getSelectedCheckbox();

        if (selected != null) {
            String selectedText = selected.getLabel();
            int selectedIndex = -1;

            for (int i = 0; i < 4; i++) {
                if (options[currentQuestion][i].equals(selectedText)) {
                    selectedIndex = i;
                    break;
                }
            }

            if (selectedIndex == correctAnswers[currentQuestion]) {
                score++;
            }

            currentQuestion++;
            loadQuestion();
        } else {
            // Optional: alert if no option selected
            Dialog d = new Dialog(this, "No Selection", true);
            d.setLayout(new FlowLayout());
            d.setSize(250, 100);
            d.add(new Label("Please select an answer before proceeding."));
            Button ok = new Button("OK");
            ok.addActionListener(event -> d.setVisible(false));
            d.add(ok);
            d.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}