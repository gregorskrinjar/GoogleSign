package um.vao.room;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class FavoriteWithUsers {

    @Embedded
    public Favorite favorite;
    @Relation(entity = UserFavorite.class,
            parentColumn = "idFavorite",
            entityColumn = "fkIdFavorite",
            projection = "fkIdUser")
    public List<Long> fkIdUserList;
}
