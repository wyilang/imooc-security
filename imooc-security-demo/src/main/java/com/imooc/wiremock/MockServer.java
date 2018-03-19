package com.imooc.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;

/**
 * @program: imooc-security
 * @description:
 * @author: Neo.Wang
 * @create: 2018-03-12 00:12
 **/
public class MockServer {
    public static void main(String[] args)throws Exception{
        try {
            WireMock.configureFor("localhost", 8066);
            WireMock.removeAllMappings();
            WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/order/1")).willReturn(WireMock.aResponse().withBody("{\"id\":1}").withStatus(200)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
