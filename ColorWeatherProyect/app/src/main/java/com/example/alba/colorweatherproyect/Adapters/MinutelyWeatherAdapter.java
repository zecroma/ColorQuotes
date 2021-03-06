package com.example.alba.colorweatherproyect.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alba.colorweatherproyect.Minute;
import com.example.alba.colorweatherproyect.R;

import java.util.ArrayList;

/**
 * Created by Alba on 01/02/2017.
 */

public class MinutelyWeatherAdapter extends RecyclerView.Adapter{

    Context context;
    ArrayList<Minute> minutes;

    public MinutelyWeatherAdapter(Context context, ArrayList<Minute> minutes){
        this.context = context;
        this.minutes = minutes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.minutely_list_item, parent, false);

        MinuteViewHolder minuteViewHolder = new MinuteViewHolder(view);

        return minuteViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((MinuteViewHolder)holder).onBind(position);

    }

    @Override
    public int getItemCount() { // Devuelve el numero de elementos.

        if(minutes == null){
            return 0;
        }else{
            return minutes.size();
        }
    }

    class MinuteViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;
        TextView rainProbabilityTextView;

        public MinuteViewHolder(View itemView) {
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.minutelyTitleTextView);
            rainProbabilityTextView = (TextView) itemView.findViewById(R.id.minutelyRainProbabilityTextView);
        }

        public void onBind(int position){

            Minute minute = minutes.get(position);

            titleTextView.setText(minute.getTitle());
            rainProbabilityTextView.setText(minute.getRainProbability());

        }

    }

}
