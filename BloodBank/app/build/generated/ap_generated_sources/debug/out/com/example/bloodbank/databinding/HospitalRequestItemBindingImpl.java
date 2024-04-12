package com.example.bloodbank.databinding;
import com.example.bloodbank.R;
import com.example.bloodbank.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HospitalRequestItemBindingImpl extends HospitalRequestItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.status, 6);
        sViewsWithIds.put(R.id.hosReqImg, 7);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HospitalRequestItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private HospitalRequestItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            );
        this.address.setTag(null);
        this.bloodType.setTag(null);
        this.hospitalName.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.patientName.setTag(null);
        this.recquiredUnits.setTag(null);
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
        if (BR.requestItem == variableId) {
            setRequestItem((com.example.bloodbank.model.Request) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRequestItem(@Nullable com.example.bloodbank.model.Request RequestItem) {
        this.mRequestItem = RequestItem;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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
        com.example.bloodbank.model.Request requestItem = mRequestItem;
        java.lang.String requestItemHospitalAddress = null;
        java.lang.String requestItemRequiredUnits = null;

        if ((dirtyFlags & 0x3L) != 0) {



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
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.address, requestItemHospitalAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.bloodType, requestItemBloodType);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.hospitalName, requestItemHospitalName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.patientName, requestItemPatientName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.recquiredUnits, requestItemRequiredUnits);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): requestItem
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}