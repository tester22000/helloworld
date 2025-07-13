from app.data.model import LottoDrawResult
from app.data.repository import db_session

def add(result : LottoDrawResult) -> LottoDrawResult:
    with db_session.begin() as session:
        session.add(result)
        session.commit()
        return result

def delete(drw_no: int) -> None:
    with db_session() as session:
        session.query(LottoDrawResult).filter(LottoDrawResult.drw_no == drw_no).delete()
        session.commit()

def get_by_drw_no(drw_no: int) -> LottoDrawResult:
    with db_session.begin() as session:
        return session.query(LottoDrawResult).where(
            LottoDrawResult.drw_no == drw_no
        ).first()