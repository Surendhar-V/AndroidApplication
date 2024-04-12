package com.example.loaditems.databinding;
import com.example.loaditems.R;
import com.example.loaditems.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemBindingImpl extends ItemBinding implements com.example.loaditems.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.img, 4);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[0]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.cardView.setTag(null);
        this.name.setTag(null);
        this.oldPrice.setTag(null);
        this.price.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.loaditems.generated.callback.OnClickListener(this, 1);
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
        if (BR.item == variableId) {
            setItem((com.example.loaditems.Item) variable);
        }
        else if (BR.itemInterface == variableId) {
            setItemInterface((com.example.loaditems.ItemInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.example.loaditems.Item Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setItemInterface(@Nullable com.example.loaditems.ItemInterface ItemInterface) {
        this.mItemInterface = ItemInterface;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.itemInterface);
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
        com.example.loaditems.Item item = mItem;
        java.lang.String itemItemOldPrice = null;
        java.lang.String itemItemPrice = null;
        java.lang.String itemItemName = null;
        com.example.loaditems.ItemInterface itemInterface = mItemInterface;

        if ((dirtyFlags & 0x5L) != 0) {



                if (item != null) {
                    // read item.itemOldPrice
                    itemItemOldPrice = item.getItemOldPrice();
                    // read item.itemPrice
                    itemItemPrice = item.getItemPrice();
                    // read item.itemName
                    itemItemName = item.getItemName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.cardView.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, itemItemName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.oldPrice, itemItemOldPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.price, itemItemPrice);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // itemInterface != null
        boolean itemInterfaceJavaLangObjectNull = false;
        // item
        com.example.loaditems.Item item = mItem;
        // itemInterface
        com.example.loaditems.ItemInterface itemInterface = mItemInterface;



        itemInterfaceJavaLangObjectNull = (itemInterface) != (null);
        if (itemInterfaceJavaLangObjectNull) {



            itemInterface.onItemClick(item);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): itemInterface
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}