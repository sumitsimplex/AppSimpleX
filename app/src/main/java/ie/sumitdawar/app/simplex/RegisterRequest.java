package ie.sumitdawar.app.simplex;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://simplexservices.xyz/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String email, String username, String password, String country, String phone, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("full_name", name);
        params.put("email", email);
        params.put("username", username);
        params.put("password", password);
        params.put("country", country);
        params.put("phone", phone);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
