# ReadMore Library

This library provides a tool for text view to be collapsed or extanded according to length of text with 'Read more' and 'Show less'

![readmore](https://github.com/Morika1/ReadMoreApp/assets/68543807/f64500cb-7f16-4d44-a077-6ba0ce558abf)  ![showless](https://github.com/Morika1/ReadMoreApp/assets/68543807/25224220-1b99-4acd-b77f-03005b39dab4)
 

# Setup

Step 1. Add the maven repository in your settings.gradle under the section:

	dependencyResolutionManagement {
    		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
   			 repositories {
      				maven { url 'https://jitpack.io' }
    			}
		}

Step 2. Add the dependency to your module:app build.gradle file:

	dependencies {
	         implementation 'com.github.Morika1:ReadMoreApp:Tag'
	}



# Usage
In usage you can set from the XML file the text, its color and size and the number of lines to show when view is collapsed.
From your activity you can set the text content. 

Activity:
	public class MainActivity extends AppCompatActivity {
	
	    private ReadMoreView main_LAY_textview;
	
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	
	        main_LAY_textview = (ReadMoreView)findViewById(R.id.main_LAY_textview);
	        //main_LAY_textview.setText(""); you can set the text in running using this line
	
	    }
	  }

XML:

	  <?xml version="1.0" encoding="utf-8"?>
	  <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    tools:context=".MainActivity">
	
	    <com.example.readmorelib.ReadMoreView
	        android:id="@+id/main_LAY_textview"
	        android:layout_width="match_parent"
	        android:layout_height="match_parent"
	        app:text="This is our library. Its purpose is to have a text view which can expand and collapse according to the length of the text. You 		can modify the minimum lines to show when view is collapsed, the text along its size and color. If the text is shorter or at the same line 		length of the minimum length, the readMore will disappear. This library can be implemented in any view. You can also use the setText 			method from your activity to change the text while running. To do so, give the view an id and initiate the view using findViewById with 		your other view component."
	        app:textColor="@color/md_green_400" />
	
	  </RelativeLayout>


# Credits
This library was composed with my partner- Sharoniki1: https://github.com/Sharoniki1
