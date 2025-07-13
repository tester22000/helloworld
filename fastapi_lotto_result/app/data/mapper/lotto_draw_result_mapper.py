from app.data.dto import LottoDrawResultDto
from app.data.model import LottoDrawResult


def model_to_dto(model: LottoDrawResult) -> LottoDrawResultDto:
    return LottoDrawResultDto.model_validate(model, by_name=True, from_attributes=True)

def dto_to_model(dto : LottoDrawResultDto) -> LottoDrawResult:
    return LottoDrawResult(**dto.model_dump())
