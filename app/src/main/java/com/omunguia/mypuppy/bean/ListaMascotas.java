package com.omunguia.mypuppy.bean;

import com.omunguia.mypuppy.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by omunguia on 19/05/2016.
 */
public class ListaMascotas {

   public static List<Mascota> mascotas = Arrays.asList(
            new Mascota(R.drawable.p1, "El Petalo", 10),
            new Mascota(R.drawable.p2, "Loba", 7),
            new Mascota(R.drawable.p3, "El Sami", 12),
            new Mascota(R.drawable.p4, "La Joya", 5),
            new Mascota(R.drawable.p5, "Laica", 15)
    );

}
