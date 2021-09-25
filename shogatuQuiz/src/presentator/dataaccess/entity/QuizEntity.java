package presentator.dataaccess.entity;

public class QuizEntity {

    /** 大会種別番号 */
    private int gameId;

    /** 問題番号 */
    private int questionId;

    /** ジャンルID */
    private int genreId;

    /** 得点ID */
    private int pointId;

    /** 問題数 */
    private int questionNumber;

    /** 残り問題数 */
    private int remainQuestionNumber;

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
     * @return genreId
     */
    public int getGenreId() {
	return genreId;
    }

    /**
     * @param genreId
     *            セットする genreId
     */
    public void setGenreId(int genreId) {
	this.genreId = genreId;
    }

    /**
     * @return pointId
     */
    public int getPointId() {
	return pointId;
    }

    /**
     * @param pointId
     *            セットする pointId
     */
    public void setPointId(int pointId) {
	this.pointId = pointId;
    }

    /**
     * @return questionNumber
     */
    public int getQuestionNumber() {
	return questionNumber;
    }

    /**
     * @param questionNumber
     *            セットする questionNumber
     */
    public void setQuestionNumber(int questionNumber) {
	this.questionNumber = questionNumber;
    }

    /**
     * @return remainQuestionNumber
     */
    public int getRemainQuestionNumber() {
	return remainQuestionNumber;
    }

    /**
     * @param remainQuestionNumber
     *            セットする remainQuestionNumber
     */
    public void setRemainQuestionNumber(int remainQuestionNumber) {
	this.remainQuestionNumber = remainQuestionNumber;
    }

    /*
     * (非 Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "quizEntity [gameId=" + gameId + ", questionId=" + questionId
		+ ", genreId=" + genreId + ", pointId=" + pointId
		+ ", questionNumber=" + questionNumber
		+ ", remainQuestionNumber=" + remainQuestionNumber + "]";
    }

}
