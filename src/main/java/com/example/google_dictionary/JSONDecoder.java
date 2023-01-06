package com.example.google_dictionary;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class JSONDecoder
{
    public String decodeData(String encoded)
    {
        String deData="";
        try
        {
            Object obj=JSONValue.parse(encoded);

            JSONArray jArray= (JSONArray) obj;

            JSONObject jObject= (JSONObject) jArray.get(0);

            deData=deData+"Word:- "+jObject.get("word")+"\n";
            JSONObject meaning= (JSONObject) jObject.get("meaning");


            JSONArray noun= (JSONArray) meaning.get("noun");
            if(noun!=null)
            {
                JSONObject nounParameters= (JSONObject) noun.get(0);
                deData=deData+"\nParts of Speech:- Noun";
                deData=deData+"\nDefinition:- "+nounParameters.get("definition");
                deData=deData+"\nExample:- "+nounParameters.get("example")+"\n";
            }
            JSONArray verb= (JSONArray) meaning.get("verb");
            if(verb!=null)
            {
                JSONObject verbParameters= (JSONObject) verb.get(0);
                deData=deData+"\nParts of Speech:- Verb";
                deData=deData+"\nDefinition:- "+verbParameters.get("definition");
                deData=deData+"\nExample:- "+verbParameters.get("example")+"\n";
            }
            JSONArray adj = (JSONArray) meaning.get("adjective");
            if(adj!=null)
            {
                JSONObject adjParameters = (JSONObject) adj.get(0);
                deData = deData + "\nParts of Speech:- Adjective";
                deData = deData + "\nDefinition:- " + adjParameters.get("definition");
                deData = deData + "\nExample:- " + adjParameters.get("example") + "\n";
            }
        }
        catch(Exception e)
        {
            deData="error";
        }

        return deData;
    }
}
