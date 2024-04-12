package com.example.qwerty.databinding;
import com.example.qwerty.R;
import com.example.qwerty.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class OrderItemsBindingImpl extends OrderItemsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.orderImg, 4);
        sViewsWithIds.put(R.id.linearLayout4, 5);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public OrderItemsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private OrderItemsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.orderItemName.setTag(null);
        this.orderItemPrice.setTag(null);
        this.orderItemQuantity.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.realTimeItem == variableId) {
            setRealTimeItem((com.example.qwerty.model.RealtimeItem) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRealTimeItem(@Nullable com.example.qwerty.model.RealtimeItem RealTimeItem) {
        this.mRealTimeItem = RealTimeItem;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.realTimeItem);
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
        java.lang.String realTimeItemItemName = null;
        com.example.qwerty.model.RealtimeItem realTimeItem = mRealTimeItem;
        java.lang.String realTimeItemCount = null;
        java.lang.String realTimeItemSubTotal = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (realTimeItem != null) {
                    // read realTimeItem.itemName
                    realTimeItemItemName = realTimeItem.getItemName();
                    // read realTimeItem.count
                    realTimeItemCount = realTimeItem.getCount();
                    // read realTimeItem.subTotal
                    realTimeItemSubTotal = realTimeItem.getSubTotal();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.orderItemName, realTimeItemItemName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.orderItemPrice, realTimeItemSubTotal);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.orderItemQuantity, realTimeItemCount);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): realTimeItem
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}