import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Perceptron {

    private double learningRate;
    private double[] weights;

    public Perceptron(double learningRate, int numInputs) {
        this.learningRate = learningRate;
        this.weights = new double[numInputs];
        Random rand = new Random();
        for (int i = 0; i < numInputs; i++) {
            this.weights[i] = rand.nextDouble();
        }
    }

    public double guess(double[] inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += weights[i] * inputs[i];
        }
        return activate(sum);
    }

    public void train(double[] inputs, double target) {
        double guess = guess(inputs);
        double error = target - guess;
        for (int i = 0; i < weights.length; i++) {
            weights[i] += learningRate * error * inputs[i];
        }
    }

    private double activate(double x) {
        if (x < -709) {
            return 0.0;
        } else if (x > 709) {
            return 1.0;
        } else {
            return 1.0 / (1.0 + Math.exp(-x));
        }
    }
}

public class g extends JFrame {

    private JTextField usernameField, passwordField;
    private JTextField learningRateField, maxEpochsField, goalField;
    private JTextField mathScoreField, englishScoreField, scienceScoreField;
    private JLabel statusLabel;
    private Perceptron perceptron;

    public g() {
        setTitle("Perceptron GUI");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        showLoginScreen();
    }

    private void showLoginScreen() {
        getContentPane().removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);

        usernameField = new JTextField();
        gbc.gridx = 1;
        add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passLabel, gbc);

        passwordField = new JPasswordField();
        gbc.gridx = 1;
        add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.GREEN);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(loginButton, gbc);

        setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("فاطمة") && password.equals("123456")) {
            showMainScreen();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showMainScreen() {
        getContentPane().removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel rateLabel = new JLabel("Learning rate:");
        rateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        rateLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(rateLabel, gbc);

        learningRateField = new JTextField();
        gbc.gridx = 1;
        add(learningRateField, gbc);

        JLabel epochLabel = new JLabel("Maximum epochs:");
        epochLabel.setFont(new Font("Arial", Font.BOLD, 14));
        epochLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(epochLabel, gbc);

        maxEpochsField = new JTextField();
        gbc.gridx = 1;
        add(maxEpochsField, gbc);

        JLabel goalLabel = new JLabel("Goal (e.g., 0.01, 0.05, 0.1):");
        goalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        goalLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(goalLabel, gbc);

        goalField = new JTextField();
        gbc.gridx = 1;
        add(goalField, gbc);

        JButton trainButton = new JButton("Train");
        trainButton.setBackground(Color.GREEN);
        trainButton.setForeground(Color.WHITE);
        trainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainPerceptron();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(trainButton, gbc);

        JLabel mathLabel = new JLabel("Math score:");
        mathLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mathLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(mathLabel, gbc);

        mathScoreField = new JTextField();
        gbc.gridx = 1;
        add(mathScoreField, gbc);

        JLabel englishLabel = new JLabel("English score:");
        englishLabel.setFont(new Font("Arial", Font.BOLD, 14));
        englishLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(englishLabel, gbc);

        englishScoreField = new JTextField();
        gbc.gridx = 1;
        add(englishScoreField, gbc);

        JLabel scienceLabel = new JLabel("Science score:");
        scienceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        scienceLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(scienceLabel, gbc);

        scienceScoreField = new JTextField();
        gbc.gridx = 1;
        add(scienceScoreField, gbc);

        JButton predictButton = new JButton("Predict");
        predictButton.setBackground(Color.GREEN);
        predictButton.setForeground(Color.WHITE);
        predictButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                predict();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(predictButton, gbc);

        JButton testButton = new JButton("Test");
        testButton.setBackground(Color.GREEN);
        testButton.setForeground(Color.WHITE);
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testPerceptron();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 8;
        add(testButton, gbc);

        statusLabel = new JLabel();
        gbc.gridx = 1;
        gbc.gridy = 9;
        add(statusLabel, gbc);

        setVisible(true);
    }

    private void trainPerceptron() {
        try {
            double learningRate = Double.parseDouble(learningRateField.getText());
            int maxEpochs = Integer.parseInt(maxEpochsField.getText());
            double goal = Double.parseDouble(goalField.getText());

            double[][] inputs = {
                    {90.0, 70.0, 65.0},
                    {40.0, 30.0, 25.0},
                    {85.0, 60.0, 50.0},
                    {60.0, 40.0, 35.0}
            };
            double[] targets = {1.0, 0.0, 1.0, 0.0};

            perceptron = new Perceptron(learningRate, 3);
            int epoch = 0;
            double totalError = Double.POSITIVE_INFINITY;
            while (epoch < maxEpochs && totalError > goal) {
                totalError = 0;
                for (int i = 0; i < inputs.length; i++) {
                    double guess = perceptron.guess(inputs[i]);
                    double error = targets[i] - guess;
                    totalError += Math.abs(error);
                    perceptron.train(inputs[i], targets[i]);
                }
                epoch++;
                System.out.println("Epoch: " + epoch + ", Total Error: " + totalError);
            }

            statusLabel.setText("Training completed in " + epoch + " epochs with total error " + totalError);
            JOptionPane.showMessageDialog(this, "Training completed in " + epoch + " epochs with total error " + totalError);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void predict() {
        try {
            double mathScore = Double.parseDouble(mathScoreField.getText());
            double englishScore = Double.parseDouble(englishScoreField.getText());
            double scienceScore = Double.parseDouble(scienceScoreField.getText());
            double[] testInput = {mathScore, englishScore, scienceScore};

            if (perceptron == null) {
                JOptionPane.showMessageDialog(this, "The perceptron is not trained yet.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double guess = perceptron.guess(testInput);
            double averageScore = (mathScore + englishScore + scienceScore) / 3;
            String result = guess > 0.5 ? "Pass" : "Fail";
            JOptionPane.showMessageDialog(this, "Predicted result: " + result + "\nAverage score: " + averageScore);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void testPerceptron() {
        try {
            double mathScore = Double.parseDouble(mathScoreField.getText());
            double englishScore = Double.parseDouble(englishScoreField.getText());
            double scienceScore = Double.parseDouble(scienceScoreField.getText());
            double[] testInput = {mathScore, englishScore, scienceScore};

            if (perceptron == null) {
                JOptionPane.showMessageDialog(this, "The perceptron is not trained yet.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double guess = perceptron.guess(testInput);
            double averageScore = (mathScore + englishScore + scienceScore) / 3;
            String result = guess > 0.5 ? "Pass" : "Fail";
            statusLabel.setText("Predicted result: " + result + "\nAverage score: " + averageScore);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new g();
            }
        });
    }
}