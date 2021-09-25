package presentator.logic.bean;

public class AnswerPlayerBean {

    /** 現在の問題数 */
    private int nowQuestionNumber;

    /** 問題の選択者 */
    private String answerPlayer;

    /**
     * @return nowQuestionNumber
     */
    public int getNowQuestionNumber() {
	return nowQuestionNumber;
    }

    /**
     * @param nowQuestionNumber
     *            セットする nowQuestionNumber
     */
    public void setNowQuestionNumber(int nowQuestionNumber) {
	this.nowQuestionNumber = nowQuestionNumber;
    }

    /**
     * @return answerPlayer
     */
    public String getAnswerPlayer() {
	return answerPlayer;
    }

    /**
     * @param answerPlayer
     *            セットする answerPlayer
     */
    public void setAnswerPlayer(String answerPlayer) {
	this.answerPlayer = answerPlayer;
    }

    /*
     * (非 Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "AnswerPlayerBean [nowQuestionNumber=" + nowQuestionNumber
		+ ", answerPlayer=" + answerPlayer + "]";
    }

}
