package com.wasPractice01;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;
//    private final HttpHeaders httpHeaders; 원래의 Http 구성이라면 있어야 하지만 생략
//    private final Body body;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine()); // protocol의 첫번째 줄이 Request Line
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String path) {
        return requestLine.matchPath(path);
    }

    public QueryStrings getQueryString() {
        return requestLine.getQueryStrings();
    }
}
