// Generated by view binder compiler. Do not edit!
package com.example.bloodbank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bloodbank.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBloodRequestBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView bloodRequestList;

  @NonNull
  public final TextView bloodRequestTitle;

  private FragmentBloodRequestBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView bloodRequestList, @NonNull TextView bloodRequestTitle) {
    this.rootView = rootView;
    this.bloodRequestList = bloodRequestList;
    this.bloodRequestTitle = bloodRequestTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBloodRequestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBloodRequestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_blood_request, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBloodRequestBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bloodRequestList;
      RecyclerView bloodRequestList = ViewBindings.findChildViewById(rootView, id);
      if (bloodRequestList == null) {
        break missingId;
      }

      id = R.id.bloodRequestTitle;
      TextView bloodRequestTitle = ViewBindings.findChildViewById(rootView, id);
      if (bloodRequestTitle == null) {
        break missingId;
      }

      return new FragmentBloodRequestBinding((ConstraintLayout) rootView, bloodRequestList,
          bloodRequestTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}