package service

import "path/filepath"

func getFileExtension(filename string) string {
	return filepath.Ext(filename)
}
