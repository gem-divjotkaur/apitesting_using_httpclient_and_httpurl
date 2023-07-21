package httpclient;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUrlPost {
    public static void main(String[] args) throws IOException {
        // creating try and catch block to handle the exceptions.
        try{
            // creating json object to store the values of payload
            JSONObject payload = new JSONObject();
            payload.put("name", "div kaur");
            payload.put("email", "div1234567@gmail.com");
            payload.put("gender", "female");
            payload.put("status", "active");

            // creating object of URL and storing the url of request.
            URL url = new URL("https://gorest.co.in/public/v2/users");

            // creating an object of HttpURLConnection that provides a connection to URL.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // passing the request method as POST
            conn.setRequestMethod("POST");

            // adding some headers :
            // adding content-type as application/json in headers.
            conn.setRequestProperty("Content-Type", "application/json");

            // adding Accept as application/json in headers.
            conn.setRequestProperty("Accept", "application/json");

            //adding Authentication for the user to authenticate or to authorize the access to the
            // protected API endpoints and giving corresponding tokens.
            conn.setRequestProperty("Authorization", "Bearer 66749fba446a1a9cf5f6fac297a180fb2c2008b60c573de494af8aa49ce099ac");

           // below line means the connection is used for output purposes
            conn.setDoOutput(true);

            //it writes the payload data to the server through the output stream
            conn.getOutputStream().write(payload.toString().getBytes());

            // this below line prints the status code
            System.out.println(conn.getResponseCode());

            // creating try and catch block to handle exception and using BufferedReader
            // to read the response data from the server with the proper encoding of utf-8.
            try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))){
                String response;
                // this below line is used to continue to loop until no more lines left.
                while((response=br.readLine())!=null){
                    System.out.println(response);
                }
            }
            // below is used to disconnect the connection.
            conn.disconnect();
        }
        // handles the exception.
        catch(Exception e){
            // print the stack trace of the exception to the console
            e.printStackTrace();
        }
    }
}
