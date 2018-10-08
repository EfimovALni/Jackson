package cz.firstapp.jackson_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainActivity mainActivity = new MainActivity();

        try {
            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> studentDataMap = new HashMap<String, Object>();

            int[] marks = {4,5,3};

            Student student = new Student();
            student.setAge(25);
            student.setName("Michail");

//            Java Object
            studentDataMap.put("student", student);
//            Java String
            studentDataMap.put("name", "Michael Kamar");
//            Java Boolean
            studentDataMap.put("verified", Boolean.FALSE);
//            Array
            studentDataMap.put("marks", marks);

//            Serialize
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentDataMap);
            Log.e("^^^", jsonString);
            /* Answer:
            {
                "name" : "Michael Kamar",
                    "student" : {
                "age" : 25,
                        "name" : "Michail"
            },
                "marks" : [ 4, 5, 3 ],
                "verified" : false
            }*/

//            DeSerialize
            studentDataMap = mapper.readValue(jsonString, Map.class);
            Log.e("-------- ", String.valueOf(studentDataMap.get("name")));
            /* Answer
            Michael Kamar*/


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}


class Student {
    private int age;
    private String name;
    public Student(){}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}