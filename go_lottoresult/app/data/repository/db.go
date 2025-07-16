package repository

import (
	"eastgrams.com/go_lottoresult/app/system"
	"eastgrams.com/go_lottoresult/driver/sqlite"
	"gorm.io/gorm"
)

var Db *gorm.DB
var DbErr error

func init() {

	Db, DbErr = gorm.Open(sqlite.Open(system.CONFIG.DbUrl), &gorm.Config{})
	if DbErr != nil {
		panic("Failed to connect database")
	}
}
