from app.data.dto import LottoDrawResultDto
from app.utils import lotto_utils
from app.data.mapper.lotto_draw_result_mapper import model_to_dto, dto_to_model
from app.data.repository import lotto_draw_result_repository as repo
from typing import Optional
import app.services.external as external
import threading
import asyncio
from app.system.exceptions.scheme  import AppException

def _add_lotto_draw_result(dto: LottoDrawResultDto) -> None:
    if repo.get_by_drw_no(dto.drw_no) == None:
        repo.add(dto_to_model(dto))

async def get_lotto_draw_result(drw_no: int) -> LottoDrawResultDto:
    last_drw_no = lotto_utils.last_draw_no()
    if drw_no > last_drw_no:
        drw_no = last_drw_no
    db_model = repo.get_by_drw_no(drw_no)
    if db_model == None:
        dto = await external.get_lotto_draw_result(drw_no)
        if dto != None:
            add_thread = threading.Thread(target=_add_lotto_draw_result, args=(dto,))
            add_thread.start()
            return dto
        raise AppException(message="system error", status_code=500)
    else:
        return model_to_dto(db_model)