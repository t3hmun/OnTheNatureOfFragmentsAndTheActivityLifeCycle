package com.t3hmun.onthenatureoffragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String TAG = "Fragment";
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_TOTAL_CREATIONS = "total_creations";

        private int creationCount = 0;
        private String ctorIdentifier;
        private String section = "?";

        public PlaceholderFragment() {
            Log.d(TAG, "ctor-default");
            ctorIdentifier = "default";
        }

        @SuppressLint("ValidFragment")
        public PlaceholderFragment(String ident) {
            Log.d(TAG, "ctor-" + ident);
            ctorIdentifier = ident;
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String sectionNumber) {
            Log.d(TAG, "newInstance " + sectionNumber);
            PlaceholderFragment fragment = new PlaceholderFragment("newInstance-" + sectionNumber);
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_NUMBER, sectionNumber);
            // For this to work this method should only be called once ever for each section.
            args.putInt(ARG_TOTAL_CREATIONS, 0);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Increment this Fragment instance's creation counter.
            creationCount++;
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            Bundle arguments = getArguments();

            // Add one to the total creations.
            int totalCreations = arguments.getInt(ARG_TOTAL_CREATIONS);
            totalCreations++;
            arguments.putInt(ARG_TOTAL_CREATIONS, totalCreations);

            String bundleNum = arguments.getString(ARG_SECTION_NUMBER);
            section = bundleNum;
            Log.d(TAG, "onCreateView " + section);
            textView.setText("bundle: " + bundleNum + " created: " + creationCount + " total: " + totalCreations + " ident: " + ctorIdentifier);

            return rootView;
        }

        @Override
        public void onStart() {
            Log.d(TAG, "onStart " + section);
            super.onStart();
        }

        @Override
        public void onAttach(Context context) {
            Log.d(TAG, "onAttach " + section);
            super.onAttach(context);
        }

        @Override
        public void onPause() {
            Log.d(TAG, "onPause " + section);
            super.onPause();
        }

        @Override
        public void onResume() {
            Log.d(TAG, "onResume " + section);
            super.onResume();
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            Log.d(TAG, "onViewCreated " + section);
            super.onViewCreated(view, savedInstanceState);
        }

        @Override
        public void onStop() {
            Log.d(TAG, "onStop " + section);
            super.onStop();
        }

        @Override
        public void onDetach() {
            Log.d(TAG, "onDetach " + section);
            super.onDetach();
        }

        @Override
        public void onDestroyView() {
            Log.d(TAG, "onDestroyView " + section);
            super.onDestroyView();
        }

        @Override
        public void onDestroy() {
            Log.d(TAG, "onDestroy " + section);
            super.onDestroy();
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            String pos;
            switch (position) {
                case 0:
                    pos = "one";
                    break;
                case 1:
                    pos = "two";
                    break;
                case 2:
                    pos = "three";
                    break;
                default:
                    pos = "error";
            }
            return PlaceholderFragment.newInstance(pos);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
