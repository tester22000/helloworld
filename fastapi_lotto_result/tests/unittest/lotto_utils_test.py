from testsetup import TestBase
from datetime import datetime, timezone
import unittest

class LottoUtilsTest(TestBase):

    def setUp(self) -> None:
        self.setPath(__file__, 2)
        return super().setUp()

    def test_draw_date(self):
        from app.utils import date_utils, lotto_utils
        drw_no = 1
        drw_date_yyyymmdd = date_utils.get_korean_date_yyyymmdd(lotto_utils.get_draw_date(drw_no))
        print(f"drw_date_yyyymmdd={drw_date_yyyymmdd}")
        self.assertEqual("20021207", drw_date_yyyymmdd)


if __name__ == '__main__':
    unittest.main()
