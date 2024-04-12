package com.example.qwerty.databinding;
import com.example.qwerty.R;
import com.example.qwerty.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CategoryItemBindingImpl extends CategoryItemBinding implements com.example.qwerty.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.category_img, 2);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CategoryItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private CategoryItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            );
        this.categoryText.setTag(null);
        this.item.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.example.qwerty.generated.callback.OnClickListener(this, 1);
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
        if (BR.category == variableId) {
            setCategory((com.example.qwerty.model.Category) variable);
        }
        else if (BR.categroyInterface == variableId) {
            setCategroyInterface((com.example.qwerty.interfaces.CategoryInterface) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCategory(@Nullable com.example.qwerty.model.Category Category) {
        this.mCategory = Category;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.category);
        super.requestRebind();
    }
    public void setCategroyInterface(@Nullable com.example.qwerty.interfaces.CategoryInterface CategroyInterface) {
        this.mCategroyInterface = CategroyInterface;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.categroyInterface);
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
        com.example.qwerty.model.Category category = mCategory;
        com.example.qwerty.interfaces.CategoryInterface categroyInterface = mCategroyInterface;
        java.lang.String categoryCategoryName = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (category != null) {
                    // read category.categoryName
                    categoryCategoryName = category.getCategoryName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryText, categoryCategoryName);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.item.setOnClickListener(mCallback2);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // category
        com.example.qwerty.model.Category category = mCategory;
        // categroyInterface != null
        boolean categroyInterfaceJavaLangObjectNull = false;
        // categroyInterface
        com.example.qwerty.interfaces.CategoryInterface categroyInterface = mCategroyInterface;



        categroyInterfaceJavaLangObjectNull = (categroyInterface) != (null);
        if (categroyInterfaceJavaLangObjectNull) {



            categroyInterface.onCategoryClick(category);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): category
        flag 1 (0x2L): categroyInterface
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}