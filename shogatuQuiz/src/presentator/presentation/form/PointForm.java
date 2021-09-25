package presentator.presentation.form;

public class PointForm {

    /** チーム名 */
    private String teamName;

    /** 得点 */
    private int point;

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
     * @return point
     */
    public int getPoint() {
	return point;
    }

    /**
     * @param point
     *            セットする point
     */
    public void setPoint(int point) {
	this.point = point;
    }

}
