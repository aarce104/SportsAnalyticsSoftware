package utils;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Abe on 10/24/16.
 */
public class ServiceUtils {

    private ServiceUtils(){

    }

    public static Client getJerseyClient(String uname, String pword) {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                .nonPreemptive()
                .credentials(uname, pword)
                .build();
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);

        return ClientBuilder.newClient(clientConfig);
    }

    public static TransportClient getTransportClient() throws UnknownHostException {
        Settings settings = Settings.settingsBuilder()
                .put("client.transport.sniff", true)
                .put("cluster.name", "sportsClusterDEV1")
                .build();
        return TransportClient.builder()
                .settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
    }
}

