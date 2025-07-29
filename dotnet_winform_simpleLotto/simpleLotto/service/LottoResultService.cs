using simpleLotto.data.model;
using simpleLotto.data.repository;
using simpleLotto.service.external;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.service {
    public static class LottoResultService {
        public static async Task<LottoDrawResult> GetLottoDrawResult(int drwNo) {
            try {
                var result = await LottoDrawResultRepository.GetLottoDrawResult(drwNo);
                if (result == null) {
                    result = await LottoResultExternalService.GetLottoDrawResult(drwNo);
                    if (result != null) {
                        await LottoDrawResultRepository.AddLottoDrawResult(result);
                    }
                }
                return result;
            } catch (Exception ex) {
                Console.WriteLine(ex.Message);
                return null;
            }
        }
    }
}
