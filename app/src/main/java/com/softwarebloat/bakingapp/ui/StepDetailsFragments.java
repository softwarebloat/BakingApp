package com.softwarebloat.bakingapp.ui;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.models.Step;

import static com.softwarebloat.bakingapp.ui.RecipeStepsFragment.STEP_KEY;

public class StepDetailsFragments extends Fragment {

    SimpleExoPlayer mExoPlayer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_step_details, container, false);

        Bundle bundle = getArguments();

        Step step = (Step) bundle.getSerializable(STEP_KEY);

        TextView mStepDescription = rootView.findViewById(R.id.step_description);
        SimpleExoPlayerView simpleExoPlayerView = rootView.findViewById(R.id.player_view);

        mStepDescription.setText(step.getDescription());


        if(mExoPlayer == null) {
            TrackSelector trackSelector = new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();
            mExoPlayer = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector, loadControl);
            simpleExoPlayerView.setPlayer(mExoPlayer);

            Uri videoUrl = Uri.parse(step.getVideoURL());


            String userAgent = Util.getUserAgent(getActivity(), "baking-app");
            ExtractorMediaSource mediaSource = new ExtractorMediaSource(
                    videoUrl,
                    new DefaultDataSourceFactory(getActivity(), userAgent),
                    new DefaultExtractorsFactory(), null, null);

            mExoPlayer.prepare(mediaSource);
            mExoPlayer.setPlayWhenReady(true);
            simpleExoPlayerView.hideController();

        }

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mExoPlayer.release();
    }
}
