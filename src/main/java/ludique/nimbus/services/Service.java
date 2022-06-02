package ludique.nimbus.services;

import ludique.nimbus.Nimbus;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public abstract class Service {

    private static final String _apiUrl = Objects.requireNonNull(JavaPlugin.getPlugin(Nimbus.class).getConfig().getString("api_public_url"));
    private static final int _connectTimeout = Integer.parseInt(Objects.requireNonNull(JavaPlugin.getPlugin(Nimbus.class).getConfig().getString("api_connect_timeout")));
    private static final int _readTimeout = Integer.parseInt(Objects.requireNonNull(JavaPlugin.getPlugin(Nimbus.class).getConfig().getString("api_read_timeout")));

    private static void _execute(String p_method, String p_path) {
        String urlTemp = _apiUrl.concat(p_path);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlTemp)).build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    protected static void get(String p_path) {
        _execute("GET", p_path);
    }

    protected static void post(String p_path, JSONObject data) {

    }

}
