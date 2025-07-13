from fastapi import APIRouter
from fastapi import Path
from app.data.dto.lotto_draw_result import LottoDrawResultDto
import app.services.lotto_draw_result_service as service

router = APIRouter(
    prefix="/lotto_draw_result",
    tags=["lotto_draw_result"]
)


@router.get("/{drw_no}", response_model=LottoDrawResultDto)
async def get_by_id(drw_no: int = Path(ge=1)):
    return await service.get_lotto_draw_result(drw_no)