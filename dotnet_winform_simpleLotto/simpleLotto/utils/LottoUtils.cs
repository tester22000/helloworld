using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.utils {
    public static class LottoUtils {
        private static DateTime START_DATE = DateUtils.GetUtcFromKoreanDateFromYmd(2002, 12, 7);
        private static int DRAW_HOUR_MIN = 2045;

        private static bool IsBeforeDrawTime(DateTime dateTime) {
            return (dateTime.Hour * 100 + dateTime.Minute) < DRAW_HOUR_MIN;
        }

        private static Tuple<DateTime, int> GetDrawInfo() {
            DateTime date = DateUtils.GetKoreanDateTime(DateTime.Now);
            int drwNo = DateUtils.WeekDiff(START_DATE, date) + 1;
            return Tuple.Create(date, drwNo);
        }
        public static int LastDrawnNo() {
            (DateTime date, int drwNo) = GetDrawInfo();
            if ( date.DayOfWeek != DayOfWeek.Saturday || !IsBeforeDrawTime(date)) {
                return drwNo;
            }
            return drwNo - 1;
        }

        public static int MaxDrawNo() {
            (DateTime date, int drwNo) = GetDrawInfo();
            return date.DayOfWeek != DayOfWeek.Saturday ? drwNo + 1 : drwNo;
        }

        public static DateTime getDrawDate(int drwNo) {
            return DateUtils.AddWeeks(START_DATE, drwNo-1);
        }
    }
}
