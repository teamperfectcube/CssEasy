/*
 * MIT License
 *
 * Copyright (c) 2017 Perfect Cube
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.itsgaurav.csseasy.activities;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.itsgaurav.csseasy.R;

import static com.itsgaurav.csseasy.constants.ConstantValue.EXTRA_CHAPTER_NUMBER;


public class ChapterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        //Obtain view reference
        WebView webView = findViewById(R.id.webView);
        AdView mAdView = findViewById(R.id.adView);

        //Retrieve data from intent
        int chapterNumber = getIntent()
                .getExtras()
                .getInt(EXTRA_CHAPTER_NUMBER) + 1;

        // To set title of actionbar
        setTitle(getTitle(chapterNumber));

        //Load content from assets folder
        webView.loadUrl("file:///android_asset/csstut/" + "c" + chapterNumber + ".html");

        //For banner ads
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    /**
     * Method to return title of the actionbar.
     *
     * @param number chapter number.
     */
    private String getTitle(int number) {

        String title;
        switch (number) {
            case 1:
                title = "CSS Introduction";
                break;
            case 2:
                title = "CSS Syntax";
                break;
            case 3:
                title = "CSS How To";
                break;
            case 4:
                title = "CSS Colors";
                break;
            case 5:
                title = "CSS Background";
                break;
            case 6:
                title = "CSS Borders";
                break;
            case 7:
                title = "CSS Margins";
                break;
            case 8:
                title = "CSS Padding";
                break;
            case 9:
                title = "CSS Height/Width";
                break;
            case 10:
                title = "CSS Text";
                break;
            case 11:
                title = "CSS Fonts";
                break;
            case 12:
                title = "CSS Links";
                break;
            case 13:
                title = "CSS Lists";
                break;
            case 14:
                title = "CSS Tables";
                break;
            case 15:
                title = "CSS Box Model";
                break;
            case 16:
                title = "CSS Outline";
                break;
            case 17:
                title = "CSS Display";
                break;
            case 18:
                title = "CSS Max-Width";
                break;
            case 19:
                title = "CSS Position";
                break;
            case 20:
                title = "CSS Float";
                break;
            case 21:
                title = "CSS Inline-block";
                break;
            case 22:
                title = "CSS Align";
                break;
            case 23:
                title = "CSS Combinator";
                break;
            case 24:
                title = "CSS Pseudo-class";
                break;
            case 25:
                title = "CSS Pseudo-elements";
                break;
            case 26:
                title = "CSS Navigation Bar";
                break;
            case 27:
                title = "CSS Dropdown";
                break;
            case 28:
                title = "CSS Tooltips";
                break;
            case 29:
                title = "CSS Image Gallery";
                break;
            case 30:
                title = "CSS Image Opacity";
                break;
            case 31:
                title = "CSS Image Sprites";
                break;
            case 32:
                title = "CSS Attr Selectors";
                break;
            case 33:
                title = "CSS Forms";
                break;
            case 34:
                title = "CSS Counters";
                break;
            case 35:
                title = "CSS3 Introduction";
                break;
            case 36:
                title = "CSS3 Rounded Corners";
                break;
            case 37:
                title = "CSS3 Border Images";
                break;
            case 38:
                title = "CSS3 Backgrounds";
                break;
            case 39:
                title = "CSS3 Colors";
                break;
            case 40:
                title = "CSS3 Gradients";
                break;
            case 41:
                title = "CSS3 Shadows";
                break;
            case 42:
                title = "CSS3 Text";
                break;
            case 43:
                title = "CSS3 Fonts";
                break;
            case 44:
                title = "CSS3 2D Transforms";
                break;
            case 45:
                title = "CSS3 3D Transforms";
                break;
            case 46:
                title = "CSS3 Transitions";
                break;
            case 47:
                title = "CSS3 Animation";
                break;
            case 48:
                title = "CSS3 Image";
                break;
            case 49:
                title = "CSS3 Buttons";
                break;
            case 50:
                title = "CSS3 Pagination";
                break;
            case 51:
                title = "CSS3 Multiple Columns";
                break;
            case 52:
                title = "CSS3 User Interface";
                break;
            case 53:
                title = "CSS3 Box Sizing";
                break;
            case 54:
                title = "CSS3 Flexbox";
                break;
            case 55:
                title = "CSS3 Filters";
                break;
            case 56:
                title = "CSS3 Media Queries";
                break;
            case 57:
                title = "CSS3 MQ Examples";
                break;
            case 58:
                title = "CSS RWD Introduction";
                break;
            case 59:
                title = "RWD Viewport";
                break;
            case 60:
                title = "RWD Grid View";
                break;
            case 61:
                title = "RWD Media Queries";
                break;
            case 62:
                title = "RWD Images";
                break;
            case 63:
                title = "RWD Video";
                break;
            case 64:
                title = "RWD Framework";
                break;
            default:
                title = "CSS Easy";
                //Do nothing
        }
        return title;
    }

}
