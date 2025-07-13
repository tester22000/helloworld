from __future__ import annotations

from dataclasses import dataclass
from datetime import timedelta
from os import getenv
from dotenv import load_dotenv


def _get_from_env(var_name: str) -> str:
    value = getenv(var_name)
    if value is None:
        raise ValueError(f"Environment variable '{var_name}' must be set.")
    return value

@dataclass(frozen=True)
class Config:
    DB_URL: str

    @staticmethod
    def get_config() -> Config:
        load_dotenv()
        db_url = getenv("DB_URL", "")
        db_test_url = getenv("DB_TEST_URL", "")
        test = getenv("TEST", "")
        if len(test.strip()) > 0:
            db_url = db_test_url
        if db_url == "":
            raise ValueError(
                "Environment variable 'DB_URL' must be set and cannot be empty. "
            )

        return Config(db_url)


CONFIG = Config.get_config()