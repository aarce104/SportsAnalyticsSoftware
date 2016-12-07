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
    private final static String PASS_AVG = "PassAvg";
    private final static String PASS_YARDS_PER_ATT = "PassYdsPerAtt";
    private final static String PASS_TD = "PassTD";
    private final static String PASS_TD_PCT = "PassTDPct";
    private final static String PASS_INT = "PassInt";
    private final static String PASS_INT_PCT = "PassIntPct";
    private final static String PASS_LNG = "PassLng";
    private final static String PASS_20_PLUS = "Pass20Plus";
    private final static String PASS_40_PLUS = "Pass40Plus";
    private final static String PASS_SACKS = "PassSacks";
    private final static String PASS_SACK_Y = "PassSackY";
    private final static String QBR_RATING = "QBRating";

    private final static String TARGETS = "Targets";
    private final static String RECEPTIONS = "Receptions";
    private final static String REC_YARDS = "RecYards";
    private final static String REC_AVERAGE = "RecAverage";
    private final static String REC_TD = "RecTD";
    private final static String REC_LNG = "RecLng";
    private final static String REC_20_PLUS = "Rec20Plus";
    private final static String REC_40_PLUS = "Rec40Plus";
    private final static String REC_FUMBLES = "RecFumbles";

    private final static String RUSH_ATTEMPTS = "RushAttempts";
    private final static String RUSH_YARDS = "RushYards";
    private final static String RUSH_AVERAGE = "RushAverage";
    private final static String RUSH_TD = "RushTD";
    private final static String RUSH_LNG = "RushLng";
    private final static String RUSH_20_PLUS = "Rush20Plus";
    private final static String RUSH_40_PLUS = "Rush40Plus";
    private final static String RUSH_FUMBLES = "RushFumbles";

    private final static String TACKLE_SOLO = "TackleSolo";
    private final static String TACKLE_TOTAL = "TackleTotal";
    private final static String TACKLE_AST = "TackleAst";
    private final static String SACKS = "Sacks";
    private final static String SACK_YDS = "SackYds";
    private final static String SAFETIES = "Safeties";

    private final static String INTERCEPTIONS = "Interceptions";
    private final static String INT_TD = "IntTD";
    private final static String INT_YDS = "IntYds";
    private final static String INT_AVERAGE = "IntAverage";
    private final static String INT_LNG = "IntLng";
    private final static String PASSED_DEFENDED = "PassesDefended";

    private final static String FUMBLES = "Fumbles";
    private final static String FUM_LOST = "FumLost";
    private final static String FUM_FORCED = "FumForced";
    private final static String FUM_OWN_REC = "FumOwnRec";
    private final static String FUM_OPP_REC = "FumOppRec";
    private final static String FUM_REC_YDS = "FumRecYds";
    private final static String FUM_TOTAL_REC = "FumTotalRec";
    private final static String FUM_TD = "FumTD";

    private final static String KR_RET = "KrRet";
    private final static String KR_YDS = "KrYds";
    private final static String KR_AVG = "KrAvg";
    private final static String KR_LNG = "KrLng";
    private final static String KR_TD = "KrTD";
    private final static String KR_20_PLUS = "Kr20Plus";
    private final static String KR_40_PLUS = "Kr40Plus";
    private final static String KR_FC = "KrFC";
    private final static String KR_FUM = "KrFum";

    private final static String KICKOFFS = "Kickoffs";
    private final static String KO_YDS = "KoYds";
    private final static String KO_OOB = "KoOOB";
    private final static String KO_AVG = "KoAvg";
    private final static String KO_TB = "KoTB";
    private final static String KO_PCT = "KoPct";
    private final static String KO_RET = "KoRet";
    private final static String KO_RET_YDS = "KoRetYds";
    private final static String KO_RET_AVG_YDS = "KoRetAvgYds";
    private final static String KO_TD = "KoTD";
    private final static String KO_OS = "KoOS";
    private final static String KO_OSR = "KoOSR";

    private final static String PR_RET = "PrRet";
    private final static String PR_YDS = "PrYds";
    private final static String PR_AVG = "PrAvg";
    private final static String PR_LNG = "PrLng";
    private final static String PR_TD = "PrTD";
    private final static String PR_20_PLUS = "Pr20Plus";
    private final static String PR_40_PLUS = "Pr40Plus";
    private final static String PR_FC = "PrFC";
    private final static String PR_FUM = "PrFum";

    private final static String PUNTS = "Punts";
    private final static String PUNT_YDS = "PuntYds";
    private final static String PUNT_NET_YDS = "PuntNetYds";
    private final static String PUNT_LNG = "PuntLng";
    private final static String PUNT_AVG = "PuntAvg";
    private final static String PUNT_NET_AVG = "PuntNetAvg";
    private final static String PUNT_BLK = "PuntBlk";
    private final static String PUNT_OOB = "PuntOOB";
    private final static String PUNT_DOWN = "PuntDown";
    private final static String PUNT_IN_20 = "PuntIn20";
    private final static String PUNT_IN_20_PCT = "PuntIn20Pct";
    private final static String PUNT_TB = "PuntTB";
    private final static String PUNT_TB_PCT = "PuntTBPct";
    private final static String PUNT_FC = "PuntFC";
    private final static String PUNT_RET = "PuntRet";
    private final static String PUNT_RET_YDS = "PuntRetYds";
    private final static String PUNT_RET_AVG = "PuntRetAvg";

    private final static String STUFFS = "Stuffs";
    private final static String STUFF_YDS = "StuffYds";

    private final static String KB = "KB";

    private final static String FG_BLK = "FgBlk";
    private final static String FG_MADE = "FgMade";
    private final static String FG_ATT = "FgAtt";
    private final static String FG_PCT = "FgPct";
    private final static String FG_MADE_1_19 = "FgMade1_19";
    private final static String FG_ATT_1_19 = "FgAtt1_19";
    private final static String FG_1_19_PCT = "Fg1_19Pct";
    private final static String FG_MADE_20_29 = "FgMade20_29";
    private final static String FG_ATT_20_29 = "FgAtt20_29";
    private final static String FG_20_29 = "Fg20_29Pct";
    private final static String FG_MADE_30_39 = "FgMade30_39";
    private final static String FG_ATT_30_39 = "FgAtt30_39";
    private final static String FG_30_39_PCT = "Fg30_39Pct";
    private final static String FG_MADE_40_49 = "FgMade40_49";
    private final static String FG_ATT_40_49 = "FgAtt40_49";
    private final static String FG_40_49_PCT = "Fg40_49Pct";
    private final static String FG_MADE_50_PLUS = "FgMade50Plus";
    private final static String FG_ATT_50_PLUS = "FgAtt50Plus";
    private final static String FG_50_PLUS_PCT = "Fg50PlusPct";
    private final static String FG_LNG = "FgLng";

    private final static String XP_BLK = "XpBlk";
    private final static String XP_MADE = "XpMade";
    private final static String XP_ATT = "XpAtt";
    private final static String XP_PCT = "XpPct";

    private final static String TWO_PT_ATT = "TwoPtAtt";
    private final static String TWO_PT_MADE = "TwoPtMade";
    private final static String TWO_PT_PASS_ATT = "TwoPtPassAtt";
    private final static String TWO_PT_PASS_MADE = "TwoPtPassMade";
    private final static String TWO_PT_PASS_REC = "TwoPtPassRec";
    private final static String TWO_PT_RUSH_ATT = "TwoPtRushAtt";
    private final static String TWO_PT_RUSH_MADE = "TwoPtRushMade";





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
