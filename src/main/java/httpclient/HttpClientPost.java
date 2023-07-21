package httpclient;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;

import java.io.IOException;

public class HttpClientPost {
    private static String SendPost(String url) throws IOException, ParseException {
        // creating an object of CloseableHttpClient to create a default http client to perform action
        // like request and respond.

        CloseableHttpClient client  = HttpClients.createDefault();

        // creating an object of HttpPost to generate post request.
        HttpPost request = new HttpPost(url);

        // adding some headers :
        // adding content-type as application/json in header.
        request.addHeader("Content-Type", "application/json");
        // adding accept as application.json in header.
        request.addHeader("Accept", "application/json");
        // adding authentication in header to authenticate or to authorize user the access of private
        // API endpoint and storing token in it.
        request.addHeader("Authorization", "Bearer 66749fba446a1a9cf5f6fac297a180fb2c2008b60c573de494af8aa49ce099ac");

        // creating json object and storing values in it
        JSONObject payload = new JSONObject();
        payload.put("name", "Divjot kaur");
        payload.put("email", "div123456@gmaail.com");
        payload.put("gender", "female");
        payload.put("status", "active");

        // this used to set the entity (payload) of an HTTP request before sending it to the server
        // and converting this json object to string value.
        request.setEntity(new StringEntity(payload.toString()));

        // creating an object of CloseableHttpResponse to execute the request of a client.
        CloseableHttpResponse response  = client.execute(request);

        // this s used to read the response body returned from the server after making an HTTP request.
        return EntityUtils.toString(response.getEntity());
    }
    public static void main(String[] args) {
        //calling the method of post request (which is used to write in a website)

        // using try and catch block to handle exceptions.
        try{
            String result = SendPost("https://gorest.co.in/public/v2/users");
            // printing the result.
            System.out.println(result);
        }
        catch(Exception e){
            // below line is used to print the stack trace of an exception to the console.
            e.printStackTrace();
        }
    }
}
