# hotelWebServer_MCDA5550

1.
Request url: http://Hotelreservation-env.eba-j7i7z6jw.us-east-2.elasticbeanstalk.com/hotelList

Request method: GET

Response parameters:
|Key|Type|Describe|
|------|------|------|
|id|int|It's the unique number for hotel|
|hotel_name|String||
|price|int||
|availability|boolean|only two values: true and false|

2.
Request url: http://Hotelreservation-env.eba-j7i7z6jw.us-east-2.elasticbeanstalk.com/reservatio

Request method: POST

Request body: JSON

{ "hotel_name": "The Halifax Hotel",
   "checkin": "20211103",
   "checkout": "20211114",
    "guests_list": [ 
           { "guest_name" : "ZZ",
             "age":22,
             "gender": 0
           },
           { "guest_name" : "JJt",
             "age":18,
             "gender": 1
           }
       ]
}

Request parameters:
|Key|Type|Describe|
|------|------|------|
|hotel_name|String|It's the unique number for hotel|
|checkin|String|It's the checkin time|
|checkout|String|It's the checkout time|
|guests_list|Set|This is a collection of information about all guests|
|guest_name|String||
|age|int||
|gender|int|0:MALE,1:FEMALE,2:NONIDENTIFIED|



Response parameter:
|Key|Type|Describe|
|------|------|------|
|Confirmation_number|String|It's the unique number for the reservation|


