// Generated by view binder compiler. Do not edit!
package com.example.qwerty.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.qwerty.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ForgotPasswordBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView forgotEmailAddressMsg;

  @NonNull
  public final EditText requestEmailAddressId;

  @NonNull
  public final Button sendResetMail;

  private ForgotPasswordBinding(@NonNull CardView rootView, @NonNull TextView forgotEmailAddressMsg,
      @NonNull EditText requestEmailAddressId, @NonNull Button sendResetMail) {
    this.rootView = rootView;
    this.forgotEmailAddressMsg = forgotEmailAddressMsg;
    this.requestEmailAddressId = requestEmailAddressId;
    this.sendResetMail = sendResetMail;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ForgotPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.forgot_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ForgotPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.forgot_emailAddress_msg;
      TextView forgotEmailAddressMsg = ViewBindings.findChildViewById(rootView, id);
      if (forgotEmailAddressMsg == null) {
        break missingId;
      }

      id = R.id.request_emailAddress_id;
      EditText requestEmailAddressId = ViewBindings.findChildViewById(rootView, id);
      if (requestEmailAddressId == null) {
        break missingId;
      }

      id = R.id.send_resetMail;
      Button sendResetMail = ViewBindings.findChildViewById(rootView, id);
      if (sendResetMail == null) {
        break missingId;
      }

      return new ForgotPasswordBinding((CardView) rootView, forgotEmailAddressMsg,
          requestEmailAddressId, sendResetMail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
