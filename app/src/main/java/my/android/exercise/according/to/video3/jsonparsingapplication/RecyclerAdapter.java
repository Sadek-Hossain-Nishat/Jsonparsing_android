package my.android.exercise.according.to.video3.jsonparsingapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;

    private List<Datasetfromjson> list;
    private Datasetfromjson datasetfromjson;



    public RecyclerAdapter(Context context, List<Datasetfromjson> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        datasetfromjson=list.get(position);
        String title=datasetfromjson.getTitle();
        String description=datasetfromjson.getDescription();
        holder.titletextview.setText(title);
        holder.descriptiontextview.setText(description);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titletextview,descriptiontextview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titletextview=itemView.findViewById(R.id.titleid);
            descriptiontextview=itemView.findViewById(R.id.descriptionid);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,SecondActivity.class);
                    intent.putExtra("title",titletextview.getText().toString());
                    intent.putExtra("description",descriptiontextview.getText().toString());
                    context.startActivity(intent);


                }
            });

        }
    }
}
