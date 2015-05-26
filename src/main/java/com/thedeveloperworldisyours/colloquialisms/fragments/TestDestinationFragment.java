package com.thedeveloperworldisyours.colloquialisms.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.thedeveloperworldisyours.colloquialisms.R;
import com.thedeveloperworldisyours.colloquialisms.activities.MainActivity;
import com.thedeveloperworldisyours.colloquialisms.dao.SentenceDAO;
import com.thedeveloperworldisyours.colloquialisms.models.Sentence;
import com.thedeveloperworldisyours.colloquialisms.utils.Constants;
import com.thedeveloperworldisyours.colloquialisms.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link TestDestinationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestDestinationFragment extends Fragment implements TextView.OnEditorActionListener {

    private TextView mSentenceDestino;
    private static List<Sentence> mSentenceList;
    private SentenceDAO mSentenceDAO;
    private int mPosition;

    public static TestDestinationFragment newInstance(int sectionNumber) {
        TestDestinationFragment fragment = new TestDestinationFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public TestDestinationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_destination, container, false);
        mSentenceDestino = (TextView) view.findViewById(R.id.fragment_test_destionation_textView);
        EditText editText = (EditText) view.findViewById(R.id.fragment_test_destination_editText);
        editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        editText.setOnEditorActionListener(this);
        getData();
        return view;
    }

    public void getData(){
        mSentenceDAO = new SentenceDAO(getActivity());
        mSentenceList = new ArrayList<Sentence>();
        if(exitsDB()){
            mSentenceList=mSentenceDAO.readAllAsc();
            showSentence();
        }
    }

    public void showSentence(){
        mPosition = Utils.randInt(0, mSentenceList.size() - 1);
        String examp = mSentenceList.get(mPosition).getSentenceDestination();
        mSentenceDestino.startAnimation(AnimationUtils.loadAnimation(
                getActivity(), R.anim.enter));
        mSentenceDestino.setText(examp);
    }


    public boolean exitsDB(){
        int sentence = mSentenceDAO.getCount();
        return sentence > 0;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(Constants.ARG_SECTION_NUMBER));
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
            showAlertView();
        }
        return false;
    }

    public void showAlertView(){

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle(getString(R.string.fragment_test_eng_solution));
        alert.setMessage("");
        alert.setCancelable(false);
        alert.setPositiveButton(getString(R.string.fragment_test_eng_next),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showSentence();
                        dialog.cancel();
                    }
                }
        );
        AlertDialog alert11 = alert.create();
        alert11.show();
        TextView messageText = (TextView) alert11.findViewById(android.R.id.message);
        messageText.setGravity(Gravity.CENTER);
        messageText.setText(mSentenceList.get(mPosition).getSentenceOrigin());

    }
}
