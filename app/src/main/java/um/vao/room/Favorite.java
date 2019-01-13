package um.vao.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
class Favorite {

    @PrimaryKey(autoGenerate = true)
    private int idFavorite;
    private int idOfFavRestaurant;
    private boolean favorite;

    public Favorite() {
    }

    public Favorite(int idOfFavRestaurant, boolean favorite) {
        this.idOfFavRestaurant = idOfFavRestaurant;
        this.favorite = favorite;
    }

    public int getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(int idFavorite) {
        this.idFavorite = idFavorite;
    }

    public int getIdOfFavRestaurant() {
        return idOfFavRestaurant;
    }

    public void setIdOfFavRestaurant(int idOfFavRestaurant) {
        this.idOfFavRestaurant = idOfFavRestaurant;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @NonNull
    @Override
    public String toString() {
        return "Favorite{" +
                "idFavorite=" + idFavorite +
                ", idOfFavRestaurant=" + idOfFavRestaurant +
                ", favorite=" + favorite +
                '}';
    }
}
