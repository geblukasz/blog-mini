package pl.akademiakodu.miniblog;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExternalRestTest {

    @Test
    public void randomQuotes(){
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://gturnquist-quoters.cfapps.io/api/random";
        QuoteResponse quoteResponse = restTemplate.getForObject(apiUrl, QuoteResponse.class);
        System.out.println(quoteResponse);

    }

    @Test
    public void basicAuthRest(){
        RestTemplate restTemplate = new RestTemplate();
        String username = "szk", password = "tpass";
        String url = "https://httpbin.org/basic-auth/"+username+"/"+password;

        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
        System.out.println(restTemplate.getForObject(url, Map.class));


    }

    @Test
    public void passArgs(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://httpbin.org/get?qwe=asd&zxc={mykey}";
        Map<String, String> args = new HashMap<>();
        args.put("mykey", "myvalue");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(Arrays.asList(Charset.forName("utf-8")));
        headers.set("X-TP-DeviceID", "your value");

//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        HttpEntity<String> entity = new HttpEntity<String>(null, null);

        System.out.println(restTemplate.getForObject(url, Map.class, args));
        System.out.println(" --- ");
        System.out.println(restTemplate.exchange(url, HttpMethod.GET, entity, Map.class, args));

    }
}
