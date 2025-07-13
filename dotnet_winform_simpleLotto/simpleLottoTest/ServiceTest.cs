using simpleLotto.model;
using simpleLotto.service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace simpleLottoTest {
    [TestClass]
    public sealed class ServiceTest {

        [TestMethod]
        public void JsonTest() {
            String testString = """
                {
                    "totSellamnt":118628811000,"returnValue":"success","drwNoDate":"2022-01-29","firstWinamnt":1246819620,"drwtNo6":42,"drwtNo4":22,"firstPrzwnerCo":22,"drwtNo5":32,"bnusNo":39,"firstAccumamnt":27430031640,"drwNo":1000,"drwtNo2":8,"drwtNo3":19,"drwtNo1":2
                }
                """;
            LottoDrawResult? result = JsonSerializer.Deserialize<LottoDrawResult>(testString);
            Assert.IsNotNull(result);
            Assert.AreEqual(118628811000, result.totSellamnt);
            Assert.AreEqual("2022", result.drwNoDate.Substring(0, 4));
            Assert.AreEqual("01", result.drwNoDate.Substring(5, 2));
            Assert.AreEqual("29", result.drwNoDate.Substring(8, 2));
        }

        [TestMethod]
        public async Task LottoServiceTest() {
            int drwNo = 1000;
            LottoDrawResult result = await LottoResultService.LottoDrawResult(drwNo);
            Assert.IsNotNull(result);
            Assert.AreEqual(drwNo, result.drwNo);
        }
    }
}
