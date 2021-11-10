package my.android.exercise.according.to.video3.jsonparsingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Datasetfromjson> datasetfromjsonList=new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            addItemfromJson();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        recyclerView =findViewById(R.id.recyclerviewid);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        recyclerAdapter=new RecyclerAdapter(this,datasetfromjsonList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

    }

    private void addItemfromJson() throws IOException, JSONException {
        String jsondatastring=readDatafromJsonFile();
        JSONArray jsonArray=new JSONArray(jsondatastring);
        for (int i=0;i<=jsonArray.length();i++){
            JSONObject itemobject=jsonArray.getJSONObject(i);
            String title=itemobject.getString("title");
            String description=itemobject.getString("description");
            Datasetfromjson datasetfromjson=new Datasetfromjson(title,description);
            datasetfromjsonList.add(datasetfromjson);
        }

    }

    private String readDatafromJsonFile() throws IOException {
        InputStream inputStream=null;
        StringBuilder builder=new StringBuilder();
        try {
            String jsonString=null;
            inputStream=getResources().openRawResource(R.raw.localfile);
            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(inputStream,"UTF-8")
            );
            while ((jsonString=bufferedReader.readLine())!=null){
                builder.append(jsonString);
            }

        }
        finally {
            if (inputStream!=null){
                inputStream.close();
            }
        }
        return new String(builder);
    }
}