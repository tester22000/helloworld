import sqlite3
from typing import Optional
from app.data.model import LottoDrawResult
from app.system import DB_NAME

class LottoDrawResultRepository:

    def _get_connection(self):
        conn = sqlite3.connect(DB_NAME)
        conn.row_factory = sqlite3.Row
        return conn

    def get_by_drw_no(self, drw_no: int) -> Optional[LottoDrawResult]:
        conn = self._get_connection()
        cursor = conn.cursor()
        cursor.execute("SELECT * FROM lotto_draw_result WHERE drwNo = ?", (drw_no,))
        row = cursor.fetchone()
        conn.close()
        if row:
            return LottoDrawResult(**row)
        return None

    def delete(self, drw_no: int) -> None:
        conn = self._get_connection()
        cursor = conn.cursor()
        cursor.execute("DELETE FROM lotto_draw_result WHERE drwNo = ?", (drw_no,))
        row = cursor.fetchone()
        conn.close()

    def create_table(self) -> None:
        conn = self._get_connection()
        cursor = conn.cursor()
        cursor.execute(
"""
create table if not exists lotto_draw_result (
        drwNo int not null primary key,
        drwNoDate varchar(200),
        drwtNo1 int not null,
        drwtNo2 int not null,
        drwtNo3 int not null,
        drwtNo4 int not null,
        drwtNo5 int not null,
        drwtNo6 int not null,
        bnusNo int not null,
        totSellamnt bigint,
        firstWinamnt int,
        firstPrzwnerCo int,
        firstAccumamnt bigint,
        returnValue varchar(20)
)
"""     )
        conn.commit()
        conn.close()

    def save(self, record: LottoDrawResult) -> None:
        conn = self._get_connection()
        cursor = conn.cursor()
        cursor.execute(
            """
            INSERT OR REPLACE INTO lotto_draw_result (
                drwNo,
                drwNoDate,
                drwtNo1,
                drwtNo2,
                drwtNo3,
                drwtNo4,
                drwtNo5,
                drwtNo6,
                bnusNo,
                totSellamnt,
                firstWinamnt,
                firstPrzwnerCo,
                firstAccumamnt,
                returnValue
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """,
            (
                record.drwNo,
                record.drwNoDate,
                record.drwtNo1,
                record.drwtNo2,
                record.drwtNo3,
                record.drwtNo4,
                record.drwtNo5,
                record.drwtNo6,
                record.bnusNo,
                record.totSellamnt,
                record.firstWinamnt,
                record.firstPrzwnerCo,
                record.firstAccumamnt,
                record.returnValue
            )
        )
        conn.commit()
        conn.close()
