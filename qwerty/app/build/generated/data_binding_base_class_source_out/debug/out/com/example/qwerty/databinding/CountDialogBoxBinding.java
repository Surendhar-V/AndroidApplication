// Generated by view binder compiler. Do not edit!
package com.example.qwerty.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.qwerty.R;
import com.shawnlin.numberpicker.NumberPicker;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CountDialogBoxBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button addBtn;

  @NonNull
  public final NumberPicker countNp;

  private CountDialogBoxBinding(@NonNull CardView rootView, @NonNull Button addBtn,
      @NonNull NumberPicker countNp) {
    this.rootView = rootView;
    this.addBtn = addBtn;
    this.countNp = countNp;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CountDialogBoxBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CountDialogBoxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.count_dialog_box, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CountDialogBoxBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addBtn;
      Button addBtn = ViewBindings.findChildViewById(rootView, id);
      if (addBtn == null) {
        break missingId;
      }

      id = R.id.count_np;
      NumberPicker countNp = ViewBindings.findChildViewById(rootView, id);
      if (countNp == null) {
        break missingId;
      }

      return new CountDialogBoxBinding((CardView) rootView, addBtn, countNp);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
