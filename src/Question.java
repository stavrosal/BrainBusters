import java.util.ArrayList;

public class Question {
	private String question;
	private ArrayList<String> answers;
	private String correct_answer;
	
	public Question(String question, ArrayList<String> answers, String correct_answer) {
		this.question = question;
		this.answers = answers;
		this.correct_answer = correct_answer;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public ArrayList<String> getAnswers(){
		return answers;
	}
	
	public String getCorrectAnswer() {
		return correct_answer;
	}
	
	public void printQuestions() {
		System.out.println(question);
		for (String answer : answers)
			System.out.println("    " + answer + "\n");
		System.out.println("\n" + "CORRECT: " + correct_answer);
	}
	
	
}
