package utils

import (
	"os"
	"path/filepath"
)

func FindFile(filename string, currentDir string) (string, error) {
	filePath := filepath.Join(currentDir, filename)
	_, err := os.Stat(filePath)
	if err == nil {
		return filePath, nil // File found
	}

	if !os.IsNotExist(err) {
		return "", err
	}

	parentDir := filepath.Dir(currentDir)

	if parentDir == currentDir {
		return "", nil // File not found in any ancestor directory
	}

	return FindFile(filename, parentDir)
}
