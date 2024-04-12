package com.example.qwerty.databinding;
import com.example.qwerty.R;
import com.example.qwerty.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HomeItemBindingImpl extends HomeItemBinding implements com.example.qwerty.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.item_image, 3);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HomeItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private HomeItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.itemPrice.setTag(null);
        this.itemText.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.example.qwerty.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.homeItemInterface == variableId) {
            setHomeItemInterface((com.example.qwerty.interfaces.HomeItemInterface) variable);
        }
        else if (BR.item == variableId) {
            setItem((com.example.qwerty.model.Item) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHomeItemInterface(@Nullable com.example.qwerty.interfaces.HomeItemInterface HomeItemInterface) {
        this.mHomeItemInterface = HomeItemInterface;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.homeItemInterface);
        super.requestRebind();
    }
    public void setItem(@Nullable com.example.qwerty.model.Item Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.qwerty.interfaces.HomeItemInterface homeItemInterface = mHomeItemInterface;
        com.example.qwerty.model.Item item = mItem;
        java.lang.String itemItemPrice = null;
        java.lang.String itemItemName = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (item != null) {
                    // read item.itemPrice
                    itemItemPrice = item.getItemPrice();
                    // read item.itemName
                    itemItemName = item.getItemName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemPrice, itemItemPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemText, itemItemName);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback3);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // homeItemInterface
        com.example.qwerty.interfaces.HomeItemInterface homeItemInterface = mHomeItemInterface;
        // item
        com.example.qwerty.model.Item item = mItem;
        // homeItemInterface != null
        boolean homeItemInterfaceJavaLangObjectNull = false;



        homeItemInterfaceJavaLangObjectNull = (homeItemInterface) != (null);
        if (homeItemInterfaceJavaLangObjectNull) {



            homeItemInterface.onHomeItemPressed(item);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): homeItemInterface
        flag 1 (0x2L): item
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}