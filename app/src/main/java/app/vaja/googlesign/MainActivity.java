package app.vaja.googlesign;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import app.vaja.googlesign.Fragments.ProfilFragment;
import app.vaja.googlesign.Fragments.SeznamKomentarjevFragment;
import app.vaja.googlesign.Fragments.ViewRestaurantFragment;
import app.vaja.googlesign.Fragments.VseRestavracijeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "mainActivity";

    //Google Sign in
    private SignInButton signIn;
    private Button signOut;
    private int RC_SIGN_IN = 1;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;

    //Drawer
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /**
         * Drawer sidebar menu
         */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);  //Da lahko kliknemo na izbrano (profil, seznam,...)
        navigationView.setNavigationItemSelectedListener(this); //ko izbiramo v navigationu

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //če slučajno rotiramo napravo, če rotiramo ni null
        if (savedInstanceState == null) {
            //Da ob vstopu ni prazen layout pokaže ta fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new VseRestavracijeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_domov);
        }

        /**
         * RATING
         */
        /*
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratting_bar);
        Button btnRating = (Button) findViewById(R.id.btnRating);
        final TextView ratingDisplayText = (TextView) findViewById(R.id.restaurant_description);

        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingDisplayText.setText("Rating je: " + ratingBar.getRating());
            }
        });*/

        /**
         * GOOGLE SIGN IN WITH FIREBASE
         */
        signIn = (SignInButton)findViewById(R.id.btnSignIn);
        signOut = (Button)findViewById(R.id.btnSignOut);
        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //Prijava
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        //Odjava
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut(); //get signed out
                signOut.setVisibility(View.GONE);
            }
        });
    }

    //za navigacijo ko je izbran določena beseda (profil, seznam...)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //Če kliknemo na ta item, nam bo v framelayoutu odpre profile, seznama,...
            case R.id.nav_domov:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new VseRestavracijeFragment()).commit();
                break;
            case R.id.nav_profil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfilFragment()).commit();
                break;
            case R.id.nav_seznam_komentarjev:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SeznamKomentarjevFragment()).commit();
                break;
            case R.id.nav_seznam_ocen:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ViewRestaurantFragment()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //da ne zapustimo activity takoj ko zapremo side menu
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            //zapremo drawer če je na levi strani
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }
    //Login process
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Ne morete se prijaviti v google", Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }
                        // ...
                    }
                });
    }
    //Če je login uspešen
    private void updateUI(FirebaseUser user) {

        signOut.setVisibility(View.VISIBLE);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            Toast.makeText(this, "Ime uporabnika : " + personName + " in ID je : " + personId, Toast.LENGTH_SHORT).show();
            System.out.println("Ime uporabnika : " + personName + " in ID je : " + personId);
        }
    }


}
