/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Gabriel Ceballos
//Liam Karim

package dondada.javaprogrammingproject;

/**
 *
 * @author gabri
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Quiz implements ActionListener{
    
        // identifies name as string 
        String namestr; 
        
	String[] questions = 	{
								"How do you close the Marauder's Map?",
								"How does Harry catch his first snitch?",
								"What is Hermione's patronus?",
								"How are students sorted in their house?"
							};
	String[][] options = 	{
								{"Mischief Managed","Hocus Pocus","Aberto","Expecto Patronum"},
								{"In his hands","In his mouth","With his feet","He never caught one"},
								{"Cat","Stag","Swift","Otter"},
								{"Dumbledore","They choose","Sorting Hat","Goblet of Fire"}
							};
	char[] answers = 		{
								'A',
								'B',
								'D',
								'C'
							};
        
        // global variables 
	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	int seconds = 10;
	
        // creates all necessary frames for display 
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
        JTextField name = new JTextField(); 

        // creates timer
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
        // namestr is a derivation from string name in main 
	public Quiz(String namestr) {
                
                // namestr is identified as the string and name will be used for the frame 
                this.namestr = namestr; 
                
                // create display frame and choose color 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(51,0,0));
		frame.setLayout(null);
		frame.setResizable(false);
		
                // top bar text field, Question Number Location
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(51,0,0));
		textfield.setForeground(new Color(255,204,51));
		textfield.setFont(new Font("Serif",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
                // middle bar text box, Question Location
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(51,0,0));
		textarea.setForeground(new Color(255,204,51));
		textarea.setFont(new Font("Serif",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
                // next 4 are for the answer selector buttons
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("Serif",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("Serif",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("Serif",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("Serif",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
                // next 4 are answer labels for each button/question
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(255,204,51));
		answer_labelA.setFont(new Font("Serif",Font.PLAIN,35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(255,204,51));
		answer_labelB.setFont(new Font("Serif",Font.PLAIN,35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(255,204,51));
		answer_labelC.setFont(new Font("Serif",Font.PLAIN,35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(255,204,51));
		answer_labelD.setFont(new Font("Serif",Font.PLAIN,35));
		
                // countdown timer 
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,204,51));
		seconds_left.setFont(new Font("Serif",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
                // create "Timer" label
		time_label.setBounds(535,475,100,25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,204,51));
		time_label.setFont(new Font("Serif",Font.BOLD,18));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("TIMER :D");
		
                // displays number of correct answers
		number_right.setBounds(225,275,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(255,204,51));
		number_right.setFont(new Font("Serif",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
                // displays calculated percentage of correct answers
		percentage.setBounds(225,375,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(255,204,51));
		percentage.setFont(new Font("Serif",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
                // display textbox to prompt user to repeat quiz 
                name.setBounds(175,175,300,100);
		name.setBackground(new Color(25,25,25));
		name.setForeground(new Color(255,204,51));
		name.setFont(new Font("Serif",Font.BOLD,50));
		name.setBorder(BorderFactory.createBevelBorder(1));
		name.setHorizontalAlignment(JTextField.CENTER);
		name.setEditable(false);
                
                // adds initial frames and displays
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
                // calls next question 
		nextQuestion();
	}
	public void nextQuestion() {
		
            // used to set questions in texts boxes 
		if(index >= total_questions) {
			results();
		}
		else {
                        // siphons through index to ask proceeding questions 
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
            // defines button functions, resets buttons to false
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource() == buttonA) {
				answer = 'A';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource() == buttonB) {
				answer = 'B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource() == buttonC) {
				answer = 'C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource() == buttonD) {
				answer = 'D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
                // sets wrong answers to red after selecting answer
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
                // allows for pause when answers are displayed as red in order to turn them back to original color 
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';   // resets answer
				seconds = 10;   // resets timer
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;    // goes to next question 
				nextQuestion();
			}
		}); 
		pause.setRepeats(false);    // only executes pause once 
		pause.start();  // starts timer
	}
	public void results(){
		
                // resets buttons 
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
                // calculate results
		result = (int)((correct_guesses/(double)total_questions)*100);
		
                // clears answer labels and text boxes
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
                // inserts results and name into text boxes 
                name.setText(namestr); 
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
                // shows frames 
                frame.add(name); 
		frame.add(number_right);
		frame.add(percentage);
                
                // creates a repeat option (recursion) to allow user to either end program or repeat quiz again
                String repeatQuiz = JOptionPane.showInputDialog("Do you want to repeat the quiz? (Y/N)");
                
                if (repeatQuiz.equalsIgnoreCase("y"))
                {
                    Quiz quiz = new Quiz(namestr); 
                }
                else
                {
                    System.exit(0); 
                }
	}
}
