package com.example.qwerty;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.qwerty.databinding.CategoryItemBindingImpl;
import com.example.qwerty.databinding.HomeItemBindingImpl;
import com.example.qwerty.databinding.ItemBindingImpl;
import com.example.qwerty.databinding.OrderItemsBindingImpl;
import com.example.qwerty.databinding.TextBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CATEGORYITEM = 1;

  private static final int LAYOUT_HOMEITEM = 2;

  private static final int LAYOUT_ITEM = 3;

  private static final int LAYOUT_ORDERITEMS = 4;

  private static final int LAYOUT_TEXT = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.qwerty.R.layout.category_item, LAYOUT_CATEGORYITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.qwerty.R.layout.home_item, LAYOUT_HOMEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.qwerty.R.layout.item, LAYOUT_ITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.qwerty.R.layout.order_items, LAYOUT_ORDERITEMS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.qwerty.R.layout.text, LAYOUT_TEXT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CATEGORYITEM: {
          if ("layout/category_item_0".equals(tag)) {
            return new CategoryItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for category_item is invalid. Received: " + tag);
        }
        case  LAYOUT_HOMEITEM: {
          if ("layout/home_item_0".equals(tag)) {
            return new HomeItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for home_item is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEM: {
          if ("layout/item_0".equals(tag)) {
            return new ItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item is invalid. Received: " + tag);
        }
        case  LAYOUT_ORDERITEMS: {
          if ("layout/order_items_0".equals(tag)) {
            return new OrderItemsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for order_items is invalid. Received: " + tag);
        }
        case  LAYOUT_TEXT: {
          if ("layout/text_0".equals(tag)) {
            return new TextBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for text is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(8);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "category");
      sKeys.put(2, "categroyInterface");
      sKeys.put(3, "homeItemInterface");
      sKeys.put(4, "item");
      sKeys.put(5, "itemInterface");
      sKeys.put(6, "realTimeItem");
      sKeys.put(7, "text");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/category_item_0", com.example.qwerty.R.layout.category_item);
      sKeys.put("layout/home_item_0", com.example.qwerty.R.layout.home_item);
      sKeys.put("layout/item_0", com.example.qwerty.R.layout.item);
      sKeys.put("layout/order_items_0", com.example.qwerty.R.layout.order_items);
      sKeys.put("layout/text_0", com.example.qwerty.R.layout.text);
    }
  }
}
