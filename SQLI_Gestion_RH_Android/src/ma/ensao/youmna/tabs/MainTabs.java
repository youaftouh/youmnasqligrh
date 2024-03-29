package ma.ensao.youmna.tabs;

import ma.ensao.youmna.LoginActivity;
import ma.ensao.youmna.R;
import ma.ensao.youmna.tabs.fragment.CollaboratorsFragment;
import ma.ensao.youmna.tabs.fragment.HomeFragment;
import ma.ensao.youmna.tabs.fragment.ReportingFragment;
import ma.ensao.youmna.util.Constants;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainTabs extends FragmentActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * three primary sections of the app. We use a {@link android.support.v4.app.FragmentPagerAdapter}
     * derivative, which will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_main);

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();

        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
        //actionBar.setHomeButtonEnabled(false);

        // Specify that we will be displaying tabs in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When swiping between different app sections, select the corresponding tab.
                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
                // Tab.
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // GoTo Home.
                    Fragment fragment = new HomeFragment();
//                    Bundle args = new Bundle();
//                    args.putInt(HomeFragment.ARG_SECTION_NUMBER, i);
//                    fragment.setArguments(args);
                return fragment;
                
                
                case 1:
                    // GoTo Collaborators.
                return new CollaboratorsFragment();
                
                
                case 2:
                    // GoTo Reporting.
                return new ReportingFragment();
                
                
                default:
                	// Home Sweet Home.
                	return new HomeFragment();
            }
        }

        @Override
        public int getCount() {
            return Constants.TABS_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
        	switch (position) {
			case 0:
	            return Constants.HOME;
			
			case 1:
	            return Constants.COLLABORATORS;
			
			case 2:
	            return Constants.REPORTING;
				
			default:
	            return Constants.HOME;
			}
        }
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case 0:
			disconnect();
			break;
		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }
    
    private void disconnect() {
		Account[] accounts = AccountManager.get(getApplicationContext())
				.getAccountsByType(Constants.ACCOUNT_TYPE);
		if (accounts.length > 0) {
			AccountManager.get(getApplicationContext()).removeAccount(accounts[0], new AccountManagerCallback<Boolean>() {
				
				@Override
				public void run(AccountManagerFuture<Boolean> arg0) {					
				}
			}, null);
		}
		Intent intent = new Intent(this, LoginActivity.class);
		finish();
		startActivity(intent);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, 0, 0, R.string.disconnect);
    	return super.onCreateOptionsMenu(menu);
    	
    }
}
