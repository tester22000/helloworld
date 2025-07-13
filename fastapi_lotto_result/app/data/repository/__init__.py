from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

from app.system.config import CONFIG

engine = create_engine(CONFIG.DB_URL, echo=False, pool_pre_ping=True, pool_recycle=3600) #reconect after 1 hour
db_session = sessionmaker(bind=engine, expire_on_commit=False)
