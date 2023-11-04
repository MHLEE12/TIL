package com.wasPractice01;

public class RequestLine {
    private final String method; // GET
    private final String urlPath; // /calculate?operand1=10&operator=*&operand2=33
    private String queryString;

    /**
     * GET /calculate?operand1=10&operator=*&operand2=33 HTTP/1.1
     */
    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryString = urlPathTokens[1];
        }
    }
}
