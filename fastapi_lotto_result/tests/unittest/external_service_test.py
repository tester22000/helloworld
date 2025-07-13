from testsetup import TestBase
import unittest
import asyncio

class LottoResultServiceTest(TestBase):
    def setUp(self):
        self.setPath(__file__, 2)

    def test_get_draw_result(self):
        import app.services.external.lotto_result_service as service
        from app.data.dto import LottoDrawResultDto

        drw_no = 1000

        dto = asyncio.run(service.get_lotto_draw_result(drw_no))
        self.assertEqual(isinstance(dto,LottoDrawResultDto), True)
        self.assertEqual(drw_no, dto.drw_no) # type: ignore


if __name__ == '__main__':
    unittest.main()







