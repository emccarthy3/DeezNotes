package com.edu.elon.deeznotes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

public class NoteViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.activity_note_view);
    }

}
