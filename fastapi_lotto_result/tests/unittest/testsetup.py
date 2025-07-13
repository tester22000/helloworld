from unittest import TestCase
from dotenv import load_dotenv

class TestBase(TestCase):
    def setPath(self, filename: str,  depth: int):
        import sys
        from os import getcwd
        from os.path import dirname

        work_directory = dirname(filename);
        for i in range(depth):
            work_directory = dirname(work_directory)
        sys.path.append(work_directory)

class DBTestBase(TestBase):
    def setPath(self, filename: str,  depth: int):
        import os
        os.environ["TEST"] = "TRUE"
        load_dotenv()
        super().setPath(filename, depth)