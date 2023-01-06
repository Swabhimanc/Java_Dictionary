package com.example.google_dictionary;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class InternetConnection
{
    public String getOnlineData(String word)
    {
        String data="";
        try
        {
            URL url=new URL("https://api.dictionaryapi.dev/api/v1/entries/en/"+word);

            HttpsURLConnection con= (HttpsURLConnection) url.openConnection();

            if(con.getResponseCode()==200)
            {
                InputStream im=con.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(im));
                String line=br.readLine();
                while(line!=null)
                {
                    data+=line;
                    line=br.readLine();
                }
                br.close();
            }
            else
            {
                System.out.println("Internet Connection Error");
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        JSONDecoder decode=new JSONDecoder();
        String decodedData=decode.decodeData(data);
        return decodedData;
    }
}
