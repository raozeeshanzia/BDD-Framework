package Util;

import org.json.JSONObject;

public class JsonReader {

    public static int getValueOfKey(JSONObject obj){
        var newObj = obj.getJSONObject("boardgames");
        var arrayData = newObj.getJSONArray("boardgame");
        JSONObject firstObject = (JSONObject) arrayData.get(0);
        return (int) firstObject.get("objectid");
    }
}
