import httpx
from typing import Union
from app.data.model import LottoDrawResult

async def get_lotto_draw_result(drw_no: int) -> Union[ LottoDrawResult, None]:
    async with httpx.AsyncClient() as client:
        response = await client.get(f"https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo={drw_no}")
        if response.status_code == 200:
            return LottoDrawResult(**response.json())
