package com.example.appbdjson.iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbdjson.Model.Character;
import com.example.appbdjson.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class AdapterRecicler extends RecyclerView.Adapter<AdapterRecicler.ViewHolder> {
    ArrayList<Character> characters;
    public AdapterRecicler(){
        this.characters = new ArrayList<Character>();
    }

    public void setCharacters(final ArrayList<Character> listcharacters) {
        this.characters.clear();
        this.characters = listcharacters;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterRecicler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapterlist, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecicler.ViewHolder holder, int position) {
        Character ch = characters.get(position);

        holder.name.setText(ch.getName());
        holder.specie.setText(ch.getSpecies());
        holder.gender.setText(ch.getGender());
        holder.serie.setText(ch.getStatus());
        Picasso.with(holder.image.getContext()).load(ch.getImage()).resize(100,100).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView gender;
        private TextView specie;
        private TextView serie;
        private ImageView image;

        public ViewHolder(@NonNull View view) {
            super(view);

            name = view.findViewById(R.id.name);
            gender = view.findViewById(R.id.gender);
            specie = view.findViewById(R.id.especie);
            serie = view.findViewById(R.id.serie);
            image = view.findViewById(R.id.image);
        }
    }
}
