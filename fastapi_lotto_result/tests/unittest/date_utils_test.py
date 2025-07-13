from testsetup import TestBase
from datetime import datetime, timezone
import unittest

class DateUtilsTest(TestBase):

    def setUp(self) -> None:
        self.setPath(__file__, 2)
        return super().setUp()

    def test_get_korean_date(self):
        import app.utils.date_utils as utils

        cur_time = datetime.now(timezone.utc)
        to_kor_time = utils.to_korean_date(cur_time)
        cur_kor_time = utils.get_korean_date()
        print(f"cur_time={cur_time}")
        print(f"to_kor_time={to_kor_time}")
        print(f"cur_kor_time={cur_kor_time}")
        self.assertEqual(to_kor_time.hour, cur_kor_time.hour)

        ymd_2000_1_1 = utils.get_korean_date_from_ymd(2000,1,1)
        self.assertEqual(2000, ymd_2000_1_1.year)
        self.assertEqual(1, ymd_2000_1_1.month)
        self.assertEqual(1, ymd_2000_1_1.day)

        yyyymmdd = utils.get_korean_date_yyyymmdd(ymd_2000_1_1)
        print(f'yyyymmdd={yyyymmdd}')
        self.assertEqual("20000101", yyyymmdd)

        yyyymmdd_str = utils.to_korean_date_string(ymd_2000_1_1)
        print(f'yyyymmdd_str={yyyymmdd_str}')
        self.assertEqual("2000-01-01", yyyymmdd_str)


    def test_day_diff(self):
        import app.utils.date_utils as utils

        start_date =  utils.get_korean_date_from_ymd(2000,1,1)
        start_date_puls_1 = utils.get_korean_date_from_ymd(2000,1,2)
        start_date_minus_1 = utils.get_korean_date_from_ymd(1999,12,31)

        self.assertEqual(utils.day_diff(start_date, start_date_puls_1),1)
        self.assertEqual(utils.day_diff(start_date_puls_1, start_date),1)

        self.assertEqual(utils.day_diff(start_date, start_date_minus_1),1)
        self.assertEqual(utils.day_diff(start_date_minus_1, start_date),1)

        self.assertEqual(utils.day_diff(start_date_puls_1, start_date_minus_1),2)

        next_date = utils.add_days(start_date, 1);
        prev_date = utils.add_days(start_date, -1);
        self.assertEqual(utils.get_korean_date_yyyymmdd(start_date_puls_1), utils.get_korean_date_yyyymmdd(next_date))
        self.assertEqual(utils.get_korean_date_yyyymmdd(start_date_minus_1), utils.get_korean_date_yyyymmdd(prev_date))

    def test_week_diff(self):
        import app.utils.date_utils as utils

        start_date =  utils.get_korean_date_from_ymd(2000,1,1)
        self.assertEqual(0, utils.week_diff(start_date, utils.add_days(start_date,1)))
        self.assertEqual(0, utils.week_diff(start_date, utils.add_days(start_date,2)))
        self.assertEqual(0, utils.week_diff(start_date, utils.add_days(start_date,3)))
        self.assertEqual(0, utils.week_diff(start_date, utils.add_days(start_date,4)))
        self.assertEqual(0, utils.week_diff(start_date, utils.add_days(start_date,5)))
        self.assertEqual(0, utils.week_diff(start_date, utils.add_days(start_date,6)))
        self.assertEqual(1, utils.week_diff(start_date, utils.add_days(start_date,7)))
        self.assertEqual(1, utils.week_diff(start_date, utils.add_days(start_date,8)))
        self.assertEqual(1, utils.week_diff(start_date, utils.add_days(start_date,9)))
        self.assertEqual(1, utils.week_diff(start_date, utils.add_days(start_date,10)))

        start_week_plus_1 = utils.get_korean_date_from_ymd(2000,1,8)
        start_week_minus_1 = utils.add_days(start_date, -7)
        self.assertEqual(1, utils.week_diff(start_date, start_week_plus_1))
        self.assertEqual(1, utils.week_diff(start_date, start_week_minus_1))

        self.assertEqual(utils.get_korean_date_yyyymmdd(start_week_plus_1), utils.get_korean_date_yyyymmdd(utils.add_weeks(start_date,1)))


if __name__ == '__main__':
    unittest.main()
