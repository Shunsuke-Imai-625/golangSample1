package answer.logic.bean;

/**
 * 解答を格納するbean
 *
 * @author yu
 *
 */
public class AnswerBean {

    /** 解答チーム番号 */
    private String teamNumber;

    /** 解答 */
    private String answer;

    /** 問題番号 */
    private String questionNumber;

    public String getTeamNumber() {
	return teamNumber;
    }

    public void setTeamNumber(String teamNumber) {
	this.teamNumber = teamNumber;
    }

    public String getAnswer() {
	return answer;
    }

    public void setAnswer(String answer) {
	this.answer = answer;
    }

    public String getQuestionNumber() {
	return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
	this.questionNumber = questionNumber;
    }

    @Override
    public String toString() {
	return "AnswerBean [teamNumber=" + teamNumber + ", answer=" + answer
		+ ", questionNumber=" + questionNumber + "]";
    }

}
