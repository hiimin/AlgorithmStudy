# Google Cloud Vision API

## Key 생성

1. [https://cloud.google.com/functions/docs/tutorials/ocr?hl=ko](https://cloud.google.com/functions/docs/tutorials/ocr?hl=ko)
2. 프로젝트 생성
3. 결제 사용 설정
4. 대시보드 -&gt; 사용자 인증 정보 -&gt; api 키 생성

## 요청

```javascript
let googleApiHost = process.env.GOOGLE_HOST + process.env.GOOGLE_CLOUD_API_KEY;
let googleOcrRequest = {
    "requests": [{
        "features": [{
            "type": "TEXT_DETECTION"
        }],
        "image": {
            "content": "<<image to base64 string>>"
        }
    }]
}
            
rpn({
        url: googleApiHost,
        method: "POST",
        body: googleOcrRequest,
        json: true
})
```

