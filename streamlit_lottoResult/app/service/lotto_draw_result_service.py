from typing import Optional
import threading

from app.data.model import LottoDrawResult
from app.system.utils import lotto_utils
from app.data.repository import LottoDrawResultRepository
import app.service.external as external

class LottoDrawResultService:

    def __init__(self, repo: LottoDrawResultRepository):
        self.repo = repo

    def _add_lotto_draw_result(self, result: LottoDrawResult) -> None:
        self.repo.save(result)

    async def get_lotto_draw_result(self, drw_no: int) -> Optional[LottoDrawResult]:
        result = self.repo.get_by_drw_no(drw_no)
        if result == None:
            result = await external.get_lotto_draw_result(drw_no)
            if result != None:
                add_thread = threading.Thread(target= self._add_lotto_draw_result, args=(result,))
                add_thread.start()
                return result
        return result