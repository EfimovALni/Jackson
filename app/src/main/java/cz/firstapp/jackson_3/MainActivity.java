package cz.firstapp.jackson_3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String jsonResponce = "{\"status\":\"OK\",\"actual_version\":0.01,\"configuartion\":{\"initial_screen\":[{\"color\":\"#0000ff\",\"text\":\"software\",\"icon\":\"data:image/png;base64,iVB=\"},{\"color\":\"#0000ff\",\"text\":\"citrix\",\"icon\":\"data:image/png;base64,iVBO+A=\"},{\"color\":\"#0000ff\",\"text\":\"equipment\",\"icon\":\"data:image/png;base64,iVB=\"}]}}";

        Configuration config = new Configuration();
        ObjectMapper mapper = new ObjectMapper();
        String json_1 = "{\"status\":\"OK\",\"actual_version\":0.01}";
//        String json_2 = "{\"status\":\"OK\",\"actual_version\":0.01,\"configuartion\":{\"initial_screen\":[]}}";


        try {
//            Deserialize
            Configuration configuration = mapper.readValue(json_1, Configuration.class);
            Log.e("json_1 (DeSer)", configuration.toString());
            Log.e("json_1. Status ", configuration.getStatus() + ". Actual version: " + configuration.getActual_version());







////            Serialize
//            json_1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(config);
//            Log.e("json_1 (Ser)", json_1);




        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}


class Configuration {
    private String status;
    private double actual_version;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getActual_version() {
        return actual_version;
    }

    public void setActual_version(double actual_version) {
        this.actual_version = actual_version;
    }

    @NonNull
    @Override
    public String toString() {
        return "Configuration{" +
                "status='" + status + '\'' +
                ", actual_version=" + actual_version +
                '}';
    }
}


