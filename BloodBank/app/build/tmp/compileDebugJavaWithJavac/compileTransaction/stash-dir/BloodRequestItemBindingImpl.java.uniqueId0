package com.example.bloodbank.databinding;
import com.example.bloodbank.R;
import com.example.bloodbank.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BloodRequestItemBindingImpl extends BloodRequestItemBinding implements com.example.bloodbank.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.bloodReqImage, 8);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final android.widget.Button mboundView6;
    @NonNull
    private final android.widget.Button mboundView7;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BloodRequestItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private BloodRequestItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[5]
            );
        this.address.setTag(null);
        this.bloodType.setTag(null);
        this.hospitalName.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView6 = (android.widget.Button) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.Button) bindings[7];
        this.mboundView7.setTag(null);
        this.patientName.setTag(null);
        this.recquiredUnits.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.bloodbank.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.example.bloodbank.generated.callback.OnClickListener(this, 2);
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
        if (BR.requestInterface == variableId) {
            setRequestInterface((com.example.bloodbank.utils.BloodRequestInterface) variable);
        }
        else if (BR.requestItem == variableId) {
            setRequestItem((com.example.bloodbank.model.Request) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRequestInterface(@Nullable com.example.bloodbank.utils.BloodRequestInterface RequestInterface) {
        this.mRequestInterface = RequestInterface;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.requestInterface);
        super.requestRebind();
    }
    public void setRequestItem(@Nullable com.example.bloodbank.model.Request RequestItem) {
        this.mRequestItem = RequestItem;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.requestItem);
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
        java.lang.String requestItemPatientName = null;
        java.lang.String requestItemHospitalName = null;
        java.lang.String requestItemBloodType = null;
        com.example.bloodbank.utils.BloodRequestInterface requestInterface = mRequestInterface;
        com.example.bloodbank.model.Request requestItem = mRequestItem;
        java.lang.String requestItemHospitalAddress = null;
        java.lang.String requestItemRequiredUnits = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (requestItem != null) {
                    // read requestItem.patientName
                    requestItemPatientName = requestItem.getPatientName();
                    // read requestItem.hospitalName
                    requestItemHospitalName = requestItem.getHospitalName();
                    // read requestItem.bloodType
                    requestItemBloodType = requestItem.getBloodType();
                    // read requestItem.hospitalAddress
                    requestItemHospitalAddress = requestItem.getHospitalAddress();
                    // read requestItem.requiredUnits
                    requestItemRequiredUnits = requestItem.getRequiredUnits();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.address, requestItemHospitalAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.bloodType, requestItemBloodType);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.hospitalName, requestItemHospitalName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.patientName, requestItemPatientName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.recquiredUnits, requestItemRequiredUnits);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView6.setOnClickListener(mCallback1);
            this.mboundView7.setOnClickListener(mCallback2);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // requestInterface
                com.example.bloodbank.utils.BloodRequestInterface requestInterface = mRequestInterface;
                // requestItem
                com.example.bloodbank.model.Request requestItem = mRequestItem;
                // requestInterface != null
                boolean requestInterfaceJavaLangObjectNull = false;



                requestInterfaceJavaLangObjectNull = (requestInterface) != (null);
                if (requestInterfaceJavaLangObjectNull) {



                    requestInterface.onAcceptPressed(requestItem);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // requestInterface
                com.example.bloodbank.utils.BloodRequestInterface requestInterface = mRequestInterface;
                // requestInterface != null
                boolean requestInterfaceJavaLangObjectNull = false;



                requestInterfaceJavaLangObjectNull = (requestInterface) != (null);
                if (requestInterfaceJavaLangObjectNull) {


                    requestInterface.onDeclinePressed();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): requestInterface
        flag 1 (0x2L): requestItem
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}