package cz.firstapp.jackson_3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String jsonResponce = "{\"status\":\"OK\",\"actual_version\":0.01,\"configuartion\":{\"initial_screen\":[{\"color\":\"#0000ff\",\"text\":\"software\",\"icon\":\"data:image/png;base64,iVB=\"},{\"color\":\"#0000ff\",\"text\":\"citrix\",\"icon\":\"data:image/png;base64,iVBO+A=\"},{\"color\":\"#0000ff\",\"text\":\"equipment\",\"icon\":\"data:image/png;base64,iVB=\"}]}}";

        Configuration config = new Configuration();
        ObjectMapper mapper = new ObjectMapper();
        String json_1 = "{\"status\":\"OK\",\"actual_version\":0.01}";
        String json_2 = "{\"status\":\"OK\",\"actual_version\":0.01,\"configuartion\":{\"initial_screen\":[]}}";
        String json_3 = "{\"status\":\"OK\",\"actual_version\":0.01,\"configuartion\":{\"initial_screen\":[{\"color\":\"#0000ff\",\"text\":\"software\",\"icon\":\"data:image/png;base64,iVB=\"}]}}";
        String json_4 = "{\"status\":\"OK\",\"actual_version\":0.01,\"configuartion\":{\"initial_screen\":[{\"color\":\"#0000ff\",\"text\":\"software\",\"icon\":\"data:image/png;base64,iVB=\"},{\"color\":\"#0000ff\",\"text\":\"citrix\",\"icon\":\"data:image/png;base64,iVBO+A=\"},{\"color\":\"#0000ff\",\"text\":\"equipment\",\"icon\":\"data:image/png;base64,iVB=\"}]}}";


        try {
//            Deserialize
            Configuration configuration = mapper.readValue(json_4, Configuration.class);

            Log.e("json_4_1 ", configuration.toString());
            Log.e("json_4_2 ", configuration.getConfiguartion().getInitial_screen().get(0).getColor());
            Log.e("json_4_2 ", configuration.getConfiguartion().getInitial_screen().get(0).getText());
            Log.e("json_4_2 ", configuration.getConfiguartion().getInitial_screen().get(0).getIcon());

            String color = "", text = "", icon =  "";
            int lenghtOfInitialScren = configuration.getConfiguartion().getInitial_screen().size();
            for (int i = 0; i < lenghtOfInitialScren; i++) {
                color += configuration.getConfiguartion().getInitial_screen().get(i).getColor();
                text += configuration.getConfiguartion().getInitial_screen().get(i).getText();
                icon += configuration.getConfiguartion().getInitial_screen().get(i).getIcon();
            }
            Log.e("\nColor ", color + ", " + "\nText " + text + ",\nIcon " + icon);





//            Log.e("json_2 ", configuration.toString());
//            Log.e("json_2. Status ", configuration.getStatus() + ". Actual version: " + configuration.getActual_version() +
//                    ". Initial screen: " + configuration.getConfiguartion().getInitial_screen());



//            Log.e("json_1 (DeSer)", configuration.toString());
//            Log.e("json_1. Status ", configuration.getStatus() + ". Actual version: " + configuration.getActual_version());







////            Serialize
//            json_1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(config);
//            Log.e("json_1 (Ser)", json_1);


            /*
            Создайте классы. К примеру DataResponse с полями
            status: String,
                actual_version: Float,
                configuration: Configuration.
            Потом Configuration с полем
                initial_screen: List<ScreenElement>.
            И класс ScreenElement с полями
                color: String,
                text: String,
                icon: String
                    */

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}


class Configuration {
    private String status;
    private Float actual_version;
    private Configuartion configuartion;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getActual_version() {
        return actual_version;
    }

    public void setActual_version(Float actual_version) {
        this.actual_version = actual_version;
    }

    public Configuartion getConfiguartion() {
        return configuartion;
    }

    public void setConfiguartion(Configuartion configuartion) {
        this.configuartion = configuartion;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "status='" + status + '\'' +
                ", actual_version=" + actual_version +
                ", configuartion=" + configuartion +
                '}';
    }
}


class Configuartion {
    private List<Initial_screen> initial_screen; // !!!!!!Заменить на "Screen Eelements"!!!!!!!!!

    public List<Initial_screen> getInitial_screen() {
        return initial_screen;
    }

    public void setInitial_screen(List<Initial_screen> initial_screen) {
        this.initial_screen = initial_screen;
    }

    @Override
    public String toString() {
        return "Configuartion{" +
                "initial_screen=" + initial_screen +
                '}';
    }
}


class Initial_screen {
    private String color;
    private String text;
    private String icon;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    @Override
    public String toString() {
        return "Initial_screen{" +
                "color='" + color + '\'' +
                ", text='" + text + '\'' +
                ", icon=" + icon +
                '}';
    }

}





