package com.omunguia.mypuppy.bean;

import com.omunguia.mypuppy.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by omunguia on 19/05/2016.
 */
public class ListaMascotas {

   public static List<Mascota> mascotas = Arrays.asList(
            new Mascota(R.drawable.p1, "El Petalo", 10, 1),
            new Mascota(R.drawable.p2, "Loba", 7, 2),
            new Mascota(R.drawable.p3, "El Sami", 12, 3),
            new Mascota(R.drawable.p4, "La Joya", 5, 4),
            new Mascota(R.drawable.p5, "Laica", 15, 5)
    );

}
