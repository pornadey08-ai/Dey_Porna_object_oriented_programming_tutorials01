import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuizBattleGUI extends JFrame {
    // Game stats
    private int playerHP = 100;
    private int bossHP = 100;
    private int score = 0;
    private int currentQuestionIndex = 0;

    private List<Questions> questionList;

    // GUI Components
    private JLabel playerHpLabel;
    private JLabel bossHpLabel;
    private JLabel scoreLabel;
    private JTextArea questionArea;
    private JButton option1Button;
    private JButton option2Button;

    public QuizBattleGUI() {
        // Load questions
        initQuestions();

        // Setup Window
        setTitle("Code Boss Challenge - Java Quiz Battle");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- Top Status Panel ---
        JPanel statusPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        statusPanel.setBorder(BorderFactory.createTitledBorder("Battle Status"));

        playerHpLabel = new JLabel("Player HP: " + playerHP, SwingConstants.CENTER);
        bossHpLabel = new JLabel("Boss HP: " + bossHP, SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);

        playerHpLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        bossHpLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        statusPanel.add(playerHpLabel);
        statusPanel.add(bossHpLabel);
        statusPanel.add(scoreLabel);

        add(statusPanel, BorderLayout.NORTH);

        // --- Center Question Panel ---
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setBorder(BorderFactory.createTitledBorder("Java Question"));

        questionArea = new JTextArea();
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        questionArea.setMargin(new Insets(10, 10, 10, 10));

        questionPanel.add(new JScrollPane(questionArea), BorderLayout.CENTER);
        add(questionPanel, BorderLayout.CENTER);

        // --- Bottom Options Panel ---
        JPanel optionPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        optionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        option1Button = new JButton();
        option2Button = new JButton();

        option1Button.setFont(new Font("SansSerif", Font.PLAIN, 13));
        option2Button.setFont(new Font("SansSerif", Font.PLAIN, 13));

        ActionListener optionClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                handleAnswer(clickedButton.getText());
            }
        };

        option1Button.addActionListener(optionClickListener);
        option2Button.addActionListener(optionClickListener);

        optionPanel.add(option1Button);
        optionPanel.add(option2Button);

        add(optionPanel, BorderLayout.SOUTH);

        // Render first question
        displayQuestion();
    }

    private void initQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Questions("What keyword is used to inherit a class in Java?", "extends", "implements", "extends"));
        questionList.add(new Questions("Which data type is used to store text in Java?", "String", "char", "String"));
        questionList.add(new Questions("What is the entry point method of a Java application?", "public static void main", "public void start", "public static void main"));
        questionList.add(new Questions("Which keyword creates an instance of a class?", "new", "create", "new"));
        questionList.add(new Questions("Which package is automatically imported in every Java program?", "java.lang", "java.util", "java.lang"));
        questionList.add(new Questions("Which modifier hides class members from other classes?", "private", "protected", "private"));
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Questions q = questionList.get(currentQuestionIndex);
            questionArea.setText(q.getQuestion());
            option1Button.setText(q.getOption1());
            option2Button.setText(q.getOption2());
        } else {
            // Reset index to loop questions if game is still active
            currentQuestionIndex = 0;
            displayQuestion();
        }
    }

    private void handleAnswer(String selectedOption) {
        Questions currentQuestion = questionList.get(currentQuestionIndex);

        if (currentQuestion.isCorrect(selectedOption)) {
            bossHP -= 20;
            score += 10;
            JOptionPane.showMessageDialog(this, "Correct! Boss HP -20 | Score +10", "Hit!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            playerHP -= 10;
            JOptionPane.showMessageDialog(this, "Wrong! Player HP -10", "Miss!", JOptionPane.ERROR_MESSAGE);
        }

        updateStats();

        // Check Win/Loss conditions
        if (bossHP <= 0) {
            JOptionPane.showMessageDialog(this, " You defeated Code Boss!\nFinal Score: " + score, "Victory!", JOptionPane.INFORMATION_MESSAGE);
            disableGame();
            return;
        } else if (playerHP <= 0) {
            JOptionPane.showMessageDialog(this, " Game Over! You were defeated by Code Boss.\nFinal Score: " + score, "Defeat!", JOptionPane.ERROR_MESSAGE);
            disableGame();
            return;
        }

        currentQuestionIndex++;
        displayQuestion();
    }

    private void updateStats() {
        playerHpLabel.setText("Player HP: " + Math.max(0, playerHP));
        bossHpLabel.setText("Boss HP: " + Math.max(0, bossHP));
        scoreLabel.setText("Score: " + score);
    }

    private void disableGame() {
        option1Button.setEnabled(false);
        option2Button.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuizBattleGUI().setVisible(true);
        });
    }
}