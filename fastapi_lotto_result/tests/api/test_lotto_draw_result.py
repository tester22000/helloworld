from fastapi.testclient import TestClient
from datetime import datetime, timezone
from unittest import TestCase
import unittest

class DateUtilsTest(TestCase):

    def setUp(self) -> None:
        import sys
        from os import getcwd
        from os.path import dirname

        work_directory = dirname(__file__);
        for i in range(2):
            work_directory = dirname(work_directory)
        sys.path.append(work_directory)


    def test_lotto_draw_result(self):
        from main import app

        client = TestClient(app)

        response = client.get("/api/lotto_draw_result/1000")
        json = response.json()
        self.assertEqual(200, response.status_code)
        self.assertEqual(1000, json['drwNo'])

        response = client.get("/api/lotto_draw_result/10000")
        json = response.json()
        self.assertEqual(200, response.status_code)
        self.assertNotEqual(10000, json['drwNo'])


if __name__ == '__main__':
    unittest.main()