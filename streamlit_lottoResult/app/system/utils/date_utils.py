from datetime import datetime, timedelta
from zoneinfo import ZoneInfo

_korean_timezone = ZoneInfo("Asia/Seoul")

def to_korean_date(date: datetime) -> datetime:
    return date.astimezone(_korean_timezone)

def get_korean_date() -> datetime:
    return datetime.now(_korean_timezone)

def get_korean_date_from_ymd(year:int, month:int, date:int) -> datetime:
    return datetime(year, month, date, 0, 0, 0, 0, _korean_timezone)

def get_korean_date_yyyymmdd(date: datetime) -> str :
    return to_korean_date(date).strftime("%Y%m%d")

def to_korean_date_string(date: datetime) -> str:
    return to_korean_date(date).strftime("%Y-%m-%d")

def day_diff(start: datetime, end: datetime) -> int:
    if (start > end):
        return (start.date() - end.date()).days
    return (end.date() - start.date()).days

def add_days(target: datetime, days: int) -> datetime:
    return target + timedelta(days=days)


def week_diff(start: datetime, end: datetime) -> int:
    if (start > end):
        return int((start.date() - end.date()).days / 7)
    return int((end.date() - start.date()).days / 7)

def add_weeks(target: datetime, weeks: int) -> datetime:
    return target + timedelta(weeks=weeks)
