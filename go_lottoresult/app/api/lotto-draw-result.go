package api

import (
	"net/http"
	"strconv"

	"eastgrams.com/go_lottoresult/app/data/models"
	"eastgrams.com/go_lottoresult/app/service"
	"eastgrams.com/go_lottoresult/app/utils"
	"github.com/gin-gonic/gin"
)

// @Summary get lotto draw result
// @Description get lotto draw result by drwNo
// @Accept  json
// @Produce  json
// @Param   drwNo     path    int     true        "drwNo"
// @Success 200 {object} models.LottoDrawResult	"ok"
// @Router /lotto_draw_result/{drwNo} [get]
func GetLottoDrawResult(c *gin.Context) {
	var lottoDrawResult models.LottoDrawResult

	drwNo, err := strconv.Atoi(c.Params.ByName("drwNo"))
	if err != nil {
		drwNo = utils.LottoUtilObj.GetLastDrawNo()
	}

	lottoDrawResult = service.LottoDrawResultServiceObj.GetLottoDrawResult(drwNo)
	c.JSON(http.StatusOK, lottoDrawResult)
}

func SetupLottoDrawResultRoute(router *gin.RouterGroup) {
	router.GET("/:drwNo", GetLottoDrawResult)
}
