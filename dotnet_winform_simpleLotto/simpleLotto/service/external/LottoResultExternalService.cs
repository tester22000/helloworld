using simpleLotto.data.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace simpleLotto.service.external {

    internal record class LottoDrawResultInput(
        string method="getLottoNumber",
        int drwNo=0
        );
    public static class LottoResultExternalService {
        private static readonly HttpClient httpClient = new() { BaseAddress = new Uri("https://www.dhlottery.co.kr/") };

        private static Encoding GetEucKrEncoding() {
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);
            return Encoding.GetEncoding(949);
        }

        public static async Task<LottoDrawResult> GetLottoDrawResult(int drwNo) {
            try {
                string url = $"common.do?method=getLottoNumber&drwNo={drwNo}";
                using var response = await httpClient.PostAsJsonAsync(url, new LottoDrawResultInput(drwNo: drwNo));
                response.EnsureSuccessStatusCode();
                using var stream = await response.Content.ReadAsStreamAsync();
                using var reader = new StreamReader(stream, GetEucKrEncoding());
                string responseBody = await reader.ReadToEndAsync();
                LottoDrawResult? result = JsonSerializer.Deserialize<LottoDrawResult>(responseBody);
                return result;
            } catch (Exception ex) {
                Console.WriteLine(ex.Message);
                return null;
            }
        }
    }
}
