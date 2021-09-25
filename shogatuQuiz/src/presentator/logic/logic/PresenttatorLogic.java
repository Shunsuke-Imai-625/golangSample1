package presentator.logic.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import answer.logic.Util.ConnectionUtil;
import presentator.dataaccess.DAO.PresentatorDAO;
import presentator.dataaccess.dataaccessUtil.DAUtil;
import presentator.dataaccess.entity.GenreEntity;
import presentator.dataaccess.entity.QuizEntity;
import presentator.logic.bean.AnswerPlayerBean;
import presentator.presentation.form.AnswerForm;
import presentator.presentation.form.PointForm;

public class PresenttatorLogic {

    /**
     * 問題数からその問題の各チームごとの解答と正解フラグを取得するメソッド
     *
     * @param quizNumber
     *            問題番号
     * @return 解答情報
     * @throws SQLException
     */
    public List<AnswerForm> getNewestAnswer(int questionId)
	    throws SQLException {

	List<AnswerForm> answerList = new ArrayList<>();
	try (Connection con = ConnectionUtil.getConnection()) {

	    PresentatorDAO presentatorDAO = new PresentatorDAO();
	    // 大会種別番号を取得
	    int selectGameId = presentatorDAO.selectGameId(con);

	    // 現在の問題数を取得
	    // int quizNumber = presentatorDAO.selectQuizNumber(con,
	    // selectGameId);

	    // その問題数から解答情報を取得
	    answerList =
		    presentatorDAO.selectAnswer(questionId, selectGameId, con);

	}

	return answerList;

    }

    /**
     * 新しいゲームを始めるための準備を行うメソッド
     *
     * @throws SQLException
     */
    public AnswerPlayerBean startGame() throws SQLException {

	try (Connection con = ConnectionUtil.getConnection()) {
	    con.setAutoCommit(false);

	    PresentatorDAO presentatorDAO = new PresentatorDAO();
	    // idを取得
	    int selectGameId = presentatorDAO.selectGameId(con);

	    // idに1を足す
	    int newGameId = selectGameId + 1;

	    // idをシークエンスに格納する
	    presentatorDAO.updateGameId(con, newGameId);

	    // now_pointテーブルにインサート
	    for (int teamNumber = 1; teamNumber <= 5; teamNumber++) {
		presentatorDAO.insertNowPoint(con, newGameId, teamNumber, 0);

	    }

	    // quiz_numberにインサート
	    presentatorDAO.insertQuizNumber(con, newGameId);

	    // quiz_tableにインサート
	    DAUtil daUtil = new DAUtil();
	    List<String> createSQLForQuizTable = daUtil.createSQLForQuizTable();
	    for (int i = 1; i <= createSQLForQuizTable.size(); i++) {
		String sql = createSQLForQuizTable.get(i - 1);
		presentatorDAO.insertQuizTable(con, sql, newGameId, i);
	    }

	    con.commit();

	}
	// 現在の問題数を解答者を取得する
	AnswerPlayerBean answerPlayerBean = getQNumberAndAnswerPlayer();

	return answerPlayerBean;
    }

    /**
     * 現在の問題数を解答者を取得するメソッド
     *
     * @return
     * @throws SQLException
     */
    public AnswerPlayerBean getQNumberAndAnswerPlayer() throws SQLException {

	AnswerPlayerBean answerPlayerBean = new AnswerPlayerBean();
	try (Connection con = ConnectionUtil.getConnection()) {
	    PresentatorDAO presentatorDAO = new PresentatorDAO();
	    // 大会種別番号を取得
	    int selectGameId = presentatorDAO.selectGameId(con);

	    // 問題数を取得
	    int selectQuizNumber =
		    presentatorDAO.selectQuizNumber(con, selectGameId);

	    // 問題数から問題選択者を算出
	    int r = (selectQuizNumber + 1) % 5;
	    if (r == 0) {
		r = 5;
	    }

	    // 問題選択者を取得
	    String answerPlayer = presentatorDAO.selectTeamName(con, r);

	    // beanにセット
	    answerPlayerBean.setNowQuestionNumber(selectQuizNumber);
	    answerPlayerBean.setAnswerPlayer(answerPlayer);

	}

	return answerPlayerBean;
    }

    /**
     * ジャンルの一覧を取得するメソッド
     *
     * @return
     * @throws SQLException
     */
    public List<GenreEntity> getGenreList() throws SQLException {
	List<GenreEntity> genreList = new ArrayList<>();

	try (Connection con = ConnectionUtil.getConnection()) {
	    PresentatorDAO presentatorDAO = new PresentatorDAO();
	    genreList = presentatorDAO.selectGenre(con);

	}
	return genreList;

    }

    /**
     * 問題の詳細を取得するメソッド
     *
     * @param genreId
     * @param pointId
     * @return
     * @throws SQLException
     */
    public QuizEntity getQuestionDetail(String genreId, String pointId)
	    throws SQLException {
	QuizEntity quizEntity = null;

	try (Connection con = ConnectionUtil.getConnection()) {

	    PresentatorDAO presentatorDAO = new PresentatorDAO();
	    // 大会種別番号を取得
	    int selectGameId = presentatorDAO.selectGameId(con);
	    int quizNumber = presentatorDAO.selectQuizNumber(con, selectGameId);

	    // 問題数をプラス１する
	    presentatorDAO.updateQuizNumber(con, selectGameId, quizNumber + 1);

	    quizEntity =
		    presentatorDAO.selectQuiz(con, Integer.parseInt(genreId),
			    Integer.parseInt(pointId), selectGameId);

	}
	return quizEntity;

    }

    /**
     * クイズの正解処理を行うメソッド
     *
     * @param correctTeamIds
     * @param questionId
     * @throws SQLException
     */
    public void dealCorrectTeam(String[] correctTeamIds, String questionId)
	    throws SQLException {

	try (Connection con = ConnectionUtil.getConnection()) {

	    con.setAutoCommit(false);
	    try {

		// 問題数を取得
		PresentatorDAO presentatorDAO = new PresentatorDAO();
		int gameId = presentatorDAO.selectGameId(con);
		int quizNumber = presentatorDAO.selectQuizNumber(con, gameId);

		// 問題IDから点数を取得
		int point = presentatorDAO.selectPoint(con, questionId, gameId);

		// 正解者でループ
		for (String teamId : correctTeamIds) {

		    // 現在の点数を取得
		    int nowPoint =
			    presentatorDAO.selectNowPoint(con, gameId, teamId);

		    // 点数にプラス
		    int newPoint = nowPoint + point;

		    // 点数テーブルに追加
		    presentatorDAO.updateNowPoint(con, newPoint, gameId,
			    teamId);

		    // 正解フラグを立てる
		    presentatorDAO.updateAnswerTable(con, newPoint, gameId,
			    quizNumber, teamId);

		}

		// クイズmanageテーブルに追加
		presentatorDAO.updateQuizManage(con, correctTeamIds, gameId,
			quizNumber);

		con.commit();

	    } finally {
		con.rollback();
	    }
	}
    }

    /**
     * 最新の得点のリストを取得するメソッド
     *
     * @return 最新の得点のリスト
     * @throws SQLException
     */
    public List<PointForm> getNewestPoint() throws SQLException {
	List<PointForm> pointForms = new ArrayList<>();
	try (Connection con = ConnectionUtil.getConnection()) {

	    PresentatorDAO presentatorDAO = new PresentatorDAO();
	    // 大会種別番号を取得
	    int selectGameId = presentatorDAO.selectGameId(con);

	    // 得点のリストを取得
	    pointForms = presentatorDAO.selectNewestPoint(con, selectGameId);

	}
	return pointForms;

    }

    /**
     * 現在の問題数を１足すメソッド
     *
     * @throws SQLException
     */
    public void plusQuizNumber() throws SQLException {
	try (Connection con = ConnectionUtil.getConnection()) {

	    PresentatorDAO presentatorDAO = new PresentatorDAO();
	    // 大会種別番号を取得
	    int selectGameId = presentatorDAO.selectGameId(con);
	    int quizNumber = presentatorDAO.selectQuizNumber(con, selectGameId);

	    // 問題数をプラス１する
	    presentatorDAO.updateQuizNumber(con, selectGameId, quizNumber + 1);
	}
    }

    /**
     * 逆転の勝者を扱うメソッド
     *
     * @param point
     * @param winer
     * @param loser
     * @throws SQLException
     */
    public void dealGyakutenQuiz(String point, String winer, String loser)
	    throws SQLException {

	try (Connection con = ConnectionUtil.getConnection()) {

	    con.setAutoCommit(false);
	    try {

		// 問題数を取得
		PresentatorDAO presentatorDAO = new PresentatorDAO();
		int gameId = presentatorDAO.selectGameId(con);
		int quizNumber = presentatorDAO.selectQuizNumber(con, gameId);

		// 問題IDを取得
		QuizEntity quizId =
			presentatorDAO.selectQuiz(con, 11, 4, gameId);

		// 勝者を扱う
		// 現在の点数を取得
		int nowWinerPoint =
			presentatorDAO.selectNowPoint(con, gameId, winer);

		// 点数をタス
		int newWinerPoint = nowWinerPoint + Integer.parseInt(point);

		// 点数テーブルに追加
		presentatorDAO.updateNowPoint(con, newWinerPoint, gameId,
			winer);

		// 敗者を扱う
		// 現在の点数を取得
		int nowLoserPoint =
			presentatorDAO.selectNowPoint(con, gameId, winer);

		// 点数をひく
		int newLoserPoint = nowLoserPoint - Integer.parseInt(point);

		// 点数テーブルに追加
		presentatorDAO.updateNowPoint(con, newLoserPoint, gameId,
			loser);

		// クイズマネージ
		presentatorDAO.insertQuizManage(con, Integer.toString(gameId),
			Integer.toString(quizNumber),
			Integer.toString(quizId.getQuestionId()), winer, loser);

		con.commit();

	    } finally {
		con.rollback();
	    }
	}

    }
}
