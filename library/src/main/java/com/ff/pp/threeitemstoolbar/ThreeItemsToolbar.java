package com.ff.pp.threeitemstoolbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by PP on 2017/3/21.
 */

public class ThreeItemsToolbar extends Toolbar {

    private static final String TAG = "ThreePositionToolbar";

    private Context mContext;
    private View mView;
    private ImageView mCenterIcon;
    private TextView mTitle;
    private ImageButton mRightButton;
    private ImageButton mLeftButton;

    public ThreeItemsToolbar(Context context) {
        this(context, null);
    }

    public ThreeItemsToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ThreeItemsToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        initView(context);
        setUserDefineAttribute(attrs, defStyleAttr);
        setOtherAttributes(attrs);

    }

    private void initView(Context context) {
        if (mView != null) return;
        inflateAndFindView(context);
        buttonSetDefaultIcon();
        addView(mView);
    }

    private void setUserDefineAttribute(@Nullable AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.ThreeItemsToolbar, defStyleAttr, 0);
            Drawable centerIcon = a.getDrawable(R.styleable.ThreeItemsToolbar_centerIcon);
            if (centerIcon != null) {
                setCenterIcon(centerIcon);
            }
            String title = a.getString(R.styleable.ThreeItemsToolbar_centerTitle);
            if (!TextUtils.isEmpty(title)) {
                setTitle(title);
            }
            Drawable rightIcon = a.getDrawable(R.styleable.ThreeItemsToolbar_rightButtonIcon);
            if (rightIcon != null) {
                setRightButtonIcon(rightIcon);
            }
            Drawable LeftIcon = a.getDrawable(R.styleable.ThreeItemsToolbar_leftButtonIcon);
            if (LeftIcon != null) {
                setLeftButtonIcon(LeftIcon);
            }
            boolean leftButtonIsClose = a.getBoolean(R.styleable.ThreeItemsToolbar_leftButtonIsClose, false);
            if (leftButtonIsClose)
                setLeftButtonClose();

            a.recycle();
        }
    }

    private void setOtherAttributes(AttributeSet attrs) {
        if (userHasNotSetBackground(attrs)) {
            setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
        }
    }

    private void inflateAndFindView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mView = inflater.inflate(R.layout.title_bar, null);

        mCenterIcon = (ImageView) mView.findViewById(R.id.image_center);
        mTitle = (TextView) mView.findViewById(R.id.textView_title_bar);
        mRightButton = (ImageButton) mView.findViewById(R.id.imageButton_title_bar);
        mLeftButton = (ImageButton) mView.findViewById(R.id.imageButton_left_title_bar);
    }

    private void buttonSetDefaultIcon() {
        setLeftButtonIcon(R.drawable.icon_back_32px);
        setRightButtonIcon(R.drawable.actionbar_more_icon);
    }

    private void setLeftButtonIcon(Drawable iconLeft) {
        if (mLeftButton != null) {
            mLeftButton.setVisibility(INVISIBLE);
            mLeftButton.setImageDrawable(iconLeft);
        }
    }

    private void setRightButtonIcon(Drawable icon) {
        if (mRightButton != null) {
            mRightButton.setVisibility(INVISIBLE);
            mRightButton.setImageDrawable(icon);
        }
    }

    private void setCenterIcon(Drawable drawable) {
        if (mCenterIcon != null) {
            mCenterIcon.setImageDrawable(drawable);
            mCenterIcon.setVisibility(VISIBLE);
        }
    }

    private void setLeftButtonClose() {
        setOnLeftButtonClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mContext instanceof Activity) {
                    ((Activity) mContext).finish();
                }
            }
        });
    }

    private boolean userHasNotSetBackground(@Nullable AttributeSet attrs) {
        for (int i = 0,count=attrs.getAttributeCount(); i < count; i++) {
            if (attrs.getAttributeName(i).contains("background")) {
                return false;
            }
        }
        return true;
    }

    public void setCenterIcon(int imageId) {
        setCenterIcon(ContextCompat.getDrawable(mContext, imageId));
    }

    @Override
    public void setTitle(@StringRes int resId) {
        this.setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView(getContext());
        if (mTitle != null) {
            mTitle.setText(title);
            mTitle.setVisibility(VISIBLE);
        }
    }

    public void setLeftButtonIcon(int resId) {
        setLeftButtonIcon(ContextCompat.getDrawable(mContext, resId));
    }

    public void setOnLeftButtonClickListener(OnClickListener listener) {
        mLeftButton.setVisibility(VISIBLE);
        mLeftButton.setOnClickListener(listener);
    }

    public void setRightButtonIcon(int resId) {
        setRightButtonIcon(ContextCompat.getDrawable(mContext, resId));
    }

    public void setOnRightButtonClickListener(OnClickListener listener) {
        mRightButton.setVisibility(VISIBLE);
        mRightButton.setOnClickListener(listener);
    }

    public void setRightSideMenu(final int resId, final PopupMenu.OnMenuItemClickListener listener){
        setOnRightButtonClickListener(new OnClickListener() {
            @Override
            public void onClick(View rightButton) {
                PopupMenu popup = new PopupMenu(mContext, rightButton);
                popup.inflate(resId);
                popup.setOnMenuItemClickListener(listener);
                popup.show();
            }
        });
    }

}
