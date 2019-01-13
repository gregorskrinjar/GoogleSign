package app.vaja.googlesign.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import app.vaja.googlesign.R;
import app.vaja.googlesign.Utils.Heart;

import static android.content.ContentValues.TAG;

public class ViewRestaurantFragment extends Fragment {
    ImageView mHeartRed, mHeartWhite;
    //detector za like, kaj se zgodi če lajkaš
    GestureDetector mGestureDetector;
    private Heart mHeart;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.row_restaurant, container, false);

        mHeartRed = (ImageView) view.findViewById(R.id.image_heart_red);
        mHeartWhite = (ImageView) view.findViewById(R.id.image_heart);

        mHeartRed.setVisibility(View.GONE);
        mHeartWhite.setVisibility(View.VISIBLE);
        mHeart = new Heart(mHeartWhite, mHeartRed);
        mGestureDetector = new GestureDetector(getActivity(), new GestureListener());

        testToggle();

        return view;
    }
    //pripnemo onClickListener na srce
    private void testToggle() {
        mHeartRed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d(TAG, "onTouch: red heart touch detexted.");
                return mGestureDetector.onTouchEvent(motionEvent);
            }
        });

        mHeartWhite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d(TAG, "onTouch: white heart touch detexted.");
                return mGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    //tukaj bomo dodajali lajke v bazo ali ne če je uporabnik že lajkal
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d(TAG, "onDoubleTap: duble tap detected.");
            mHeart.toggleLike();
            return true;
        }
    }
}

