from testsetup import TestBase
from dotenv import load_dotenv
import unittest


class EnvConfTest(TestBase):
    def setUp(self) -> None:
        self.setPath(__file__, 2)
        load_dotenv() 
        return super().setUp()

    def test_get_config(self):
        from app.system.config import CONFIG 

        print(CONFIG.DB_URL)
        self.assertNotEqual(CONFIG.DB_URL,"")


if __name__ == '__main__':
    unittest.main()