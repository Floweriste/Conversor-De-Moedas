import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMoedas {

    public static double converter(String de, String para, double valor) throws Exception {
        String endpoint = "https://open.er-api.com/v6/latest/" + de;
        URL url = new URL(endpoint);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");

        InputStreamReader leitor = new InputStreamReader(conexao.getInputStream());
        MoedaResponse resposta = new Gson().fromJson(leitor, MoedaResponse.class);
        leitor.close();

        if (resposta.getRates() == null || !resposta.getRates().containsKey(para)) {
            throw new Exception("Conversão não disponível para " + para);
        }

        double taxa = resposta.getRates().get(para);
        return valor * taxa;
    }
}
