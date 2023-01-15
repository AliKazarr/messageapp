package com.example.realtimechapapp.ui.grupoluştur;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.realtimechapapp.GrupMoldel;
import com.example.realtimechapapp.R;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class GrupAdapter extends RecyclerView.Adapter<GrupAdapter.GrupViewHolder> {


    List<GrupMoldel> grupMoldelList ;
    public GrupAdapter(List<GrupMoldel> grupMoldelList) {

        this.grupMoldelList=grupMoldelList;

    }
    @NonNull
    @Override
    public  GrupAdapter.GrupViewHolder onCreateViewHolder (@NonNull ViewGroup parent , int viewType) {


         GrupViewHolder grupViewHolder=new GrupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grupolustur_grup, parent, false));
                 return grupViewHolder;
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull GrupViewHolder holder, int position) {
        GrupMoldel grupMoldel=grupMoldelList.get(position);
               holder.setData(grupMoldel);
    }


    @Override
    public int getItemCount() {
        return grupMoldelList.size();
    }


    public class GrupViewHolder extends RecyclerView.ViewHolder
    {
        TextView grupAdı,grupAciklamasi;
         ImageView grupResmi;
        public GrupViewHolder (View itemView)
        {
            super(itemView);
            grupResmi=itemView.findViewById(R.id.grupolustur_grup_resim);
            grupAdı=itemView.findViewById(R.id.grupolustur_grup_adı);
            grupAciklamasi=itemView.findViewById(R.id.grupolustur_grup_aciklama);

        }

        public void setData(GrupMoldel grupMoldel) {

            grupAdı.setText(grupMoldel.getGrupAdi());
            grupAciklamasi.setText(grupMoldel.getGrupAciklamasi());

            if(grupMoldel.getGrupResmi()!=null)
            {

            }
        }
    }

}
