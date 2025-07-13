from dotenv import load_dotenv
from fastapi import FastAPI

from app.api import lotto_draw_result_router
from app.system.middlewares import cors_middleware
from app.system.exceptions import handler

# apps
app = FastAPI() # api for json

handler.add_json(app)
cors_middleware.add(app)

# include api routers
app.include_router(router=lotto_draw_result_router.router, prefix="/api")
