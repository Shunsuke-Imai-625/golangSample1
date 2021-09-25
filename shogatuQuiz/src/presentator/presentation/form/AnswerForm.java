package presentator.presentation.form;

public class AnswerForm {

    /** 解答チーム名 */
    private String teamName;

    /** 解答 */
    private String answer;

    /** 正解フラグ */
    private String correctFlag;

    /**
     * @return correctFlag
     */
    public String getCorrectFlag() {
	return correctFlag;
    }

    /**
     * @param correctFlag
     *            セットする correctFlag
     */
    public void setCorrectFlag(String correctFlag) {
	this.correctFlag = correctFlag;
    }

    /**
     * @return teamName
     */
    public String getTeamName() {
	return teamName;
    }

    /**
     * @param teamName
     *            セットする teamName
     */
    public void setTeamName(String teamName) {
	this.teamName = teamName;
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

    /*
     * (非 Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "AnswerForm [teamName=" + teamName + ", answer=" + answer
		+ ", correctFlag=" + correctFlag + "]";
    }

}
