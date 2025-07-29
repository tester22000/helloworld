using simpleLotto.utils;

namespace simpleLottoTest {
    [TestClass]
    public sealed class UtilsTest {
        [TestMethod]
        public void DateUtilsTest() {
            DateTime utcTarget = DateUtils.GetUtcFromKoreanDateFromYmd(2000, 1, 1);
            DateTime korTarget = DateUtils.GetKoreanDateTime(utcTarget);
            DateTime korTime = DateUtils.GetKoreanDateFromYmd(2000, 1, 1);
            Console.WriteLine($"utcTarget={utcTarget} korTarget={korTarget}");
            Assert.AreEqual(2000, korTarget.Year);
            Assert.AreEqual(korTarget, korTime);
            Assert.AreEqual("20000101", DateUtils.GetYYYMMDD(DateUtils.GetUtcFromKoreanDateFromYmd(2000, 1, 1)));
            Assert.AreEqual("20000110", DateUtils.GetYYYMMDD(DateUtils.GetUtcFromKoreanDateFromYmd(2000, 1, 10)));
            Assert.AreEqual("20000120", DateUtils.GetYYYMMDD(DateUtils.GetUtcFromKoreanDateFromYmd(2000, 1, 20)));
            Assert.AreEqual("20001101", DateUtils.GetYYYMMDD(DateUtils.GetUtcFromKoreanDateFromYmd(2000, 11, 1)));
            Assert.AreEqual("20000501", DateUtils.GetYYYMMDD(DateUtils.GetUtcFromKoreanDateFromYmd(2000, 5, 1)));
            Assert.AreEqual("20000511", DateUtils.GetYYYMMDD(DateUtils.GetUtcFromKoreanDateFromYmd(2000, 5, 11)));
            Assert.AreEqual("2000-05-11", DateUtils.GetDateString(DateUtils.GetUtcFromKoreanDateFromYmd(2000, 5, 11)));

            DateTime start = utcTarget;
            DateTime end = DateUtils.AddDays(start, 10);
            DateTime endWeeks = DateUtils.AddWeeks(start, 10);
            Console.WriteLine($"start={start} end={end} endWeeks={endWeeks}");
            Assert.AreEqual(10, DateUtils.DayDiff(start, end));
            Assert.AreEqual(10, DateUtils.WeekDiff(start, endWeeks));

        }

        [TestMethod]
        public void LottoUtilsTest() {
            const int testDrwNo = 1179;
            Assert.AreEqual("20250705", DateUtils.GetYYYMMDD(LottoUtils.getDrawDate(testDrwNo)));
        }
    }
}
