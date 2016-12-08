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
    private final static String RUNNING_BACK = "RB";
    private final static String WIDE_RECEIVER = "WR";
    private final static String TIGHT_END = "TE";
    private final static String FULLBACK = "FB";
    private final static String LONG_SNAPPER = "LS";
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
    private final static String QB_RATING = "QBRating";

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
    private final static String PASSES_DEFENDED = "PassesDefended";

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

    private final static String BLOCKED_KICKS = "KB";

    private final static String FG_BLK = "FgBlk";
    private final static String FG_MADE = "FgMade";
    private final static String FG_ATT = "FgAtt";
    private final static String FG_PCT = "FgPct";
    private final static String FG_MADE_1_19 = "FgMade1_19";
    private final static String FG_ATT_1_19 = "FgAtt1_19";
    private final static String FG_1_19_PCT = "Fg1_19Pct";
    private final static String FG_MADE_20_29 = "FgMade20_29";
    private final static String FG_ATT_20_29 = "FgAtt20_29";
    private final static String FG_20_29_PCT = "Fg20_29Pct";
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
        int PassCMP = player.getAsJsonObject(STATS).getAsJsonObject(PASS_COMPLETIONS).get("#text").getAsInt();
        double PassPCT = player.getAsJsonObject(STATS).getAsJsonObject(PASS_PCT).get("#text").getAsDouble();
        int PassYds = player.getAsJsonObject(STATS).getAsJsonObject(PASS_YDS).get("#text").getAsInt();
        double PassAvg = player.getAsJsonObject(STATS).getAsJsonObject(PASS_AVG).get("#text").getAsDouble();
        double PassYdsPerAtt = player.getAsJsonObject(STATS).getAsJsonObject(PASS_YARDS_PER_ATT).get("#text").getAsDouble();
        int PassTD = player.getAsJsonObject(STATS).getAsJsonObject(PASS_TD).get("#text").getAsInt();
        double PassTDPct = player.getAsJsonObject(STATS).getAsJsonObject(PASS_TD_PCT).get("#text").getAsDouble();
        int PassInt = player.getAsJsonObject(STATS).getAsJsonObject(PASS_INT).get("#text").getAsInt();
        double PassIntPct = player.getAsJsonObject(STATS).getAsJsonObject(PASS_INT_PCT).get("#text").getAsDouble();
        int PassLng = player.getAsJsonObject(STATS).getAsJsonObject(PASS_LNG).get("#text").getAsInt();
        int Pass20Plus = player.getAsJsonObject(STATS).getAsJsonObject(PASS_20_PLUS).get("#text").getAsInt();
        int Pass40Plus = player.getAsJsonObject(STATS).getAsJsonObject(PASS_40_PLUS).get("#text").getAsInt();
        int PassSacks = player.getAsJsonObject(STATS).getAsJsonObject(PASS_SACKS).get("#text").getAsInt();
        int PassSacksY = player.getAsJsonObject(STATS).getAsJsonObject(PASS_SACK_Y).get("#text").getAsInt();
        double QBRating = player.getAsJsonObject(STATS).getAsJsonObject(QB_RATING).get("#text").getAsDouble();

        int Targets = player.getAsJsonObject(STATS).getAsJsonObject(TARGETS).get("#text").getAsInt();
        int Receptions = player.getAsJsonObject(STATS).getAsJsonObject(RECEPTIONS).get("#text").getAsInt();
        int RecYds = player.getAsJsonObject(STATS).getAsJsonObject(REC_YARDS).get("#text").getAsInt();
        double RecAvg = player.getAsJsonObject(STATS).getAsJsonObject(REC_AVERAGE).get("#text").getAsDouble();
        int RecTD = player.getAsJsonObject(STATS).getAsJsonObject(REC_TD).get("#text").getAsInt();
        int RecLng = player.getAsJsonObject(STATS).getAsJsonObject(REC_LNG).get("#text").getAsInt();
        int Rec20Plus = player.getAsJsonObject(STATS).getAsJsonObject(REC_20_PLUS).get("#text").getAsInt();
        int Rec40Plus = player.getAsJsonObject(STATS).getAsJsonObject(REC_40_PLUS).get("#text").getAsInt();
        int RecFumbles = player.getAsJsonObject(STATS).getAsJsonObject(REC_FUMBLES).get("#text").getAsInt();

        int RushAtt = player.getAsJsonObject(STATS).getAsJsonObject(RUSH_ATTEMPTS).get("#text").getAsInt();
        int RushYds = player.getAsJsonObject(STATS).getAsJsonObject(RUSH_YARDS).get("#text").getAsInt();
        double RushAvg = player.getAsJsonObject(STATS).getAsJsonObject(RUSH_AVERAGE).get("#text").getAsDouble();
        int RushTD = player.getAsJsonObject(STATS).getAsJsonObject(RUSH_TD).get("#text").getAsInt();
        int RushLng = player.getAsJsonObject(STATS).getAsJsonObject(RUSH_LNG).get("#text").getAsInt();
        int Rush20Plus = player.getAsJsonObject(STATS).getAsJsonObject(RUSH_20_PLUS).get("#text").getAsInt();
        int Rush40Plus = player.getAsJsonObject(STATS).getAsJsonObject(RUSH_40_PLUS).get("#text").getAsInt();
        int RushFumbles = player.getAsJsonObject(STATS).getAsJsonObject(RUSH_FUMBLES).get("#text").getAsInt();

        int TackleSolo = player.getAsJsonObject(STATS).getAsJsonObject(TACKLE_SOLO).get("#text").getAsInt();
        int TackleTotal = player.getAsJsonObject(STATS).getAsJsonObject(TACKLE_TOTAL).get("#text").getAsInt();
        int TackleAst = player.getAsJsonObject(STATS).getAsJsonObject(TACKLE_AST).get("#text").getAsInt();
        double Sacks = player.getAsJsonObject(STATS).getAsJsonObject(SACKS).get("#text").getAsDouble();
        int SackYds = player.getAsJsonObject(STATS).getAsJsonObject(SACK_YDS).get("#text").getAsInt();
        int Safeties = player.getAsJsonObject(STATS).getAsJsonObject(SAFETIES).get("#text").getAsInt();

        int Interceptions = player.getAsJsonObject(STATS).getAsJsonObject(INTERCEPTIONS).get("#text").getAsInt();
        int IntTD = player.getAsJsonObject(STATS).getAsJsonObject(INT_TD).get("#text").getAsInt();
        int IntYds = player.getAsJsonObject(STATS).getAsJsonObject(INT_YDS).get("#text").getAsInt();
        double IntAvg = player.getAsJsonObject(STATS).getAsJsonObject(INT_AVERAGE).get("#text").getAsDouble();
        int IntLng = player.getAsJsonObject(STATS).getAsJsonObject(INT_LNG).get("#text").getAsInt();
        int PassesDefended = player.getAsJsonObject(STATS).getAsJsonObject(PASSES_DEFENDED).get("#text").getAsInt();

        int Fumbles = player.getAsJsonObject(STATS).getAsJsonObject(FUMBLES).get("#text").getAsInt();
        int FumLost = player.getAsJsonObject(STATS).getAsJsonObject(FUM_LOST).get("#text").getAsInt();
        int FumForced = player.getAsJsonObject(STATS).getAsJsonObject(FUM_FORCED).get("#text").getAsInt();
        int FumOwnRec = player.getAsJsonObject(STATS).getAsJsonObject(FUM_OWN_REC).get("#text").getAsInt();
        int FumOppRec = player.getAsJsonObject(STATS).getAsJsonObject(FUM_OPP_REC).get("#text").getAsInt();
        int FumRecYds = player.getAsJsonObject(STATS).getAsJsonObject(FUM_REC_YDS).get("#text").getAsInt();
        int FumTotalRec = player.getAsJsonObject(STATS).getAsJsonObject(FUM_TOTAL_REC).get("#text").getAsInt();
        int FumTD = player.getAsJsonObject(STATS).getAsJsonObject(FUM_TD).get("#text").getAsInt();

        int KrRet = player.getAsJsonObject(STATS).getAsJsonObject(KR_RET).get("#text").getAsInt();
        int KrYds = player.getAsJsonObject(STATS).getAsJsonObject(KR_YDS).get("#text").getAsInt();
        double KrAvg = player.getAsJsonObject(STATS).getAsJsonObject(KR_AVG).get("#text").getAsDouble();
        int KrLng = player.getAsJsonObject(STATS).getAsJsonObject(KR_LNG).get("#text").getAsInt();
        int KrTD = player.getAsJsonObject(STATS).getAsJsonObject(KR_TD).get("#text").getAsInt();
        int Kr20Plus = player.getAsJsonObject(STATS).getAsJsonObject(KR_20_PLUS).get("#text").getAsInt();
        int Kr40Plus = player.getAsJsonObject(STATS).getAsJsonObject(KR_40_PLUS).get("#text").getAsInt();
        int KrFC = player.getAsJsonObject(STATS).getAsJsonObject(KR_FC).get("#text").getAsInt();
        int KrFum = player.getAsJsonObject(STATS).getAsJsonObject(KR_FUM).get("#text").getAsInt();

        int Kickoffs = player.getAsJsonObject(STATS).getAsJsonObject(KICKOFFS).get("#text").getAsInt();
        int KoYds = player.getAsJsonObject(STATS).getAsJsonObject(KO_YDS).get("#text").getAsInt();
        int KoOOB = player.getAsJsonObject(STATS).getAsJsonObject(KO_OOB).get("#text").getAsInt();
        double KoAvg = player.getAsJsonObject(STATS).getAsJsonObject(KO_AVG).get("#text").getAsDouble();
        int KoTB = player.getAsJsonObject(STATS).getAsJsonObject(KO_TB).get("#text").getAsInt();
        double KoPct = player.getAsJsonObject(STATS).getAsJsonObject(KO_PCT).get("#text").getAsDouble();
        int KoRet = player.getAsJsonObject(STATS).getAsJsonObject(KO_RET).get("#text").getAsInt();
        int KoRetYds = player.getAsJsonObject(STATS).getAsJsonObject(KO_RET_YDS).get("#text").getAsInt();
        double KoRetAvgYds = player.getAsJsonObject(STATS).getAsJsonObject(KO_RET_AVG_YDS).get("#text").getAsDouble();
        int KoTD = player.getAsJsonObject(STATS).getAsJsonObject(KO_TD).get("#text").getAsInt();
        int KoOS = player.getAsJsonObject(STATS).getAsJsonObject(KO_OS).get("#text").getAsInt();
        int KoOSR = player.getAsJsonObject(STATS).getAsJsonObject(KO_OSR).get("#text").getAsInt();

        int PrRet = player.getAsJsonObject(STATS).getAsJsonObject(PR_RET).get("#text").getAsInt();
        int PrYds = player.getAsJsonObject(STATS).getAsJsonObject(PR_YDS).get("#text").getAsInt();
        double PrAvg = player.getAsJsonObject(STATS).getAsJsonObject(PR_AVG).get("#text").getAsDouble();
        int PrLng = player.getAsJsonObject(STATS).getAsJsonObject(PR_LNG).get("#text").getAsInt();
        int PrTD = player.getAsJsonObject(STATS).getAsJsonObject(PR_TD).get("#text").getAsInt();
        int Pr20Plus = player.getAsJsonObject(STATS).getAsJsonObject(PR_20_PLUS).get("#text").getAsInt();
        int Pr40Plus = player.getAsJsonObject(STATS).getAsJsonObject(PR_40_PLUS).get("#text").getAsInt();
        int PrFC = player.getAsJsonObject(STATS).getAsJsonObject(PR_FC).get("#text").getAsInt();
        int PrFum = player.getAsJsonObject(STATS).getAsJsonObject(PR_FUM).get("#text").getAsInt();

        int Punts = player.getAsJsonObject(STATS).getAsJsonObject(PUNTS).get("#text").getAsInt();
        int PuntYds = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_YDS).get("#text").getAsInt();
        int PuntNetYds = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_NET_YDS).get("#text").getAsInt();
        int PuntLng = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_LNG).get("#text").getAsInt();
        double PuntAvg = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_AVG).get("#text").getAsDouble();
        double PuntNetAvg = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_NET_AVG).get("#text").getAsDouble();
        int PuntBlk = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_BLK).get("#text").getAsInt();
        int PuntOOB = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_OOB).get("#text").getAsInt();
        int PuntDown = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_DOWN).get("#text").getAsInt();
        int PuntIn20 = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_IN_20).get("#text").getAsInt();
        double PuntIn20Pct = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_IN_20_PCT).get("#text").getAsDouble();
        int PuntTB = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_TB).get("#text").getAsInt();
        double PuntTBPct = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_TB_PCT).get("#text").getAsDouble();
        int PuntFC = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_FC).get("#text").getAsInt();
        int PuntRet = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_RET).get("#text").getAsInt();
        int PuntRetYds = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_RET_YDS).get("#text").getAsInt();
        double PuntRetAvg = player.getAsJsonObject(STATS).getAsJsonObject(PUNT_RET_AVG).get("#text").getAsDouble();

        int Stuffs = player.getAsJsonObject(STATS).getAsJsonObject(STUFFS).get("#text").getAsInt();
        int StuffYds = player.getAsJsonObject(STATS).getAsJsonObject(STUFF_YDS).get("#text").getAsInt();

        int KB = player.getAsJsonObject(STATS).getAsJsonObject(BLOCKED_KICKS).get("#text").getAsInt();

        int FgBlk = player.getAsJsonObject(STATS).getAsJsonObject(FG_BLK).get("#text").getAsInt();
        int FgMade = player.getAsJsonObject(STATS).getAsJsonObject(FG_MADE).get("#text").getAsInt();
        int FgAtt = player.getAsJsonObject(STATS).getAsJsonObject(FG_ATT).get("#text").getAsInt();
        double FgPct = player.getAsJsonObject(STATS).getAsJsonObject(FG_PCT).get("#text").getAsDouble();
        int FgMade1_19 = player.getAsJsonObject(STATS).getAsJsonObject(FG_MADE_1_19).get("#text").getAsInt();
        int FgAtt1_19 = player.getAsJsonObject(STATS).getAsJsonObject(FG_ATT_1_19).get("#text").getAsInt();
        double Fg1_19Pct = player.getAsJsonObject(STATS).getAsJsonObject(FG_1_19_PCT).get("#text").getAsDouble();
        int FgMade20_29 = player.getAsJsonObject(STATS).getAsJsonObject(FG_MADE_20_29).get("#text").getAsInt();
        int FgAtt20_29 = player.getAsJsonObject(STATS).getAsJsonObject(FG_ATT_20_29).get("#text").getAsInt();
        double Fg20_29Pct = player.getAsJsonObject(STATS).getAsJsonObject(FG_20_29_PCT).get("#text").getAsDouble();
        int FgMade30_39 = player.getAsJsonObject(STATS).getAsJsonObject(FG_MADE_30_39).get("#text").getAsInt();
        int FgAtt30_39 = player.getAsJsonObject(STATS).getAsJsonObject(FG_ATT_30_39).get("#text").getAsInt();
        double Fg30_39Pct = player.getAsJsonObject(STATS).getAsJsonObject(FG_30_39_PCT).get("#text").getAsDouble();
        int FgMade40_49 = player.getAsJsonObject(STATS).getAsJsonObject(FG_MADE_40_49).get("#text").getAsInt();
        int FgAtt40_49 = player.getAsJsonObject(STATS).getAsJsonObject(FG_ATT_40_49).get("#text").getAsInt();
        double Fg40_49Pct = player.getAsJsonObject(STATS).getAsJsonObject(FG_40_49_PCT).get("#text").getAsDouble();
        int FgMade50Plus = player.getAsJsonObject(STATS).getAsJsonObject(FG_MADE_50_PLUS).get("#text").getAsInt();
        int FgAtt50Plus = player.getAsJsonObject(STATS).getAsJsonObject(FG_ATT_50_PLUS).get("#text").getAsInt();
        double Fg50PlusPct = player.getAsJsonObject(STATS).getAsJsonObject(FG_50_PLUS_PCT).get("#text").getAsDouble();
        int FgLng = player.getAsJsonObject(STATS).getAsJsonObject(FG_LNG).get("#text").getAsInt();

        int XpBlk = player.getAsJsonObject(STATS).getAsJsonObject(XP_BLK).get("#text").getAsInt();
        int XpMade = player.getAsJsonObject(STATS).getAsJsonObject(XP_MADE).get("#text").getAsInt();
        int XpAtt = player.getAsJsonObject(STATS).getAsJsonObject(XP_ATT).get("#text").getAsInt();
        double XpPct = player.getAsJsonObject(STATS).getAsJsonObject(XP_PCT).get("#text").getAsDouble();

        int TwoPtAtt = player.getAsJsonObject(STATS).getAsJsonObject(TWO_PT_ATT).get("#text").getAsInt();
        int TwoPtMade = player.getAsJsonObject(STATS).getAsJsonObject(TWO_PT_MADE).get("#text").getAsInt();
        int TwoPtPassAtt = player.getAsJsonObject(STATS).getAsJsonObject(TWO_PT_PASS_ATT).get("#text").getAsInt();
        int TwoPtPassMade = player.getAsJsonObject(STATS).getAsJsonObject(TWO_PT_PASS_MADE).get("#text").getAsInt();
        int TwoPtPassRec = player.getAsJsonObject(STATS).getAsJsonObject(TWO_PT_PASS_REC).get("#text").getAsInt();
        int TwoPtRushAtt = player.getAsJsonObject(STATS).getAsJsonObject(TWO_PT_RUSH_ATT).get("#text").getAsInt();
        int TwoPtRushMade = player.getAsJsonObject(STATS).getAsJsonObject(TWO_PT_RUSH_MADE).get("#text").getAsInt();

        System.out.println(GP);


        //System.out.println(player.getAsJsonObject(STATS));
        if(playerPosition.equals(LONG_SNAPPER)){
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

        } else if(playerPosition.equals(RUNNING_BACK) || playerPosition.equals(WIDE_RECEIVER) || playerPosition.equals(TIGHT_END) || playerPosition.equals(FULLBACK)){

        } else {

        }
    }

    public void persist(JsonObject jsonObject) {

    }
}
