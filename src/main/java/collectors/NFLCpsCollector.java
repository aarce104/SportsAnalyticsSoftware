package collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import utils.JsonUtils;

/**
 * Created by Abe on 11/2/16.
 */
public class NFLCpsCollector implements CollectorGeneric {

    private final static String PLAYER = "player";
    private final static String PUNTER = "P";
    private final static String QUARTERBACK = "QB";
    private final static String KICKER = "K";
    private final static String RUNNINGBACK = "RB";
    private final static String WIDE_RECEIVER = "WR";
    private final static String TIGHTEND = "TE";
    private final static String FULLBACK = "FB";
    private final static String LONGSNAPPER = "LS";
    private final static String POSITION = "Position";
    private final static String ID = "ID";
    private final static String TEAM = "team";
    private final static String STATS = "stats";
    private final static String GAMES_PLAYED = "GamesPlayed";
    private final static String PASS_ATTEMPTS = "PassAttempts";
    private final static String PASS_COMPLETIONS = "PassCompletions";
    private final static String PASS_PCT = "PassPct";
    private final static String PASS_YDS = "PassYards";
    PassInt PassIntPct
    PassLng Pass20Plus
    Pass40Plus PassSacks
    PassSackY QBRating
    private final static String PASS_AVG = "PassAvg";
    private final static String PASS_YARDS_PER_ATT = "PassYdsPerAtt";
    private final static String PASS_TD = "PassTD";
    private final static String PASS_TD_PCT = "PassTDPct";
    private final static String PASS_INT = "PassInt";
    private final static String PASS_INT_PCT
    private final static String PASS_LNG
    private final static String PASS_20_PLUS
    private final static String PASS_40_PLUS
    private final static String PASS_SACKS
    private final static String PASS_SACK_Y
    private final static String QBR_RATING





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
        JsonObject playerJson = new JsonObject();
        String playerPosition = player.getAsJsonObject(PLAYER).get(POSITION).getAsString();
        int GP = player.getAsJsonObject(STATS).getAsJsonObject(GAMES_PLAYED).get("#text").getAsInt();
        int PassAtt = player.getAsJsonObject(STATS).getAsJsonObject(PASS_ATTEMPTS).get("#text").getAsInt();
        System.out.println(GP);


        //System.out.println(player.getAsJsonObject(STATS));
        if(playerPosition.equals(LONGSNAPPER)){
            player.getAsJsonObject(PLAYER).remove(ID);
            player.getAsJsonObject(TEAM).remove(ID);
            playerJson.add("player", player.getAsJsonObject(PLAYER));
            playerJson.add("team", player.getAsJsonObject(TEAM));
            //System.out.println(playerJson);
            //System.out.println(player.getAsJsonObject(TEAM));
            //System.out.print(player);
            //System.out.println("true");
        } else if (playerPosition.equals(PUNTER)) {

        } else if (playerPosition.equals(QUARTERBACK)){

        } else if(playerPosition.equals(KICKER)){

        } else if(playerPosition.equals(RUNNINGBACK) || playerPosition.equals(WIDE_RECEIVER) || playerPosition.equals(TIGHTEND) || playerPosition.equals(FULLBACK)){

        } else {

        }
    }

    public void persist(JsonObject jsonObject) {

    }
}
