package um.vao.room;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UserWithFavorites {

    @Embedded
    public User user;
    @Relation(entity = UserFavorite.class,
            parentColumn = "idUser",
            entityColumn = "fkIdUser",
            projection = "fkIdFavorite")
    public List<Long> fkIdFavoriteList;
}
