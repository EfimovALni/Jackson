package cz.firstapp.jackson_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        String jsonString_2 =   "{\"id\":\"1\",\"level\":\"3\",\"name\":\"KI Group\",\"type\":\"true\"}";

        //map json to student
        try {

            Student student = mapper.readValue(jsonString, Student.class);

            Log.e("Student\t", student.toString());

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            Log.e("Response ", jsonString);


//            Desirialize
            Sponsors sponsors =  mapper.readValue(jsonString_2, Sponsors.class);
            Log.e("Desirialize 'sponsors'", "Name: " + sponsors);
            Log.e("Desirialize 'sponsors'", "Name: " + sponsors.name + "\nid: " + sponsors.id);

//            Serialize
            jsonString_2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sponsors);
            Log.e("Serialize 'sponsors'", jsonString_2);


        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


class Student {
    private String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student [ name: " + name + ", age: " + age + " ]";
    }
}

class Sponsors {
    String description;
    int id;
    int level;
    String name;
    boolean type;

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public boolean isType() {
        return type;
    }

    @Override
    public String toString() {
        return "sponsors{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}