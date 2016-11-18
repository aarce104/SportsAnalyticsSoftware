package collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import utils.JsonUtils;

/**
 * Created by Abe on 11/2/16.
 */
public class NFLCpsCollector implements CollectorGeneric {
    //the_

    public NFLCpsCollector() {

    }

    public JsonObject enrichJson(String jsonStr) {
        JsonArray playerStatsEntry = JsonUtils.getAsJsonObject(jsonStr).
                getAsJsonObject("cumulativeplayerstats")
                .getAsJsonArray("playerstatsentry");
        for (JsonElement elem : playerStatsEntry) {
            enrichPlayer(elem.getAsJsonObject());

        }

        //extract json array from string
        // for each player, enrich
        return null;
    }

    public void enrichPlayer(JsonObject player) {
        player.getAsJsonObject("player").remove("ID");
        player.getAsJsonObject("team").remove("ID");
        player.getAsJsonObject("team").addProperty("ID", 23);
        //player.getAsJsonObject("stats")

        System.out.println(player);

    }

    public void persist(JsonObject jsonObject) {

    }
}
