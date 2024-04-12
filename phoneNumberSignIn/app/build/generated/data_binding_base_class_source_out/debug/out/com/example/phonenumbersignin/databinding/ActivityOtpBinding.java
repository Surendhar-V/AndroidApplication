// Generated by view binder compiler. Do not edit!
package com.example.phonenumbersignin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phonenumbersignin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityOtpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText OtpEd;

  @NonNull
  public final Button verifyBtn;

  private ActivityOtpBinding(@NonNull ConstraintLayout rootView, @NonNull EditText OtpEd,
      @NonNull Button verifyBtn) {
    this.rootView = rootView;
    this.OtpEd = OtpEd;
    this.verifyBtn = verifyBtn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOtpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOtpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_otp, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOtpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Otp_ed;
      EditText OtpEd = ViewBindings.findChildViewById(rootView, id);
      if (OtpEd == null) {
        break missingId;
      }

      id = R.id.verify_btn;
      Button verifyBtn = ViewBindings.findChildViewById(rootView, id);
      if (verifyBtn == null) {
        break missingId;
      }

      return new ActivityOtpBinding((ConstraintLayout) rootView, OtpEd, verifyBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}