package db;

/**
 * Created by omunguia on 05/06/2016.
 */
public final class BaseDatosConfig {
    public static final String NAME_DB = "MyPuppyDB";
    public static final int VERSION_DB = 1;

    public final class Puppy{
        public static final String NAME_TABLE = "Puppy";
        public static final String PUPPY_ID = "id_puppy";
        public static final String PUPPY_NOMBRE = "nombre";
        public static final String PUPPY_LIKES = "no_likes";
        public static final String PUPPY_IMG_RECURSO_ID= "id_recurso";
    }

    public final class PuppyLikes{
        public static final String NAME_TABLE = "PuppyLikes";
        public static final String PUPPY_lIKES_ID = "id_puppy_likes";
        public static final String PUPPY_ID = "id_puppy_r";
        public static final String NO_LIKES = "no_likes";
    }
}
