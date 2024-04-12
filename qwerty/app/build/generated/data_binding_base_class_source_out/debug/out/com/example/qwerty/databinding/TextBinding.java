// Generated by data binding compiler. Do not edit!
package com.example.qwerty.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.qwerty.R;
import com.example.qwerty.model.Heading;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class TextBinding extends ViewDataBinding {
  @NonNull
  public final TextView msg;

  @Bindable
  protected Heading mText;

  protected TextBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView msg) {
    super(_bindingComponent, _root, _localFieldCount);
    this.msg = msg;
  }

  public abstract void setText(@Nullable Heading text);

  @Nullable
  public Heading getText() {
    return mText;
  }

  @NonNull
  public static TextBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.text, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static TextBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<TextBinding>inflateInternal(inflater, R.layout.text, root, attachToRoot, component);
  }

  @NonNull
  public static TextBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.text, null, false, component)
   */
  @NonNull
  @Deprecated
  public static TextBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
    return ViewDataBinding.<TextBinding>inflateInternal(inflater, R.layout.text, null, false, component);
  }

  public static TextBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static TextBinding bind(@NonNull View view, @Nullable Object component) {
    return (TextBinding)bind(component, view, R.layout.text);
  }
}