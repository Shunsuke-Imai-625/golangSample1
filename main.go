package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func main() {
	r := gin.Default()
	r.POST("/", postfunc)
	r.Run(":8080")
}

type InputCompany struct {
	Request string `json:"request"`
}

func postfunc(c *gin.Context) {
	var hoge InputCompany

	if err := c.ShouldBindJSON(&hoge); err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}
	c.JSON(http.StatusOK, gin.H{
		"respons": hoge.Request,
	})
}
