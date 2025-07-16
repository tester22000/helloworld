package system

import (
	"os"

	"eastgrams.com/go_lottoresult/app/utils"
	"github.com/joho/godotenv"
)

type Config struct {
	DbUrl string
}

var CONFIG Config

func init() {
	curDir, _ := os.Getwd()
	envFile, _ := utils.FindFile(ENV_FILENAME, curDir)
	err := godotenv.Load(envFile)
	if err != nil {
		panic(err)
	}
	var testing = os.Getenv(ENV_TESTING)
	if len(testing) > 0 {
		CONFIG = Config{DbUrl: os.Getenv(ENV_DB_TEST_URL)}
	} else {
		CONFIG = Config{DbUrl: os.Getenv(ENV_DB_URL)}
	}
}
