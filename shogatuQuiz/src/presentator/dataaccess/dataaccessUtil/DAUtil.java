package presentator.dataaccess.dataaccessUtil;

import java.util.ArrayList;
import java.util.List;

import presentator.presentation.constant.QuizDetailConstants;

public class DAUtil {

    /**
     * quiz_tableにインサートするためのsql文を作成するメソッド
     *
     * @return
     */
    public List<String> createSQLForQuizTable() {

	List<String> sqlList = new ArrayList<>();

	// 国語10
	String sql =
		"INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
			+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
			+ " VALUES (?,?,1,1,"
			+ QuizDetailConstants.KOKUGO_NUMBER_10 + ", "
			+ QuizDetailConstants.KOKUGO_NUMBER_10 + ")";
	sqlList.add(sql);

	// 国語20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,1,2," + QuizDetailConstants.KOKUGO_NUMBER_20
		+ ", " + QuizDetailConstants.KOKUGO_NUMBER_20 + ")";
	sqlList.add(sql);

	// 数学10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,2,1," + QuizDetailConstants.SUGAKU_NUMBER_10
		+ ", " + QuizDetailConstants.SUGAKU_NUMBER_10 + ")";
	sqlList.add(sql);

	// 数学20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,2,2," + QuizDetailConstants.SUGAKU_NUMBER_20
		+ ", " + QuizDetailConstants.SUGAKU_NUMBER_20 + ")";
	sqlList.add(sql);

	// 理科10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,3,1," + QuizDetailConstants.RIKA_NUMBER_10
		+ ", " + QuizDetailConstants.RIKA_NUMBER_10 + ")";
	sqlList.add(sql);

	// 理科20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,3,2," + QuizDetailConstants.RIKA_NUMBER_20
		+ ", " + QuizDetailConstants.RIKA_NUMBER_20 + ")";
	sqlList.add(sql);

	// 社会10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,4,1," + QuizDetailConstants.SHAKAI_NUMBER_10
		+ ", " + QuizDetailConstants.SHAKAI_NUMBER_10 + ")";
	sqlList.add(sql);

	// 社会20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,4,2," + QuizDetailConstants.SHAKAI_NUMBER_20
		+ ", " + QuizDetailConstants.SHAKAI_NUMBER_20 + ")";
	sqlList.add(sql);

	// 英語10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,5,1," + QuizDetailConstants.EIGO_NUMBER_10
		+ ", " + QuizDetailConstants.EIGO_NUMBER_10 + ")";
	sqlList.add(sql);

	// 英語20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,5,2," + QuizDetailConstants.EIGO_NUMBER_20
		+ ", " + QuizDetailConstants.EIGO_NUMBER_20 + ")";
	sqlList.add(sql);

	// 芸能10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,6,1," + QuizDetailConstants.GEINO_NUMBER_10
		+ ", " + QuizDetailConstants.GEINO_NUMBER_10 + ")";
	sqlList.add(sql);

	// 芸能20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,6,2," + QuizDetailConstants.GEINO_NUMBER_20
		+ ", " + QuizDetailConstants.GEINO_NUMBER_20 + ")";
	sqlList.add(sql);

	// 映画10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,7,1," + QuizDetailConstants.EIGA_NUMBER_10
		+ ", " + QuizDetailConstants.EIGA_NUMBER_10 + ")";
	sqlList.add(sql);

	// 映画20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,7,2," + QuizDetailConstants.EIGA_NUMBER_20
		+ ", " + QuizDetailConstants.EIGA_NUMBER_20 + ")";
	sqlList.add(sql);

	// 漫画10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,8,1," + QuizDetailConstants.ANIME_NUMBER_10
		+ ", " + QuizDetailConstants.ANIME_NUMBER_10 + ")";
	sqlList.add(sql);

	// 漫画20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,8,2," + QuizDetailConstants.ANIME_NUMBER_20
		+ ", " + QuizDetailConstants.ANIME_NUMBER_20 + ")";
	sqlList.add(sql);

	// ゲーム10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,9,1," + QuizDetailConstants.GAME_NUMBER_10
		+ ", " + QuizDetailConstants.GAME_NUMBER_10 + ")";
	sqlList.add(sql);

	// ゲーム20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,9,2," + QuizDetailConstants.GAME_NUMBER_20
		+ ", " + QuizDetailConstants.GAME_NUMBER_20 + ")";
	sqlList.add(sql);

	// 俺30
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,10,3," + QuizDetailConstants.ORE_NUMBER_30
		+ ", " + QuizDetailConstants.ORE_NUMBER_30 + ")";
	sqlList.add(sql);

	// その他10
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,11,1," + QuizDetailConstants.SONOTA_NUMBER_10
		+ ", " + QuizDetailConstants.SONOTA_NUMBER_10 + ")";
	sqlList.add(sql);

	// その他20
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,11,2," + QuizDetailConstants.SONOTA_NUMBER_20
		+ ", " + QuizDetailConstants.SONOTA_NUMBER_20 + ")";
	sqlList.add(sql);

	// その他100(逆転用)
	sql = "INSERT INTO quiz_table(ID ,QUESTION_ID ,GENRE_ID ,POINT_ID ,"
		+ "QUESTION_NUMBER ,REMAIN_QUESTION_NUMBER )"
		+ " VALUES (?,?,11,4," + QuizDetailConstants.SONOTA_NUMBER_100
		+ ", " + QuizDetailConstants.SONOTA_NUMBER_100 + ")";
	sqlList.add(sql);

	return sqlList;

    }

}
