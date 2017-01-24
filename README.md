# OnTheNatureOfFragmentsAndTheActivityLifeCycle

The relationship between Activity, ViewPager, FragmentPagerAdapter and Fragments in the activity life-cycle.

This is a handy app for watching the app life-cycle in debug logs and seeing how that relates to paged fragments.

Roles:

* Activity - This is more or less the app.
* [ViewPager](https://developer.android.com/reference/android/support/v4/view/ViewPager.html) - Facilitates the swiping between pages
* [FragmentPagerAdapter](https://developer.android.com/reference/android/support/v4/app/FragmentPagerAdapter.html) [(PagerAdapter)](https://developer.android.com/reference/android/support/v4/view/PagerAdapter.html) - Manages the views (fragments) and supplies them to the pager.
* FragmentManager - Manages the fragment life-cycle. Destory and restore.
* Fragment - The view for a page.

## Things to Try

> I'm writing an article that will have more detail than in this readme, I'll link it when ready.

Run in Android Studio.

## What ViewPager is doing

> Don't rotate the screen to avoid confusion.

First just swipe between pages 1 and 2.
Nothing insteresting appears to be happening.

But now swipe to page 3; you will notice it has been created many times.

The pager needs the adjacent views ready to show on swiping so they are created off screen in preparation.

You will be able to see this happening in the debug log in android studio.

The identifier saved in the constructor remains `newInstance-number` all though this.
That means the same object instance created using the `newInstance()` method is re-used, with `onCreated` called many times.
The view is destroyed to save memory, but the object remains with all its fields intact.

* An fragment instance may have `onCreateView()` be called multiple times.


## Now Rotate

Screen rotation is more interesting.
Rotate the screen.

A new instance of the fragment is created using the default constructor.
All field vars are lost.
The bundle is the only thing that persists.

* Fields in the fragment instance are lost on rotation so the instance cannot be relied upon to persist data.
* Writing code that requires `onCreateView()` to know the difference between a re-used and new isntance would be complicated.

## Other Things

These kinds of changes can also be witnessed by navigating away from the app and loading many other large apps to use the RAM.



