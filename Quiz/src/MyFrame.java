import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements MouseListener{
    
	ArrayList<String> correctAnswers;
	int points=0;
	String correctAnswer="";
	int counter=1;
	int from=5;
	public JLabel question;
	public JLabel answer1;
	public JLabel answer2;
	public JLabel answer3;
	public JLabel answer4;
	
	MyFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		question=new JLabel();
		question.setBounds(5,5,475,250);
		question.setBackground(Color.LIGHT_GRAY);
		question.setOpaque(true);
		
		
		answer1=new JLabel();
		answer1.setBounds(5,350,200,50);
		answer1.setBackground(Color.LIGHT_GRAY);
		answer1.setFont(new Font("MV Boli",Font.PLAIN,15));
		answer1.setOpaque(true);
		answer1.addMouseListener(this);
		
		answer2=new JLabel();
		answer2.setBounds(280,350,200,50);
		answer2.setBackground(Color.LIGHT_GRAY);
		answer2.setFont(new Font("MV Boli",Font.PLAIN,15));
		answer2.setOpaque(true);
		answer2.addMouseListener(this);
		
		answer3=new JLabel();
		answer3.setBounds(5,405,200,50);
		answer3.setBackground(Color.LIGHT_GRAY);
		answer3.setFont(new Font("MV Boli",Font.PLAIN,15));
		answer3.setOpaque(true);
		answer3.addMouseListener(this);
		
		answer4=new JLabel();
		answer4.setBounds(280,405,200,50);
		answer4.setBackground(Color.LIGHT_GRAY);
		answer4.setFont(new Font("MV Boli",Font.PLAIN,15));
		answer4.setOpaque(true);
		answer4.addMouseListener(this);
		
		this.add(answer1);
		this.add(answer2);
		this.add(answer3);
		this.add(answer4);
		this.add(question);
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		
		correctAnswers=new ArrayList<String>();
		
		print(from);
	}
	public  void printCorrectAnswers() {
		question.setText("");
		String s="<html>Correct answers are: "+"<br>";
		for(int i=0;i<correctAnswers.size();i++) {
			s=s+correctAnswers.get(i)+"<br>";	
		}
		s+="You have " +points+" points.</html>";
		question.setText(s);
		question.setVisible(true);
		question.setOpaque(true);
		System.out.println(s);
		System.out.println("You have "+points+" points.");
	}
	public void print(int from) {
		try {
			File file=new File("Quiz.txt");
			Scanner scanner=new Scanner(file);
			
			for(int i=0;i<from;i++) {
				String data=scanner.nextLine();
				//System.out.println(data);
				if(i==from-5) {
				    question.setText(data);
				    question.setFont(new Font("MV Boli",Font.PLAIN,15));
				    question.setVerticalAlignment(JLabel.TOP);
				    if(data.endsWith("*")) {
						data=data.substring(0,data.length()-2);
						correctAnswers.add(data);
						}
				}
				if(i==from-4) {
					
					if(data.endsWith("*")) {
						data=data.substring(0,data.length()-2);
						correctAnswer=data;
						correctAnswers.add(data);
						}
					answer1.setText("A: "+data);
				}
				if(i==from-3) {
				
					if(data.endsWith("*")) {
						data=data.substring(0,data.length()-2);
						correctAnswer=data;
						correctAnswers.add(data);
						}
					answer2.setText("B: "+data);
					}
				if(i==from-2) {
					
					if(data.endsWith("*")) {
						data=data.substring(0,data.length()-2);
						correctAnswer=data;
						correctAnswers.add(data);
						}
					answer3.setText("C: "+data);
					}
				if(i==from-1) {
					
					if(data.endsWith("*")) {
						data=data.substring(0,data.length()-2);
						correctAnswer=data;
						correctAnswers.add(data);
						}
					answer4.setText("D: "+data);
					}
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==answer1) {
			String answer=answer1.getText().substring(3, answer1.getText().length());
			if(answer.equals(correctAnswer)) {
				points+=1;
			}
			counter+=1;
			if(counter<6) {
			print(counter*from);
			}
			else if(counter==6) {
				question.setVisible(false);
				answer1.setVisible(false);
				answer2.setVisible(false);
				answer3.setVisible(false);
				answer4.setVisible(false);
				printCorrectAnswers();
			}
		}
		if(e.getSource()==answer2) {
			String answer=answer2.getText().substring(3, answer2.getText().length());
			if(answer.equals(correctAnswer)) {
				points+=1;
			}
			counter+=1;
			if(counter<6) {
			print(counter*from);
			}
			else if(counter==6) {
				question.setVisible(false);
				answer1.setVisible(false);
				answer2.setVisible(false);
				answer3.setVisible(false);
				answer4.setVisible(false);
				printCorrectAnswers();
			}
		}
		if(e.getSource()==answer3) {
			String answer=answer3.getText().substring(3, answer3.getText().length());
			if(answer.equals(correctAnswer)) {
				points+=1;
			}
			counter+=1;
			if(counter<6) {
			print(counter*from);
			}
			else if(counter==6) {
				question.setVisible(false);
				answer1.setVisible(false);
				answer2.setVisible(false);
				answer3.setVisible(false);
				answer4.setVisible(false);
				printCorrectAnswers();
			}
		}
		if(e.getSource()==answer4) {
			String answer=answer4.getText().substring(3, answer4.getText().length());
			if(answer.equals(correctAnswer)) {
				points+=1;
			}
			counter+=1;
			if(counter<6) {
			print(counter*from);
			}
			else if(counter==6) {
				question.setVisible(false);
				answer1.setVisible(false);
				answer2.setVisible(false);
				answer3.setVisible(false);
				answer4.setVisible(false);
				printCorrectAnswers();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
