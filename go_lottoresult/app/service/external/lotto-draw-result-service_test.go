package external_test

import (
	"net/http"
	"testing"

	"eastgrams.com/go_lottoresult/app/service/external"
)

func TestGetResult(t *testing.T) {

	t.Run("success get", func(t *testing.T) {
		const drwNo = 1001

		result, status, error := external.LottoDrawResultExternalServiceObj.GetResult(drwNo)

		if http.StatusOK != status {
			t.Errorf("response status code is %d; expected: %d", status, http.StatusOK)
		}

		if error != nil {
			t.Errorf("response error %s", error)
		}

		if drwNo != result.DrwNo {
			t.Errorf("Invalid response drwNo:%d; expected:%d", result.DrwNo, drwNo)
		}
	})
}
