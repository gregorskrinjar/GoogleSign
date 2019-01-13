package um.vao.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
class UserFavorite {

    @PrimaryKey(autoGenerate = true)
    private int idUserFavorite;
    private int fkIdUser;
    private int fkIdFavorite;

    public UserFavorite() {
    }

    public UserFavorite(int fkIdUser, int fkIdFavorite) {
        this.fkIdUser = fkIdUser;
        this.fkIdFavorite = fkIdFavorite;
    }

    public int getIdUserFavorite() {
        return idUserFavorite;
    }

    public void setIdUserFavorite(int idUserFavorite) {
        this.idUserFavorite = idUserFavorite;
    }

    public int getFkIdUser() {
        return fkIdUser;
    }

    public void setFkIdUser(int fkIdUser) {
        this.fkIdUser = fkIdUser;
    }

    public int getFkIdFavorite() {
        return fkIdFavorite;
    }

    public void setFkIdFavorite(int fkIdFavorite) {
        this.fkIdFavorite = fkIdFavorite;
    }

    @NonNull
    @Override
    public String toString() {
        return "UserFavorite{" +
                "idUserFavorite=" + idUserFavorite +
                ", fkIdUser=" + fkIdUser +
                ", fkIdFavorite=" + fkIdFavorite +
                '}';
    }
}
