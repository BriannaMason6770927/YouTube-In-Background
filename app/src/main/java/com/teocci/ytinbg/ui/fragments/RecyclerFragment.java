package com.teocci.ytinbg.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.teocci.ytinbg.R;
import com.teocci.ytinbg.adapters.VideosAdapter;
import com.teocci.ytinbg.utils.NetworkHelper;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by teocci.
 *
 * @author teocci@yandex.com on 2017-May-13
 */

public abstract class RecyclerFragment extends Fragment implements AdapterView.OnItemClickListener
{
    protected RecyclerView recyclerView;
    protected VideosAdapter videoListAdapter;

    protected NetworkHelper networkConf;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = rootView.findViewById(R.id.recently_played);
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.addItemDecoration(getItemDecoration());

        recyclerView.getItemAnimator().setAddDuration(500);
        recyclerView.getItemAnimator().setChangeDuration(500);
        recyclerView.getItemAnimator().setMoveDuration(500);
        recyclerView.getItemAnimator().setRemoveDuration(500);

        videoListAdapter = getAdapter();
        videoListAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(videoListAdapter);

        return rootView;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        networkConf = new NetworkHelper(getActivity());
    }

    /**
     * Required Overrides for Sample Fragments
     */

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract RecyclerView.ItemDecoration getItemDecoration();

    protected abstract VideosAdapter getAdapter();
}
