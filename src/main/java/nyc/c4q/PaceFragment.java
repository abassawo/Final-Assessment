package nyc.c4q;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by c4q-Abass on 8/30/15.
 */
public class PaceFragment extends Fragment{
    private View view;
    private EditText distField;
    private EditText time_Min_Field;
    private EditText time_Sec_Field;
    private EditText pace_Min_Field;
    private EditText pace_Sec_Field;

    private boolean fieldsValidated;
    private Button calcButton;


    Double distDouble;
    int minutes; int seconds;
    Double paceDouble;

    private boolean distFilled; //for checking which we shall calculate;
    private boolean timeFilled;
    private boolean paceFilled;


    //if all fields are blank, do nthing.
    //if all fields are empty...do nothing.
    //if only one field...do nothing. Simplify this to one boolean


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pace_calculator, container, false);
        initViews();

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_calculate_onClick();
            }
        });
        //initState();
        return view;
    }

    public void button_calculate_onClick(){
        initState();
        if(allFieldsFilled()){
            return;
        } else
        if(!areFieldsOkay()){
            Toast.makeText(getActivity().getApplicationContext(), "Stop crashing", Toast.LENGTH_SHORT);
            return ;
        } else {
            if (distFilled && timeFilled) {
                calculatePace(seconds, distDouble);
            } else if (distFilled && paceFilled) {
                calculateTime(distDouble, paceDouble);
            } else if (timeFilled && paceFilled) {
                calculateDistance(seconds, paceDouble);
            }
        }


    }

    public void calculateDistance(int time, Double pace){
            Double distance = time / pace;
            distField.setText(String.valueOf(distance));

    }

    public void calculateTime(Double distance, Double pace){
            Double time = distance * pace;
            String time_Str = String.valueOf(time);
            if (time_Str.contains(".")) {
                //split num and decimal;
                int decIndex = time_Str.indexOf(".");
                //split num and decimal;
                time_Sec_Field.setText(time_Str.substring(decIndex, time_Str.length()));
                time_Min_Field.setText(time_Str.substring(0, time_Str.lastIndexOf(".")));

            }
    }

    public void calculatePace(int time, Double distance){
            Double pace = time / distance;
            String pace_Str = String.valueOf(pace);
            if (pace_Str.contains(".")) {
                int decIndex = pace_Str.indexOf(".");
                //split num and decimal;
                pace_Min_Field.setText(pace_Str.substring(0, decIndex));
                pace_Sec_Field.setText(pace_Str.substring(decIndex, pace_Str.length()));
            }


    }

    public void initViews() {
        distField = (EditText) view.findViewById(R.id.input_distance);
        time_Min_Field = (EditText) view.findViewById(R.id.input_time_min);
        time_Sec_Field = (EditText) view.findViewById(R.id.input_time_sec);
        pace_Min_Field = (EditText) view.findViewById(R.id.input_pace_min);
        pace_Sec_Field = (EditText) view.findViewById(R.id.input_pace_sec);
        calcButton = (Button) view.findViewById(R.id.button_calculate);
    }

    public void initState() {
        timeFilled = !isEmpty(time_Min_Field) || !isEmpty(time_Sec_Field);
        paceFilled = !isEmpty(pace_Min_Field) || !isEmpty(pace_Sec_Field);
        distFilled = !isEmpty(distField);

        if(allFieldsFilled() || (allFieldsEmpty())){
           return;
        } else if(areFieldsOkay()) {
            if (distFilled) {
                distDouble = Double.parseDouble(distField.getText().toString());
            }
            if (timeFilled) {
                try {
                    if (isEmpty(time_Sec_Field)) {
                        seconds = Integer.parseInt(time_Min_Field.getText().toString());
                    } else if (isEmpty(time_Min_Field)) {
                        seconds = 60 * (Integer.parseInt(String.valueOf("0." + time_Sec_Field.getText())));
                    } else {
                        int mins_in_seconds = 60 * (Integer.parseInt(String.valueOf("0." + time_Sec_Field.getText())));
                        int seconds_field_txt = Integer.parseInt(time_Min_Field.getText().toString());
                       seconds = mins_in_seconds + seconds_field_txt ;
                    }
                } catch(Exception e){

                }
            }
            if (paceFilled) {
                try {
                    if (isEmpty(pace_Sec_Field)) {
                        paceDouble = Double.parseDouble(pace_Min_Field.getText().toString());
                    } else if (isEmpty(pace_Min_Field)) {
                        paceDouble = Double.parseDouble(pace_Sec_Field.getText().toString());
                    } else {
                        int paceBig = Integer.parseInt((pace_Min_Field.getText().toString()));
                        int paceLil = Integer.parseInt((pace_Sec_Field.getText().toString()));
                        paceDouble = Double.parseDouble(String.valueOf(paceBig + "." + paceLil));
                        Log.d("concat_test", String.valueOf(paceDouble));
                    }
                } catch(Exception e){

                }
            }
        }
    }


    public boolean areFieldsOkay(){
        if (allFieldsEmpty() || allFieldsFilled()){
            fieldsValidated = false;
        }  else {
            fieldsValidated = true;
        }
        return fieldsValidated;
    }

    public boolean allFieldsEmpty(){  //if all fields empty, stop
        if (isEmpty(distField)
                && isEmpty(time_Min_Field)
                && isEmpty(time_Sec_Field)
                && isEmpty(pace_Min_Field)
                && isEmpty(pace_Sec_Field)
                ){
            return true;
        } else {
            return false;
        }
    }

    public boolean allFieldsFilled(){
        if ( hasText(distField) && hasText(time_Min_Field)
                && hasText(time_Sec_Field)
                && hasText(pace_Min_Field)
                && hasText(pace_Sec_Field)
        ){
            return  true;
        } else {
            return false;
        }

    }


    public boolean isEmpty(EditText et){
        return et.getText().toString().isEmpty();
    }

    public boolean hasText(EditText et){
        return et.getText().toString().length() > 0;
    }




}
