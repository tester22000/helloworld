import app.utils.date_utils as dateUtils
from datetime import datetime

_START_DATE = dateUtils.get_korean_date_from_ymd(2002, 12, 7)
_DRAW_HOUT_MIN = 2045
_SATURDAY = 5

def is_before_drawtime(date: datetime) -> bool:
    return date.hour*100 + date.minute < _DRAW_HOUT_MIN

def last_draw_no() -> int:
    date = dateUtils.get_korean_date()
    drw_no = dateUtils.week_diff(_START_DATE, date) + 1
    if (date.weekday != _SATURDAY or not is_before_drawtime(date)):
        return drw_no
    return drw_no - 1


def max_draw_no() -> int:
    date = dateUtils.get_korean_date()
    drw_no = dateUtils.week_diff(_START_DATE, date) + 1
    if (date.weekday != _SATURDAY ):
        return drw_no
    return drw_no + 1

def get_draw_date(drnNo : int) -> datetime:
    return dateUtils.add_weeks(_START_DATE, drnNo-1)
