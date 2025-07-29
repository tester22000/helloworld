using simpleLotto.data.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.data.repository {
    public class LottoDrawResultRepository {
        public static async Task<LottoDrawResult> GetLottoDrawResult(int drwNo) {
            return await DB.Instance.lottoDrawResults.FindAsync(drwNo);
        }

        public static async Task AddLottoDrawResult(LottoDrawResult result) {
            DB.Instance.lottoDrawResults.Add(result);
            await  DB.Instance.SaveChangesAsync();
        }

        public static async Task DeleteLottoDrawResult(int drwNo) {
            var resultToDelete = new LottoDrawResult { drwNo = drwNo };

            DB.Instance.lottoDrawResults.Attach(resultToDelete);
            DB.Instance.lottoDrawResults.Remove(resultToDelete);

            await DB.Instance.SaveChangesAsync();
        }
    }
}
