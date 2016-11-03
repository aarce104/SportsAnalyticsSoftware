package entry;


import com.google.gson.JsonObject;
import org.elasticsearch.client.transport.TransportClient;
import utils.JsonUtils;
import utils.ServiceUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Scanner;


/**
 * Created by Abraham on 10/6/16.
 */

public class SportsBettingMain {
    public static void main(String[] args) throws IOException {
        //ServiceUtils serviceUtils = new ServiceUtils();
        String uname, pword;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter username ");
        uname = in.next();
        System.out.println("password ");
        pword = in.next();
        Client client = ServiceUtils.getJerseyClient(uname, pword);
        TransportClient transportClient = ServiceUtils.getTransportClient();
        Response response = client.target("https://www.mysportsfeeds.com/api/feed/pull/nfl/2016-2017-regular/cumulative_player_stats.json?force=true")
                .request()
                .get();
        String playerstats2016 = response.readEntity(String.class);
        JsonObject jsonObj = JsonUtils.getAsJsonObject(playerstats2016);


        for (int i = 1; i < 2; i++) {
            JsonObject temp = jsonObj.getAsJsonObject("cumulativeplayerstats")
                    .getAsJsonArray("playerstatsentry").get(i).getAsJsonObject()
                    .getAsJsonObject("player");
            temp.remove("ID");
            System.out.println(temp);

            //temp.get("player");
            /*oint val = temp.get("stats").get("GamesPlayed").get("#text");
            temp.get("stats").delete("GamesPlayer");
            temp.get("Stats").put("GP" : va);k*/

        }


        /*while (true) {
            scanner.readin val;
            request with val in string
        }*/
    }
}

