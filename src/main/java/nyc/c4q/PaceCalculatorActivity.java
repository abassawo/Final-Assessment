package nyc.c4q;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class PaceCalculatorActivity extends FragmentActivity {
    private FragmentManager fragMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);
        initState();
        fragMan.beginTransaction().add(R.id.activity_pace_calculator, new PaceFragment()).commit();
    }

    public void initState(){
        fragMan = getSupportFragmentManager();
    }

}
