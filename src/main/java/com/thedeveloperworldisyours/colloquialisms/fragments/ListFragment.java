package com.thedeveloperworldisyours.colloquialisms.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thedeveloperworldisyours.colloquialisms.activities.MainActivity;
import com.thedeveloperworldisyours.colloquialisms.R;
import com.thedeveloperworldisyours.colloquialisms.adapters.ListAdapter;
import com.thedeveloperworldisyours.colloquialisms.dao.SentenceDAO;
import com.thedeveloperworldisyours.colloquialisms.models.Sentence;
import com.thedeveloperworldisyours.colloquialisms.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    private ListView mListView;
    private static List<Sentence> mSentenceList;
    private ListAdapter mListAdapter;
    private SentenceDAO mSentenceDAO;

    public static ListFragment newInstance(int sectionNumber) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mListView = (ListView) view.findViewById(R.id.fragment_list_listView);

        getData();

        return view;
    }

    public void getData(){
        mSentenceDAO = new SentenceDAO(getActivity());
        mSentenceList = new ArrayList<Sentence>();
        if(exitsDB()){
            mSentenceList=mSentenceDAO.readAllAsc();
            showList();
        }
    }

    public boolean exitsDB(){
        int sentence = mSentenceDAO.getCount();
        return sentence > 0;
    }

    public void showList(){
        mListAdapter = new ListAdapter(getActivity(), mSentenceList);
        mListView.setAdapter(mListAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(Constants.ARG_SECTION_NUMBER));
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
