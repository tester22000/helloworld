import streamlit as st
from typing import List, Set, Optional
import asyncio
import pandas as pd

from app.data.model import LottoDrawResult
from app.system.utils import lotto_utils
from app.service import LottoDrawResultService
from app.data.repository import LottoDrawResultRepository
from app.ui.widget.lotto_ball import lotto_ball_widget, lotto_plus_sign

def display_lotto_result_numbers(result: LottoDrawResult):
    cols = st.columns(8)

    result_cols : List[Set] = [
        (cols[0], result.drwtNo1 if result != None else 0),
        (cols[1], result.drwtNo2 if result != None else 0),
        (cols[2], result.drwtNo3 if result != None else 0),
        (cols[3], result.drwtNo4 if result != None else 0),
        (cols[4], result.drwtNo5 if result != None else 0),
        (cols[5], result.drwtNo6 if result != None else 0),
    ]

    for i in range(len(result_cols)):
        col, num = result_cols[i]
        with col:
            lotto_ball_widget(num)

    with cols[6]:
        lotto_plus_sign()

    with cols[7]:
        lotto_ball_widget(result.bnusNo if result != None else 0)

def get_lotto_draw_result(service: LottoDrawResultService, drw_no: int) -> Optional[LottoDrawResult]:
    return asyncio.run(service.get_lotto_draw_result(drw_no))

st.set_page_config(layout="wide")
last_drw_no = lotto_utils.last_draw_no()
service = LottoDrawResultService(LottoDrawResultRepository())

if "drw_no" not in st.session_state:
    st.session_state.drw_no = last_drw_no

drw_no = st.session_state.drw_no
if drw_no > last_drw_no:
    drw_no = last_drw_no
    st.session_state.drw_no = drw_no

st.title(f"{drw_no}회 당첨결과")
col_prev, col_next = st.columns([1, 1])

with col_prev:
    if st.button("<", use_container_width=True, disabled= drw_no <= 1 ):
        st.session_state.drw_no = drw_no -1

with col_next:
    if st.button("\>", use_container_width=True, disabled=(drw_no >= last_drw_no)):
        st.session_state.drw_no = drw_no + 1

result = get_lotto_draw_result(service, drw_no)
st.write("---")

display_lotto_result_numbers(result)

st.write("---")

df = pd.DataFrame([{"total": result.firstAccumamnt, "count": result.firstPrzwnerCo, "prize" : result.firstWinamnt}])
new_column_names = {
    "total": "1등 총 당첨금액",
    "count": "당첨 게임수",
    "prize": "1게임당 당첨금액"
}
df = df.rename(columns=new_column_names)
st.dataframe(df)