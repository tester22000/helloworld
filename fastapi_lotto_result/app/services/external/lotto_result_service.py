import asyncio
import httpx
from app.data.dto import LottoDrawResultDto
from typing import Union

async def get_lotto_draw_result(drw_no: int) -> Union[ LottoDrawResultDto, None]:
    async with httpx.AsyncClient() as client:
        response = await client.get(f"https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo={drw_no}")
        if response.status_code == 200:
            return LottoDrawResultDto(**response.json())