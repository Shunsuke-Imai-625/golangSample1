package presentator.dataaccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import presentator.dataaccess.entity.GenreEntity;
import presentator.dataaccess.entity.QuizEntity;
import presentator.presentation.form.AnswerForm;
import presentator.presentation.form.PointForm;

public class PresentatorDAO {

    /**
     * 問題数からその問題の解答のリストを返却するSQL文
     */
    private static final String SELECT_ANSWER_BY_QUIZ_NUMBER =
	    " SELECT t.TEAM_NAME,a.ANSWER,a.CORRECT_FLAG FROM answer_table a"
		    + " LEFT OUTER JOIN team_table t ON a.team_id = t.team_id"
		    + " WHERE a.QUESTION_ID= ? AND a.ID=? ORDER BY a.TEAM_ID";

    /** 現在の問題数を取得するSQL文 */
    private static final String SELECT_QUIZ_NUMBER =
	    "SELECT QUIZ_NUMBER FROM quiz_number WHERE id=?";

    /** 今の大会識別番号を取得するSQL文 */
    private static final String SELECT_GAME_ID =
	    "SELECT game_id FROM id_sequence";

    /** 大会種別番号を更新するSQL文 */
    private static final String UPDATE_GAME_ID =
	    "UPDATE id_sequence SET game_id = ?";

    /** 現在の得点を追加するメソッド */
    private static final String INSERT_NOW_POINT =
	    "INSERT INTO now_point VALUES ( ?,?,?)";

    /** 問題数テーブルの準備をするSQL文 */
    private static final String INSERT_QUIZ_NUMBER =
	    "INSERT INTO quiz_number VALUES ( ?,0 )";

    /** teamIdからteamNameを取得するSQL文 */
    private static final String SELECT_TEAM_NAME =
	    "SELECT TEAM_NAME FROM team_table WHERE TEAM_ID =?";

    /** ジャンルの一覧を取得するSQL文 */
    private static final String SELECT_GENRE =
	    "SELECT GENRE_ID ,GENRE_NAME FROM genre_table";

    private static final String SELECT_QUIZ =
	    "SELECT ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		    + "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER FROM quiz_table"
		    + " WHERE GENRE_ID=? AND POINT_ID=? AND ID=?";

    private static final String SELECT_POINT =
	    "SELECT POINT FROM quiz_table q left outer join point_table p "
		    + "on q.point_id = p.point_id WHERE q.QUESTION_ID = ? AND q.ID=?";

    private static final String UPDATE_CORRECT_FLAG =
	    "UPDATE answer_table SET NOW_POINT = ?,CORRECT_FLAG = 0 WHERE ID = ? AND QUIZ_NUMBER =? AND TEAM_ID = ?";

    private static final String SELECT_NOW_POINT =
	    "SELECT now_point FROM now_point WHERE id=? AND team_number = ?";

    private static final String UPDATE_NOW_POINT =
	    "UPDATE now_point SET now_point = ? WHERE id = ? AND team_number =?";

    private static final String UPDATE_QUIZ_MANAGE = "UPDATE quiz_manage SET";

    private static final String UPDATE_QUIZ_NUMBER =
	    "UPDATE quiz_number SET QUIZ_NUMBER = ? WHERE ID =?";

    private static final String SELECT_NEWEST_POINT =
	    "SELECT n.now_point ,t.TEAM_NAME FROM now_point n "
		    + "LEFT OUTER JOIN team_table t ON n.team_number = t.team_id "
		    + "WHERE id = ?";

    /** 逆転クイズの結果をクイズマネージにインサート */
    private static final String INSERT_GYAKUTEN_RESULT =
	    "INSERT INTO quiz_manage ( ID, QUIZ_NUMBER, CORRECT_TEAM_ID_1,"
		    + "LOSER_ID, QUESTION_ID) VALUES ( ?,?,?,?,?)";

    /**
     * 問題数からその問題の解答のリストを返却するメソッド
     *
     * @param questionId
     *            問題番号
     * @param con
     * @return 解答情報のリスト
     * @throws SQLException
     */
    public List<AnswerForm> selectAnswer(int questionId, int gameId,
	    Connection con) throws SQLException {

	List<AnswerForm> answerList = new ArrayList<>();

	try (PreparedStatement ps =
		con.prepareStatement(SELECT_ANSWER_BY_QUIZ_NUMBER)) {

	    ps.setInt(1, questionId);
	    ps.setInt(2, gameId);
	    try (ResultSet rs = ps.executeQuery()) {
		while (rs.next()) {
		    AnswerForm answerForm = new AnswerForm();
		    answerForm.setTeamName(rs.getString("TEAM_NAME"));
		    answerForm.setAnswer(rs.getString("ANSWER"));
		    answerForm.setCorrectFlag(rs.getString("CORRECT_FLAG"));

		    answerList.add(answerForm);
		}

	    }

	}

	return answerList;

    }

    /**
     * 現在の問題数を取得するメソッド
     *
     * @param con
     *            コネクション
     * @return 現在の問題数
     * @throws SQLException
     */
    public int selectQuizNumber(Connection con, int gameId)
	    throws SQLException {
	int quizNumber = 0;
	try (PreparedStatement ps = con.prepareStatement(SELECT_QUIZ_NUMBER);) {

	    ps.setInt(1, gameId);
	    try (ResultSet rs = ps.executeQuery()) {

		if (rs.next()) {
		    quizNumber = rs.getInt("QUIZ_NUMBER");

		}
	    }
	}

	return quizNumber;

    }

    /**
     * 現在の大会種別番号を取得するメソッド
     *
     * @param con
     *            コネクション
     * @return 現在の大会種別番号
     * @throws SQLException
     */
    public int selectGameId(Connection con) throws SQLException {
	int gameId = 0;

	try (PreparedStatement ps = con.prepareStatement(SELECT_GAME_ID);
		ResultSet rs = ps.executeQuery()) {
	    if (rs.next()) {
		gameId = rs.getInt("game_id");
	    }
	}

	return gameId;
    }

    /**
     * 大会種別番号を更新するメソッド
     *
     * @param con
     *            コネクション
     * @param gameId
     *            大会種別番号
     * @return 更新件数
     * @throws SQLException
     */
    public int updateGameId(Connection con, int gameId) throws SQLException {
	int count = 0;

	try (PreparedStatement ps = con.prepareStatement(UPDATE_GAME_ID);) {
	    ps.setInt(1, gameId);

	    count = ps.executeUpdate();

	}
	return count;
    }

    /**
     * 得点テーブルの準備をするメソッド
     *
     * @param con
     *            コネクション
     * @param gameId
     *            大会種別番号
     * @param teamNumber
     *            チーム番号
     * @param nowPoint
     *            得点
     * @return 更新件数
     * @throws SQLException
     */
    public int insertNowPoint(Connection con, int gameId, int teamNumber,
	    int nowPoint) throws SQLException {
	int count = 0;

	try (PreparedStatement ps = con.prepareStatement(INSERT_NOW_POINT);) {
	    ps.setInt(1, gameId);
	    ps.setInt(2, teamNumber);
	    ps.setInt(3, nowPoint);

	    count = ps.executeUpdate();

	}
	return count;
    }

    /**
     * 問題数テーブルの準備をするメソッド
     *
     * @param con
     *            コネクション
     * @param gameId
     *            大会種別番号
     * @return 更新件数
     * @throws SQLException
     */
    public int insertQuizNumber(Connection con, int gameId)
	    throws SQLException {
	int count = 0;

	try (PreparedStatement ps = con.prepareStatement(INSERT_QUIZ_NUMBER);) {
	    ps.setInt(1, gameId);

	    count = ps.executeUpdate();

	}
	return count;

    }

    /**
     * クイズテーブルに問題数などをインサートするメソッド
     *
     * @param con
     * @param sql
     * @param gameId
     * @param questionId
     * @throws SQLException
     */
    public void insertQuizTable(Connection con, String sql, int gameId,
	    int questionId) throws SQLException {
	try (PreparedStatement ps = con.prepareStatement(sql);) {
	    ps.setInt(1, gameId);
	    ps.setInt(2, questionId);

	    ps.executeUpdate();
	}

    }

    /**
     * teamIdからteamnameを取得するメソッド
     *
     * @param con
     * @param teamId
     * @return
     * @throws SQLException
     */
    public String selectTeamName(Connection con, int teamId)
	    throws SQLException {
	String teamName = null;
	try (PreparedStatement ps = con.prepareStatement(SELECT_TEAM_NAME);) {

	    ps.setInt(1, teamId);

	    try (ResultSet rs = ps.executeQuery()) {
		while (rs.next()) {

		    teamName = rs.getString("team_name");
		}

	    }
	}

	return teamName;

    }

    /**
     * ジャンルとジャンルIDのセットを取得するメソッド
     *
     * @param con
     * @return
     * @throws SQLException
     */
    public List<GenreEntity> selectGenre(Connection con) throws SQLException {

	List<GenreEntity> genreList = new ArrayList<>();
	try (PreparedStatement ps = con.prepareStatement(SELECT_GENRE);
		ResultSet rs = ps.executeQuery()) {

	    while (rs.next()) {
		GenreEntity genreEntity = new GenreEntity();
		genreEntity.setGenreId(rs.getInt("GENRE_ID"));
		genreEntity.setGenreName(rs.getString("GENRE_NAME"));
		genreList.add(genreEntity);
	    }

	}
	return genreList;

    }

    /**
     * 大会識別番号、ジャンルID、得点IDからその問題の詳細を取得するメソッド
     *
     * @param con
     * @param genreId
     * @param pointId
     * @param gameId
     * @return
     * @throws SQLException
     */
    public QuizEntity selectQuiz(Connection con, int genreId, int pointId,
	    int gameId) throws SQLException {

	QuizEntity quizEntity = null;
	try (PreparedStatement ps = con.prepareStatement(SELECT_QUIZ);) {
	    ps.setInt(1, genreId);
	    ps.setInt(2, pointId);
	    ps.setInt(3, gameId);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    quizEntity = new QuizEntity();
		    quizEntity.setGameId(gameId);
		    quizEntity.setQuestionId(rs.getInt("QUESTION_ID"));
		    quizEntity.setGenreId(genreId);
		    quizEntity.setPointId(pointId);
		    quizEntity.setQuestionNumber(rs.getInt("QUESTION_NUMBER"));
		    quizEntity.setRemainQuestionNumber(
			    rs.getInt("REMAIN_QUESTION_NUMBER"));

		}
	    }

	}
	return quizEntity;

    }

    /**
     * gameIdとquizIdからその問題の点数を取得するメソッド
     *
     * @param con
     * @param quizId
     * @param gameId
     * @return 得点
     * @throws SQLException
     */
    public int selectPoint(Connection con, String quizId, int gameId)
	    throws SQLException {
	int point = 0;

	try (PreparedStatement ps = con.prepareStatement(SELECT_POINT);) {
	    ps.setString(1, quizId);
	    ps.setInt(2, gameId);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    point = rs.getInt("POINT");

		}
	    }
	}
	return point;

    }

    /**
     * 大会識別番号、問題番号、チーム番号から正解フラグを立て、現在のポイントを追加するメソッド
     *
     * @param con
     * @param gameId
     * @param quizNumber
     * @param teamId
     * @throws SQLException
     */
    public void updateAnswerTable(Connection con, int newPoint, int gameId,
	    int quizNumber, String teamId) throws SQLException {

	try (PreparedStatement ps =
		con.prepareStatement(UPDATE_CORRECT_FLAG);) {
	    ps.setInt(1, newPoint);
	    ps.setInt(2, gameId);
	    ps.setInt(3, quizNumber);
	    ps.setString(4, teamId);

	    ps.executeUpdate();

	}

    }

    /**
     * 現在の得点を取得するメソッド
     *
     * @param con
     * @param gameId
     * @param teamId
     * @return 現在の得点
     * @throws SQLException
     */
    public int selectNowPoint(Connection con, int gameId, String teamId)
	    throws SQLException {
	int nowPoint = 0;
	try (PreparedStatement ps = con.prepareStatement(SELECT_NOW_POINT);) {
	    ps.setInt(1, gameId);
	    ps.setString(2, teamId);

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    nowPoint = rs.getInt("NOW_POINT");
		}
	    }
	}
	return nowPoint;
    }

    /**
     * 現在の得点を更新するメソッド
     *
     * @param con
     * @param newPoint
     * @param gameId
     * @param teamId
     * @throws SQLException
     */
    public void updateNowPoint(Connection con, int newPoint, int gameId,
	    String teamId) throws SQLException {

	try (PreparedStatement ps = con.prepareStatement(UPDATE_NOW_POINT);) {

	    ps.setInt(1, newPoint);
	    ps.setInt(2, gameId);
	    ps.setString(3, teamId);

	    ps.executeUpdate();

	}
    }

    /**
     * quizManageに正解チームを追加するメソッド
     *
     * @param con
     * @param correctTeamIds
     * @throws SQLException
     */
    public void updateQuizManage(Connection con, String[] correctTeamIds,
	    int gameId, int quizNumber) throws SQLException {

	// sqlを作成
	String sql = UPDATE_QUIZ_MANAGE;
	for (int i = 1; i <= correctTeamIds.length; i++) {
	    if (i != 1) {

		sql = sql + " , ";
	    }

	    sql = sql + " CORRECT_TEAM_ID_" + Integer.toString(i) + "=?";
	}

	sql = sql + " WHERE ID=? AND QUIZ_NUMBER = ?";

	try (PreparedStatement ps = con.prepareStatement(sql);) {

	    for (int i = 1; i <= correctTeamIds.length; i++) {
		ps.setString(i, correctTeamIds[i - 1]);
	    }
	    ps.setInt((correctTeamIds.length + 1), gameId);
	    ps.setInt((correctTeamIds.length + 2), quizNumber);

	    ps.executeUpdate();

	}

    }

    /**
     * 現在の問題数を更新するメソッド
     *
     * @param con
     * @param gameId
     * @param quizNumber
     * @throws SQLException
     */
    public void updateQuizNumber(Connection con, int gameId, int quizNumber)
	    throws SQLException {
	try (PreparedStatement ps = con.prepareStatement(UPDATE_QUIZ_NUMBER);) {

	    ps.setInt(1, quizNumber);
	    ps.setInt(2, gameId);

	    ps.executeUpdate();

	}
    }

    /**
     * 最新の得点のリストを取得するメソッド
     *
     * @param con
     * @param gameId
     * @return 最新の得点のリスト
     * @throws SQLException
     */
    public List<PointForm> selectNewestPoint(Connection con, int gameId)
	    throws SQLException {

	List<PointForm> pointList = new ArrayList<>();

	try (PreparedStatement ps = con.prepareStatement(SELECT_NEWEST_POINT)) {

	    ps.setInt(1, gameId);
	    try (ResultSet rs = ps.executeQuery()) {
		while (rs.next()) {
		    PointForm pointForm = new PointForm();
		    pointForm.setTeamName(rs.getString("TEAM_NAME"));
		    pointForm.setPoint(rs.getInt("NOW_POINT"));

		    pointList.add(pointForm);
		}

	    }

	}

	return pointList;

    }

    /**
     * 逆転クイズの結果をクイズマネージにインサートするメソッド
     *
     * @param con
     * @param gameId
     * @param quizNumber
     * @param QuizId
     * @param winer
     * @param loser
     * @throws SQLException
     */
    public void insertQuizManage(Connection con, String gameId,
	    String quizNumber, String QuizId, String winer, String loser)
	    throws SQLException {

	try (PreparedStatement ps =
		con.prepareStatement(INSERT_GYAKUTEN_RESULT);) {

	    ps.setString(1, gameId);
	    ps.setString(2, quizNumber);
	    ps.setString(3, winer);
	    ps.setString(4, loser);
	    ps.setString(5, gameId);

	    ps.executeUpdate();

	}

    }

}
