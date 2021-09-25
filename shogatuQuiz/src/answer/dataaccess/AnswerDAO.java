package answer.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.dataaccess.entity.AnswerEntity;

/**
 * 解答用のDAOクラス
 *
 * @author yu
 *
 */
public class AnswerDAO {

    /** 大会識別番号を取得するSQL文 */
    private static final String SELECT_GAME_ID =
	    "SELECT game_id FROM id_sequence";

    /** 解答を登録するSQL文 */
    private static final String INSERT_ANSWER =
	    " INSERT INTO answer_table ( ID, QUIZ_NUMBER, TEAM_ID, ANSWER,"
		    + " QUESTION_ID ) VALUES ( ?, ?, ?, ?, ? )";

    /** 解答を登録するSQL文 */
    private static final String SELECT_QUIZ_NUMBER =
	    " SELECT QUIZ_NUMBER FROM quiz_number WHERE ID = ?";

    private static final String SELECT_ANSWER =
	    "SELECT ANSWER FROM answer_table WHERE ID=? AND QUIZ_NUMBER=? AND TEAM_ID=?";

    /**
     * 大会識別番号を取得するメソッド
     *
     * @param con
     * @return
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
     * 現在の問題数を取得するメソッド
     *
     * @param con
     * @return
     * @throws SQLException
     */
    public int selectquizNumber(Connection con, int gameId)
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
     * 解答を登録するメソッド
     *
     * @param answerEntity
     * @param con
     * @return
     * @throws SQLException
     */
    public int insertAnswer(AnswerEntity answerEntity, Connection con)
	    throws SQLException {
	int count = 0;

	try (PreparedStatement ps = con.prepareStatement(INSERT_ANSWER)) {
	    ps.setInt(1, answerEntity.getGameId());
	    ps.setInt(2, answerEntity.getQuizNumber());
	    ps.setInt(3, answerEntity.getTeamNumber());
	    ps.setString(4, answerEntity.getAnswer());
	    ps.setInt(5, answerEntity.getQuestionId());

	    count = ps.executeUpdate();
	}

	return count;

    }

    /**
     * その人の解答を取得するメソッド
     *
     * @param answerEntity
     * @param con
     * @return
     * @throws SQLException
     */
    public String selectAnswer(AnswerEntity answerEntity, Connection con)
	    throws SQLException {
	String answer = null;

	try (PreparedStatement ps = con.prepareStatement(SELECT_ANSWER);) {
	    ps.setInt(1, answerEntity.getGameId());
	    ps.setInt(2, answerEntity.getQuizNumber());
	    ps.setInt(3, answerEntity.getTeamNumber());

	    try (ResultSet rs = ps.executeQuery()) {
		if (rs.next()) {
		    answer = rs.getString("answer");
		}
	    }
	}

	return answer;
    }
}
