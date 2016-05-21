package com.omunguia.mypuppy;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.omunguia.mypuppy.bean.ListaMascotas;
import com.omunguia.mypuppy.bean.Mascota;

import java.util.List;

/**
 * Created by mjcruzs on 13/5/16.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    public List<Mascota> mascotas;

    public MascotaAdapter(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);


        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgvPet.setImageResource(mascota.getImgStr());
        holder.imgvBounNamePet.setImageResource(R.drawable.dog_bone_filled_50);
        holder.tvPetName.setText(mascota.getNombre());
        holder.tvLikes.setText(String.valueOf(mascota.getLikes()));
        holder.imgvLikes.setImageResource(R.drawable.star_filled_48);

        holder.imgvLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namePet =  holder.tvPetName.getText().toString();
                int likes = Integer.parseInt(holder.tvLikes.getText().toString()) + 1;
                holder.tvLikes.setText(String.valueOf(likes));

                Mascota mOld = null;
                Mascota mNew = null;
                Log.i("#MascotaAdapter", "Modificando los likes");
               /* for (Mascota m : ListaMascotas.mascotas ) {

                    if(m.getNombre().equals(namePet)){
                        mOld = m;
                        m.setLikes(likes);
                        mNew = m;
                    }
                }

                if(mOld != null || mNew != null){
                    ListaMascotas.mascotas.remove(mOld);
                    ListaMascotas.mascotas.add(mNew);
                }*/


                //for (Mascota m : ListaMascotas.mascotas ) {
                  //  Log.i("Datos Lista",m.getNombre() + ":"+ m.getLikes().toString());
                //}
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgvBounNamePet;
        public TextView tvPetName;
        public TextView tvLikes;
        public ImageView imgvLikes;
        public ImageView imgvPet;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgvBounNamePet = (ImageView) itemView.findViewById(R.id.imgvBounNamePet);
            tvPetName = (TextView) itemView.findViewById(R.id.tvPetName);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            imgvLikes = (ImageView) itemView.findViewById(R.id.imgvLikes);
            imgvPet = (ImageView) itemView.findViewById(R.id.imgvPet);
        }

    }

}
