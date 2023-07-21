package httpclient;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;

public class HttpClientGet {
    public static void main(String[] args) throws IOException {
        // creating an object of ClosableHttpClient that create a default http client to perform
        // action like request and respond.
        CloseableHttpClient client = HttpClients.createDefault();
        // Adding try and catch block to handle exceptions and errors.
        try{
            // adding GET request with its URL to read the website.
            HttpGet request = new HttpGet("https://gorest.co.in/public/v2/users/2162");
            // creating an object of CloseableHttpResponse which executes the request of the client.
            CloseableHttpResponse response = client.execute(request);
        }
        finally{
            // closing CloseableHttpClient after you are done with it.
            client.close();
        }
    }
}
