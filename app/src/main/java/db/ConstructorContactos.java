package db;

import android.content.Context;

import com.omunguia.mypuppy.bean.ListaMascotas;
import com.omunguia.mypuppy.bean.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omunguia on 05/06/2016.
 */
public class ConstructorContactos {
    private Context context;
    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public List<Mascota> getMascotas(){
        return ListaMascotas.mascotas;
    }
}
