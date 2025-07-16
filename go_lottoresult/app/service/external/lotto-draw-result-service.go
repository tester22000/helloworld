package external

import (
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"time"

	"eastgrams.com/go_lottoresult/app/data/models"
)

var httpClient = &http.Client{
	Timeout: 10 * time.Second,
	Transport: &http.Transport{
		MaxIdleConns:    100,              // Max total idle connections
		IdleConnTimeout: 90 * time.Second, // How long idle connections are kept alive
		// Other settings like TLSClientConfig, Proxy, etc.
	},
}

var emptyResult = models.LottoDrawResult{}

type LottoDrawResultExternalService struct{}

func (l LottoDrawResultExternalService) GetResult(drwNo int) (models.LottoDrawResult, int, error) {
	url := fmt.Sprintf("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=%d", drwNo)
	resp, err := httpClient.Get(url)
	if err == nil && resp.StatusCode == http.StatusOK {
		defer resp.Body.Close()
		body, err := io.ReadAll(resp.Body)
		if err != nil {
			return emptyResult, resp.StatusCode, err
		}
		var result models.LottoDrawResult
		err = json.Unmarshal(body, &result)
		if err != nil {
			return emptyResult, resp.StatusCode, err
		}
		return result, resp.StatusCode, err
	}
	return emptyResult, resp.StatusCode, err
}

var LottoDrawResultExternalServiceObj = LottoDrawResultExternalService{}
