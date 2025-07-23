import 'package:flutter_lottoresult/system/config.dart';
import 'package:flutter_lottoresult/data/model/lotto_draw_result.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:sqlite3/sqlite3.dart';

class LottoDrawResultRepository {
  final Database _db;
  final String _insertSql = '''
  INSERT INTO lotto_draw_result (
	drw_no,
	drw_no_date,
	drwt_no1,
	drwt_no2,
	drwt_no3,
	drwt_no4,
	drwt_no5,
	drwt_no6,
	bnus_no,
	tot_sell_amnt,
	first_win_amnt,
	first_prz_wner_co,
	first_accum_amnt,
	return_value
  ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)
  ''';

  LottoDrawResultRepository(this._db);

  LottoDrawResult? getLottoDrawResultByDrwNo(int drwNo) {
    try {
      final ResultSet result = _db.select(
        "select * from lotto_draw_result where drw_no = ?",
        [drwNo],
      );
      return LottoDrawResult.fromDB(result.first);
    } catch (ex) {
      return null;
    }
  }

  void insertLottoDrawResult(LottoDrawResult result) {
    _db.execute(_insertSql, [
      result.drwNo,
      result.drwNoDate,
      result.drwtNo1,
      result.drwtNo2,
      result.drwtNo3,
      result.drwtNo4,
      result.drwtNo5,
      result.drwtNo6,
      result.bnusNo,
      result.totSellAmnt,
      result.firstWinAmnt,
      result.FirstPrzWnerCo,
      result.firstAccumAmnt,
      result.returnValue,
    ]);
  }

  void deleteLottoDrawResult(int drwNo) {
    _db.execute("delete from lotto_draw_result where drw_no = ?", [drwNo]);
  }
}

final sqlite3Provider = Provider<Database>((ref) {
  final config = ref.watch(configProvider);
  final database = sqlite3.open(config.dbFile);
  database.execute('''
create table if not exists lotto_draw_result (
        drw_no INT NOT NULL PRIMARY KEY,
        drw_no_date VARCHAR(200),
        drwt_no1 INT NOT NULL,
        drwt_no2 INT NOT NULL,
        drwt_no3 INT NOT NULL,
        drwt_no4 INT NOT NULL,
        drwt_no5 INT NOT NULL,
        drwt_no6 INT NOT NULL,
        bnus_no INT NOT NULL,
        tot_sell_amnt BIGINT,
        first_win_amnt INT,
        first_prz_wner_co INT,
        first_accum_amnt BIGINT,
        return_value VARCHAR(20)
)
''');
  return database;
});

final lottoDrawResultRepositoryProvider = Provider<LottoDrawResultRepository>((
  ref,
) {
  final sqlite3 = ref.watch(sqlite3Provider);
  return LottoDrawResultRepository(sqlite3);
});

// final lottoDrawResultRepositoryProvider = FutureProvider<LottoDrawResultRepository>((
//   
// ) async {
//   final sqlite3 = ref.watch(sqlite3Provider.future);
//   return LottoDrawResultRepository(sqlite3);
// });
//  