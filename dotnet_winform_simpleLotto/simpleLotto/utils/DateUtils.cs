using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.utils {
    //readonly TimeZoneInfo seoulTimeZOne = TimeZoneInfo.
     public static class DateUtils {
        internal struct SDate {
            public string Year { get; }
            public string Month { get; }
            public string Day { get; }

            public SDate(DateTime date) : this(date.Year, date.Month, date.Day){ }
            public SDate(int year, int month, int day) {
                Year = year.ToString();
                Month = month < 10 ? $"0{month}" : $"{month}";
                Day = day < 10 ? $"0{day}" : $"{day}";
            }

            public string GetYYYYMMD() {
                return $"{Year}{Month}{Day}";
            }
        }

        private static readonly TimeZoneInfo KOREAN_TZ = TimeZoneInfo.GetSystemTimeZones()
            .Where(t => t.Id.Equals("Korea Standard Time", StringComparison.Ordinal))
            .FirstOrDefault();

        private static readonly TimeSpan KOREAN_TIMESPAN = new TimeSpan(9,0,0);

        public static DateTime GetKoreanDateTime(DateTime date) {
            return TimeZoneInfo.ConvertTime(date, KOREAN_TZ);
        }

        public static DateTime GetKoreanDateTime() {
            return GetKoreanDateTime(DateTime.Now);
        }

        public static DateTime GetUtcFromKoreanDateFromYmd(int year, int month, int day) {
            return TimeZoneInfo.ConvertTimeToUtc(
                new DateTime(year, month, day, 0, 0, 0, DateTimeKind.Unspecified),
                KOREAN_TZ
             );
        }
        public static DateTime GetKoreanDateFromYmd(int year, int month, int day) {
            return GetKoreanDateTime(GetUtcFromKoreanDateFromYmd(year, month, day));
        }

        public static string GetYYYMMDD(DateTime date) {
            DateTime korean = GetKoreanDateTime(date);
            SDate sdate = new SDate(korean);
            return sdate.GetYYYYMMD();
        }

        public static string GetDateString(DateTime date) {
            SDate sdate = new SDate(GetKoreanDateTime(date));
            return $"{sdate.Year}-{sdate.Month}-{sdate.Day}";
        }

        public static int DayDiff(DateTime start, DateTime end) {
            if ( end > start ) {
                return (int)end.Subtract(start).TotalDays;
            }
            return (int)start.Subtract(end).TotalDays;
        }
        public static DateTime AddDays(DateTime date, int days) {
            return date.AddDays(days);
        }

        public static int WeekDiff(DateTime start, DateTime end) {

            if ( end > start ) {
                return (int)(end.Subtract(start).TotalDays / 7);
            }
            return (int)(start.Subtract(end).TotalDays / 7);
        }

        public static DateTime AddWeeks(DateTime date, int weeks) {
            return date.AddDays(weeks*7);
        }
    }
}
