from testsetup import DBTestBase
from datetime import datetime, timezone
import unittest
import os
import json
import asyncio

class SqliteDBTest(DBTestBase):

    test_str = """
    {"totSellamnt":118628811000,"returnValue":"success","drwNoDate":"2022-01-29","firstWinamnt":1246819620,"drwtNo6":42,"drwtNo4":22,"firstPrzwnerCo":22,"drwtNo5":32,"bnusNo":39,"firstAccumamnt":27430031640,"drwNo":1000,"drwtNo2":8,"drwtNo3":19,"drwtNo1":2}
"""

    def setUp(self) -> None:
        self.setPath(__file__, 2)
        return super().setUp()

    def test_lotto_draw_result_mapper(self):
        from app.data.mapper.lotto_draw_result_mapper import dto_to_model, model_to_dto
        from app.data.dto.lotto_draw_result import LottoDrawResultDto
        json_obj = json.loads(self.test_str)
        dto = LottoDrawResultDto(**json_obj)
        db_model = dto_to_model(dto)
        dto2 = model_to_dto(db_model)
        self.assertEqual(dto, dto2)

    def test_lotto_draw_result(self):
        from app.services.external import get_lotto_draw_result
        from app.data.repository import lotto_draw_result_repository as repo
        from app.data.mapper.lotto_draw_result_mapper import dto_to_model, model_to_dto
        from app.data.dto.lotto_draw_result import LottoDrawResultDto
        import asyncio

        drw_no: int = 1000
        repo.delete(drw_no)

        result_model = repo.get_by_drw_no(drw_no)
        self.assertEqual(None, result_model)

        dto = asyncio.run(get_lotto_draw_result(drw_no))
        model = dto_to_model(dto) # type: ignore
        repo.add(model)
        result_model = repo.get_by_drw_no(drw_no)

        self.assertNotEqual(None, result_model)
        self.assertEqual(drw_no, result_model.drw_no)

        if dto != None:
            for key in dto.model_dump():
                self.assertEqual(getattr(dto,key), getattr(result_model,key))


    def test_lotto_draw_result_service(self):
        from app.data.repository import lotto_draw_result_repository as repo
        import app.services.lotto_draw_result_service as service
        import time

        drw_no = 1001
        repo.delete(drw_no)
        db_model = repo.get_by_drw_no(drw_no)
        self.assertEqual(None, db_model)

        dto = asyncio.run(service.get_lotto_draw_result(drw_no))
        self.assertNotEqual(None, dto)
        self.assertEqual(drw_no, dto.drw_no) # type: ignore
        time.sleep(1)
        dto = asyncio.run(service.get_lotto_draw_result(drw_no))
        self.assertNotEqual(None, dto)
        db_model = repo.get_by_drw_no(drw_no)
        self.assertNotEqual(None, db_model)



if __name__ == '__main__':
    unittest.main()
