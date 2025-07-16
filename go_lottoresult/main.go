package main

import (
	"os"

	"eastgrams.com/go_lottoresult/app/api"
	"eastgrams.com/go_lottoresult/app/system/middlewares"
	docs "eastgrams.com/go_lottoresult/docs"
	"github.com/gin-gonic/gin"
	swaggerfiles "github.com/swaggo/files"
	ginSwagger "github.com/swaggo/gin-swagger"
)

// @title golang Lotto Draw Result Sample API
// @version 1.0

// @host localhost:8000
// @BasePath /api
func main() {

	is_production := os.Getenv("PRODUCTION")
	if is_production == "true" {
		gin.SetMode(gin.ReleaseMode)
	}

	r := gin.Default()
	r.Use(middlewares.CORS())

	apiV1 := r.Group("/api")
	api.SetupLottoDrawResultRoute(apiV1.Group("/lotto_draw_result"))
	docs.SwaggerInfo.BasePath = "/api"
	r.GET("/swagger/*any", ginSwagger.WrapHandler(swaggerfiles.Handler))

	port := os.Getenv("PORT")
	if port == "" {
		port = "8100"
	}

	err := r.Run(":" + port)
	if err != nil {
		panic(err)
	}
}
