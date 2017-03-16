package ie.sumitdawar.app.simplex;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRequest extends StringRequest {
    private static final String CONVERSION_REQUEST_URL = "http://simplexservices.xyz/Conversion.php";
    private Map<String, String> params;

    public ExchangeRequest(String amount, String from, String to, Response.Listener<String> listener) {
        super(Method.POST, CONVERSION_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("amount", amount);
        params.put("from", from);
        params.put("to", to);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}