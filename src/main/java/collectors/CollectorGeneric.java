package collectors;

import com.google.gson.JsonObject;

/**
 * Created by Abe on 11/2/16.
 */
public interface CollectorGeneric {

    public JsonObject enrichJson(String jsonStr);

    public void persist(JsonObject jsonObject);
}
