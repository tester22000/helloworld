from sqlalchemy import Column, Integer, String , BigInteger
from app.data.model.db_base_model import DbModelBase

class LottoDrawResult(DbModelBase):
    __tablename__ = 'lotto_draw_result'
    drw_no = Column(Integer, primary_key=True)
    drw_no_date = Column(String)
    drwt_no1 = Column(Integer)
    drwt_no2 = Column(Integer)
    drwt_no3 = Column(Integer)
    drwt_no4 = Column(Integer)
    drwt_no5 = Column(Integer)
    drwt_no6 = Column(Integer)
    bnus_no = Column(Integer)
    tot_sell_amnt = Column(BigInteger)
    first_win_amnt = Column(BigInteger)
    first_prz_wner_co = Column(Integer)
    first_accum_amnt = Column(BigInteger)
    return_value = Column(String)