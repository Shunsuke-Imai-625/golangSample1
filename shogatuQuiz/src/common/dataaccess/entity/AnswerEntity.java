package common.dataaccess.entity;

public class AnswerEntity {

    /** 大会識別番号 */
    private int gameId;

    /** 問題番号 */
    private int quizNumber;

    /** チーム番号 */
    private int teamNumber;

    /** 問題識別番号 */
    private int questionId;

    /** 解答 */
    private String answer;

    /** 正解フラグ */
    private int correctFlag;

    /** 現在の合計得点 */
    private int nowPoint;

    /**
     * @return gameId
     */
    public int getGameId() {
	return gameId;
    }

    /**
     * @param gameId
     *            セットする gameId
     */
    public void setGameId(int gameId) {
	this.gameId = gameId;
    }

    /**
     * @return quizNumber
     */
    public int getQuizNumber() {
	return quizNumber;
    }

    /**
     * @param quizNumber
     *            セットする quizNumber
     */
    public void setQuizNumber(int quizNumber) {
	this.quizNumber = quizNumber;
    }

    /**
     * @return teamNumber
     */
    public int getTeamNumber() {
	return teamNumber;
    }

    /**
     * @param teamNumber
     *            セットする teamNumber
     */
    public void setTeamNumber(int teamNumber) {
	this.teamNumber = teamNumber;
    }

    /**
     * @return questionId
     */
    public int getQuestionId() {
	return questionId;
    }

    /**
     * @param questionId
     *            セットする questionId
     */
    public void setQuestionId(int questionId) {
	this.questionId = questionId;
    }

    /**
     * @return answer
     */
    public String getAnswer() {
	return answer;
    }

    /**
     * @param answer
     *            セットする answer
     */
    public void setAnswer(String answer) {
	this.answer = answer;
    }

    /**
     * @return correctFlag
     */
    public int getCorrectFlag() {
	return correctFlag;
    }

    /**
     * @param correctFlag
     *            セットする correctFlag
     */
    public void setCorrectFlag(int correctFlag) {
	this.correctFlag = correctFlag;
    }

    /**
     * @return nowPoint
     */
    public int getNowPoint() {
	return nowPoint;
    }

    /**
     * @param nowPoint
     *            セットする nowPoint
     */
    public void setNowPoint(int nowPoint) {
	this.nowPoint = nowPoint;
    }

    /*
     * (非 Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "AnswerEntity [gameId=" + gameId + ", quizNumber=" + quizNumber
		+ ", teamNumber=" + teamNumber + ", questionId=" + questionId
		+ ", answer=" + answer + ", correctFlag=" + correctFlag
		+ ", nowPoint=" + nowPoint + "]";
    }

}
