// Generated by view binder compiler. Do not edit!
package com.example.partyplanner.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.partyplanner.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityChecklistBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CheckBox cakecheck;

  @NonNull
  public final ConstraintLayout checklistActivity;

  @NonNull
  public final EditText editText2;

  @NonNull
  public final EditText editText3;

  @NonNull
  public final EditText editText4;

  @NonNull
  public final EditText editText5;

  @NonNull
  public final CheckBox foodcheck;

  @NonNull
  public final CheckBox invcheck;

  @NonNull
  public final Button openDialogbtn;

  @NonNull
  public final EditText plaintext;

  @NonNull
  public final ProgressBar taskCompBar;

  @NonNull
  public final TextView taskCompNum;

  @NonNull
  public final TextView textView;

  @NonNull
  public final CheckBox tnccheck;

  @NonNull
  public final CheckBox venuecheck;

  private ActivityChecklistBinding(@NonNull ConstraintLayout rootView, @NonNull CheckBox cakecheck,
      @NonNull ConstraintLayout checklistActivity, @NonNull EditText editText2,
      @NonNull EditText editText3, @NonNull EditText editText4, @NonNull EditText editText5,
      @NonNull CheckBox foodcheck, @NonNull CheckBox invcheck, @NonNull Button openDialogbtn,
      @NonNull EditText plaintext, @NonNull ProgressBar taskCompBar, @NonNull TextView taskCompNum,
      @NonNull TextView textView, @NonNull CheckBox tnccheck, @NonNull CheckBox venuecheck) {
    this.rootView = rootView;
    this.cakecheck = cakecheck;
    this.checklistActivity = checklistActivity;
    this.editText2 = editText2;
    this.editText3 = editText3;
    this.editText4 = editText4;
    this.editText5 = editText5;
    this.foodcheck = foodcheck;
    this.invcheck = invcheck;
    this.openDialogbtn = openDialogbtn;
    this.plaintext = plaintext;
    this.taskCompBar = taskCompBar;
    this.taskCompNum = taskCompNum;
    this.textView = textView;
    this.tnccheck = tnccheck;
    this.venuecheck = venuecheck;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChecklistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChecklistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_checklist, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChecklistBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cakecheck;
      CheckBox cakecheck = ViewBindings.findChildViewById(rootView, id);
      if (cakecheck == null) {
        break missingId;
      }

      ConstraintLayout checklistActivity = (ConstraintLayout) rootView;

      id = R.id.editText2;
      EditText editText2 = ViewBindings.findChildViewById(rootView, id);
      if (editText2 == null) {
        break missingId;
      }

      id = R.id.editText3;
      EditText editText3 = ViewBindings.findChildViewById(rootView, id);
      if (editText3 == null) {
        break missingId;
      }

      id = R.id.editText4;
      EditText editText4 = ViewBindings.findChildViewById(rootView, id);
      if (editText4 == null) {
        break missingId;
      }

      id = R.id.editText5;
      EditText editText5 = ViewBindings.findChildViewById(rootView, id);
      if (editText5 == null) {
        break missingId;
      }

      id = R.id.foodcheck;
      CheckBox foodcheck = ViewBindings.findChildViewById(rootView, id);
      if (foodcheck == null) {
        break missingId;
      }

      id = R.id.invcheck;
      CheckBox invcheck = ViewBindings.findChildViewById(rootView, id);
      if (invcheck == null) {
        break missingId;
      }

      id = R.id.openDialogbtn;
      Button openDialogbtn = ViewBindings.findChildViewById(rootView, id);
      if (openDialogbtn == null) {
        break missingId;
      }

      id = R.id.plaintext;
      EditText plaintext = ViewBindings.findChildViewById(rootView, id);
      if (plaintext == null) {
        break missingId;
      }

      id = R.id.taskCompBar;
      ProgressBar taskCompBar = ViewBindings.findChildViewById(rootView, id);
      if (taskCompBar == null) {
        break missingId;
      }

      id = R.id.taskCompNum;
      TextView taskCompNum = ViewBindings.findChildViewById(rootView, id);
      if (taskCompNum == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.tnccheck;
      CheckBox tnccheck = ViewBindings.findChildViewById(rootView, id);
      if (tnccheck == null) {
        break missingId;
      }

      id = R.id.venuecheck;
      CheckBox venuecheck = ViewBindings.findChildViewById(rootView, id);
      if (venuecheck == null) {
        break missingId;
      }

      return new ActivityChecklistBinding((ConstraintLayout) rootView, cakecheck, checklistActivity,
          editText2, editText3, editText4, editText5, foodcheck, invcheck, openDialogbtn, plaintext,
          taskCompBar, taskCompNum, textView, tnccheck, venuecheck);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
