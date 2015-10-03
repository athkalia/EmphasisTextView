# EmphasisTextView
An android TextView that supports highlighting parts or all of the text contained in it.

This library is hosted in https://bintray.com/bintray/jcenter

For gradle, you can import it with:

    dependencies {
        compile 'com.topantidevelopers.emphasis:library:0.2'
    }

For maven, you can import it with: 

       <dependency>
            <groupId>com.topantidevelopers.emphasis</groupId>
            <artifactId>library</artifactId>
            <type>aar</type>
            <version>0.2</version>
       </dependency>


To set the highlight areas you can add the following statements programmatically:

    emphasisTextView.setText("SALAD");
    emphasisTextView.setTextToHighlight("sa");
    emphasisTextView.setHighlightColor("#ff3393b4");
    emphasisTextView.setCaseInsensitive(true);
    emphasisTextView.highlight();

Please check the sample project for some more working examples.
 