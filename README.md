# EmphasisTextView
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0) [![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-EmphasisTextView-green.svg?style=true)](https://android-arsenal.com/details/1/3203)

An android TextView that supports highlighting parts or all of the text contained in it.

Screenshots           
===========
![Demo Screenshot][1]

How to
======

To set the highlight areas you can add the following statements programmatically:
```java
emphasisTextView.setText("SALAD");
emphasisTextView.setTextToHighlight("sa");
emphasisTextView.setHighlightColor("#ff3393b4"); 
emphasisTextView.setCaseInsensitive(true);
emphasisTextView.highlight();
```
Please check the sample project for some more working examples.

Add it to your project
----------------------

This library is hosted in [jcenter](https://bintray.com/bintray/jcenter) 

For gradle, you can import it with:
```groovy
dependencies {
    compile 'com.athkalia.emphasis:emphasis:0.3'
}
```
For maven, you can import it with: 
```xml
<dependency>
    <groupId>com.athkalia.emphasis</groupId>
    <artifactId>emphasis</artifactId>
    <type>aar</type>
    <version>0.3</version>
</dependency>
```
Todos
-----
Feel free to open a pull request for anything that you want to see added.
 
What I have in mind:


1) Introduce a delegate when someone is using another class that is already extending from TextView (possibly another library).

2) Create similar functionality via xml attributes.
       
 [1]: ./art/screenshot.png
