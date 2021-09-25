package answer.logic.logic;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import answer.dataaccess.AnswerDAO;
import answer.logic.Util.ConnectionUtil;
import answer.logic.bean.AnswerBean;
import common.dataaccess.entity.AnswerEntity;

public class AnswerLogic {

    /**
     * その人がすでに解答済みかどうかを調べるメソッド
     *
     * @param teamNumber
     * @return 解答済みならtrue
     * @throws SQLException
     */
    public boolean isAnswered(String teamNumber) throws SQLException {
	AnswerEntity answerEntity = new AnswerEntity();
	answerEntity.setTeamNumber(Integer.parseInt(teamNumber));

	try (Connection con = ConnectionUtil.getConnection()) {

	    // 大会識別番号を取得
	    AnswerDAO answerDAO = new AnswerDAO();
	    int selectGameId = answerDAO.selectGameId(con);
	    answerEntity.setGameId(selectGameId);

	    // 現在の問題数を取得
	    int selectquizNumber =
		    answerDAO.selectquizNumber(con, selectGameId);
	    answerEntity.setQuizNumber(selectquizNumber);

	    // 解答を取得
	    String selectAnswer = answerDAO.selectAnswer(answerEntity, con);

	    if (StringUtils.isEmpty(selectAnswer)) {
		return false;
	    }

	}
	return true;

    }

    /**
     * 解答を送信するメソッド
     *
     * @param answerBean
     * @throws SQLException
     */
    public void sendAnswer(AnswerBean answerBean) throws SQLException {
	// beanをentityに詰め替え
	String answer = answerBean.getAnswer();
	String questionNumber = answerBean.getQuestionNumber();
	String teamNumber = answerBean.getTeamNumber();

	AnswerEntity answerEntity = new AnswerEntity();
	answerEntity.setAnswer(answer);
	answerEntity.setQuestionId(Integer.parseInt(questionNumber));
	answerEntity.setTeamNumber(Integer.parseInt(teamNumber));

	try (Connection con = ConnectionUtil.getConnection()) {

	    // 大会識別番号を取得
	    AnswerDAO answerDAO = new AnswerDAO();
	    int selectGameId = answerDAO.selectGameId(con);
	    answerEntity.setGameId(selectGameId);

	    // 現在の問題数を取得
	    int selectquizNumber =
		    answerDAO.selectquizNumber(con, selectGameId);
	    answerEntity.setQuizNumber(selectquizNumber);

	    // 解答テーブルに解答を登録
	    answerDAO.insertAnswer(answerEntity, con);

	}

    }
}
