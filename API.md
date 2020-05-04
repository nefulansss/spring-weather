#天气端口

101.132.158.185:8082/

各个城市数据：

路由: /index

get

参数 无


 ```json


 {
	"code": 200,
	"data": {
		"黑河市": "降雪",
		"七台河市": "雾凇",
		"齐齐哈尔市": "冰雹",
		"佳木斯市": "冰雹",
		"双鸭山市": "冰雹",
		"鸡西市": "冰雹",
		"大兴安岭地区": "冰雹",
		"牡丹江市": "冰雹",
		"牡丹江": "结冰",
		"鹤岗市": "结冰",
		"伊春市": "冰雹",
		"哈尔滨": "降雪",
		"绥化市": "降雪",
		"大庆市": "降雪"
	},
	"message": "成功查找"
}
```

折线图和饼状图：

路由 city/detail

get

String city


```json

 {
	"code": 200,
	"data": {
		"weather": {
			"cityName": "哈尔滨",
			"weather1": 0.02610000,
			"weather2": 0.08180000,
			"weather3": 0.20920000,
			"weather4": 0.19230000,
			"weather5": 0.09510000,
			"weather6": 0.08000000,
			"weather7": 0.02090000,
			"weather8": 0.22330000,
			"weather9": 0.07140000,
			"weatherId": 19,
			"weatherTime": 1585284751000
		},
		"city7": [{
			"date": "2-27",
			"name": "哈尔滨",
			"waether": "降雪"
		}, {
			"date": "2-28",
			"name": "哈尔滨",
			"waether": "结冰"
		}]
	},
	"message": "成功查找"
}

```



图片上传端口

路由  /upload

post

参数 File img String city

```json

{
    "data": {
        "result": "霜"
    },
    "message": "成功查找",
    "code": 200
}
```
